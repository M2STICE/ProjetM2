package com.m2stice.graphics;

import java.awt.Dimension;

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
	
	private Interface interfaceUtilisateur;				//Liaison avec l'applet
	private JPanel bloc = new JPanel();			//Bloc de container transparent
	private BanniereComponent banniere;			//Bannière de la fenêtre
	
	public void init(){
		banniere = new BanniereComponent(interfaceUtilisateur,"ResultatViewBanniere.jpg");
		banniere.setPreferredSize(new Dimension(1024,69));
		
		//Paramètrage de la vue
		this.setOpaque(false);
		this.setVisible(true);
		
		//Agencement de la vue
		this.add(bloc);
	}
	
	public NavigationView(Interface interfaceUtilisateur){
		this.interfaceUtilisateur = interfaceUtilisateur;
		this.init();
	}

}
