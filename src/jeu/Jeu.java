package jeu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import cartes.Bataille;
import cartes.Botte;
import cartes.Carte;
import cartes.JeuDeCartes;
import utils.GestionCartes;

public class Jeu {
	private Sabot sabot;
	private Set<Joueur> joueurs = new HashSet<>();
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
			for (Joueur j : joueurs) {
				j.donner(sabot.piocher());
			}
		}

	}

	public Sabot getSabot() {
		return sabot;
	}
	
	public String jouerTour(Joueur joueur) {
		 StringBuilder sb = new StringBuilder();
	        sb.append("Le joueur ").append(joueur.getNom() + " pioche ").append(joueur.prendreCarte(sabot)).append("\n");
	        List<Carte> cartesMain = joueur.getMain().getMain();
	        sb.append("- Il a dans sa main: ").append(cartesMain.isEmpty() ? "Vide" : cartesMain).append("\n");
	        
	        Coup coup = joueur.choisirCoup(joueurs);
	        
	       sb.append(joueur.getNom()).append(" ").append(coup.toString());
	        

	        
	        return sb.toString();
	}
}
