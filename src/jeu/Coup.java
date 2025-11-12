package jeu;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import cartes.Attaque;
import cartes.Carte;
import cartes.DebutLimite;
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
		if (joueurCible == null) {
			return true;
		} else if (joueurCible.equals(joueurCourant)) {
			if (carteJouee instanceof Attaque || carteJouee instanceof DebutLimite) {
				return false;
			}
			return joueurCourant.estDepotAutorise(carteJouee);
		} else  {
			if(carteJouee instanceof Attaque || carteJouee instanceof DebutLimite) {
				return joueurCible.estDepotAutorise(carteJouee);
			}
			
		}
		return false;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true; // optimisation classique
		if (!(obj instanceof Coup c))
			return false;

		return Objects.equals(joueurCourant, c.getJoueurCourant()) && Objects.equals(carteJouee, c.getCarteJouee())
				&& Objects.equals(joueurCible, c.getJoueurCible());
	}

	@Override
	public int hashCode() {
		return Objects.hash(joueurCourant, carteJouee, joueurCible);
	}

	@Override
	public String toString() {
		if (joueurCible != null) {
			return "Depose la carte " + carteJouee.toString() + " dans la zone de jeu de " + joueurCible.getNom();
		} else {
			return "Defausse la carte " + carteJouee.toString();
		}
	}

}
