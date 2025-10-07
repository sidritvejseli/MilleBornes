package cartes;

public class FinLimite extends Limite {

	@Override
	public String toString() {
		return "Fin Limite";
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof FinLimite finLimite) {
			return this.toString().equals(finLimite.toString());
			
		}
		return false;
	}
}
