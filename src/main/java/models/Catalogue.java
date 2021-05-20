package models;

import java.util.ArrayList;
import java.util.List;

public class Catalogue {

	private List<TypeBarre> listTypeBarre;

	public Catalogue() {
	}

	public List<TypeBarre> getListTypeBarre() {
		if (listTypeBarre == null) {
			listTypeBarre = new ArrayList<>();
		}
		return listTypeBarre;
	}

	public void setListTypeBarre(List<TypeBarre> listTypeBarre) {
		this.listTypeBarre = listTypeBarre;
	}
	
	@Override
	public String toString() {
		String str = "";
		for (TypeBarre typeBarre : listTypeBarre) {
			str += typeBarre.toString();
		}
		str += "FINCATALOGUE\n";
		return str;
	}

}
