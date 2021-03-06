package com.m2stice.graphics;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

import com.m2stice.controller.RechercheViewListener;


/*
* Nom de classe : RechercheView
*
* Description: La classe qui va g�n�rer la vue de recherche.
*
* Version : 1.0
*
* Date : 03/12/2015
*
* Copyright : Emmanuel
*/

/**
 * RechercheView - La classe qui va generer la vue de recherche.
 * @author BIABIANY
 * @version 1.0
 * @copyright (C) Master 2 2015
 * @date 03/12/2015
 */
public class RechercheView extends JPanel {

	/**
	 * Numéro de serie
	 */
	private static final long serialVersionUID = 971L;
	
	private Interface interfaceUtilisateur; 						//Lien vers l'applet
	
	private JPanel bloc = new JPanel();								//Bloc container transparent
	private JHintTextField rechercheTextField = new JHintTextField();		//Zone saisie de la recherche
	private RechercheViewListener rechercheViewListener;			//Controler de la vue
	
	/**
	 * Mise en place de la vue
	 */
	public void init(){
		//Paramétrage de la vue
		this.rechercheViewListener = new RechercheViewListener(interfaceUtilisateur, this);
		this.setVisible(true);
		this.setOpaque(false);
		
		//Paramétrage des composants de la vue
		//
		rechercheTextField.addKeyListener(rechercheViewListener.getKeyListener());
		rechercheTextField.setTextSize(24);
		rechercheTextField.setHintText("Saisir un diplôme...");
		rechercheTextField.setToolTipText("Outils de recherche");
		rechercheTextField.setPreferredSize(new Dimension(400,32));
		//
		bloc.setLayout(new GridBagLayout());
		bloc.add(rechercheTextField);
		bloc.setOpaque(false);
		bloc.setVisible(true);
		
		//Agencement de la vue
		this.setLayout(new BorderLayout());
		this.add(bloc,BorderLayout.CENTER);	
	}
	
	public RechercheView(Interface interfaceUtilisateur){
		//Liaison avec l'applet
		this.setInterfaceUtilisateur(interfaceUtilisateur);
		
		this.init();
	}

	/**
	 * @return the interfaceUtilisateur
	 */
	public Interface getInterfaceUtilisateur() {
		return interfaceUtilisateur;
	}

	/**
	 * @param interfaceUtilisateur the interfaceUtilisateur to set
	 */
	public void setInterfaceUtilisateur(Interface interfaceUtilisateur) {
		this.interfaceUtilisateur = interfaceUtilisateur;
	}
	
	/**
	 * Affiche le composant
	 * @param le paramétre graphique
	 */
	public void paint(Graphics g){
		g.drawImage(interfaceUtilisateur.loadImage("RechercheViewImage.jpg"), 0, 0,(int)getBounds().getWidth(), (int)getBounds().getHeight(), this);
		super.paint(g);
	}
	
	/**
	 * Renvoie le mot saisi dans la barre de recherche
	 * @return Le mot rechercher
	 */
	public String getRecherche(){
		return this.rechercheTextField.getText();
	}
	
}
