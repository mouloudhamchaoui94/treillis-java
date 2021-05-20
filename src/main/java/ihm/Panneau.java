package ihm;

import java.awt.Graphics;

import javax.swing.JPanel;

import models.Treillis;

public class Panneau extends JPanel {

	private static final long serialVersionUID = -4241895702570813689L;

	private Treillis treillis = null;

	public Treillis getTreillis() {
		return treillis;
	}

	public void setTreillis(Treillis treillis) {
		this.treillis = treillis;
	}

	private void doDrawing(Graphics g) {

		/*var g2d = (Graphics2D) g;

		// Afficher le terrain
		g2d.setColor(Color.ORANGE);

		if (treillis.getTerrain() != null) {

			for (Triangle tr : treillis.getTerrain().getTriangles()) {
				g2d.setColor(Color.ORANGE);
				for (int i = 0; i < 3; i++) {
					g2d.fillOval((int) tr.getPT(i).getX() * ZOOM, (int) tr.getPT(i).getY() * ZOOM, Point.R, Point.R);

					g2d.setStroke(new BasicStroke(3f));
					g2d.drawLine((int) tr.getPT(i).getX() * ZOOM + Point.R / 2,
							(int) tr.getPT(i).getY() * ZOOM + Point.R / 2,
							(int) tr.getPT((i + 1) % 3).getX() * ZOOM + Point.R / 2,
							(int) tr.getPT((i + 1) % 3).getY() * ZOOM + Point.R / 2);
				}
			}
		}

		// Afficher les barres
		for (Barre barre : treillis.getListBarres()) {
			System.out.println(barre);
			g2d.setColor(Color.GREEN);
			g2d.setStroke(new BasicStroke(5f));
			g2d.drawLine((int) barre.getNd1().getPos().getX() * ZOOM + Noeud.R / 2,
					(int) barre.getNd1().getPos().getY() * ZOOM + Noeud.R / 2,
					(int) barre.getNd2().getPos().getX() * ZOOM + Noeud.R / 2,
					(int) barre.getNd2().getPos().getY() * ZOOM + Noeud.R / 2);
		}

		// Afficher les noeuds
		for (Noeud noeud : treillis.getListNoeuds()) {
			if (noeud instanceof NoeudSimple) {
				g2d.setColor(Color.BLUE);
				NoeudSimple noeudSimple = (NoeudSimple) noeud;
				g2d.fillRoundRect((int) noeudSimple.getPos().getX() * ZOOM, (int) noeudSimple.getPos().getY() * ZOOM,
						noeudSimple.R, noeudSimple.R, noeudSimple.R, noeudSimple.R);
			} else if (noeud instanceof AppuiSimple) {
				/*g2d.setColor(Color.RED);
				NoeudSimple noeudSimple = (NoeudSimple) noeud;
				g2d.fillRoundRect((int) noeudSimple.getPos().getX() * ZOOM, (int) noeudSimple.getPos().getY() * ZOOM,
						noeudSimple.R, noeudSimple.R, noeudSimple.R, noeudSimple.R);
			} else if (noeud instanceof AppuiDouble) {
				/*g2d.setColor(Color.PINK);
				NoeudSimple noeudSimple = (NoeudSimple) noeud;
				g2d.fillRoundRect((int) noeudSimple.getPos().getX() * ZOOM, (int) noeudSimple.getPos().getY() * ZOOM,
						noeudSimple.R, noeudSimple.R, noeudSimple.R, noeudSimple.R);
			}
		}*/

	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		doDrawing(g);
	}

}
