package cartes;

public class JeuDeCartes {
	public JeuDeCartes() {
		// TODO Auto-generated constructor stub
	}
	private class Configuration{
		private int nbExemplaires;
		private Carte carte;
		private Configuration(Carte carte,int nbExemplaire) {
			this.carte = carte;
			this.nbExemplaires = nbExemplaire;
					
		}
		public Carte getCarte() {
			return carte;
		}
		public int getNbExemplaires() {
			return nbExemplaires;
		}
	}
	
	private Configuration[] typesDeCartes = new Configuration[19];
}
