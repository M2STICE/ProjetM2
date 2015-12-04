package com.m2stice.graphics;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;

public class ResultatView extends JPanel {

	/**
	 * Numéro de série
	 */
	private static final long serialVersionUID = 971L;
	
	private Interface interfaceUtilisateur;			//Lien vers l'applet
	
	protected JPanel bloc = new JPanel();			//Bloc container transparent
	protected BanniereComponent banniere;			//La banniere de la vue
	
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
		bloc.setLayout(new BorderLayout());
		bloc.add(banniere,BorderLayout.NORTH);
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
	
}
