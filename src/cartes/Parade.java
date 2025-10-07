package cartes;

public class Parade extends Bataille {

	public Parade(Type type) {
		super(type);

	}

	@Override
	public String toString() {
		return getType().toString();
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Parade parade) {
			return this.toString().equals(parade.toString());
		}
		return false;
	}
}
