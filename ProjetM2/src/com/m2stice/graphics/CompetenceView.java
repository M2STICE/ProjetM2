package com.m2stice.graphics;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.LinkedList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.m2stice.model.Domaine;

/**
 * 
 * CompetenceView - La classe qui va générer la vue des compétences.
 * @author Emmanuel
 * @version 1.0
 * @copyright (C) Master 2 2015
 * @date 14/12/2015
 *
 */
public class CompetenceView extends JPanel {

	/**
	 * Numéro de série
	 */
	private static final long serialVersionUID = 971L;
	private JScrollPane blocInferrieure;
	public JPanel bloc = new JPanel();
	
	public JTable tableauDomaine;
	private JTable tableauCompetence;
	private JTable tableauItem;
	private JTable tableauEC;
	private JTable tableauSousItem;
	private JTable tableauEvaluation;
	
	private Object[][] donneesDomaine;
	Object[][] donneesCompetence;
	Object[][] donneesItem;
	Object[][] donneesEC;
	Object[][] donneesSousItem;
	Object[][] donneesEvaluation;
	
	
	private Interface interfaceUtilisateur;						//Liaison avec l'interface
	
	/**
	 * Création de la vue
	 */
	public void init(){
		
		this.setLayout(new BorderLayout());
		bloc.setLayout(new FlowLayout(FlowLayout.LEADING));
		blocInferrieure = new JScrollPane(bloc);
		blocInferrieure.setBackground(Color.WHITE);
		this.add(blocInferrieure,BorderLayout.CENTER);
	}
	
	/**
	 * Contructeur de la vue
	 * @param interfaceUtilisateur
	 */
	public CompetenceView(Interface interfaceUtilisateur){
		this.interfaceUtilisateur = interfaceUtilisateur;
		init();
	}
	
	public void setDomaineJTable(LinkedList<Domaine> ld){
		donneesDomaine = new Object[ld.size()][1];
		int cpt = 0;
		for(Domaine d:ld){
			System.out.println(d.getNom());
			donneesDomaine[cpt][0] = d.getNom().toUpperCase();
			cpt++;
		}
		String[] titre = {"Domaines de compétences"};
		tableauDomaine = new JTable(donneesDomaine,titre);
		tableauDomaine.setPreferredSize(new Dimension(50,1000));
		this.bloc.add(new JScrollPane(tableauDomaine));
	}

}
