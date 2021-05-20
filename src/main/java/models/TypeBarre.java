package models;

public class TypeBarre {

	private int id;
	private double coutMetre;
	private double longMin;
	private double longMax;
	private double resMaxTra;
	private double resMaxComp;

	public TypeBarre() {
	}

	public double getCoutMetre() {
		return coutMetre;
	}

	public void setCoutMetre(double coutMetre) {
		this.coutMetre = coutMetre;
	}

	public double getLongMin() {
		return longMin;
	}

	public void setLongMin(double longMin) {
		this.longMin = longMin;
	}

	public double getLongMax() {
		return longMax;
	}

	public void setLongMax(double longMax) {
		this.longMax = longMax;
	}

	public double getResMaxTra() {
		return resMaxTra;
	}

	public void setResMaxTra(double resMaxTra) {
		this.resMaxTra = resMaxTra;
	}

	public double getResMaxComp() {
		return resMaxComp;
	}

	public void setResMaxComp(double resMaxComp) {
		this.resMaxComp = resMaxComp;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		String str = "TypeBarre;" + id + ";" + coutMetre + ";" + longMin + ";" + longMax + ";" + resMaxTra + ";" + resMaxComp + "\n";
		return str;
	}
	
}
