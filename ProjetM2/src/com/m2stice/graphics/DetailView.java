package com.m2stice.graphics;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class DetailView extends JPanel {

	/**
	 * Numéro de série
	 */
	private static final long serialVersionUID = 971L;
	private Interface interfaceUtilisateur;
	private JPanel bloc;
	private JScrollPane blocInferieur;
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
		
		entete.setPreferredSize(new Dimension(0,20));
		entete.setBackground(Color.WHITE);
		
		contenu.setBackground(Color.WHITE);
		
		bloc.setLayout(new BorderLayout());
		bloc.add(entete,BorderLayout.NORTH);
		bloc.add(contenu,BorderLayout.CENTER);
		bloc.setOpaque(false);
		
		blocInferieur = new JScrollPane(bloc);
		blocInferieur.setOpaque(false);
		
		this.setLayout(new BorderLayout());
		this.add(blocInferieur,BorderLayout.CENTER);
		this.setOpaque(false);
	}
	
	public void setDetail(String entete,String contenu){
		this.entete.setText(entete);
		this.contenu.setText(contenu);
	}

}
