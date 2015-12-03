package com.m2stice.graphics;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Color;

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
 * @copyright m2stice
 * @date 03/12/2015
 * @notes Elle va �tre utiliser dans le main.
 *
 */
public class Interface extends Applet {
	
	private JPanel blocPrincipal = new JPanel(); //JPanel qui contient le bloc principal
	
	/**
	 * Num�ro de s�rie
	 */
	private static final long serialVersionUID = 971L;
	
	
	/**
	 * M�thode appel�e par le navigateur lorsque l'applet est charg�e
	 */
	public void init(){
		super.init();
		
		//Param�trage du blocPrincipal et 
		this.blocPrincipal.setBackground(Color.DARK_GRAY);
		
		//Param�trage de l'applet
		this.setLayout(new BorderLayout());
		this.setSize(1200,800);
		this.setBackground(Color.GRAY);
		this.add(blocPrincipal,BorderLayout.CENTER);
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
