package com.m2stice.graphics;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.LinkedList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import com.m2stice.controller.NavigationViewListener;
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
	
	public JTableNotEditable tableauDomaine = new JTableNotEditable();
	public JTableNotEditable tableauCompetence =  new JTableNotEditable();
	public JTableNotEditable tableauItem = new JTableNotEditable();
	public JTableNotEditable tableauEC = new JTableNotEditable();
	public JTableNotEditable tableauSousItem = new JTableNotEditable();
	public JTableNotEditable tableauEvaluation = new JTableNotEditable();
	
	private Object[][] donneesDomaine;
	Object[][] donneesCompetence;
	Object[][] donneesItem;
	Object[][] donneesEC;
	Object[][] donneesSousItem;
	Object[][] donneesEvaluation;
	
	ListSelectionModel cellSelectionDomaine = tableauDomaine.getSelectionModel();
	ListSelectionModel cellSelectionCompetence  = tableauCompetence.getSelectionModel();
	ListSelectionModel cellSelectionItem = tableauItem.getSelectionModel();
	ListSelectionModel cellSelectionEC   = tableauEC.getSelectionModel();
	ListSelectionModel cellSelectionSousItem = tableauSousItem.getSelectionModel();
	ListSelectionModel cellSelectionEvaluation = tableauEvaluation.getSelectionModel();
	
	private Interface interfaceUtilisateur;						//Liaison avec l'interface
	
	public boolean click_competence;
	public boolean click_item;
	public boolean click_ec;
	public boolean click_sous_item;
	public boolean click_evaluation;
	
	/**
	 * Création de la vue
	 */
	public void init(){
		click_competence=false;
		click_item=false;
		click_ec=false;
		click_sous_item=false;
		click_evaluation=false;
		
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
		
		cellSelectionDomaine = tableauDomaine.getSelectionModel();
		cellSelectionDomaine.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		tableauDomaine.setPreferredSize(new Dimension(50,1000));
		this.bloc.add(new JScrollPane(tableauDomaine));
		interfaceUtilisateur.repaint();
	}
	
	public void setCompetenceJTable(LinkedList<Competence> lc,NavigationViewListener nvl){
		
		if(click_evaluation == true)
		{
			this.bloc.remove(5);
			click_evaluation = false;
		}
		if(click_sous_item == true)
		{
			this.bloc.remove(4);
			click_sous_item = false;
		}
		if(click_ec == true)
		{
			this.bloc.remove(3);
			click_ec = false;
		}
		if(click_item == true)
		{
			this.bloc.remove(2);
			click_item = false;
		}
		if(click_competence == true)
			this.bloc.remove(1);
		
		
		
		
		
		donneesCompetence = new Object[lc.size()][1];
		int cpt = 0;
		for(Competence c:lc){
			donneesCompetence[cpt][0] = c.getNom().toUpperCase();
			cpt++;
		}
		String[] titre = {"Compétences"};
		tableauCompetence = new JTableNotEditable(donneesCompetence,titre);
		
		cellSelectionCompetence = tableauCompetence.getSelectionModel();
		cellSelectionCompetence.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		cellSelectionCompetence.addListSelectionListener(nvl.getCompetenceTableListener(tableauCompetence));
		
		tableauCompetence.setPreferredSize(new Dimension(50,1000));
		click_competence = true;
		this.bloc.add(new JScrollPane(tableauCompetence));
		
		interfaceUtilisateur.repaint();
	}
	public void setItemJTable(LinkedList<Item> li,NavigationViewListener nvl){
		if(click_evaluation == true)
		{
			this.bloc.remove(5);
			click_evaluation = false;
		}
		if(click_sous_item == true)
		{
			this.bloc.remove(4);
			click_sous_item = false;
		}
		if(click_ec == true)
		{
			this.bloc.remove(3);
			click_ec = false;
		}
		if(click_item == true)
		this.bloc.remove(2);
		
		
		donneesItem = new Object[li.size()][1];
		int cpt = 0;
		for(Item i:li){
			donneesItem[cpt][0] = i.getNom().toUpperCase();
			cpt++;
		}
		String[] titre = {"Items"};
		tableauItem = new JTableNotEditable(donneesItem,titre);
		
		cellSelectionItem = tableauItem.getSelectionModel();
		cellSelectionItem.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		cellSelectionItem.addListSelectionListener(nvl.getItemTableListener(tableauItem));
		
		tableauItem.setPreferredSize(new Dimension(50,1000));
		this.bloc.add(new JScrollPane(tableauItem));
		click_item = true;
		interfaceUtilisateur.repaint();
	}
	public void setEcJTable(LinkedList<Ec> lec,NavigationViewListener nvl){
		if(click_evaluation == true)
		{
			this.bloc.remove(5);
			click_evaluation = false;
		}
		if(click_sous_item == true)
		{
			this.bloc.remove(4);
			click_sous_item = false;
		}
		if(click_ec == true)
		this.bloc.remove(3);

		donneesEC = new Object[lec.size()][1];
		int cpt = 0;
		for(Ec ec:lec){
			donneesEC[cpt][0] = ec.getNom().toUpperCase();
			cpt++;
		}
		String[] titre = {"EC"};
		tableauEC = new JTableNotEditable(donneesEC,titre);
		
		cellSelectionEC = tableauEC.getSelectionModel();
		cellSelectionEC.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		cellSelectionEC.addListSelectionListener(nvl.getECTableListener(tableauEC));
		
		tableauEC.setPreferredSize(new Dimension(50,1000));
		this.bloc.add(new JScrollPane(tableauEC));
		click_ec = true;
		interfaceUtilisateur.repaint();
	}
	public void setSousItemJTable(LinkedList<SousItem> lsi,NavigationViewListener nvl){
		
		if(click_evaluation == true)
		{
			this.bloc.remove(5);
			click_evaluation = false;
		}
		if(click_sous_item == true)
		this.bloc.remove(4);
			
		donneesSousItem = new Object[lsi.size()][1];
		int cpt = 0;
		for(SousItem si:lsi){
			//System.out.println(d.getNom());
			donneesSousItem[cpt][0] = si.getNom().toUpperCase();
			cpt++;
		}
		String[] titre = {"SousItem"};
		tableauSousItem = new JTableNotEditable(donneesSousItem,titre);
		
		cellSelectionSousItem = tableauSousItem.getSelectionModel();
		cellSelectionSousItem.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		cellSelectionSousItem.addListSelectionListener(nvl.getSousItemTableListener(tableauSousItem));
		
		tableauSousItem.setPreferredSize(new Dimension(50,1000));
		this.bloc.add(new JScrollPane(tableauSousItem));
		click_sous_item=true;
		interfaceUtilisateur.repaint();
	}
	public void setEvaluationJTable(LinkedList<Evaluation> le,NavigationViewListener nvl){
		if(click_evaluation == true)
		this.bloc.remove(5);
			
		donneesEvaluation = new Object[le.size()][1];
		int cpt = 0;
		for(Evaluation e:le){
			//System.out.println(d.getNom());
			donneesEvaluation[cpt][0] = e.getNom().toUpperCase();
			cpt++;
		}
		String[] titre = {"Evaluations"};
		tableauEvaluation = new JTableNotEditable(donneesEvaluation,titre);
		
		cellSelectionEvaluation = tableauEvaluation.getSelectionModel();
		cellSelectionEvaluation.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		cellSelectionEvaluation.addListSelectionListener(nvl.getEvaluationTableListener(tableauEvaluation));
		
		tableauEvaluation.setPreferredSize(new Dimension(50,1000));
		this.bloc.add(new JScrollPane(tableauEvaluation));
		click_evaluation = true;
		interfaceUtilisateur.repaint();
	}
}