package jeu;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import cartes.Carte;
import cartes.Cartes;
import cartes.DebutLimite;
import cartes.FinLimite;
import cartes.Limite;
import cartes.Parade;
import cartes.Type;
import cartes.Attaque;
import cartes.Bataille;
import cartes.Borne;
import cartes.Botte;

public class ZoneDeJeu {
	Set<Botte> bottes = new HashSet<>();
	List<Limite> pileLimites = new LinkedList<>();
	List<Bataille> pileBataille = new LinkedList<>();
	List<Borne> bornes = new ArrayList<>();

	public int donnerLimitationVitesse() {
		if (pileLimites.isEmpty() || (pileLimites.getLast() instanceof FinLimite) || estPrioritaire()) {
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
		switch (c) {
		case Borne b -> bornes.add(b);

		case Limite l -> pileLimites.add(l);

		case Bataille b -> pileBataille.add(b);

		case Botte b -> bottes.add(b);

		default -> throw new IllegalArgumentException("Type de carte inconnu");

		}
	}

//
	public boolean peutAvancer() {
		if (pileBataille.isEmpty()) {
			return estPrioritaire();
		}
		Bataille sommet = pileBataille.getLast();

		return sommet.equals(Cartes.FEU_VERT) || (sommet instanceof Parade && estPrioritaire())
				|| (sommet instanceof Attaque a && a.getType() == Type.FEU && estPrioritaire())
				|| (sommet instanceof Attaque a && bottes.contains(new Botte(a.getType())) && estPrioritaire());
	}

	private boolean estDepotFeuVertAutorise() {
		if (estPrioritaire()) {
			return false;
		}

		if (pileBataille.isEmpty()) {
			return true;
		}
		Bataille sommet = pileBataille.getLast();

		return (sommet.equals(Cartes.FEU_ROUGE)) || (sommet instanceof Parade && !(sommet.equals(Cartes.FEU_VERT)))
				|| (sommet instanceof Attaque a && bottes.contains(new Botte(a.getType())));
	}

	private boolean estDepotBorneAutorise(Borne borne) {
		return peutAvancer() && (borne.getKm() <= donnerLimitationVitesse())
				&& (donnerKmParcourus() + borne.getKm() <= 1000);
	}

	private boolean estDepotLimiteAutorise(Limite limite) {
		if (estPrioritaire()) {
			return false;
		}
		if (limite instanceof DebutLimite) {
			return pileLimites.isEmpty() || pileLimites.getLast() instanceof FinLimite;
		} else {
			return pileLimites.getLast() instanceof DebutLimite;
		}

	}

//

	private boolean estDepotBatailleAutorise(Bataille bataille) {
		if (bottes.contains(new Botte(bataille.getType()))) {
			return false;
		}
		if (bataille instanceof Attaque) {
			return peutAvancer();
		} else if (bataille instanceof Parade p) {
			if (p.getType() == Type.FEU) {
				return estDepotFeuVertAutorise();
			} else {
				return !(pileBataille.isEmpty()) && pileBataille.getLast().getType() == p.getType();
			}
		}

		return false;
	}

	public boolean estDepotAutorise(Carte carte) {
		return switch (carte) {
		case Borne b -> estDepotBorneAutorise(b);
		case Limite l -> estDepotLimiteAutorise(l);
		case Bataille b -> estDepotBatailleAutorise(b);
		case Botte b -> bottes.add(b);

		default -> throw new IllegalArgumentException("Type de carte inconnu");
		};
	}

	public boolean estPrioritaire() {
		return bottes.contains(Cartes.PRIORITAIRE);
	}

}
