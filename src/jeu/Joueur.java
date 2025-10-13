package jeu;

public class Joueur {
	String nom;
	ZoneDeJeu zoneDeJeu;
	public Joueur(String nom) {
		this.nom = nom;
		zoneDeJeu = new ZoneDeJeu();
	}

	public String getNom() {
		return nom;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Joueur joueur ) {
			return this.nom.equals(joueur.getNom());
		}
		return false;
	}
	@Override
	public String toString() {
		return this.nom.toString();
	}
}
