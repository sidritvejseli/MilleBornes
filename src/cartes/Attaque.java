package cartes;

//new
public class Attaque extends Bataille {

	public Attaque(Type type) {
		super(type);
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getType().getAttaque().toString();
	}

}
