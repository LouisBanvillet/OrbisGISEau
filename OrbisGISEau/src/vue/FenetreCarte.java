package vue;

import java.awt.Graphics;
import java.util.Vector;

import javax.swing.JFrame;

/**
Classe permettant le trace de divers objets graphiques donnes sous forme 
d'une liste d'objets graphiques
 */
public class FenetreCarte extends JFrame {

	private static final long serialVersionUID = 1L;

	private Vector<ObjetGraphique> ObjetsGraphiques; // les objets a tracer

	public FenetreCarte() {
		super("OrbisGISEau");
		ObjetsGraphiques = new Vector<ObjetGraphique>();
		setSize(600,600);
		this.setVisible(true);
	}

	public void paint(Graphics g) {
		super.paint(g);
		for( ObjetGraphique oG : ObjetsGraphiques) {
			oG.colorerObjet(g); // chaque objet graphique a une methode colorerObjet
			oG.dessinerObjet(g); // chaque objet graphique a une methode dessinerObjet
		}
	}

	public void ajoutObjet(ObjetGraphique objet) {
		ObjetsGraphiques.add(objet);
	}

}
