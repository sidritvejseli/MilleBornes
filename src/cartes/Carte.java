package cartes;

public abstract class Carte {
	
	@Override
	public boolean equals(Object obj) {
		if (obj.getClass() != getClass()) {
			return false;
		}
		return toString().equals(obj.toString());
	}
	
}
