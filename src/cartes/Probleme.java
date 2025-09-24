package cartes;

public abstract class Probleme {
	private Type type;

	
protected Probleme(Type type2) {
	this.type = type2;
}

public Type getType() {
	return type;
}
}
