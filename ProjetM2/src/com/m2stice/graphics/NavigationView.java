package com.m2stice.graphics;

import java.awt.Dimension;

import javax.swing.JPanel;

public class NavigationView extends JPanel {
	/**
	 * Numéro de série
	 */
	private static final long serialVersionUID = 971L;
	
	Interface interfaceUtilisateur;
	private JPanel bloc = new JPanel();			
	private BanniereComponent banniere;
	
	public void init(){
		banniere = new BanniereComponent(interfaceUtilisateur,"ResultatViewBanniere.jpg");
		banniere.setPreferredSize(new Dimension(1024,69));
	}
	
	public NavigationView(Interface interfaceUtilisateur){
		this.interfaceUtilisateur = interfaceUtilisateur;
		this.init();
	}

}
