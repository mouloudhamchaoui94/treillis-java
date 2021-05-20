package models;

public class Noeud {

	private int id;
	private Point p;

	public Noeud() {
	}

	public Noeud(double x, double y) {
		setP(new Point(x, y));
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Point getP() {
		return p;
	}

	public void setP(Point p) {
		this.p = p;
	}

}
