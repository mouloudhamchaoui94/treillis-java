package models;

public class NoeudSimple extends Noeud {

	public NoeudSimple() {
	}

	public NoeudSimple(double x, double y) {
		super(x, y);
	}

	@Override
	public String toString() {
		return String.format("NoeudSimple;%d;%s\n", getId(), getP());
	}

}
