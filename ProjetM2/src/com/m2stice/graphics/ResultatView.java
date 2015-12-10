package com.m2stice.graphics;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.LinkedList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

import com.m2stice.model.Diplome;

public class ResultatView extends JPanel {

	/**
	 * Numéro de série
	 */
	private static final long serialVersionUID = 971L;
	
	private Interface interfaceUtilisateur;					//Lien vers l'applet
	
	private JPanel bloc = new JPanel();						//Bloc container transparent
	private JPanel blocEntete = new JPanel();				//Bloc contenant l'entete
	private JPanel blocResultat = new JPanel();				//Bloc contenant les résultats
	private JPanel blocRecherche = new JPanel();			//Bloc contenant le sujet de recherche et le détal
	private JLabel titreRecherche = new JLabel(" 🔍  Résultat de la recherche: '...'");
	private JLabel detailRecherche = new JLabel("     X résultats trouvés");
	private BanniereComponent banniere;						//La banniere de la vue
	
	/**
	 * Mise en place de la vue
	 */
	public void init(){
		//Paramétrage de la vue
		this.setLayout(new BorderLayout());
		this.setOpaque(false);
		
		//Paramétrage des composants de la vue
		//
		banniere = new BanniereComponent(interfaceUtilisateur,"ResultatViewBanniere.jpg");
		banniere.setPreferredSize(new Dimension(1024,69));
		//
		titreRecherche.setFont(new Font("Gill Sans MT",Font.BOLD,30));
		titreRecherche.setPreferredSize(new Dimension(1024,40));
		//
		detailRecherche.setFont(new Font("Gill Sans MT",Font.ROMAN_BASELINE,15));
		detailRecherche.setPreferredSize(new Dimension(1024,25));
		//
		blocRecherche.setLayout(new BorderLayout());
		blocRecherche.add(titreRecherche,BorderLayout.NORTH);
		blocRecherche.add(new JSeparator(SwingConstants.HORIZONTAL),BorderLayout.CENTER);
		blocRecherche.add(detailRecherche,BorderLayout.SOUTH);
		blocRecherche.setPreferredSize(new Dimension(1024,70));
		//
		blocEntete.setPreferredSize(new Dimension(1024,150));
		blocEntete.add(banniere,BorderLayout.NORTH);
		blocEntete.add(blocRecherche,BorderLayout.CENTER);
		//
		blocResultat.setLayout(new FlowLayout());
		blocResultat.setOpaque(false);
		//
		bloc.setLayout(new BorderLayout());
		bloc.add(blocEntete, BorderLayout.NORTH);
		bloc.add(blocResultat, BorderLayout.CENTER);
		bloc.setOpaque(false);
		bloc.setVisible(true);
		
		this.add(bloc,BorderLayout.CENTER);
	}
	
	/**
	 * @param L'interface d'utilisateur
	 */
	public ResultatView(Interface interfaceUtilisateur){
		this.setInterfaceUtilisateur(interfaceUtilisateur);
		
		init();
	}

	/**
	 * @return L'interface d'utilisateur
	 */
	public Interface getInterfaceUtilisateur() {
		return interfaceUtilisateur;
	}

	/**
	 * @param Modifier l'interface
	 */
	public void setInterfaceUtilisateur(Interface interfaceUtilisateur) {
		this.interfaceUtilisateur = interfaceUtilisateur;
	}
	
	/**
	 * @param Le titre de la recherche
	 */
	public void setEntete(String titreRecherche,int nombreTrouvés){
		this.titreRecherche.setText(" 🔍  Résultat de la recherche \""+titreRecherche+"\"");
		this.detailRecherche.setText("     "+nombreTrouvés+" résultats trouvés");
	}
	
	public void setResultat(LinkedList<Diplome> diplomes){
		for(Diplome d:diplomes){
			this.blocResultat.add(new JLabel(d.getNom()) );
		}
	}
	
}
