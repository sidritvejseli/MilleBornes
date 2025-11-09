package jeu;

import cartes.Borne;
import cartes.Carte;

public class Joueur {
	String nom;
	ZoneDeJeu zoneDeJeu;
	MainJoueur main;

	public Joueur(String nom) {
		this.nom = nom;
		zoneDeJeu = new ZoneDeJeu();
	}

	public String getNom() {
		return nom;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Joueur joueur) {
			return this.nom.equals(joueur.getNom());
		}
		return false;
	}
	@Override
	public int hashCode() {
		return 31*nom.hashCode();
	}

	@Override
	public String toString() {
		return this.nom;
	}

	public void donner(Carte carte) {
		main.prendre(carte);
	}

	public Carte prendreCarte(Sabot sabot) {
		if (!sabot.estVide()) {
			Carte carte = sabot.piocher();
			donner(carte);
			return carte;
		}
		return null;
	}
	
	public int donnerKmParcourus() {
		return zoneDeJeu.donnerKmParcourus();
	}
	
	public void deposer(Carte c) {
		zoneDeJeu.deposer(c);
	}
}
