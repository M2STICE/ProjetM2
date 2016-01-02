package com.m2stice.graphics;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.m2stice.model.Competence;
import com.m2stice.model.Domaine;
import com.m2stice.model.Ec;

public class DetailView extends JPanel {

	/**
	 * Numéro de série
	 */
	private static final long serialVersionUID = 971L;
	private Interface interfaceUtilisateur;
	private JPanel bloc;
	private JScrollPane blocInferieur;
	private JLabel entete;
	private JTextArea contenu;
	
	public DetailView(Interface interfaceUtilisateur) {
		this.interfaceUtilisateur = interfaceUtilisateur;
		init();
	}
	
	public void init(){
		this.bloc = new JPanel();
		this.entete = new JLabel();
		this.contenu = new JTextArea();
		
		entete.setPreferredSize(new Dimension(0,20));
		entete.setOpaque(true);
		entete.setFont(new Font("Gill Sans MT",Font.BOLD,15));
		entete.setBackground(Color.WHITE);
		
		contenu.setOpaque(true);
		contenu.setFont(new Font("Gill Sans MT",Font.ROMAN_BASELINE,11));
		contenu.setBackground(Color.WHITE);
		contenu.setEditable(false);
		
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
	
	public void afficher(Domaine domaine){
		setDetail(" Domaine: "+domaine.getNom().toUpperCase(), "  Code: "+domaine.getCode()
			+"\n  Code du diplome: "+domaine.getCodeDiplome());
	}
	
	public void afficher(Competence competence){
		setDetail(" Compétence: "+competence.getNom().toUpperCase(), "  Code: "+competence.getCode()
			+"\n  Code du domaine: "+competence.getCodeDomaine());
	}
	
	public void afficher(Ec ec){
		setDetail(" EC: "+ec.getNom().toUpperCase(), "  Code: "+ec.getCode()
			+"\n  Coefficent: "+ec.getCoefficient()
			+"\n  Descriptions: "+ec.getResume()
			+"\n  Nombres ECTS: "+ec.getNombreEcts());
	}

}
