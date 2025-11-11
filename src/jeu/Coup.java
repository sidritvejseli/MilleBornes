package jeu;

import java.util.HashSet;
import java.util.Set;

import cartes.Attaque;
import cartes.Carte;
import cartes.Limite;

public class Coup {
	Joueur joueurCourant;
	Joueur joueurCible;
	Carte carteJouee;

	public Coup(Joueur joueurCourant, Carte carteJouee, Joueur joueurCible) {
		this.joueurCourant = joueurCourant;
		this.joueurCible = joueurCible;
		this.carteJouee = carteJouee;
	}

	public Carte getCarteJouee() {
		return carteJouee;
	}

	public Joueur getJoueurCible() {
		return joueurCible;
	}

	public Joueur getJoueurCourant() {
		return joueurCourant;
	}

	public boolean estValide() {
		if (carteJouee instanceof Attaque || carteJouee instanceof Limite) {
			return joueurCible.estDepotAutorise(carteJouee);
		} else {
			return joueurCourant.estDepotAutorise(carteJouee);
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Coup c) {
			return joueurCible.equals(c.getJoueurCible()) && joueurCourant.equals(c.getJoueurCourant())
					&& carteJouee.equals(c.getCarteJouee());
		}
		return false;
	}

	@Override
	public int hashCode() {
		int result = 1;
		result = 31 * result + (joueurCourant == null ? 0 : joueurCourant.hashCode());
		result = 31 * result + (carteJouee == null ? 0 : carteJouee.hashCode());
		result = 31 * result + (joueurCible == null ? 0 : joueurCible.hashCode());
		return result;
	}


}
