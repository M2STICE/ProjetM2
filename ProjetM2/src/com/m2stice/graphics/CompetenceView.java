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
 * @author BIABIANY
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
		bloc.setBackground(Color.GRAY);
		blocInferrieure = new JScrollPane(bloc);
		//blocInferrieure.setBackground(Color.WHITE);
		this.setOpaque(false);
		this.add(blocInferrieure,BorderLayout.CENTER);
		
		this.interfaceUtilisateur.revalidate();
	}
	
	/**
	 * Contructeur de la vue
	 * @param interfaceUtilisateur
	 */
	public CompetenceView(Interface interfaceUtilisateur){
		this.interfaceUtilisateur = interfaceUtilisateur;
		init();
	}
	
	public void setDomaineJTable(LinkedList<Domaine> ld, NavigationViewListener nvl){
		donneesDomaine = new Object[ld.size()][1];
		int cpt = 0;
		int maxLength = 0;
		for(Domaine d:ld){
			//System.out.println(d.getNom());
			if(d.getNom().length()>maxLength)
				maxLength = d.getNom().length();
			donneesDomaine[cpt][0] = d.getNom().toUpperCase();
			
			//Pour le code couleur
			if(nvl.listeCouleurDomaine !=null)
			{
				for(int i = 0; i<nvl.listeCouleurDomaine.size(); i++)
				{
					String tab[] = nvl.listeCouleurDomaine.get(i).split(";");
					int codeDomaine = Integer.parseInt(tab[0]);
					if(codeDomaine == d.getCode())
					{
						String nouveauContenu = tab[0]+";"+tab[1]+";"+d.getNom().toUpperCase();
						nvl.listeCouleurDomaine.set(i, nouveauContenu);
					}
				}
			}
			
			cpt++;
		}
		String[] titre = {"Domaines de compétences"};
		tableauDomaine = new JTableNotEditable(donneesDomaine,titre);
		tableauDomaine.setToolTipText("Tableau des domaines");
		
		//Pour le code couleur
		if(nvl.listeCouleurDomaine != null)
		{
			tableauDomaine.setDefaultRenderer(Object.class, new JTableCodeCouleur(nvl.listeCouleurDomaine));
		}
		
		cellSelectionDomaine = tableauDomaine.getSelectionModel();
		cellSelectionDomaine.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		cellSelectionDomaine.addListSelectionListener(nvl.getDomaineTableListener(tableauDomaine));
		
		//tableauDomaine.setPreferredSize(new Dimension(500,500));
		JScrollPane blocTableau = new JScrollPane(tableauDomaine);
		blocTableau.setBackground(Color.GRAY);
		blocTableau.setPreferredSize(new Dimension(maxLength*8,15+ld.size()*20));
		this.bloc.add(blocTableau);
		this.revalidate();
		this.repaint();
		
		click_competence = false;
		click_item = false;
		click_ec = false;
		click_sous_item = false;
		click_evaluation = false;
	}
	
	public void setCompetenceJTable(LinkedList<Competence> lc, NavigationViewListener nvl){
		
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
		{
			this.bloc.remove(1);
		}
		
		
		donneesCompetence = new Object[lc.size()][1];
		int cpt = 0;
		int maxLength = 0;
		for(Competence c:lc){
			if(c.getNom().length()>maxLength)
				maxLength = c.getNom().length();
			donneesCompetence[cpt][0] = c.getNom().toUpperCase();
			
			//Pour le code couleur
			if(nvl.listeCouleurCompetence != null)
			{
				for(int i = 0; i<nvl.listeCouleurCompetence.size() ; i++)
				{
					String tab[] = nvl.listeCouleurCompetence.get(i).split(";");
					int codeCompetence = Integer.parseInt(tab[0]);
					if(codeCompetence == c.getCode())
					{
						String nouveauContenu = tab[0]+";"+tab[1]+";"+c.getNom().toUpperCase();
						
						nvl.listeCouleurCompetence.set(i, nouveauContenu);
					}
					//System.out.println(nvl.listeCouleurCompetence.get(i));
				}
			}
			
			cpt++;
		}
		String[] titre = {"Compétences"};
		tableauCompetence = new JTableNotEditable(donneesCompetence,titre);
		
		//Pour le code couleur
		if(nvl.listeCouleurCompetence != null)
		{
			tableauCompetence.setDefaultRenderer(Object.class, new JTableCodeCouleur(nvl.listeCouleurCompetence));
		}
		
		cellSelectionCompetence = tableauCompetence.getSelectionModel();
		cellSelectionCompetence.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		cellSelectionCompetence.addListSelectionListener(nvl.getCompetenceTableListener(tableauCompetence));
		
		//tableauCompetence.setPreferredSize(new Dimension(50,1000));
		click_competence = true;
		JScrollPane blocTableau = new JScrollPane(tableauCompetence);
		blocTableau.setBackground(Color.GRAY);
		blocTableau.setPreferredSize(new Dimension(maxLength*8,20+lc.size()*18));
		if(maxLength>40)
			blocTableau.setPreferredSize(new Dimension(300,20+lc.size()*18));
		this.bloc.add(blocTableau);
		this.revalidate();
		this.repaint();
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
		{
			this.bloc.remove(2);
		}
		
		
		donneesItem = new Object[li.size()][1];
		int cpt = 0;
		int maxLength = 0;
		for(Item i:li){
			if(i.getNom().length()>maxLength)
				maxLength = i.getNom().length();
			donneesItem[cpt][0] = i.getNom().toUpperCase();
			
			//Pour le code couleur
			if(nvl.listeCouleurItem != null)
			{
				for(int j = 0; j<nvl.listeCouleurItem.size() ; j++)
				{
					String tab[] = nvl.listeCouleurItem.get(j).split(";");
					int codeItem = Integer.parseInt(tab[0]);
					if(codeItem == i.getCode())
					{
						String nouveauContenu = tab[0]+";"+tab[1]+";"+i.getNom().toUpperCase();
						nvl.listeCouleurItem.set(j, nouveauContenu);
					}
				}
			}
			
			cpt++;
		}
		String[] titre = {"Items"};
		tableauItem = new JTableNotEditable(donneesItem,titre);
		
		//Pour le code couleur
		if(nvl.listeCouleurItem != null)
		 {
			tableauItem.setDefaultRenderer(Object.class, new JTableCodeCouleur(nvl.listeCouleurItem));
		 }
		
		cellSelectionItem = tableauItem.getSelectionModel();
		cellSelectionItem.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		cellSelectionItem.addListSelectionListener(nvl.getItemTableListener(tableauItem));
		
		//tableauItem.setPreferredSize(new Dimension(50,1000));
		JScrollPane blocTableau = new JScrollPane(tableauItem);
		blocTableau.setBackground(Color.GRAY);
		blocTableau.setPreferredSize(new Dimension(maxLength*8,20+li.size()*18));
		if(maxLength>40)
			blocTableau.setPreferredSize(new Dimension(300,20+li.size()*18));
		this.bloc.add(blocTableau);
		click_item = true;
		this.revalidate();
		this.repaint();
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
		{
		 this.bloc.remove(3);
		 click_ec = false;
		}

		donneesEC = new Object[lec.size()][1];
		int cpt = 0;
		int maxLength = 0;
		for(Ec ec:lec){
			if(ec.getNom().length()>maxLength)
				maxLength = ec.getNom().length();
			donneesEC[cpt][0] = ec.getNom().toUpperCase();
			cpt++;
		}
		String[] titre = {"EC"};
		tableauEC = new JTableNotEditable(donneesEC,titre);
		
		cellSelectionEC = tableauEC.getSelectionModel();
		cellSelectionEC.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		cellSelectionEC.addListSelectionListener(nvl.getECTableListener(tableauEC));
		
		//tableauEC.setPreferredSize(new Dimension(50,1000));
		JScrollPane blocTableau = new JScrollPane(tableauEC);
		blocTableau.setBackground(Color.GRAY);
		blocTableau.setPreferredSize(new Dimension(maxLength*8,20+lec.size()*18));
		if(maxLength>40)
			blocTableau.setPreferredSize(new Dimension(300,20+lec.size()*18));
		this.bloc.add(blocTableau);
		click_ec = true;
		this.revalidate();
		this.repaint();
	}
	public void setSousItemJTable(LinkedList<SousItem> lsi,NavigationViewListener nvl){
		
		if(click_evaluation == true)
		{
			this.bloc.remove(5);
			click_evaluation = false;
		}
		if(click_sous_item == true)
		{	
			this.bloc.remove(4);
		}
			
		donneesSousItem = new Object[lsi.size()][1];
		int cpt = 0;
		int maxLength = 0;
		for(SousItem si:lsi){
			//System.out.println(d.getNom());
			if(si.getNom().length()>maxLength)
				maxLength = si.getNom().length();
			donneesSousItem[cpt][0] = si.getNom().toUpperCase();
			
			//Pour le code couleur
			if(nvl.listeCouleurSousItem != null)
			{
				for(int i = 0; i<nvl.listeCouleurSousItem.size() ; i++)
				{
					String tab[] = nvl.listeCouleurSousItem.get(i).split(";");
					int codeSousItem = Integer.parseInt(tab[0]);
					if(codeSousItem == si.getCode())
					{
						String nouveauContenu = tab[0]+";"+tab[1]+";"+si.getNom().toUpperCase();
						nvl.listeCouleurSousItem.set(i, nouveauContenu);
					}
				}
			}
			
			cpt++;
		}
		String[] titre = {"SousItem"};
		tableauSousItem = new JTableNotEditable(donneesSousItem,titre);
		
		//Pour le code couleur
		if(nvl.listeCouleurSousItem != null)
		{
		  tableauSousItem.setDefaultRenderer(Object.class, new JTableCodeCouleur(nvl.listeCouleurSousItem));
		}
		
		cellSelectionSousItem = tableauSousItem.getSelectionModel();
		cellSelectionSousItem.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		cellSelectionSousItem.addListSelectionListener(nvl.getSousItemTableListener(tableauSousItem));
		
		//tableauSousItem.setPreferredSize(new Dimension(50,1000));
		JScrollPane blocTableau = new JScrollPane(tableauSousItem);
		blocTableau.setBackground(Color.GRAY);
		blocTableau.setPreferredSize(new Dimension(maxLength*8,20+lsi.size()*18));
		if(maxLength>40)
			blocTableau.setPreferredSize(new Dimension(300,20+lsi.size()*18));
		this.bloc.add(blocTableau);
		click_sous_item=true;
		this.revalidate();
		this.repaint();
	}
	public void setEvaluationJTable(LinkedList<Evaluation> le,NavigationViewListener nvl){
		if(click_evaluation == true)
		{
			this.bloc.remove(5);
		}
		LinkedList<String> listCouleur = new LinkedList<String>();
		donneesEvaluation = new Object[le.size()][1];
		int cpt = 0;
		int maxLength = 0;
		for(Evaluation e:le){
			//System.out.println(d.getNom());
			if(e.getNom().length()>maxLength)
				maxLength = e.getNom().length();
			donneesEvaluation[cpt][0] = e.getNom().toUpperCase();
			
			//Pour le code couleur
			if(nvl.listeCouleurEvaluation != null)
			{
				for(int i = 0; i<nvl.listeCouleurEvaluation.size() ; i++)
				{
					String tab[] = nvl.listeCouleurEvaluation.get(i).split(";");
					int codeEvaluation = Integer.parseInt(tab[0]);
					if(codeEvaluation == e.getCode())
					{
						String nouveauContenu = tab[0]+";"+tab[1]+";"+e.getNom().toUpperCase();
						listCouleur.add(nouveauContenu);
						nvl.listeCouleurEvaluation.set(i, nouveauContenu);
					}
				}
			}
			
			cpt++;
		}
		String[] titre = {"Evaluations"};
		tableauEvaluation = new JTableNotEditable(donneesEvaluation,titre);
		
		//Pour le code couleur
		if(nvl.listeCouleurEvaluation != null)
		{
		 tableauEvaluation.setDefaultRenderer(Object.class, new JTableCodeCouleur(listCouleur));
		}
		
		cellSelectionEvaluation = tableauEvaluation.getSelectionModel();
		cellSelectionEvaluation.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		cellSelectionEvaluation.addListSelectionListener(nvl.getEvaluationTableListener(tableauEvaluation));
		
		//tableauEvaluation.setPreferredSize(new Dimension(50,1000));
		JScrollPane blocTableau = new JScrollPane(tableauEvaluation);
		blocTableau.setBackground(Color.GRAY);
		blocTableau.setPreferredSize(new Dimension(maxLength*8,20+le.size()*18));
		if(maxLength<15)
			blocTableau.setPreferredSize(new Dimension(150,20+le.size()*18));
		this.bloc.add(blocTableau);
		click_evaluation = true;
		this.revalidate();
		this.repaint();
	}
	
}