package models;

import java.util.ArrayList;
import java.util.List;

public class Terrain {

	private double xMax;
	private double xMin;
	private double yMax;
	private double yMin;
	private List<Triangle> triangles;

	public Terrain() {
	}

	public double getxMax() {
		return xMax;
	}

	public void setxMax(double xMax) {
		this.xMax = xMax;
	}

	public double getxMin() {
		return xMin;
	}

	public void setxMin(double xMin) {
		this.xMin = xMin;
	}

	public double getyMax() {
		return yMax;
	}

	public void setyMax(double yMax) {
		this.yMax = yMax;
	}

	public double getyMin() {
		return yMin;
	}

	public void setyMin(double yMin) {
		this.yMin = yMin;
	}

	public List<Triangle> getTriangles() {
		if (triangles == null) {
			triangles = new ArrayList<>();
		}
		return triangles;
	}

	public void setTriangles(List<Triangle> triangles) {
		this.triangles = triangles;
	}
	
	@Override
	public String toString() {
		String str = "ZoneConstructible;" + xMin + ";" + xMax + ";" + yMin + ";" + yMax + "\n";
		for (Triangle triangle : triangles) {
			str += triangle.toString();
		}
		str += "FINTRIANGLES\n";
		return str;
	}

}
