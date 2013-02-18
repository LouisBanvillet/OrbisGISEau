package geometrie;

import java.util.ArrayList;

public class Carte {
	
	protected ArrayList<Point> ensemblePoint;
	protected ArrayList<Arete> ensembleArete;
	protected ArrayList<Triangle> ensembleTriangle;	
	protected Point pointEau;
	
	public Carte(ArrayList<Point> ensemblePoint, ArrayList<Arete> ensembleArete) {
		this.ensemblePoint = ensemblePoint;
		this.ensembleArete = ensembleArete;
		this.ensembleTriangle = listeTriangle();
	}
	
	public Carte(ArrayList<Point> ensemblePoint, ArrayList<Arete> ensembleArete, 
			ArrayList<Triangle> ensembleTriangle, Point pointEau) {
		this.ensemblePoint = ensemblePoint;
		this.ensembleArete = ensembleArete;
		this.ensembleTriangle = ensembleTriangle;
		this.pointEau = pointEau;
	}
	
	//retourne la liste des triangles connaissant la liste des aretes
	public ArrayList<Triangle> listeTriangle(){
		return null;
	}

	public ArrayList<Point> getEnsemblePoint() {
		return ensemblePoint;
	}

	public void setEnsemblePoint(ArrayList<Point> ensemblePoint) {
		this.ensemblePoint = ensemblePoint;
	}

	public ArrayList<Arete> getEnsembleArete() {
		return ensembleArete;
	}

	public void setEnsembleArete(ArrayList<Arete> ensembleArete) {
		this.ensembleArete = ensembleArete;
	}

	public ArrayList<Triangle> getEnsembleTriangle() {
		return ensembleTriangle;
	}

	public void setEnsembleTriangle(ArrayList<Triangle> ensembleTriangle) {
		this.ensembleTriangle = ensembleTriangle;
	}

	public Point getPointEau() {
		return pointEau;
	}

	public void setPointEau(Point pointEau) {
		this.pointEau = pointEau;
	}
		
}
