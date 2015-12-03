package com.m2stice.graphics;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;

/*
* Nom de classe : Interface
*
* Description: La classe qui va générer l'interface graphique du système.
*
* Version : 1.0
*
* Date : 03/12/2015
*
* Copyright : Emmanuel
*/

/**
 * 
 * Fenetre - Classe qui va générer l'interface graphique du système.
 * @author Emmanuel
 * @version 1.0
 * @copyright m2stice
 * @date 03/12/2015
 * @notes Elle va être utiliser dans le main.
 *
 */
public class Interface extends Applet {
	
	private JPanel blocPrincipal = new JPanel(); //JPanel qui contient le bloc principal
	
	/**
	 * Numéro de série
	 */
	private static final long serialVersionUID = 971L;
	
	
	/**
	 * Méthode appelée par le navigateur lorsque l'applet est chargée
	 */
	public void init(){
		super.init();
		
		//Paramétrage du blocPrincipal et 
		this.blocPrincipal.setBackground(Color.DARK_GRAY);
		
		//Paramétrage de l'applet
		this.setLayout(new BorderLayout());
		this.setSize(1200,800);
		this.setBackground(Color.GRAY);
		this.add(blocPrincipal,BorderLayout.CENTER);
		this.setVisible(false);
	}
	
	/**
	 * Méthode qui redéfini la taille
	 */
	public void setSize(int largeur, int hauteur){
		super.setSize(largeur, hauteur);
	}
	
	/**
	 * Lance l'applet dans le navigateur
	 */
	public void start(){
		this.setSize(1200,800);
		this.setVisible(true);
	}
	

	/**
	 * @return la variable blocPrincipal
	 */
	public JPanel getBlocPrincipal() {
		return blocPrincipal;
	}

	/**
	 * @param le JPanel qui va servir de blocPrincipal 
	 */
	public void setBlocPrincipal(JPanel blocPrincipal) {
		this.blocPrincipal = blocPrincipal;
	}

}
