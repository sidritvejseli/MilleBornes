package jeu;

import java.util.ArrayList;
import java.util.List;

import cartes.Carte;
import cartes.FinLimite;

public class ZoneDeJeu {
	List<Carte> pileVitesse = new ArrayList<>();
	List<Carte> pileBataille = new ArrayList<>();
	List<Carte> pileBornes = new ArrayList<>();

	int donnerLimitationVitesse() {
		if (pileVitesse.isEmpty() || (pileVitesse.get(pileVitesse.size() - 1) instanceof FinLimite)) {
			return 200;
		}
		return 50;
	}
	
	int donnerKmParcours() {
		int somme = 0;
		return 0;
	}
}
