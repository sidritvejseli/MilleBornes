package cartes;

public class Botte extends Probleme {

	public Botte(Type type) {
		super(type);
	}

	@Override
	public String toString() {
		return getType().getBotte();
	}
	
	@Override
	public boolean equals(Object obj) {
	    if (this == obj) return true;
	    if (!(obj instanceof Botte other)) return false;
	    return this.getType() == other.getType();
	}

	@Override
	public int hashCode() {
	    return getType().hashCode();
	}

}
