package com.m2stice.controller;

import java.util.LinkedList;

import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

import com.m2stice.graphics.CompetenceView;
import com.m2stice.graphics.Interface;
import com.m2stice.graphics.NavigationView;
import com.m2stice.graphics.ResultatView;
import com.m2stice.graphics.SyllabusView;
import com.m2stice.model.Competence;
import com.m2stice.model.Domaine;
import com.m2stice.model.Ec;
import com.m2stice.model.Item;

public class NavigationViewListener {
	
	private Interface interfaceUtilisateur;
	private ResultatView resultatView;
	private NavigationView navigationView;
	private SyllabusView syllabusView;
	private CompetenceView competenceView;
	
	private String comparaisonDomaineSelection=""; 
	private String comparaisonCompetenceSelection="";
	private String comparaisonItemSelection="";
	private String comparaisonEcSelection="";
	private String comparaisonSousItemSelection="";
	private String comparaisonEvaluationSelection="";
	
	public NavigationViewListener(Interface interfaceUtilisateur,NavigationView navigationView){
		this.interfaceUtilisateur = interfaceUtilisateur;
		this.navigationView = navigationView;
	}
	
	public void setCompetenceView(CompetenceView competenceView){
		this.competenceView = competenceView;
	}
	
	public void setSyllabusView(SyllabusView syllabusView){
		this.syllabusView = syllabusView;
	}
	
	public void setDomaine(){
		int codeDiplome = navigationView.diplomeCourant.getCode();
		String requete = "select * from domaine "
				+ "inner join diplome on "
				+ "domaine.code_diplome = diplome.code_diplome "
				+ "where diplome.code_diplome = " + codeDiplome + ";";
		competenceView.setDomaineJTable(interfaceUtilisateur.getController().getDomaine(requete));
	}
	
	public void setCompetence(){
		int codeDomaine = navigationView.domaineCourant.getCode();
		String requete = "select * from competence "
				+ "where competence.code_domaine = " + codeDomaine + ";";
		competenceView.setCompetenceJTable(interfaceUtilisateur.getController().getCompetence(requete),this);
	}
	
	public void setItem(){
		int codeCompetence = navigationView.competenceCourante.getCode();
		String requete = "select * from item "
				+ "where item.code_competence = " + codeCompetence + ";";
		competenceView.setItemJTable(interfaceUtilisateur.getController().getItem(requete),this);
	}
	
	public void setEc(){
		int codeItem = navigationView.itemCourant.getCode();
		String requete = "select * from ec,ec_item "
				+ "where ec.code_ec = ec_item.code_ec and ec_item.code_item = " + codeItem + ";";
		competenceView.setEcJTable(interfaceUtilisateur.getController().getEc(requete),this);
	}
	
	public void setSousItem(){
		int codeEc = navigationView.ecCourant.getCode();
		String requete = "select * from sous_item,ec_sous_item"
				+ " where sous_item.code_sous_item = ec_sous_item.code_sous_item and ec_sous_item.code_ec = " + codeEc + ";";
		competenceView.setSousItemJTable(interfaceUtilisateur.getController().getSousItem(requete),this);
	}
	
	public void setEvaluation(){
		int codeSousItem = navigationView.sousItemCourant.getCode();
		String requete = "select * from evaluation, sous_item_evaluation"
				+ " where evaluation.code_evaluation = sous_item_evaluation.code_evaluation and sous_item_evaluation.code_sous_item =" + codeSousItem + ";";
		competenceView.setEvaluationJTable(interfaceUtilisateur.getController().getEvaluation(requete),this);
	}
	
	public ListSelectionListener getDomaineTableListener(JTable table){
		return new ListSelectionListener(){
			public void valueChanged(ListSelectionEvent arg0) {
				
				String nomDomaineSelection = null;
		        int[] selectedRow = table.getSelectedRows();
		        int[] selectedColumns = table.getSelectedColumns();

		        for (int i = 0; i < selectedRow.length; i++) {
		          for (int j = 0; j < selectedColumns.length; j++) {
		            nomDomaineSelection = (String) table.getValueAt(selectedRow[i], selectedColumns[j]);
		          }
		        }
		       
		       if(comparaisonDomaineSelection.compareTo(nomDomaineSelection)!=0)
		       {
		    	   String requete = "select * from domaine "
		       		+ "where nom_domaine = '"+nomDomaineSelection+"'";
		       
		    	   navigationView.domaineCourant = interfaceUtilisateur.getController().getDomaine(requete).get(0);
		    	   setCompetence();
		    	   comparaisonDomaineSelection = nomDomaineSelection;
		       }
			}
			
		};
	}
	
	public ListSelectionListener getCompetenceTableListener(JTable table){
		return new ListSelectionListener(){

			@Override
			public void valueChanged(ListSelectionEvent arg0) {
		    	
				String nomCompetenceSelection = null;
		        int[] selectedRow = table.getSelectedRows();
		        int[] selectedColumns = table.getSelectedColumns();

		        for (int i = 0; i < selectedRow.length; i++) {
		          for (int j = 0; j < selectedColumns.length; j++) {
		            nomCompetenceSelection = (String) table.getValueAt(selectedRow[i], selectedColumns[j]);
		          }
		        }
		        
		        if(comparaisonCompetenceSelection.compareTo(nomCompetenceSelection)!=0)
			       {
			    	   String requete = "select * from competence "
			       		+ "where nom_competence = '"+nomCompetenceSelection+"'";
			    	   navigationView.competenceCourante = interfaceUtilisateur.getController().getCompetence(requete).get(0);

			    	   setItem();
			    	   comparaisonCompetenceSelection = nomCompetenceSelection;
			       }
		        
			}
			
		};
	}
	
	public ListSelectionListener getItemTableListener(JTable table){
		return new ListSelectionListener(){

			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				
				String nomItemSelection = null;
		        int[] selectedRow = table.getSelectedRows();
		        int[] selectedColumns = table.getSelectedColumns();

		        for (int i = 0; i < selectedRow.length; i++) {
		          for (int j = 0; j < selectedColumns.length; j++) {
		            nomItemSelection = (String) table.getValueAt(selectedRow[i], selectedColumns[j]);
		          }
		        }
		        if(comparaisonItemSelection.compareTo(nomItemSelection)!=0)
			       {
			    	   String requete = "select * from item "
			       		+ "where nom_item = '"+nomItemSelection+"'";
			       
			    	   navigationView.itemCourant = interfaceUtilisateur.getController().getItem(requete).get(0);
			    	   setEc();
			    	   comparaisonItemSelection = nomItemSelection;
			       }
			}
			
		};
	}
	
	public ListSelectionListener getECTableListener(JTable table){
		return new ListSelectionListener(){

			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				
				String nomEcSelection = null;
		        int[] selectedRow = table.getSelectedRows();
		        int[] selectedColumns = table.getSelectedColumns();

		        for (int i = 0; i < selectedRow.length; i++) {
		          for (int j = 0; j < selectedColumns.length; j++) {
		            nomEcSelection = (String) table.getValueAt(selectedRow[i], selectedColumns[j]);
		          }
		        }
		        if(comparaisonEcSelection.compareTo(nomEcSelection)!=0)
			       {
			    	   String requete = "select * from ec "
			       		+ "where nom_ec = '"+nomEcSelection+"'";
			       
			    	   navigationView.ecCourant = interfaceUtilisateur.getController().getEc(requete).get(0);
			    	   setSousItem();
			    	   comparaisonEcSelection = nomEcSelection;
			       }
			}
			
		};
	}
	
	public ListSelectionListener getSousItemTableListener(JTable table){
		return new ListSelectionListener(){

			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				
				String nomSousItemSelection = null;
		        int[] selectedRow = table.getSelectedRows();
		        int[] selectedColumns = table.getSelectedColumns();

		        for (int i = 0; i < selectedRow.length; i++) {
		          for (int j = 0; j < selectedColumns.length; j++) {
		            nomSousItemSelection = (String) table.getValueAt(selectedRow[i], selectedColumns[j]);
		          }
		        }
		        
		        if(comparaisonSousItemSelection.compareTo(nomSousItemSelection)!=0)
			       {
			    	   String requete = "select * from sous_item "
			       		+ "where nom_sous_item = '"+nomSousItemSelection+"'";
			       
			    	   navigationView.sousItemCourant = interfaceUtilisateur.getController().getSousItem(requete).get(0);
			    	   setEvaluation();
			    	   comparaisonSousItemSelection = nomSousItemSelection;
			       }
		        
				
			}
			
		};
	}
	
	public ListSelectionListener getEvaluationTableListener(JTable table){
		return new ListSelectionListener(){

			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				
				
			}
			
		};
	}
	
	
	public TreeSelectionListener getSyllabusListener(){
		return new TreeSelectionListener() {
			
			@Override
			public void valueChanged(TreeSelectionEvent e) 
			{
				System.out.println("[Log-NAVIGATION_VIEW_LISTENER]: "+e.getPath().toString());
				
				String cheminSyllabus[] = e.getPath().toString().split(",");
				
				/*
				 * 0 - Syllabus
				 * 1 - Diplome
				 * 2 - Année
				 * 3 - Semestre
				 * 4 - UE
				 * 5 - EC
				 * 
				 * Enlever ] du derniere
				 * */
				
				int tailleCheminSyllabus = cheminSyllabus.length - 1;
				String requete = null;
				
				if (tailleCheminSyllabus == 2)
				{
					cheminSyllabus[2] = cheminSyllabus[2].substring(1, cheminSyllabus[2].length()-1);
					
					LinkedList<Ec> lesEc = new LinkedList<Ec>();
					requete = "select * from ec "
							+ "inner join ue on "
							+ "ue.code_ue = ec.code_ue "
							+ "inner join diplome on "
							+ "diplome.code_diplome = ue.code_diplome "
							+ "inner join diplome_annee on "
							+ "diplome_annee.code_diplome = diplome.code_diplome "
							+ "inner join annee on "
							+ "diplome_annee.code_annee = annee.code_annee "
							+ "where nom_annee = '" + cheminSyllabus[2] + "' "
							+ "and diplome.code_diplome = " + navigationView.diplomeCourant.getCode();

					lesEc = interfaceUtilisateur.getController().getEc(requete);
					
					LinkedList<Item> lesItemsGlobal = new LinkedList<Item>();
					
					int i = 0;
					while (i < lesEc.size())
					{
						LinkedList<Item> lesItems = new LinkedList<Item>();
						requete = "select * from item "
								+ "inner join ec_item on "
								+ "ec_item.code_item = item.code_item "
								+ "inner join ec on "
								+ "ec.code_ec = ec_item.code_ec "
								+ "where ec.code_ec = " + lesEc.get(i).getCode();
						lesItems = interfaceUtilisateur.getController().getItem(requete);
						
						for (int item = 0; item < lesItems.size(); item++)
						{
							lesItemsGlobal.add(lesItems.get(item));
						}
	
						i++;
					}
					
					LinkedList<Competence> lesCompetencesGlobales = new LinkedList<Competence>();
					LinkedList<Integer> listCodesComp = new LinkedList<Integer>();
					
					i = 0;
					while (i < lesItemsGlobal.size())
					{
						LinkedList<Competence> lesCompetences = new LinkedList<Competence>();
						requete = "select * from competence "
								+ "inner join item on "
								+ "item.code_competence = competence.code_competence "
								+ "where code_item = " + lesItemsGlobal.get(i).getCode();
						
						lesCompetences = interfaceUtilisateur.getController().getCompetence(requete);
						
						for (int comp = 0; comp < lesCompetences.size(); comp++)
						{
							if (listCodesComp.indexOf(lesCompetences.get(comp).getCode()) == -1)
							{
								lesCompetencesGlobales.add(lesCompetences.get(comp));
								listCodesComp.add(lesCompetences.get(comp).getCode());
							}
						}
					
						i++;
					}

					LinkedList<Domaine> lesDomainesGlobales = new LinkedList<Domaine>();
					LinkedList<Integer> listCodeDomaines = new LinkedList<>();
					
					i = 0;
					while (i < listCodesComp.size()) 
					{
						LinkedList<Domaine> lesDomaines = new LinkedList<Domaine>();
						requete = "select * from domaine "
								+ "inner join competence on "
								+ "competence.code_domaine = domaine.code_domaine "
								+ "where competence.code_competence = " + listCodesComp.get(i);
						
						lesDomaines = interfaceUtilisateur.getController().getDomaine(requete);
						
						for (int j = 0; j < lesDomaines.size(); j++) 
						{
							if (listCodeDomaines.indexOf(lesDomaines.get(j).getCode()) == -1){
								lesDomainesGlobales.add(lesDomaines.get(j));
								listCodeDomaines.add(lesDomaines.get(j).getCode());
							}
						}
						i++;
					}
					competenceView.bloc.removeAll();
					competenceView.setDomaineJTable(lesDomainesGlobales);
					
				}
				else if (tailleCheminSyllabus == 3)
				{
					
				}
				else if (tailleCheminSyllabus == 4)
				{
					
				}
				else if (tailleCheminSyllabus == 1)
				{
					
				}
			}
		};
	}
	
}
