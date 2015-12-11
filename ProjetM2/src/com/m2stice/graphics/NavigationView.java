package com.m2stice.graphics;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
/**
 * 
 * @author Emmanuel
 *
 */
public class NavigationView extends JPanel {
	/**
	 * Numéro de série
	 */
	private static final long serialVersionUID = 971L;
	
	private String mouseMode = "click"; 			//Type de pointeur (click ou zoom_plus ou zoom_moins)
	
	private Interface interfaceUtilisateur;			//Liaison avec l'applet
	private JPanel bloc = new JPanel();				//Bloc de container transparent
	private JPanel blocEntete = new JPanel();   	//Bloc de l'entete
	private JPanel blocCommande = new JPanel(); 	//Bloc qui contient les boutons
	private JButton clickButton = new JButton();
	private BanniereComponent banniere;				//Bannière de la fenêtre
	
	public void init(){
		
		//Paramètrage des composants
		//
		banniere = new BanniereComponent(interfaceUtilisateur,"ResultatViewBanniere.jpg");
		banniere.setPreferredSize(new Dimension(1024,69));
		//
		clickButton.setPreferredSize(new Dimension(50,50));
		clickButton.setIcon(new ImageIcon(interfaceUtilisateur.loadImage("BoutonFlecheIcon.png")));
		//
		blocCommande.setLayout(new FlowLayout());
		blocCommande.setPreferredSize(new Dimension(1024,60));
		blocCommande.add(clickButton,FlowLayout.LEFT);
		//
		blocEntete.setLayout(new BorderLayout());
		blocEntete.add(banniere,BorderLayout.NORTH);
		blocEntete.add(blocCommande,BorderLayout.CENTER);
		blocEntete.setPreferredSize(new Dimension(1024,130));
		blocEntete.setOpaque(false);
		//
		bloc.setLayout(new BorderLayout());
		bloc.add(blocEntete,BorderLayout.NORTH);
		bloc.setOpaque(false);
		
		//Paramètrage de la vue
		this.setOpaque(false);
		this.setVisible(true);
		
		//Agencement de la vue
		this.setLayout(new BorderLayout());
		this.add(bloc,BorderLayout.CENTER);
	}
	
	public NavigationView(Interface interfaceUtilisateur){
		this.interfaceUtilisateur = interfaceUtilisateur;
		this.init();
	}

}
