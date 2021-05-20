package models;

public class Triangle {

	private int id;
	private Point[] PT = new Point[3];

	public Triangle() {
	}

	public Point getPT(int i) {
		return PT[i];
	}

	public Point[] getPT() {
		return PT;
	}

	public void setPT(Point[] pT) {
		PT = pT;
	}

	public void setPT(Point p, int i) {
		PT[i] = p;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		String str = "Triangle;" + id + ";" + PT[0] + ";" + PT[1] + ";" + PT[2] + "\n";
		return str;
	}

}
