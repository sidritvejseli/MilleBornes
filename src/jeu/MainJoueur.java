package jeu;

import java.util.ArrayList;
import java.util.List;

import cartes.Carte;

public class MainJoueur {

	List<Carte> mainJoueur = new ArrayList<>();
	
	
	public void prendre(Carte carte) {
		mainJoueur.add(carte);
	}
	
	public void jouer(Carte carte) {
		mainJoueur.remove(carte);
	}
	
	@Override
	public String toString() {
		String affichageMain ="Main : ";
		for (Carte carte : mainJoueur ) {
			affichageMain+=carte.toString()+ "\n";
		}
		return affichageMain;
	}
}
