package jeu;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import cartes.Carte;
import cartes.DebutLimite;
import cartes.FinLimite;
import cartes.Limite;
import cartes.Parade;
import cartes.Type;
import cartes.Attaque;
import cartes.Bataille;
import cartes.Borne;

public class ZoneDeJeu {
	Set<Carte> bottes = new HashSet<>();

	List<Limite> pileLimites = new LinkedList<>();
	List<Bataille> pileBataille = new LinkedList<>();
	List<Borne> bornes = new ArrayList<>();

	public int donnerLimitationVitesse() {
		if (pileLimites.isEmpty() || (pileLimites.getLast() instanceof FinLimite)) {
			return 200;
		}
		return 50;
	}

	public int donnerKmParcourus() {
		int sommeKm = 0;
		for (Borne c : bornes) {
			sommeKm += c.getKm();
		}
		return sommeKm;
	}

	public void deposer(Carte c) {
		if (c instanceof Borne b) {
			bornes.add(b);
		} else if (c instanceof Limite l) {
			pileLimites.add(l);
		} else if (c instanceof Bataille b) {
			pileBataille.add(b);
		}
	}

	public boolean peutAvancer() {
		return (!pileBataille.isEmpty()) && pileBataille.getLast().equals(new Parade(Type.FEU));
	}
	
	public boolean estDepotFeuVertAutorise() {
		return pileBataille.isEmpty() || pileBataille.getLast().equals(new Attaque(Type.FEU)) 
				|| !(pileBataille.getLast().equals(new Parade(Type.FEU)));
	}
	
	public boolean estDepotBorneAutorise(Borne borne) {
		return !peutAvancer() && (borne.getKm()<= donnerLimitationVitesse())
				&& (donnerKmParcourus()+borne.getKm() <= 1000);
	}
	
	public boolean estDepotLimiteAutorise(Limite limite) {
		if(limite instanceof DebutLimite) {
			return pileLimites.isEmpty() || pileLimites.getLast() instanceof FinLimite;
		}
		else {
			return pileLimites.getLast() instanceof DebutLimite;
		}
		
	}
	

}
