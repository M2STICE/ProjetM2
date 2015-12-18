package com.m2stice.graphics;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
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
 * Interface - Classe qui va générer l'interface graphique du système.
 * @author Emmanuel
 * @version 1.0
 * @copyright (C) Master 2 2015
 * @date 03/12/2015
 * @notes Elle va créer l'interface utilisateur.
 * @revision 15/12/2015
 * ASDRUBAL & NERES
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
		controller.setMainInterface(this);
		if(!controller.getProperties())
			this.blocPrincipal = new DatabaseInfoView(this);
		else
			this.blocPrincipal = new RechercheView(this);
		
		//Paramétrage de l'applet
		
		this.setLayout(new BorderLayout());
		this.setSize(1024,768);
		this.setBackground(Color.GRAY);
		this.add(blocPrincipal,BorderLayout.CENTER);
		this.setMinimumSize(new Dimension(1024,768));
		this.setVisible(false);
		
		this.setMinimumSize(new Dimension(1024, 768));
		this.setVisible(true);
		
		Thread th = new Thread(){
			public void run(){
				resolveTimeOutProblem();
			}
		};
		th.start();
	}
	
//	public void stop(){
//		System.out.println("stop");
//	}
	
	public void destroy(){
		controller.closeConnection();
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
		this.removeAll();
		this.blocPrincipal = blocPrincipal;
		this.add(this.blocPrincipal,BorderLayout.CENTER);
		this.repaint();
	}

	/**
	 * Charge un image
	 * @param Le nom de l'image
	 * @return l'image
	 */
	public Image loadImage(String nomImage){
		return getImage(getCodeBase(), "../res/"+nomImage);
	}

	/**
	 * Charge le fichier
	 * @param nomFile
	 * @return l'url du fichier
	 */
	public URL loadFile(String nomFile){
		try {
			return new URL(getCodeBase(), "../res/" + nomFile);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * @return the controller
	 */
	public Controller getController() {
		return controller;
	}
	
	/**
	 * Permet de rafraichir la page
	 * le super.repaint() ne fonctionne pas bien
	 */
	public void repaint(){
		super.repaint();
		this.resize(1025,768);
		this.resize(1024,768);
	}
	
	/**
	 * Permet d'afficher un message d'erreur
	 */
	public void showMessageAlert(String text){
	    Toolkit.getDefaultToolkit().beep();
	    JOptionPane optionPane = new JOptionPane(text,JOptionPane.ERROR_MESSAGE);
	    JDialog dialog = optionPane.createDialog("Attention");
	    dialog.setAlwaysOnTop(true);
	    //this.add(dialog);
	    dialog.setVisible(true);
	    
	}
	
	public void resolveTimeOutProblem(){
		try {
			Thread.sleep(2000);
			this.controller.resolvingSet();
			//System.out.println("!");
			resolveTimeOutProblem();
		} catch (Exception e) {
			System.err.println("[Log-INTERFACE]: Le contact avec la base de donnée a été perdu.");
		}
	}
	
}
