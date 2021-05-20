package models;

public class Appui extends Noeud {

	private Triangle triangle;
	private int j;
	private int k;
	private double alpha;

	public Appui() {
	}

	public Triangle getTriangle() {
		return triangle;
	}

	public void setTriangle(Triangle triangle) {
		this.triangle = triangle;
	}

	public int getJ() {
		return j;
	}

	public void setJ(int j) {
		this.j = j;
		this.k = (j + 1) % 3;
	}

	public int getK() {
		return k;
	}

	public double getAlpha() {
		return alpha;
	}

	public void setAlpha(double alpha) {
		this.alpha = alpha;
		Point p = new Point();
		p.setX(alpha * triangle.getPT(j).getX() + (1 - alpha) * triangle.getPT(k).getX());
		p.setY(alpha * triangle.getPT(j).getY() + (1 - alpha) * triangle.getPT(k).getY());
		this.setP(p);
	}

}
