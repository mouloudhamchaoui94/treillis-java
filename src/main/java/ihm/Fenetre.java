package ihm;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import calculus.PivotGauss;
import calculus.SystemeEquations;
import consts.Consts;
import io.IO;

public class Fenetre extends JFrame implements ActionListener {

	private static final long serialVersionUID = 148037745910541340L;

	Panneau panneau = new Panneau();

	public void actionPerformed(ActionEvent e) {

		JFileChooser fileChooser = new JFileChooser();

		switch (e.getActionCommand()) {
		case "Nouveau":
			JDialog jDialog = new JDialog(this, "Saisir un treillis");
			jDialog.setSize(500, 300);
			jDialog.setLocationRelativeTo(this);
			JTextArea jTextArea = new JTextArea("Entrer la description d'un treillis");
			JScrollPane jScrollPane = new JScrollPane(jTextArea);
			jDialog.add(jScrollPane, BorderLayout.CENTER);

			JButton jButton = new JButton("Valider");
			jDialog.add(jButton, BorderLayout.SOUTH);

			jDialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			jDialog.setVisible(true);
			jButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					String[] lines = jTextArea.getText().split("\n");
					panneau.setTreillis(IO.loadFile(lines));
					panneau.repaint();
					System.out.println(panneau.getTreillis());
					jDialog.dispose();
				}
			});
			break;
		case "Ouvrir":
			fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
			int result = fileChooser.showOpenDialog(this);
			if (result == JFileChooser.APPROVE_OPTION) {
				File selectedFile = fileChooser.getSelectedFile();
				Scanner sc = null;
				try {
					sc = new Scanner(selectedFile);
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
					System.exit(Consts.EXIT_FAILURE);
				}
				ArrayList<String> lines = new ArrayList<>();
				while (sc.hasNext()) {
					lines.add(sc.next());
				}
				sc.close();

				String[] linesTab = new String[lines.size()];
				for (int i = 0; i < lines.size(); i++) {
					linesTab[i] = lines.get(i);
				}

				panneau.setTreillis(IO.loadFile(linesTab));
				System.out.println(panneau.getTreillis());
				panneau.repaint();
			}
			break;
		case "Enregistrer":
			if (panneau.getTreillis() != null) {
				fileChooser.setDialogTitle("Spécifiez un fichier à enregistrer");
				int userSelection = fileChooser.showSaveDialog(this);
				if (userSelection == JFileChooser.APPROVE_OPTION) {
					File fileToSave = fileChooser.getSelectedFile();
					IO.saveFile(panneau.getTreillis(), fileToSave);
				}
			}
			break;
		case "Calculer les forces":
			SystemeEquations system = new SystemeEquations(panneau.getTreillis());

			double[] x = PivotGauss.resolutionGauss(system.getA(), system.getY());

			for (int i = 0; i < x.length; i++) {
				System.out.println(x[i]);
			}
		}
	}

	public Fenetre() {
		super("Treillis");
		JMenuBar jmb = new JMenuBar();
		JMenu file = new JMenu("Fichier");
		JMenuItem item;
		file.add(item = new JMenuItem("Nouveau"));
		item.addActionListener(this);
		file.add(item = new JMenuItem("Ouvrir"));
		item.addActionListener(this);
		file.add(item = new JMenuItem("Enregistrer"));
		item.addActionListener(this);
		jmb.add(file);

		JMenu node = new JMenu("Calculs");
		node.add(item = new JMenuItem("Calculer les forces"));
		item.addActionListener(this);
		jmb.add(node);

		setJMenuBar(jmb);
		setContentPane(panneau);
		setSize(800, 600);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
	}

}