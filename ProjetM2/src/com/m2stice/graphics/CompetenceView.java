package com.m2stice.graphics;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.LinkedList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.m2stice.model.Competence;
import com.m2stice.model.Domaine;
import com.m2stice.model.Ec;
import com.m2stice.model.Evaluation;
import com.m2stice.model.Item;
import com.m2stice.model.SousItem;

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
	
	private JTableNotEditable tableauDomaine;
	private JTableNotEditable tableauCompetence;
	private JTableNotEditable tableauItem;
	private JTableNotEditable tableauEC;
	private JTableNotEditable tableauSousItem;
	private JTableNotEditable tableauEvaluation;
	
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
			//System.out.println(d.getNom());
			donneesDomaine[cpt][0] = d.getNom().toUpperCase();
			cpt++;
		}
		String[] titre = {"Domaines de compétences"};
		tableauDomaine = new JTableNotEditable(donneesDomaine,titre);
		tableauDomaine.setPreferredSize(new Dimension(50,1000));
		this.bloc.add(new JScrollPane(tableauDomaine));
	}
	
	public void setCompetenceJTable(LinkedList<Competence> lc){
		donneesCompetence = new Object[lc.size()][1];
		int cpt = 0;
		for(Competence c:lc){
			donneesCompetence[cpt][0] = c.getNom().toUpperCase();
			cpt++;
		}
		String[] titre = {"Compétences"};
		tableauCompetence = new JTableNotEditable(donneesDomaine,titre);
		tableauCompetence.setPreferredSize(new Dimension(50,1000));
		this.bloc.add(new JScrollPane(tableauCompetence));
	}
	public void setItemJTable(LinkedList<Item> li){
		donneesItem = new Object[li.size()][1];
		int cpt = 0;
		for(Item i:li){
			donneesItem[cpt][0] = i.getNom().toUpperCase();
			cpt++;
		}
		String[] titre = {"Items"};
		tableauItem = new JTableNotEditable(donneesItem,titre);
		tableauItem.setPreferredSize(new Dimension(50,1000));
		this.bloc.add(new JScrollPane(tableauItem));
	}
	public void setEcJTable(LinkedList<Ec> lec){
		donneesEC = new Object[lec.size()][1];
		int cpt = 0;
		for(Ec ec:lec){
			donneesEC[cpt][0] = ec.getNom().toUpperCase();
			cpt++;
		}
		String[] titre = {"EC"};
		tableauEC = new JTableNotEditable(donneesEC,titre);
		tableauEC.setPreferredSize(new Dimension(50,1000));
		this.bloc.add(new JScrollPane(tableauEC));
	}
	public void setSousItemJTable(LinkedList<SousItem> lsi){
		donneesSousItem = new Object[lsi.size()][1];
		int cpt = 0;
		for(SousItem si:lsi){
			//System.out.println(d.getNom());
			donneesSousItem[cpt][0] = si.getNom().toUpperCase();
			cpt++;
		}
		String[] titre = {"SousItem"};
		tableauSousItem = new JTableNotEditable(donneesSousItem,titre);
		tableauSousItem.setPreferredSize(new Dimension(50,1000));
		this.bloc.add(new JScrollPane(tableauSousItem));
	}
	public void setEvaluationJTable(LinkedList<Evaluation> le){
		donneesEvaluation = new Object[le.size()][1];
		int cpt = 0;
		for(Evaluation e:le){
			//System.out.println(d.getNom());
			donneesEvaluation[cpt][0] = e.getNom().toUpperCase();
			cpt++;
		}
		String[] titre = {"Evaluations"};
		tableauEvaluation = new JTableNotEditable(donneesEvaluation,titre);
		tableauEvaluation.setPreferredSize(new Dimension(50,1000));
		this.bloc.add(new JScrollPane(tableauEvaluation));
	}
}
