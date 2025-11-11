package jeu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import cartes.Carte;
import cartes.JeuDeCartes;
import utils.GestionCartes;

public class Jeu {
	private Sabot sabot;
	private Set<Joueur> joueurs;
	public static final int NB_CARTES = 6;

	public Jeu() {
		JeuDeCartes jeuDeCartes = new JeuDeCartes();

		List<Carte> listeCartes = new ArrayList<>();
		Collections.addAll(listeCartes, jeuDeCartes.donnerCartes());

		listeCartes = GestionCartes.melanger(listeCartes);
		Carte[] tabMelange = listeCartes.toArray(new Carte[0]);

		sabot = new Sabot(tabMelange);

	}
	
	public void inscire(Joueur j) {
		joueurs.add(j);
		
	}
	public void distribuerCartes() {
		for (int i = 0; i < NB_CARTES; i++) {
			for(Joueur j : joueurs) {
				j.donner(sabot.piocher());
			}
		}
	}
}
