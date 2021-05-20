package models;

public class Barre {

	private int id;
	private Noeud nd1;
	private Noeud nd2;
	private TypeBarre type;

	public Barre() {

	}

	public Noeud getNd1() {
		return nd1;
	}

	public void setNd1(Noeud nd1) {
		this.nd1 = nd1;
	}

	public Noeud getNd2() {
		return nd2;
	}

	public void setNd2(Noeud nd2) {
		this.nd2 = nd2;
	}

	public TypeBarre getType() {
		return type;
	}

	public void setType(TypeBarre type) {
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		String str = "Barre;" + id + ";" + type.getId() + ";" + nd1.getId() + ";" + nd2.getId() + "\n";
		return str;
	}

}
