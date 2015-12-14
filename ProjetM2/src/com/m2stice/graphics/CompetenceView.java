package com.m2stice.graphics;

import java.util.LinkedList;

import javax.swing.JPanel;
import javax.swing.JTable;

import com.m2stice.controller.NavigationViewListener;
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
	
	private String titreDomaine[];
	private String titreCompetence[];
	private String titreItem[];
	private String titreEc[];
	private String titreSousItem[];
	private String titreEvaluation[];
	
	private JTable tableauDomaine;
	private JTable tableauCompetence;
	private JTable tableauItem;
	private JTable tableauEC;
	private JTable tableauSousItem;
	private JTable tableauEvaluation;
	
	Object[][] donneesDomaine;
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
		titreDomaine[0] = "Domaines de compétences";
		titreCompetence[0] = "Compétences";
		titreItem[0] = "Items";
		titreEc[0] = "EC";
		titreSousItem[0] = "Sous Items";
		titreEvaluation[0] = "Evaluations";
		
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
			donneesDomaine[cpt][0] = d.getNom();
			cpt++;
		}
		tableauDomaine = new JTable(donneesDomaine,titreDomaine);
	}

}
