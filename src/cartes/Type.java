package cartes;

public enum Type {
	FEU("Feu rouge", "Feu vert",
			"Vehicule prioritaire"), ESSENCE("Panne d'essence", "essence", "citerne"), CREVAISON("crevaison", "roue de secours", "increvable"),ACCIDENT("accident", "reparation", "as du volant");
	
		private final String attaque;
		private final String parade;
		private final String botte;
		
	
	private Type(String attaque, String parade, String botte) {
		this.attaque =attaque;
		this.parade = parade;
		this.botte = botte;
		
	}
	public String getAttaque() {
		return attaque;
	}
	
	public String getBotte() {
		return botte;
	}
	 public String getParade() {
		return parade;
	}
}
