package main;

import geometrie.*;

import java.awt.Color;
import java.util.ArrayList;

import vue.*;

import algorithme.*;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {		
		// Chargement de la carte de depart et de la hauteur d'eau
		Carte c = InstancesCarte.carte2();
		// hauteur d'eau de depart
		double heau = 0.0;
		
		// L'algo ressort l'ensemble des aretes delimitant la zone inondee
		ArrayList<Arete> listeFinaleArete = new ArrayList<Arete>();
		listeFinaleArete = Algorithme.algorithme(c, c.getPointEau(), heau);	
		
		FenetreCarte fenetreCarte = new FenetreCarte();
		
		// pour l'ensemble des aretes de la carte, on l'ajoute a la fenetre
		for(Arete a : c.getEnsembleArete()){
			AreteGraphique aGraphique = new AreteGraphique(a, Color.black, 1);
			fenetreCarte.ajoutObjet(aGraphique);			
		}
		// Coloration des points graphiques selon leur hauteur/niveau d'eau
		for(Point p : c.getEnsemblePoint()){
			PointGraphique pGraphique = new PointGraphique(p, Color.black, 7);
			if(p.getZ() < heau){
				pGraphique.setCouleur(Color.cyan);
			}
			else if(p.getZ() == heau){
				pGraphique.setCouleur(Color.orange);				
			}
			else{
				pGraphique.setCouleur(Color.red);
			}
			fenetreCarte.ajoutObjet(pGraphique);
		}
		
		//Liste des points d'intersection avec le plan d'eau
		ArrayList<PointEau> listePointsEau = Fonctions.listePointsEau(c, heau);
		for(Point p : listePointsEau){
			PointGraphique pGraphique = new PointGraphique(p, Color.magenta, 4);
			fenetreCarte.ajoutObjet(pGraphique);
		}
		
		// Trace avec rafraichissement de la zone de dessin de la zone delimitee
		for(Arete a : listeFinaleArete){
			try{Thread.sleep(400);}catch(Exception e){}
			AreteGraphique aGraphique = new AreteGraphique(a, Color.blue, 2);
			fenetreCarte.ajoutObjet(aGraphique);
			fenetreCarte.repaint();
		}

	}

}
