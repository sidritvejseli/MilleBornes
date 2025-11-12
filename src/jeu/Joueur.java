package jeu;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import cartes.Bataille;
import cartes.Botte;
import cartes.Carte;

public class Joueur  {
	private String nom;
	private ZoneDeJeu zoneDeJeu;
	private MainJoueur main;
	Random random = new Random();

	public Joueur(String nom) {
		this.nom = nom;
		zoneDeJeu = new ZoneDeJeu();
		main = new MainJoueur();
	}

	public String getNom() {
		return nom;
	}

	public MainJoueur getMain() {
		return main;
	}
	
	public ZoneDeJeu getZoneDeJeu() {
		return zoneDeJeu;
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
		return 31 * nom.hashCode();
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

	public boolean estDepotAutorise(Carte carte) {
		return zoneDeJeu.estDepotAutorise(carte);
	}

	public Set<Coup> coupsDefausse() {
		Set<Coup> defausses = new HashSet<>();

		for (Carte c : main.getMain()) {
			defausses.add(new Coup(this, c, null));
		}
		return defausses;
	}

	public void retirerDeLaMain(Carte carte) {
		main.getMain().remove(carte);
	}

	public Set<Coup> coupsPossibles(Set<Joueur> participants) {
		Set<Coup> coups = new HashSet<>();
		for (Joueur participant : participants) {
			for (Carte c : main.getMain()) {
				Coup coupCourant = new Coup(this, c, participant);
				if (coupCourant.estValide()) {
					coups.add(coupCourant);
				}
			}
		}

		return coups;
	}

	public Coup choisirCoup(Set<Joueur> participants) {
		Set<Coup> coups = coupsPossibles(participants);
		if (coups.isEmpty()) {

			coups = coupsDefausse();

		}
		Coup[] tabCoups = coups.toArray(new Coup[coups.size()]);
		int indiceAleatoire = random.nextInt(coups.size());
		return tabCoups[indiceAleatoire];

	}
	
    public String afficherEtatJoueur() {
        StringBuilder sb = new StringBuilder();
        sb.append("État du joueur ").append(nom).append(" :\n");
        
        Set<Botte> bottes = zoneDeJeu.bottes;
        sb.append("- Bottes: ").append(bottes.isEmpty() ? "Aucune" : bottes).append("\n");

        boolean limitation = zoneDeJeu.donnerLimitationVitesse() == 50;
        sb.append("- Limitation de vitesse : ").append(limitation).append("\n");

        List<Bataille> pileBataille = zoneDeJeu.pileBataille;
        Bataille sommet = pileBataille.isEmpty() ? null : pileBataille.getLast();
        sb.append("- Sommet pile de bataille : ").append(sommet).append("\n");

        List<Carte> cartesMain = main.getMain();
        sb.append("- Il a dans sa main: ").append(cartesMain.isEmpty() ? "Vide" : cartesMain).append("\n");

        return sb.toString();
    }
	
}
