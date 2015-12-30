package com.m2stice.graphics;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class DetailView extends JPanel {

	/**
	 * Numéro de série
	 */
	private static final long serialVersionUID = 971L;
	private Interface interfaceUtilisateur;
	private JPanel bloc;
	private JLabel entete;
	private JLabel contenu;
	
	public DetailView(Interface interfaceUtilisateur) {
		this.interfaceUtilisateur = interfaceUtilisateur;
		init();
	}
	
	public void init(){
		this.bloc = new JPanel();
		this.entete = new JLabel("Information:");
		this.contenu = new JLabel("\"...\"");
		
		bloc.setLayout(new BorderLayout());
		
		bloc.add(entete,BorderLayout.NORTH);
		bloc.add(contenu,BorderLayout.CENTER);
	}
	
	public void setDetail(String entete,String contenu){
		this.entete.setText(entete);
		this.contenu.setText(contenu);
	}

}
