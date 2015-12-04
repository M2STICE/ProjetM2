package com.m2stice.graphics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


/*
* Nom de classe : RechercheView
*
* Description: La classe qui va générer la vue de recherche.
*
* Version : 1.0
*
* Date : 03/12/2015
*
* Copyright : Emmanuel
*/

/**
 * 
 * RechercheView - La classe qui va générer la vue de recherche.
 * @author Emmanuel
 * @version 1.0
 * @copyright (C) Master 2 2015
 * @date 03/12/2015
 * @notes Elle va être utiliser dans le main.
 *
 */
public class RechercheView extends JPanel {

	/**
	 * Numéro de série
	 */
	private static final long serialVersionUID = 971L;
	
	private Interface interfaceUtilisateur = null; 					//Lien vers l'applet
	
	protected JPanel bloc = new JPanel();							//Bloc container transparent
	protected JLabel appNameLabel = new JLabel("               e-Livret               ");			//Label avec le nom du système
	protected JTextField rechercheTextField = new JTextField();
	
	public void init(){
		//Paramétrage de la vue 
		//this.setLayout(new BorderLayout());
		this.setBackground(Color.DARK_GRAY);
		this.setOpaque(false);
		
		//Paramétrage des composants de la vue
		// 
		//
		appNameLabel.setForeground(Color.BLACK);
		appNameLabel.setVisible(false);
		//
		rechercheTextField.setText("Saisir un diplôme...");
		rechercheTextField.setToolTipText("Outils de recherche");
		rechercheTextField.setFont(new Font("Gill Sans MT",Font.ITALIC,24));
		rechercheTextField.setPreferredSize(new Dimension(400,32));
		//
		bloc.setLayout(new GridLayout(40,1));
		bloc.add(appNameLabel);
		for(int i=0;i<10;i++)
			bloc.add(Box.createGlue());
		//bloc.add(appNameLabel);
		//bloc.setOpaque(false);
		bloc.add(rechercheTextField);
		//bloc.setSize(1000,1000);
		//bloc.setPreferredSize(new Dimension(300,0));
		bloc.setOpaque(false);
		bloc.setVisible(true);
		
		this.add(bloc/*, BorderLayout.CENTER*/);	
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
	
	public void paint(Graphics g){
		g.drawImage(interfaceUtilisateur.imageFond, 0, 0,(int)getBounds().getWidth(), (int)getBounds().getHeight(), this);
		super.paint(g);
	}
	
	
	public String toString(){
		return "RechercheViewImage.jpg";
	}

}
