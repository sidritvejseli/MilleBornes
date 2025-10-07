package cartes;

public class JeuDeCartes {
	public static final int NB_CARTES = 106;
	private Configuration[] typesDeCartes = { new Configuration(new Borne(25), 10),
			new Configuration(new Borne(50), 10), new Configuration(new Borne(75), 10),
			new Configuration(new Borne(100), 12), new Configuration(new Borne(200), 4),

			new Configuration(new Parade(Type.FEU), 14), new Configuration(new FinLimite(), 6),
			new Configuration(new Parade(Type.ESSENCE), 6), new Configuration(new Parade(Type.CREVAISON), 6),
			new Configuration(new Parade(Type.ACCIDENT), 6),

			new Configuration(new Attaque(Type.FEU), 5), new Configuration(new DebutLimite(), 4), // ← 4 selon les
																									// règles
																									// officielles
			new Configuration(new Attaque(Type.ESSENCE), 3), new Configuration(new Attaque(Type.CREVAISON), 3),
			new Configuration(new Attaque(Type.ACCIDENT), 3),

			new Configuration(new Botte(Type.FEU), 1), new Configuration(new Botte(Type.ESSENCE), 1),
			new Configuration(new Botte(Type.CREVAISON), 1), new Configuration(new Botte(Type.ACCIDENT), 1) };

	public JeuDeCartes() {

	}

	public String affichageJeuDeCartes() {
		StringBuilder affichage = new StringBuilder("JEU :\n");
		for (Configuration config : typesDeCartes) {
			affichage.append(config.getNbExemplaires()).append(" ").append(config.getCarte()).append("\n");
		}
		return affichage.toString();
	}

	public Carte[] donnerCartes() {
		Carte[] cartes = new Carte[NB_CARTES];
		int indice = 0;
		for (Configuration configuration : typesDeCartes) {
			for (int i = 0; i < configuration.getNbExemplaires(); i++) {
				cartes[indice] = configuration.getCarte();
				indice++;
			}
		}
		return cartes;

	}

	public boolean checkCount() {
		Carte[] cartes = donnerCartes();
		for (Configuration config : typesDeCartes) {
			int compteur = 0;

			for (Carte c : cartes) {
				if (c.equals(config.getCarte())) {
					compteur++;
				}
			}
			if (compteur != config.nbExemplaires) {
				return false;
			}
		}

		return true;

	}

	private static class Configuration {
		private int nbExemplaires;
		private Carte carte;

		private Configuration(Carte carte, int nbExemplaire) {
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

}
