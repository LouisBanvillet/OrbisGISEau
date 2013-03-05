package main;

import geometrie.Arete;
import geometrie.Carte;
import geometrie.Point;
import geometrie.PointEau;

import java.io.File;
import java.util.ArrayList;

import algorithme.Algorithme;
import algorithme.Fonctions;

import vue.FenetreControle;

/**
 * Ce controleur gere les les interractions entre les différentes données de l'application.
 * 
 * @author Louis
 */
public class Controleur {

	protected File fichierCarte;
	protected Carte carte;
	protected Point pointEau;
	protected double heau;
	protected ArrayList<PointEau> listePointsEau;
	protected ArrayList<Arete> listeFinaleArete;

	public static int largeurFenetreChoix = 400;
	public static int hauteurFenetreChoix = 400;
	public static int largeurFenetreCarte = 700;
	public static int hauteurFenetreCarte = 700;

	//Paramètres utilisés pour la vue 2D
	protected double zoom;

	public Controleur() {
		new FenetreControle(this);
		fichierCarte = null;
		carte = null;
		pointEau = null;
		heau = 0.0;
		listePointsEau = null;
		listeFinaleArete = null;
	}

	//Renvoie la liste de points contenue dans le fichier fichierCarte.
	public ArrayList<Point> getListePointFromCarte(){

		//Lecture du fichier renvoyant une carte
		//carte = lectureFichier(fichierCarte)
		//return carte.getEnsemblePoint();

		//Provisoire :
		carte = InstancesCarte.carte2();
		return carte.getEnsemblePoint();
	}

	//Génère la carte résultante de l'algorithme
	public void generer(){
		listeFinaleArete = Algorithme.algorithme(carte, pointEau, heau);
		listePointsEau = Fonctions.listePointsEau(carte, heau);
		zoom = Math.max((maximumXCarte()- minimumXCarte())/Controleur.largeurFenetreCarte, 
				(maximumYCarte() - minimumYCarte())/Controleur.hauteurFenetreCarte)/0.8;
		
	}
	
	public double minimumXCarte(){
		double minimumX = carte.getEnsemblePoint().get(0).getX();
		for(Point p : carte.getEnsemblePoint()){
			if(p.getX() < minimumX){
				minimumX = p.getX();
			}
		}
		return minimumX;
	}
	
	public double maximumXCarte(){
		double maximumX = carte.getEnsemblePoint().get(0).getX();
		for(Point p : carte.getEnsemblePoint()){
			if(p.getX() > maximumX){
				maximumX = p.getX();
			}
		}
		return maximumX;
	}
	
	public double minimumYCarte(){
		double minimumY = carte.getEnsemblePoint().get(0).getY();
		for(Point p : carte.getEnsemblePoint()){
			if(p.getX() < minimumY){
				minimumY = p.getY();
			}
		}
		return minimumY;
	}
	
	public double maximumYCarte(){
		double maximumY = carte.getEnsemblePoint().get(0).getY();
		for(Point p : carte.getEnsemblePoint()){
			if(p.getX() > maximumY){
				maximumY = p.getY();
			}
		}
		return maximumY;
	}

	public File getFichierCarte() {
		return fichierCarte;
	}

	public void setFichierCarte(File fichierCarte) {
		this.fichierCarte = fichierCarte;
	}

	public Carte getCarte() {
		return carte;
	}

	public void setCarte(Carte carte) {
		this.carte = carte;
	}

	public Point getPointEau() {
		return pointEau;
	}

	public void setPointEau(Point pointEau) {
		this.pointEau = pointEau;
	}

	public double getHeau() {
		return heau;
	}

	public void setHeau(double heau) {
		this.heau = heau;
	}

	public ArrayList<PointEau> getListePointsEau() {
		return listePointsEau;
	}

	public void setListePointsEau(ArrayList<PointEau> listePointsEau) {
		this.listePointsEau = listePointsEau;
	}

	public ArrayList<Arete> getListeFinaleArete() {
		return listeFinaleArete;
	}

	public void setListeFinaleArete(ArrayList<Arete> listeFinaleArete) {
		this.listeFinaleArete = listeFinaleArete;
	}

	public double getZoom() {
		return zoom;
	}

	public void setZoom(double zoom) {
		this.zoom = zoom;
	}
	
}

