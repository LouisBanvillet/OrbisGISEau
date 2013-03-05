package vue;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import main.Controleur;
import vue.controle.AffichageCarteVue;
import vue.controle.ChargementCarteVue;
import vue.controle.ChoixHauteurEauVue;
import vue.controle.ChoixPointEauVue;


/**
 * On gere ici les diff�rents vues. On commence par les initialiser et les
 * mettres dans le LayoutManager. Celui-ci permet d'effectuer les pr�c�dent-suivant
 * 
 * Elle a besoin du controleurs en constructeur.
 * @author Louis
 */
public class FenetreControle extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	//Les vues
	private ChargementCarteVue chargementCarte;
	private ChoixPointEauVue choixPointEau;
	private ChoixHauteurEauVue choixHauteurEau;
	private AffichageCarteVue affichageCarte;

	//Bouttons pr�c�dent-suivant
	private JButton precedent = new JButton("Prec�dent");
	private JButton suivant = new JButton("Suivant");

	//Le layout manager
	private LayoutControleur contentPanel = new LayoutControleur();

	public FenetreControle(Controleur controleur) {
		this.chargementCarte = new ChargementCarteVue(controleur);
		this.choixPointEau = new ChoixPointEauVue(controleur);
		this.choixHauteurEau = new ChoixHauteurEauVue(controleur);
		this.affichageCarte = new AffichageCarteVue(controleur);

		contentPanel.setPreferredSize(new Dimension(Controleur.largeurFenetreChoix,
				Controleur.hauteurFenetreChoix-50));
		contentPanel.add(chargementCarte, "OrbisGISEau - Chargement de la carte");
		contentPanel.add(choixPointEau, "OrbisGISEau - Choix du point d'entr�e");
		contentPanel.add(choixHauteurEau, "OrbisGISEau - Choix de la hauteur d'eau");
		contentPanel.add(affichageCarte, "OrbisGISEau - Carte g�n�r�e");

		add(contentPanel, BorderLayout.CENTER);

		JPanel p = new JPanel();
		precedent.addActionListener(this);
		precedent.setVisible(false);
		suivant.addActionListener(this);
		p.add(precedent);
		p.add(suivant);
		add(p, BorderLayout.SOUTH);

		setTitle("OrbisGISEau - Recherche de zone inond�e");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(Controleur.largeurFenetreChoix, Controleur.hauteurFenetreChoix);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		Object obj = ae.getSource();

		JPanel currentCard = this.contentPanel.getCurrentCard();
		if (obj == precedent) {
			this.contentPanel.previous();
		} else if (obj == suivant) {
			if(currentCard.equals(this.choixHauteurEau)){
				choixHauteurEau.generer();
			}
			this.contentPanel.next();
		}

		currentCard = this.contentPanel.getCurrentCard();

		//Si on se trouve sur le panneau de choix de carte, on enl�ve le bouton pr�c�dent.
		if(currentCard.equals(this.chargementCarte)){
			precedent.setVisible(false);
		}
		else{
			precedent.setVisible(true);
		}

		//Si on se trouve sur le panneau de choix de heau, on enl�ve le bouton suivant.
		if(currentCard.equals(this.choixHauteurEau)){
			suivant.setText("G�n�rer");
		}
		else{
			suivant.setText("Suivant");
		}

		//Si on affiche les cartes, la fen�tre s'agrandit.
		if(currentCard.equals(this.affichageCarte)){
			setSize(Controleur.largeurFenetreCarte, Controleur.hauteurFenetreCarte);
		}
		else{
			setSize(Controleur.largeurFenetreChoix, Controleur.hauteurFenetreChoix);
		}
		setLocationRelativeTo(null);
	}
}
