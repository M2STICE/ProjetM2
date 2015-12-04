package com.m2stice.graphics;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;

import javax.swing.JPanel;

/*
* Nom de classe : Interface
*
* Description: La classe qui va g�n�rer l'interface graphique du syst�me.
*
* Version : 1.0
*
* Date : 03/12/2015
*
* Copyright : Emmanuel
*/

/**
 * 
 * Fenetre - Classe qui va g�n�rer l'interface graphique du syst�me.
 * @author Emmanuel
 * @version 1.0
 * @copyright (C) Master 2 2015
 * @date 03/12/2015
 * @notes Elle va �tre utiliser dans le main.
 *
 */
public class Interface extends Applet {
	
	private JPanel blocPrincipal = new RechercheView(this); //JPanel qui contient le bloc principal
	
	/**
	 * Num�ro de s�rie
	 */
	private static final long serialVersionUID = 971L;
	protected Image imageFond;
	
	
	/**
	 * M�thode appel�e par le navigateur lorsque l'applet est charg�e
	 */
	public void init(){
		super.init();
		
		//Param�trage de l'applet
		this.setLayout(new BorderLayout());
		this.setSize(1024,768);
		this.setBackground(Color.GRAY);
		this.add(blocPrincipal,BorderLayout.CENTER);
		this.setMinimumSize(new Dimension(1024,768));
		imageFond = getImage(getCodeBase(), blocPrincipal.toString());
		//System.out.println(blocPrincipal.toString());
		this.setVisible(false);
	}
	
	/**
	 * M�thode qui red�fini la taille
	 */
	public void setSize(int largeur, int hauteur){
		super.setSize(largeur, hauteur);
	}
	
	/**
	 * Lance l'applet dans le navigateur
	 */
	public void start(){
		this.setSize(1024,768);
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
