package calculus;

import java.util.List;
import java.util.stream.Collectors;

import models.AppuiDouble;
import models.AppuiSimple;
import models.Barre;
import models.Noeud;
import models.NoeudSimple;
import models.Treillis;

public class SystemeEquations {

	private double[][] A;
	private double[] y;

	public double[][] getA() {
		return A;
	}

	public void setA(double[][] a) {
		A = a;
	}

	public double[] getY() {
		return y;
	}

	public void setY(double[] y) {
		this.y = y;
	}

	public SystemeEquations(Treillis treillis) {

		/*A = new double[2*treillis.getListNoeuds().size()][2*treillis.getListNoeuds().size()];
		y = new double[2*treillis.getListNoeuds().size()];

		// Créer le système d'équations
		for (Noeud noeud : treillis.getListNoeuds()) {

			// Trouver toutes les barres relier à ce noeud
			List<Barre> listeBarres = treillis.getListBarres().stream()
					.filter(barre -> barre.getNd1().getId() == noeud.getId()).collect(Collectors.toList());

			if (noeud instanceof NoeudSimple) {
				NoeudSimple noeudSimple = (NoeudSimple) noeud;
				for (int i = 0; i < treillis.getListNoeuds().size(); i++) {
					for (Barre barre : listeBarres) {
						A[(noeudSimple.getId() - 1) * 2][barre.getId() - 1] += Math
								.abs(barre.getNd1().getPos().getY() - barre.getNd2().getPos().getY());
						A[(noeudSimple.getId() - 1) * 2 + 1][barre.getId() - 1] += Math
								.abs(barre.getNd1().getPos().getX() - barre.getNd2().getPos().getX());
					}
				}

			} else if (noeud instanceof AppuiSimple) {

				AppuiSimple appuiSimple = (AppuiSimple) noeud;
				for (int i = 0; i < treillis.getListNoeuds().size(); i++) {
					for (Barre barre : listeBarres) {
						A[(appuiSimple.getId() - 1) * 2][barre.getId() - 1] += Math
								.abs(barre.getNd1().getPos().getY() - barre.getNd2().getPos().getY());
						A[(appuiSimple.getId() - 1) * 2 + 1][barre.getId() - 1] += Math
								.abs(barre.getNd1().getPos().getX() - barre.getNd2().getPos().getX());
					}
				}

			} else if (noeud instanceof AppuiDouble) {

				AppuiDouble appuiDouble = (AppuiDouble) noeud;
				for (int i = 0; i < treillis.getListNoeuds().size(); i++) {
					for (Barre barre : listeBarres) {
						A[(appuiDouble.getId() - 1) * 2][barre.getId() - 1] += Math
								.abs(barre.getNd1().getPos().getY() - barre.getNd2().getPos().getY());
						A[(appuiDouble.getId() - 1) * 2 + 1][barre.getId() - 1] += Math
								.abs(barre.getNd1().getPos().getX() - barre.getNd2().getPos().getX());
					}
				}
			}

		}*/

	}

}
