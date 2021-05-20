package io;

import java.io.File;
import java.io.FileOutputStream;
import java.util.stream.Collectors;

import consts.Consts;
import models.AppuiDouble;
import models.AppuiSimple;
import models.Barre;
import models.Catalogue;
import models.NoeudSimple;
import models.Point;
import models.Terrain;
import models.Treillis;
import models.Triangle;
import models.TypeBarre;

public class IO {

	private IO() {
	}

	private static Point extractPoint(String str) {
		str = str.substring(1, str.length() - 2);
		String[] cps = str.split(",");
		return new Point(Double.parseDouble(cps[0]), Double.parseDouble(cps[1]));
	}

	public static Treillis loadFile(String[] lines) {

		Treillis treillis = new Treillis();

		for (String line : lines) {

			String[] cps = line.split(";");

			switch (cps[0]) {
			case "ZoneConstructible":
				treillis.setTerrain(new Terrain());
				treillis.getTerrain().setxMin(Double.parseDouble(cps[1]));
				treillis.getTerrain().setxMax(Double.parseDouble(cps[2]));
				treillis.getTerrain().setyMin(Double.parseDouble(cps[3]));
				treillis.getTerrain().setyMax(Double.parseDouble(cps[4]));
				break;

			// Triangles
			case "Triangle":
				Triangle triangle = new Triangle();
				triangle.setId(Integer.parseInt(cps[1]));
				triangle.setPT(extractPoint(cps[2]), 0);
				triangle.setPT(extractPoint(cps[3]), 1);
				triangle.setPT(extractPoint(cps[4]), 2);
				treillis.getTerrain().getTriangles().add(triangle);
				break;
			case "FINTRIANGLES":
				break;

			// Types de barres
			case "TypeBarre":
				TypeBarre typeBarre = new TypeBarre();
				typeBarre.setId(Integer.parseInt(cps[1]));
				typeBarre.setCoutMetre(Double.parseDouble(cps[2]));
				typeBarre.setLongMin(Double.parseDouble(cps[3]));
				typeBarre.setLongMax(Double.parseDouble(cps[4]));
				typeBarre.setResMaxTra(Double.parseDouble(cps[5]));
				typeBarre.setResMaxComp(Double.parseDouble(cps[6]));
				treillis.setCatalogue(new Catalogue());
				treillis.getCatalogue().getListTypeBarre().add(typeBarre);
				break;
			case "FINCATALOGUE":
				break;

			// Noeuds
			case "AppuiDouble":
				AppuiDouble appuiDouble = new AppuiDouble();
				appuiDouble.setId(Integer.parseInt(cps[1]));
				appuiDouble.setTriangle(treillis.getTerrain().getTriangles().stream().filter(tr -> {
					return tr.getId() == Integer.parseInt(cps[2]);
				}).collect(Collectors.toList()).get(0));
				appuiDouble.setJ(Integer.parseInt(cps[3]));
				appuiDouble.setAlpha(Double.parseDouble(cps[4]));
				treillis.getListNoeuds().add(appuiDouble);
				break;
			case "AppuiSimple":
				AppuiSimple appuiSimple = new AppuiSimple();
				appuiSimple.setId(Integer.parseInt(cps[1]));
				appuiSimple.setTriangle(treillis.getTerrain().getTriangles().stream().filter(tr -> {
					return tr.getId() == Integer.parseInt(cps[2]);
				}).collect(Collectors.toList()).get(0));
				appuiSimple.setJ(Integer.parseInt(cps[3]));
				appuiSimple.setAlpha(Double.parseDouble(cps[4]));
				treillis.getListNoeuds().add(appuiSimple);
				break;
			case "NoeudSimple":
				NoeudSimple noeudSimple = new NoeudSimple();
				noeudSimple.setId(Integer.parseInt(cps[1]));
				noeudSimple.setP(extractPoint(cps[2]));
				treillis.getListNoeuds().add(noeudSimple);
				break;
			case "FINNOEUDS":
				break;

			// Barres
			case "Barre":
				Barre barre = new Barre();
				barre.setId(Integer.parseInt(cps[1]));
				barre.setType(treillis.getCatalogue().getListTypeBarre().stream()
						.filter(type -> type.getId() == Integer.parseInt(cps[2])).collect(Collectors.toList()).get(0));
				barre.setNd1(
						treillis.getListNoeuds().stream().filter(noeud -> noeud.getId() == Integer.parseInt(cps[3]))
								.collect(Collectors.toList()).get(0));
				barre.setNd2(
						treillis.getListNoeuds().stream().filter(noeud -> noeud.getId() == Integer.parseInt(cps[4]))
								.collect(Collectors.toList()).get(0));
				treillis.getListBarres().add(barre);
				break;
			case "FINBARRES":
				break;
			}
		}

		return treillis;
	}

	/**
	 * Output
	 * 
	 * @param treillis
	 * @param file
	 */
	public static void saveFile(Treillis treillis, File file) {

		try {
			FileOutputStream fos = new FileOutputStream(file);
			fos.write(treillis.toString().getBytes());
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(Consts.EXIT_FAILURE);
		}

	}

}
