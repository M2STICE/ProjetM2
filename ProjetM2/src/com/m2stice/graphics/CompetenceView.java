package com.m2stice.graphics;

import javax.swing.JPanel;

/**
 * 
 * CompetenceView - La classe qui va générer la vue des compétences.
 * @author Emmanuel
 * @version 1.0
 * @copyright (C) Master 2 2015
 * @date 14/12/2015
 *
 */
public class CompetenceView extends JPanel {

	/**
	 * Numéro de série
	 */
	private static final long serialVersionUID = 971L;
	
	private Interface interfaceUtilisateur;				//Liaison avec l'interface
	
	/**
	 * Création de la vue
	 */
	public void init(){
		
	}
	
	/**
	 * Contructeur de la vue
	 * @param interfaceUtilisateur
	 */
	public CompetenceView(Interface interfaceUtilisateur){
		this.interfaceUtilisateur = interfaceUtilisateur;
		init();
	}

}
