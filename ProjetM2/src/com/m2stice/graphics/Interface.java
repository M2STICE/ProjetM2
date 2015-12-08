package com.m2stice.graphics;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;

import javax.swing.JPanel;

import com.m2stice.controller.Controller;

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
 * @copyright (C) Master 2 2015
 * @date 03/12/2015
 * @notes Elle va être utiliser dans le main.
 *
 */
public class Interface extends Applet {
	
	private JPanel blocPrincipal; //JPanel qui contient le bloc principal
	private Controller controller;
	
	/**
	 * Numéro de série
	 */
	private static final long serialVersionUID = 971L;
	
	/**
	 * Méthode appelée par le navigateur lorsque l'applet est chargée
	 */
	public void init(){
		this.controller = new Controller();
		super.init();
		
		//Paramétrage de l'applet
		this.blocPrincipal = new RechercheView(this);
		this.setLayout(new BorderLayout());
		this.setSize(1024,768);
		this.setBackground(Color.GRAY);
		this.add(blocPrincipal,BorderLayout.CENTER);
		this.setMinimumSize(new Dimension(1024,768));
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
		this.setMinimumSize(new Dimension(1024, 768));
		this.setVisible(true);
		/*try{
			Thread.sleep(4000);
			this.remove(blocPrincipal);
			this.setBlocPrincipal(new ResultatView(this));
			this.add(blocPrincipal);
			this.repaint();
		}
		catch(Exception e){ e.printStackTrace();}**/
		
	}
	

	/**
	 * getBlocPrincipale
	 * @return la variable blocPrincipal
	 */
	public JPanel getBlocPrincipal() {
		return blocPrincipal;
	}

	/**
	 * setBlocPrincipal
	 * @param le JPanel qui va servir de blocPrincipal 
	 */
	public void setBlocPrincipal(JPanel blocPrincipal) {
		this.remove(this.blocPrincipal);
		this.blocPrincipal = (ResultatView)blocPrincipal;
		this.add(this.blocPrincipal,BorderLayout.CENTER);
		this.repaint();
	}

	/**
	 * loadImage
	 * @param Le nom de l'image
	 * @return l'image
	 */
	public Image loadImage(String nomImage){
		return getImage(getCodeBase(), "../res/"+nomImage);
	}

	/**
	 * @return the controller
	 */
	public Controller getController() {
		return controller;
	}

}
