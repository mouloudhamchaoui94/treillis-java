package models;

import java.util.ArrayList;
import java.util.List;

public class Treillis {

	private int id;
	private List<Noeud> listNoeuds;
	private List<Barre> listBarres;
	private Terrain terrain;
	private Catalogue catalogue;

	public Treillis() {
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Noeud> getListNoeuds() {
		if (listNoeuds == null) {
			listNoeuds = new ArrayList<>();
		}
		return listNoeuds;
	}

	public void setListNoeuds(List<Noeud> listNoeuds) {
		this.listNoeuds = listNoeuds;
	}

	public List<Barre> getListBarres() {
		if (listBarres == null) {
			listBarres = new ArrayList<>();
		}
		return listBarres;
	}

	public void setListBarres(List<Barre> listBarres) {
		this.listBarres = listBarres;
	}

	public Terrain getTerrain() {
		return terrain;
	}

	public void setTerrain(Terrain terrain) {
		this.terrain = terrain;
	}

	public Catalogue getCatalogue() {
		return catalogue;
	}

	public void setCatalogue(Catalogue catalogue) {
		this.catalogue = catalogue;
	}

	public int getId() {
		return id;
	}
	
	@Override
	public String toString() {
		String str = "";
		str += terrain.toString();
		str += catalogue.toString();
		for (Noeud noeud : listNoeuds) {
			str += noeud.toString();
		}
		str += "FINNOEUDS\n";
		for (Barre barre : listBarres) {
			str += barre.toString();
		}
		str += "FINBARRES\n";
		return str;
	}

}
