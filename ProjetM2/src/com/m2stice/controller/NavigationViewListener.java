package com.m2stice.controller;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;

import com.m2stice.graphics.CompetenceView;
import com.m2stice.graphics.DetailView;
import com.m2stice.graphics.Interface;
import com.m2stice.graphics.NavigationView;
import com.m2stice.graphics.SyllabusView;
import com.m2stice.model.Annee;
import com.m2stice.model.Competence;
import com.m2stice.model.Domaine;
import com.m2stice.model.Ec;
import com.m2stice.model.Etudiant;
import com.m2stice.model.Evaluation;
import com.m2stice.model.EvaluationEtudiant;
import com.m2stice.model.Intervenant;
import com.m2stice.model.Item;
import com.m2stice.model.SousItem;

/**
 * NavigationViewListener - Classe qui gère la vue de navigation.
 * @author BIABIANY
 * @version 2.0 
 * @revision 21/12
 * BIABIANY, HENRY & CISNEROS
 */

public class NavigationViewListener {
	
	private Interface interfaceUtilisateur;
	//private ResultatView resultatView;
	private NavigationView navigationView;
	//private SyllabusView syllabusView;
	private CompetenceView competenceView;
	private DetailView detailView;
	
	private String comparaisonDomaineSelection=""; 
	private String comparaisonCompetenceSelection="";
	private String comparaisonItemSelection="";
	private String comparaisonEcSelection="";
	private String comparaisonSousItemSelection="";
	//private String comparaisonEvaluationSelection="";public LinkedList<String> listCouleurEvaluation;
	
	public LinkedList<String> listeCouleurSousItem=null;
	public LinkedList<String> listeCouleurItem=null;
	public LinkedList<String> listeCouleurCompetence=null;
	public LinkedList<String> listeCouleurDomaine=null;
	public LinkedList<String> listeCouleurEvaluation=null;
	
	LinkedList<Intervenant> listeIntervenant = new LinkedList<Intervenant>();
	
	public NavigationViewListener(Interface interfaceUtilisateur,NavigationView navigationView){
		this.interfaceUtilisateur = interfaceUtilisateur;
		this.navigationView = navigationView;
	}
	
	public void setCompetenceView(CompetenceView competenceView){
		this.competenceView = competenceView;
	}
	
	public void setSyllabusView(SyllabusView syllabusView){
		//this.syllabusView = syllabusView;
	}
	
	public void setDetailView(DetailView detailView){
		this.detailView = detailView;
	}
	
	public void setDomaine(){
		int codeDiplome = navigationView.diplomeCourant.getCode();
		String requete = "select domaine.code_domaine, "
				+ "domaine.nom_domaine,"
				+ "domaine.code_diplome "
				+ "from domaine "
				+ "inner join diplome on "
				+ "domaine.code_diplome = diplome.code_diplome "
				+ "where diplome.code_diplome = " + codeDiplome + ";";
		competenceView.setDomaineJTable(interfaceUtilisateur.getController().getDomaine(requete), this);
	}
	
	public void setCompetence(){
		int codeDomaine = navigationView.domaineCourant.getCode();
		String requete = "select competence.code_competence,"
				+ "competence.nom_competence,"
				+ "competence.code_domaine "
				+ "from competence "
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
		String requete = "select ec.code_ec, "
				+ "ec.nom_ec,"
				+ "ec.coefficient_ec, "
				+ "ec.nombre_ects, "
				+ "ec.volume_heure_cours, "
				+ "ec.volume_heure_TD, "
				+ "ec.volume_heure_TP, "
				+ "ec.volume_heure_BE, "
				+ "ec.volume_heure_TPERSO, "
				+ "ec.resume_ec, "
				+ "ec.code_ue, "
				+ "ec.responsable_ec, "
				+ "ec.code_semestre "
				+ "from ec,ec_item "
				+ "where ec.code_ec = ec_item.code_ec and ec_item.code_item = " + codeItem + ";";
		competenceView.setEcJTable(interfaceUtilisateur.getController().getEc(requete),this);
	}
	
	public void setSousItem(){
		int codeEc = navigationView.ecCourant.getCode();
		int codeItem = navigationView.itemCourant.getCode();
		String requete = "select sous_item.code_sous_item, "
				+ "sous_item.nom_sous_item "
				+ "from sous_item, ec_sous_item, item_sous_item "
				+ "where sous_item.code_sous_item = ec_sous_item.code_sous_item and ec_sous_item.code_ec = " + codeEc + " and "
				+ "sous_item.code_sous_item = item_sous_item.code_sous_item and "
				+ "item_sous_item.code_item = "+codeItem+" ;";
		competenceView.setSousItemJTable(interfaceUtilisateur.getController().getSousItem(requete),this);
	}
	
	public void setEvaluation(){
		int codeSousItem = navigationView.sousItemCourant.getCode();
		String requete = "select evaluation.code_evaluation,"
				+ "evaluation.nom_evaluation, "
				+ "evaluation.note_maximale, "
				+ "evaluation.coefficient_evaluation, "
				+ "evaluation.type_epreuve "
				+ "from evaluation, sous_item_evaluation "
				+ "where evaluation.code_evaluation = sous_item_evaluation.code_evaluation "
				+ "and sous_item_evaluation.code_sous_item =" + codeSousItem + ";";
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
		        
		        String requete = "select * from domaine "
			       		+ "where nom_domaine = '"+ nomDomaineSelection+ "'";
			   navigationView.domaineCourant = interfaceUtilisateur.getController().getDomaine(requete).get(0);
			   Thread th1 = new Thread(){
		    		 public void run(){
		    			 detailView.afficher(navigationView.domaineCourant);
		    		 }
		    	   };
	    	   th1.start();
		        
		       if(navigationView.listCompetenceCourant == null){
			       if(comparaisonDomaineSelection.compareTo(nomDomaineSelection)!=0){
			    	   requete = "select * from domaine "
					       		+ "where nom_domaine = '"+ nomDomaineSelection+ "'";
					   navigationView.domaineCourant = interfaceUtilisateur.getController().getDomaine(requete).get(0);
			    	   setCompetence();
			    	   comparaisonDomaineSelection = nomDomaineSelection;
			       }
		       }
		       else{
		    	   
		    	   LinkedList<Competence> listCompeteceDuDomaineChoisi = new LinkedList<Competence>();
		    	   
		    	   requete = "select competence.code_competence, "
		    	   			+ "competence.nom_competence,"
		    	   			+ "competence.code_domaine "
		    	   			+ "from competence "
		    		   		+ "inner join domaine on "
		    		   		+ "domaine.code_domaine = competence.code_domaine "
		    		   		+ "where domaine.nom_domaine = '" + nomDomaineSelection + "'";
		    	   
		    	   for (int i = 0; i < navigationView.listCompetenceCourant.size(); i++) 
		    	   {
		    		   if (i == 0) 
		    		   {
		    			   requete += " and (competence.code_competence = " + navigationView.listCompetenceCourant.get(i).getCode();
		    		   }
		    		   else
		    		   {
		    			   requete += " or competence.code_competence = " + navigationView.listCompetenceCourant.get(i).getCode(); 			 
		    		   }
		    	   }
		    	   
		    	   requete += ")";
		    	  // System.out.println(requete);
		    	   listCompeteceDuDomaineChoisi = interfaceUtilisateur.getController().getCompetence(requete);
		    	   competenceView.setCompetenceJTable(listCompeteceDuDomaineChoisi, navigationView.getNavigationViewListener());
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
		        
		        String requete = "select competence.code_competence, "
	    	   			+ "competence.nom_competence,"
	    	   			+ "competence.code_domaine "
		    	   		+ "from competence "
		    	   		+ "where nom_competence = '"+ nomCompetenceSelection + "'";
		    	   navigationView.competenceCourante = interfaceUtilisateur.getController().getCompetence(requete).get(0);
		    	   Thread th1 = new Thread(){
			    		 public void run(){
			    			 detailView.afficher(navigationView.competenceCourante);
			    		 }
			    	   };
		    	   th1.start();
		        
		        if (navigationView.listItemCourant == null)
		        {
			       if(comparaisonCompetenceSelection.compareTo(nomCompetenceSelection)!=0)
			       {
			    	   setItem();
			    	   comparaisonCompetenceSelection = nomCompetenceSelection;
			       }
		        }
		        else
		        {
		           LinkedList<Item> listItemDelaCompetenceChoisie = new LinkedList<Item>();
			    	   
		    	   requete = "select item.code_item, "
		    	   			+ "item.nom_item, "
		    	   			+ "item.code_competence, "
		    	   			+ "item.code_evaluation "
		    	   			+ "from item "
		    		   		+ "inner join competence on "
		    		   		+ "competence.code_competence = item.code_competence "
		    		   		+ "where competence.nom_competence = '" + nomCompetenceSelection + "'";
		    	   
		    	   for (int i = 0; i < navigationView.listItemCourant.size(); i++) 
		    	   {
		    		   if (i == 0) 
		    		   {
		    			   requete += " and (item.code_item = " + navigationView.listItemCourant.get(i).getCode();
		    		   }
		    		   else
		    		   {
		    			   requete += " or item.code_item = " + navigationView.listItemCourant.get(i).getCode();
		    		   }
		    	   }
		    	   //System.out.println(requete);
		           requete += ")";
		    	   listItemDelaCompetenceChoisie = interfaceUtilisateur.getController().getItem(requete);
		    	   competenceView.setItemJTable(listItemDelaCompetenceChoisie, navigationView.getNavigationViewListener());
		    	   competenceView.repaint();
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
				
				String requete = "select * from item "
						   + "where nom_item = '" + nomItemSelection + "'";
			   
			   navigationView.itemCourant = interfaceUtilisateur.getController().getItem(requete).get(0);
			   Thread th1 = new Thread(){
	    		 public void run(){
	    			 detailView.afficher(navigationView.itemCourant);
	    		 }
	    	   };
		    	th1.start();
			   
				if (navigationView.listEcCourant == null)
				{
					if(comparaisonItemSelection.compareTo(nomItemSelection)!=0)
				   {

					   setEc();
					   comparaisonItemSelection = nomItemSelection;
				   }
				}
				else{
				   
				   LinkedList<Ec> listEcDuItemChoisi = new LinkedList<Ec>();
		    	   requete = "select ec.code_ec, "
		   				+ "ec.nom_ec,"
						+ "ec.coefficient_ec, "
						+ "ec.nombre_ects, "
						+ "ec.volume_heure_cours, "
						+ "ec.volume_heure_TD, "
						+ "ec.volume_heure_TP, "
						+ "ec.volume_heure_BE, "
						+ "ec.volume_heure_TPERSO, "
						+ "ec.resume_ec, "
						+ "ec.code_ue, "
						+ "ec.responsable_ec, "
						+ "ec.code_semestre "
		    	   		+ "from ec "
		    	   		+ "inner join ec_item on "
		    	   		+ "ec_item.code_ec = ec.code_ec "
		    	   		+ "inner join item on "
		    	   		+ "item.code_item = ec_item.code_item "
		    	   		+ "where item.nom_item = '" + nomItemSelection + "'";
		    		   		
		    	   for (int i = 0; i < navigationView.listEcCourant.size(); i++) 
		    	   {
		    		   if (i == 0) 
		    		   {
		    			   requete += " and (ec_item.code_ec = " + navigationView.listEcCourant.get(i).getCode();
		    		   } 
		    		   else
		    		   {
		    			   requete += " or ec_item.code_ec = " + navigationView.listEcCourant.get(i).getCode();
		    		   }
		    	   }
		    	   //System.out.println(requete);
		    	   requete += ")";
		    	   listEcDuItemChoisi = interfaceUtilisateur.getController().getEc(requete);
		    	   competenceView.setEcJTable(listEcDuItemChoisi, navigationView.getNavigationViewListener());
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
			       		+ "where nom_ec = '" + nomEcSelection + "'";
			       
			    	   navigationView.ecCourant = interfaceUtilisateur.getController().getEc(requete).get(0);
			    	   			    	   
			    	   requete = "select intervenant.code_intervenant, "
			    	   		+ "intervenant.nom_intervenant, "
			    	   		+ "intervenant.prenom_intervenant, "
			    	   		+ "intervenant.mot_de_passe from intervenant "
			    	   		+ "inner join intervenant_ec on "
			    	   		+ "intervenant.code_intervenant = intervenant_ec.code_intervenant "
			    	   		+ "inner join ec on "
			    	   		+ "ec.code_ec = intervenant_ec.code_ec "
			    	   		+ "where ec.code_ec = " + navigationView.ecCourant.getCode() + ";";
			    	   
			    	   //System.out.println(requete);
			    	   
			    	   listeIntervenant = interfaceUtilisateur.getController().getIntervenant(requete);
			    	   
			    	   Thread th1 = new Thread(){
				    		 public void run(){
				    			 detailView.afficher(navigationView.ecCourant, listeIntervenant);
				    		 }
				    	   };
			    	   th1.start();
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
			       		+ "where nom_sous_item = '"+ nomSousItemSelection + "'";
			       
			    	   navigationView.sousItemCourant = interfaceUtilisateur.getController().getSousItem(requete).get(0);
			    	   
			    	   Thread th1 = new Thread(){
				    		 public void run(){
				    			 detailView.afficher(navigationView.sousItemCourant);
				    		 }
				    	   };
			    	   th1.start();
			    	   
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
			public void valueChanged(TreeSelectionEvent e) {
				
				Thread th = new Thread(){
					public void run(){
						navigationView.chargementImg.setVisible(true);
						LinkedList<Ec> lesEc = new LinkedList<Ec>();
						
						//System.out.println("[Log-NAVIGATION_VIEW_LISTENER]: "+e.getPath().toString());
						
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
						String annee;
						int codeAnnee = 0;
						
						listeCouleurEvaluation = new LinkedList<String>();
						listeCouleurSousItem = new LinkedList<String>();
						listeCouleurItem = new LinkedList<String>();
						listeCouleurCompetence = new LinkedList<String>();
						listeCouleurDomaine = new LinkedList<String>();
						
						if(tailleCheminSyllabus >= 2)
						{
						 if(tailleCheminSyllabus == 2)
						 {
							 annee = cheminSyllabus[2].substring(1, cheminSyllabus[2].length()-1);
						 }
						 else
						 {
							 annee = cheminSyllabus[2].substring(1, cheminSyllabus[2].length());
						 }
						 requete = "select * from annee where annee.nom_annee ='"+annee+"';";
						 LinkedList <Annee> listAnnee = new LinkedList<Annee>();
						 listAnnee = interfaceUtilisateur.getController().getAnnee(requete);
						 codeAnnee = listAnnee.get(0).getCode();
						 
						}
						if (tailleCheminSyllabus == 2)
						{
							// ANNEE
							cheminSyllabus[2] = cheminSyllabus[2].substring(1, cheminSyllabus[2].length()-1);
							
							requete = "select ec.code_ec, "
									+ "ec.nom_ec, ec.coefficient_ec, "
									+ "ec.nombre_ects, ec.volume_heure_cours, "
									+ "ec.volume_heure_TD, ec.volume_heure_TP, "
									+ "ec.volume_heure_BE, ec.volume_heure_TPERSO, "
									+ "ec.resume_ec, ec.code_ue, "
									+ "ec.responsable_ec, ec.code_semestre from ec "
									+ "inner join ue on "
									+ "ue.code_ue = ec.code_ue "
									+ "inner join semestre on "
									+ "ue.code_semestre = semestre.code_semestre "
									+ "inner join annee on "
									+ "semestre.code_annee = annee.code_annee "
									+ "where nom_annee = '" + cheminSyllabus[2] + "' "
									+ "and ue.code_diplome = " + navigationView.diplomeCourant.getCode();
							
							lesEc = interfaceUtilisateur.getController().getEc(requete);
						}
						else if (tailleCheminSyllabus == 3)
						{
							// SEMESTRE
							cheminSyllabus[3] = cheminSyllabus[3].substring(1, cheminSyllabus[3].length()-1);
							
							requete = "select ec.code_ec, "
									+ "ec.nom_ec, ec.coefficient_ec, "
									+ "ec.nombre_ects, ec.volume_heure_cours, "
									+ "ec.volume_heure_TD, ec.volume_heure_TP, "
									+ "ec.volume_heure_BE, ec.volume_heure_TPERSO, "
									+ "ec.resume_ec, ec.code_ue, "
									+ "ec.responsable_ec, ec.code_semestre from ec "
									+ "inner join semestre on "
									+ "semestre.code_semestre = ec.code_semestre "
									+ "inner join annee on "
									+ "annee.code_annee = semestre.code_annee "
									+ "inner join ue on "
									+ "ue.code_ue = ec.code_ue "
									+ "inner join diplome on "
									+ "diplome.code_diplome = ue.code_diplome "
									+ "where semestre.nom_semestre = '" + cheminSyllabus[3] + "' "
									+ "and diplome.code_diplome = " + navigationView.diplomeCourant.getCode();
							
							lesEc = interfaceUtilisateur.getController().getEc(requete);
						}
						else if (tailleCheminSyllabus == 4)
						{
							// UE
							cheminSyllabus[3] = cheminSyllabus[3].substring(1, cheminSyllabus[3].length());
							cheminSyllabus[4] = cheminSyllabus[4].substring(1, cheminSyllabus[4].length()-1);
							
							requete = "select ec.code_ec, "
									+ "ec.nom_ec, ec.coefficient_ec, "
									+ "ec.nombre_ects, ec.volume_heure_cours, "
									+ "ec.volume_heure_TD, ec.volume_heure_TP, "
									+ "ec.volume_heure_BE, ec.volume_heure_TPERSO, "
									+ "ec.resume_ec, ec.code_ue, "
									+ "ec.responsable_ec, ec.code_semestre from ec "
									+ "inner join semestre on "
									+ "semestre.code_semestre = ec.code_semestre "
									+ "inner join annee on "
									+ "annee.code_annee = semestre.code_annee "
									+ "inner join ue on "
									+ "ue.code_ue = ec.code_ue "
									+ "inner join diplome on "
									+ "diplome.code_diplome = ue.code_diplome "
									+ "where ue.nom_ue = '" + cheminSyllabus[4] + "' "
									+ "and semestre.nom_semestre = '" + cheminSyllabus[3] + "' "
									+ "and diplome.code_diplome = " + navigationView.diplomeCourant.getCode();
							
							lesEc = interfaceUtilisateur.getController().getEc(requete);
						}
						else if (tailleCheminSyllabus == 5)
						{
							// EC
							cheminSyllabus[3] = cheminSyllabus[3].substring(1, cheminSyllabus[3].length());
							cheminSyllabus[4] = cheminSyllabus[4].substring(1, cheminSyllabus[4].length());
							cheminSyllabus[5] = cheminSyllabus[5].substring(1, cheminSyllabus[5].length()-1);
							
							requete = "select ec.code_ec, "
									+ "ec.nom_ec, ec.coefficient_ec, "
									+ "ec.nombre_ects, ec.volume_heure_cours, "
									+ "ec.volume_heure_TD, ec.volume_heure_TP, "
									+ "ec.volume_heure_BE, ec.volume_heure_TPERSO, "
									+ "ec.resume_ec, ec.code_ue, "
									+ "ec.responsable_ec, ec.code_semestre "
									+ "from ec "
									+ "inner join semestre on "
									+ "semestre.code_semestre = ec.code_semestre "
									+ "inner join annee on "
									+ "annee.code_annee = semestre.code_annee "
									+ "inner join ue on "
									+ "ue.code_ue = ec.code_ue "
									+ "inner join diplome on "
									+ "diplome.code_diplome = ue.code_diplome "
									+ "where ue.nom_ue = '" + cheminSyllabus[4] + "' "
									+ "and semestre.nom_semestre = '" + cheminSyllabus[3] + "' "
									+ "and ec.nom_ec = '" + cheminSyllabus[5] + "' "
									+ "and diplome.code_diplome = " + navigationView.diplomeCourant.getCode();
							//System.out.println(requete);
							lesEc = interfaceUtilisateur.getController().getEc(requete);
						}
						
						
						
						
						LinkedList<Item> lesItemsGlobal = new LinkedList<Item>();
						LinkedList<Integer> listCodesItems = new LinkedList<Integer>();
						
						int i = 0;
						while (i < lesEc.size())
						{
							LinkedList<Item> lesItems = new LinkedList<Item>();
							requete = "select item.code_item, "
				    	   			+ "item.nom_item, "
				    	   			+ "item.code_competence, "
				    	   			+ "item.code_evaluation "
									+ "from item "
									+ "inner join ec_item on "
									+ "ec_item.code_item = item.code_item "
									+ "inner join ec on "
									+ "ec.code_ec = ec_item.code_ec "
									+ "where ec.code_ec = " + lesEc.get(i).getCode();
							lesItems = interfaceUtilisateur.getController().getItem(requete);
							
							for (int item = 0; item < lesItems.size(); item++)
							{
								if (listCodesItems.indexOf(lesItems.get(item).getCode()) == -1)
								{
									lesItemsGlobal.add(lesItems.get(item));
									listCodesItems.add(lesItems.get(item).getCode());
								}
							}

							i++;
						}
						
						
						
						/*
						System.out.println("--------------------------------");
						System.out.println("Items");
						for(int i1=0; i1<listCodesItems.size();i1++)
						{
							System.out.println(lesItemsGlobal.get(i1).getCode());
						}
						System.out.println("--------------------------------");*/
					
						LinkedList<Competence> lesCompetencesGlobales = new LinkedList<Competence>();
						LinkedList<Integer> listCodesComp = new LinkedList<Integer>();
						
						i = 0;
						while (i < lesItemsGlobal.size())
						{
							LinkedList<Competence> lesCompetences = new LinkedList<Competence>();
							requete = "select competence.code_competence, "
				    	   			+ "competence.nom_competence,"
				    	   			+ "competence.code_domaine "
									+ "from competence "
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
						
						if(tailleCheminSyllabus == 2 || tailleCheminSyllabus == 3 || tailleCheminSyllabus == 4 || tailleCheminSyllabus == 5)
						{
						 navigationView.listEcCourant = lesEc;
						 navigationView.listItemCourant = lesItemsGlobal;
						 navigationView.listCompetenceCourant = lesCompetencesGlobales;
						}
						
						/*System.out.println("--------------------------------");
						System.out.println("Compétences");
						for(int i1=0; i1<listCodesComp.size();i1++)
						{
							System.out.println(lesCompetencesGlobales.get(i1).getCode());
						}
						System.out.println("--------------------------------");*/

						LinkedList<Domaine> lesDomainesGlobales = new LinkedList<Domaine>();
						LinkedList<Integer> listCodeDomaines = new LinkedList<>();
						
						i = 0;
						while (i < listCodesComp.size()) 
						{
							LinkedList<Domaine> lesDomaines = new LinkedList<Domaine>();
							requete = "select domaine.code_domaine, "
									+ "domaine.nom_domaine,"
									+ "domaine.code_diplome "
									+ "from domaine "
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
						
						//Traitements pour le code couleur
						if(tailleCheminSyllabus != 1 )
						{
							LinkedList <Integer> listCodeSousItem = new LinkedList <Integer>();
							
							for(int iter = 0; iter<navigationView.listEcCourant.size(); iter++)
							{
								LinkedList<SousItem> lesSousItem = new LinkedList<SousItem>();
								requete ="select sous_item.code_sous_item, "
										+ "sous_item.nom_sous_item "
										+ "from sous_item, ec_sous_item "
										+ "where sous_item.code_sous_item = ec_sous_item.code_sous_item and "
										+ "ec_sous_item.code_ec = "+navigationView.listEcCourant.get(iter).getCode();
								lesSousItem = interfaceUtilisateur.getController().getSousItem(requete);
								
								for(int comp = 0 ; comp < lesSousItem.size(); comp ++)
								{
									if(listCodeSousItem.indexOf(lesSousItem.get(comp).getCode()) == -1)
									{
										listCodeSousItem.add(lesSousItem.get(comp).getCode());
									}
								}
							}
							
							LinkedList <Integer> listCodeEvaluation = new LinkedList<Integer>();
							
							for(int iter = 0; iter<listCodeSousItem.size(); iter++)
							{
								LinkedList<Evaluation> lesEvaluation = new LinkedList<Evaluation>();
								requete="select evaluation.code_evaluation, "
										+ "evaluation.nom_evaluation,"
										+ "evaluation.note_maximale, "
										+ "evaluation.coefficient_evaluation, "
										+ "evaluation.type_epreuve "
										+ "from evaluation, sous_item_evaluation "
										+ "where evaluation.code_evaluation = sous_item_evaluation.code_evaluation and "
										+ "sous_item_evaluation.code_sous_item = "+listCodeSousItem.get(iter);
								lesEvaluation = interfaceUtilisateur.getController().getEvaluation(requete);
								
								for(int comp = 0; comp < lesEvaluation.size(); comp++)
								{
									if(listCodeEvaluation.indexOf(lesEvaluation.get(comp).getCode()) == -1)
									{
										listCodeEvaluation.add(lesEvaluation.get(comp).getCode());
									}
								}
							}
							
							LinkedList<Etudiant> lesEtudiant = new LinkedList<Etudiant>();
							requete="select etudiant.code_etudiant, "
									+ "etudiant.nom_etudiant, "
									+ "etudiant.prenom_etudiant, "
									+ "etudiant.mot_de_passe_etudiant "
									+ "from etudiant, promotion, etudiant_promotion "
									+ "where etudiant.code_etudiant = etudiant_promotion.code_etudiant "
									+ "and promotion.code_promotion = etudiant_promotion.code_promotion "
									+ "and promotion.code_promotion = "+navigationView.promotionCourante.getCode()+" "
									+ "and promotion.code_diplome = "+navigationView.promotionCourante.getCodeDiplome()+" "
									+ "and promotion.code_annee = "+codeAnnee;
							
							lesEtudiant = interfaceUtilisateur.getController().getEtudiant(requete);
							
							int nombre_etudiant = lesEtudiant.size();
							
							//Si il y a des étudiants pour cette promotion
							if(nombre_etudiant != 0)
							{
							
								//Récupérer les tuples concernés dans la table etudiant_evaluation
								LinkedList<EvaluationEtudiant> listEvaluationEtudiantGlobale = new LinkedList<EvaluationEtudiant>();
								LinkedList<EvaluationEtudiant> lesEvaluationEtudiant = new LinkedList<EvaluationEtudiant>();
								int annee_debut = navigationView.promotionCourante.getAnneeDebutPromotion();
								int annee_fin = navigationView.promotionCourante.getAnneeFinPromotion();
								float somme = 0;
								float moyenne;
								
								for(int comp = 0; comp <listCodeEvaluation.size() ; comp ++)
								{
									
									listEvaluationEtudiantGlobale = new LinkedList<EvaluationEtudiant>();
									somme = 0;
									for(int comp1 = 0; comp1<lesEtudiant.size() ; comp1 ++)
									{
										lesEvaluationEtudiant = new LinkedList<EvaluationEtudiant>();
										requete ="select etudiant_evaluation.code_etudiant, "
												+ "etudiant_evaluation.code_evaluation, "
												+ "etudiant_evaluation.note_evaluation, "
												+ "etudiant_evaluation.date_evaluation "
												+ "from etudiant_evaluation "
												+ "where etudiant_evaluation.code_etudiant ="+lesEtudiant.get(comp1).getCode()
												+ " and etudiant_evaluation.code_evaluation ="+listCodeEvaluation.get(comp)
												+ " and etudiant_evaluation.date_evaluation between '"+annee_debut+"-09-01' and '"+annee_fin+"-07-01'";
										
										lesEvaluationEtudiant = interfaceUtilisateur.getController().getEvaluationEtudiant(requete);
										
										for(int compt = 0 ; compt< lesEvaluationEtudiant.size() ; compt ++)
										{
											listEvaluationEtudiantGlobale.add(lesEvaluationEtudiant.get(compt));
										}
									}
									for(int cpt = 0 ; cpt< listEvaluationEtudiantGlobale.size() ; cpt++)
									{
										somme = somme + listEvaluationEtudiantGlobale.get(cpt).getNoteEvaluation();
									}
									
									moyenne = somme / nombre_etudiant;
									
									if( moyenne >=0 && moyenne< 10)
									{
										String moy =""+listCodeEvaluation.get(comp)+";1";
										listeCouleurEvaluation.add(moy);
									}
									if(moyenne>=10 && moyenne<12)
									{
										String moy =""+listCodeEvaluation.get(comp)+";2";
										listeCouleurEvaluation.add(moy);
									}
									if(moyenne>=12 && moyenne<14)
									{
										String moy =""+listCodeEvaluation.get(comp)+";3";
										listeCouleurEvaluation.add(moy);
									}
									if(moyenne>=14 && moyenne<16)
									{
										String moy =""+listCodeEvaluation.get(comp)+";4";
										listeCouleurEvaluation.add(moy);
									}
									if(moyenne>=16 && moyenne<=20)
									{
										String moy =""+listCodeEvaluation.get(comp)+";5";
										listeCouleurEvaluation.add(moy);
									}
									
								}
								
								//Attribution code couleur SousItem
								for(int cpt = 0 ; cpt <listCodeSousItem.size() ; cpt ++)
								{
									float s = 0;
									float m = 0;
									int nb_evaluation=0;
									requete="select evaluation.code_evaluation, "
											+ "evaluation.nom_evaluation,"
											+ "evaluation.note_maximale, "
											+ "evaluation.coefficient_evaluation, "
											+ "evaluation.type_epreuve "
											+ "from evaluation, sous_item_evaluation "
											+ "where evaluation.code_evaluation = sous_item_evaluation.code_evaluation and "
											+ "sous_item_evaluation.code_sous_item = "+listCodeSousItem.get(cpt);
									
									LinkedList <Evaluation> listEvaluation = new LinkedList<Evaluation>();
									listEvaluation = interfaceUtilisateur.getController().getEvaluation(requete);
									
									for(int compt = 0 ; compt< listEvaluation.size(); compt ++)
									{
										
										int codeEvaluation = listEvaluation.get(compt).getCode();
										
										for(int compteur = 0 ; compteur < listeCouleurEvaluation.size() ; compteur ++)
										{
											String tab[] = listeCouleurEvaluation.get(compteur).split(";");
											int codeEval = Integer.parseInt(tab[0]);
											int codeCoul = Integer.parseInt(tab[1]);
											if(codeEvaluation == codeEval)
											{
												s = s+codeCoul;
												nb_evaluation ++;
											}
										}
										
									}
									
									m = s/nb_evaluation;
									
									if(m >= 1 && m<2)
									{
										String moy =""+listCodeSousItem.get(cpt)+";1";
										listeCouleurSousItem.add(moy);
									}
									if(m >= 2 && m<3)
									{
										String moy =""+listCodeSousItem.get(cpt)+";2";
										listeCouleurSousItem.add(moy);
									}
									if(m>=3 && m<4)
									{
										String moy =""+listCodeSousItem.get(cpt)+";3";
										listeCouleurSousItem.add(moy);
									}
									if(m>=4 && m<5)
									{
										String moy =""+listCodeSousItem.get(cpt)+";4";
										listeCouleurSousItem.add(moy);
									}
									if(m==5)
									{
										String moy =""+listCodeSousItem.get(cpt)+";5";
										listeCouleurSousItem.add(moy);
									}
								}
								
								//Attribution code couleur Item
								for(int cpt = 0 ; cpt < listCodesItems.size(); cpt ++)
								{
									float s = 0;
									float m = 0;
									int nbSousItem = 0;
									
									requete ="select sous_item.code_sous_item, "
											+ "sous_item.nom_sous_item "
											+ "from sous_item, item_sous_item "
											+ "where sous_item.code_sous_item = item_sous_item.code_sous_item and "
											+ "item_sous_item.code_item ="+listCodesItems.get(cpt);
									
									LinkedList<SousItem> listSousItem = new LinkedList<SousItem>();
									listSousItem = interfaceUtilisateur.getController().getSousItem(requete);
									
									for(int comp = 0; comp < listSousItem.size() ; comp++)
									{
										int codeSousItem = listSousItem.get(comp).getCode();
										
										for(int compt = 0 ; compt <listeCouleurSousItem.size(); compt++)
										{
											String tab[]=listeCouleurSousItem.get(compt).split(";");
											int codeSI = Integer.parseInt(tab[0]);
											int codeCouleur = Integer.parseInt(tab[1]);
											
											if(codeSousItem == codeSI)
											{
												s = s+codeCouleur;
												nbSousItem ++;
											}
											
										}
									}
									
									m = s/nbSousItem;
									
									if(m >= 1 && m<2)
									{
										String moy =""+listCodesItems.get(cpt)+";1";
										listeCouleurItem.add(moy);
									}
									if(m >= 2 && m<3)
									{
										String moy =""+listCodesItems.get(cpt)+";2";
										listeCouleurItem.add(moy);
									}
									if(m >= 3 && m<4)
									{
										String moy =""+listCodesItems.get(cpt)+";3";
										listeCouleurItem.add(moy);
									}
									if(m >= 4 && m<5)
									{
										String moy =""+listCodesItems.get(cpt)+";4";
										listeCouleurItem.add(moy);
									}
									if(m==5)
									{
										String moy =""+listCodesItems.get(cpt)+";5";
										listeCouleurItem.add(moy);
									}
								}
								
								//Attribution code couleur Compétence
								for(int cpt = 0; cpt<listCodesComp.size() ; cpt++ )
								{
									float s = 0;
									float m = 0;
									int nbItem = 0;
									
									requete="select item.code_item, "
											+ "item.nom_item, "
											+ "item.code_competence, "
											+ "item.code_evaluation "
											+ "from item "
											+ "where item.code_competence ="+listCodesComp.get(cpt);
									
									LinkedList<Item> listItem = new LinkedList<Item>();
									listItem = interfaceUtilisateur.getController().getItem(requete);
									
									for(int comp = 0 ; comp < listItem.size() ; comp++)
									{
										int codeItem = listItem.get(comp).getCode();
										
										for(int compt = 0 ; compt < listeCouleurItem.size(); compt++)
										{
											String tab[] = listeCouleurItem.get(compt).split(";");
											int codeI = Integer.parseInt(tab[0]);
											int codeCouleur = Integer.parseInt(tab[1]);
											
											if(codeItem == codeI)
											{
												s=s+codeCouleur;
												nbItem++;
											}
											
										}
									}
									m=s/nbItem;
									
									if(m >= 1 && m<2)
									{
										String moy =""+listCodesComp.get(cpt)+";1";
										listeCouleurCompetence.add(moy);
									}
									if(m >= 2 && m<3)
									{
										String moy =""+listCodesComp.get(cpt)+";2";
										listeCouleurCompetence.add(moy);
									}
									if(m >= 3 && m<4)
									{
										String moy =""+listCodesComp.get(cpt)+";3";
										listeCouleurCompetence.add(moy);
									}
									if(m >= 4 && m<5)
									{
										String moy =""+listCodesComp.get(cpt)+";4";
										listeCouleurCompetence.add(moy);
									}
									if(m == 5)
									{
										String moy =""+listCodesComp.get(cpt)+";5";
										listeCouleurCompetence.add(moy);
									}
									
								}
								
								//Attribution code couleur Domaine
								for(int cpt = 0; cpt<listCodeDomaines.size() ; cpt++ )
								{
									float s = 0;
									float m = 0;
									int nbComptence = 0;
									
									requete="select competence.code_competence, "
											+ "competence.nom_competence, "
											+ "competence.code_domaine "
											+ "from competence "
											+ "where competence.code_domaine ="+listCodeDomaines.get(cpt);
									
									LinkedList<Competence> listCompetence = new LinkedList<Competence>();
									listCompetence = interfaceUtilisateur.getController().getCompetence(requete);
									
									for(int comp = 0 ; comp <listCompetence.size() ; comp++)
									{
										int codeComp = listCompetence.get(comp).getCode();
										
										for(int compt = 0 ; compt < listeCouleurCompetence.size(); compt++)
										{
											String tab[] = listeCouleurCompetence.get(compt).split(";");
											int codeCpt = Integer.parseInt(tab[0]);
											int codeCouleur = Integer.parseInt(tab[1]);
											
											if(codeComp == codeCpt)
											{
												s= s+codeCouleur;
												nbComptence++;
											}
										}
									}
									
									m=s/nbComptence;
									
									if(m >= 1 && m<2)
									{
										String moy =""+listCodeDomaines.get(cpt)+";1";
										listeCouleurDomaine.add(moy);
									}
									
									if(m >= 2 && m<3)
									{
										String moy =""+listCodeDomaines.get(cpt)+";2";
										listeCouleurDomaine.add(moy);
									}
									if(m >= 3 && m<4)
									{
										String moy =""+listCodeDomaines.get(cpt)+";3";
										listeCouleurDomaine.add(moy);
									}
									
									if(m >= 4 && m<5)
									{
										String moy =""+listCodeDomaines.get(cpt)+";4";
										listeCouleurDomaine.add(moy);
									}
									
									if(m == 5)
									{
										String moy =""+listCodeDomaines.get(cpt)+";5";
										listeCouleurDomaine.add(moy);
									}
									
								}
							}
							
							
							
							competenceView.bloc.removeAll();
							competenceView.setDomaineJTable(lesDomainesGlobales, navigationView.getNavigationViewListener());
						}
						
						
							
						
						if(tailleCheminSyllabus == 1)
						{
							competenceView.bloc.removeAll();
							navigationView.listEcCourant = null;
							navigationView.listItemCourant = null;
							navigationView.listCompetenceCourant = null;
							setDomaine();
						}
						/*System.out.println("--------------------------------");
						System.out.println("Domaines");
						for(int i1=0; i1<listCodeDomaines.size();i1++)
						{
							System.out.println(lesDomainesGlobales.get(i1).getCode());
						}
						System.out.println("--------------------------------");*/
						
						/*competenceView.bloc.removeAll();
						competenceView.setDomaineJTable(lesDomainesGlobales);
						*/
						navigationView.chargementImg.setVisible(false);
					}
				};
				th.start();
			}
		};
	}
	
	
	//Bouton Zoom Listener
	//Plus
	public ActionListener getZoomPlusListener(){
		return new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(competenceView.tableauDomaine!=null){
					try{
						competenceView.tableauDomaine.setRowHeight(competenceView.tableauDomaine.getRowHeight()+2);
						competenceView.tableauDomaine.setPreferredSize(new Dimension(competenceView.getWidth()+10,competenceView.getHeight()+1));
						competenceView.bloc.getComponent(0).setSize(competenceView.bloc.getComponent(0).getWidth()+10,competenceView.bloc.getComponent(0).getHeight()+5);
						competenceView.bloc.getComponent(0).setPreferredSize(new Dimension(competenceView.bloc.getComponent(0).getWidth()+20,competenceView.bloc.getComponent(0).getHeight()+5));
						competenceView.tableauDomaine.setFont(new Font("Dialog",Font.PLAIN,competenceView.tableauDomaine.getFont().getSize()+2));
						competenceView.tableauDomaine.revalidate();
					}
					catch(Exception e1){}
				}
				
				if(competenceView.tableauCompetence!=null){
					try{
						competenceView.tableauCompetence.setRowHeight(competenceView.tableauCompetence.getRowHeight()+2);
						competenceView.tableauCompetence.setPreferredSize(new Dimension(competenceView.getWidth()+10,competenceView.getHeight()+1));
						competenceView.bloc.getComponent(1).setSize(competenceView.bloc.getComponent(1).getWidth()+10,competenceView.bloc.getComponent(1).getHeight()+5);
						competenceView.bloc.getComponent(1).setPreferredSize(new Dimension(competenceView.bloc.getComponent(1).getWidth()+20,competenceView.bloc.getComponent(1).getHeight()+5));
						competenceView.tableauCompetence.setFont(new Font("Dialog",Font.PLAIN,competenceView.tableauCompetence.getFont().getSize()+2));
					}
					catch(Exception e1){}
				}
				if(competenceView.tableauCompetence!=null){
					try{
						competenceView.tableauCompetence.setRowHeight(competenceView.tableauCompetence.getRowHeight()+2);
						competenceView.tableauCompetence.setPreferredSize(new Dimension(competenceView.getWidth()+10,competenceView.getHeight()+1));
//						competenceView.bloc.getComponent(0).setSize(competenceView.bloc.getComponent(0).getWidth()+10,competenceView.bloc.getComponent(0).getHeight()+5);
						competenceView.bloc.getComponent(0).setPreferredSize(new Dimension(competenceView.bloc.getComponent(0).getWidth()+20,competenceView.bloc.getComponent(0).getHeight()+5));
						competenceView.tableauCompetence.setFont(new Font("Dialog",Font.PLAIN,competenceView.tableauCompetence.getFont().getSize()+2));
					}
					catch(Exception e1){}
				}
				
				if(competenceView.tableauItem!=null){
					try{
						competenceView.tableauItem.setRowHeight(competenceView.tableauItem.getRowHeight()+2);
						competenceView.tableauItem.setPreferredSize(new Dimension(competenceView.getWidth()+10,competenceView.getHeight()+1));
//						competenceView.bloc.getComponent(0).setSize(competenceView.bloc.getComponent(0).getWidth()+10,competenceView.bloc.getComponent(0).getHeight()+5);
						competenceView.bloc.getComponent(0).setPreferredSize(new Dimension(competenceView.bloc.getComponent(0).getWidth()+20,competenceView.bloc.getComponent(0).getHeight()+5));
						competenceView.tableauItem.setFont(new Font("Dialog",Font.PLAIN,competenceView.tableauItem.getFont().getSize()+2));
					}
					catch(Exception e1){}
				}
				
				if(competenceView.tableauEC!=null){
					try{
						competenceView.tableauEC.setRowHeight(competenceView.tableauEC.getRowHeight()+2);
						competenceView.tableauEC.setPreferredSize(new Dimension(competenceView.getWidth()+10,competenceView.getHeight()+1));
//						competenceView.bloc.getComponent(0).setSize(competenceView.bloc.getComponent(0).getWidth()+10,competenceView.bloc.getComponent(0).getHeight()+5);
						competenceView.bloc.getComponent(0).setPreferredSize(new Dimension(competenceView.bloc.getComponent(0).getWidth()+20,competenceView.bloc.getComponent(0).getHeight()+5));
						competenceView.tableauEC.setFont(new Font("Dialog",Font.PLAIN,competenceView.tableauEC.getFont().getSize()+2));
					}
					catch(Exception e1){}
				}
				
				if(competenceView.tableauSousItem!=null){
					try{
						competenceView.tableauSousItem.setRowHeight(competenceView.tableauSousItem.getRowHeight()+2);
						competenceView.tableauSousItem.setPreferredSize(new Dimension(competenceView.getWidth()+10,competenceView.getHeight()+1));
//						competenceView.bloc.getComponent(0).setSize(competenceView.bloc.getComponent(0).getWidth()+10,competenceView.bloc.getComponent(0).getHeight()+5);
						competenceView.bloc.getComponent(0).setPreferredSize(new Dimension(competenceView.bloc.getComponent(0).getWidth()+20,competenceView.bloc.getComponent(0).getHeight()+5));
						competenceView.tableauSousItem.setFont(new Font("Dialog",Font.PLAIN,competenceView.tableauSousItem.getFont().getSize()+2));
					}
					catch(Exception e1){}
				}
				
				if(competenceView.tableauEvaluation!=null){
					try{
						competenceView.tableauEvaluation.setRowHeight(competenceView.tableauEvaluation.getRowHeight()+2);
						competenceView.tableauEvaluation.setPreferredSize(new Dimension(competenceView.getWidth()+10,competenceView.getHeight()+1));
//						competenceView.bloc.getComponent(0).setSize(competenceView.bloc.getComponent(0).getWidth()+10,competenceView.bloc.getComponent(0).getHeight()+5);
						competenceView.bloc.getComponent(0).setPreferredSize(new Dimension(competenceView.bloc.getComponent(0).getWidth()+20,competenceView.bloc.getComponent(0).getHeight()+5));
						competenceView.tableauEvaluation.setFont(new Font("Dialog",Font.PLAIN,competenceView.tableauEvaluation.getFont().getSize()+2));
					}
					catch(Exception e1){}
				}
				
				competenceView.revalidate();
				competenceView.bloc.repaint();
			}
		};
	}
	
	public ActionListener getZoomMoinsListener(){
		return new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//int taille = competenceView.bloc.getComponents().length;
				
				if(competenceView.tableauDomaine!=null){
					try{
						competenceView.tableauDomaine.setRowHeight(competenceView.tableauDomaine.getRowHeight()-2);
						competenceView.tableauDomaine.setPreferredSize(new Dimension(competenceView.getWidth()-10,competenceView.getHeight()-1));
						competenceView.bloc.getComponent(0).setSize(competenceView.bloc.getComponent(0).getWidth()-10,competenceView.bloc.getComponent(0).getHeight()-5);
						competenceView.bloc.getComponent(0).setPreferredSize(new Dimension(competenceView.bloc.getComponent(0).getWidth()-20,competenceView.bloc.getComponent(0).getHeight()-5));
						competenceView.tableauDomaine.setFont(new Font("Dialog",Font.PLAIN,competenceView.tableauDomaine.getFont().getSize()-2));
						competenceView.tableauDomaine.revalidate();
					}
					catch(Exception e1){}
				}
				
				if(competenceView.tableauCompetence!=null){
					try{
						competenceView.tableauCompetence.setRowHeight(competenceView.tableauCompetence.getRowHeight()-2);
						competenceView.tableauCompetence.setPreferredSize(new Dimension(competenceView.getWidth()-10,competenceView.getHeight()-1));
						competenceView.bloc.getComponent(1).setSize(competenceView.bloc.getComponent(1).getWidth()-10,competenceView.bloc.getComponent(0).getHeight()-5);
						competenceView.bloc.getComponent(1).setPreferredSize(new Dimension(competenceView.bloc.getComponent(1).getWidth()-20,competenceView.bloc.getComponent(1).getHeight()-5));
						competenceView.tableauCompetence.setFont(new Font("Dialog",Font.PLAIN,competenceView.tableauCompetence.getFont().getSize()-2));
					}
					catch(Exception e1){}
				}
				if(competenceView.tableauCompetence!=null){
					try{
						competenceView.tableauCompetence.setRowHeight(competenceView.tableauCompetence.getRowHeight()-2);
						competenceView.tableauCompetence.setPreferredSize(new Dimension(competenceView.getWidth()-10,competenceView.getHeight()-1));
//						competenceView.bloc.getComponent(0).setSize(competenceView.bloc.getComponent(0).getWidth()-10,competenceView.bloc.getComponent(0).getHeight()-5);
						competenceView.bloc.getComponent(0).setPreferredSize(new Dimension(competenceView.bloc.getComponent(0).getWidth()-20,competenceView.bloc.getComponent(0).getHeight()-5));
						competenceView.tableauCompetence.setFont(new Font("Dialog",Font.PLAIN,competenceView.tableauCompetence.getFont().getSize()-2));
					}
					catch(Exception e1){}
				}
				
				if(competenceView.tableauItem!=null){
					try{
						competenceView.tableauItem.setRowHeight(competenceView.tableauItem.getRowHeight()-2);
						competenceView.tableauItem.setPreferredSize(new Dimension(competenceView.getWidth()-10,competenceView.getHeight()-1));
//						competenceView.bloc.getComponent(0).setSize(competenceView.bloc.getComponent(0).getWidth()-10,competenceView.bloc.getComponent(0).getHeight()-5);
						competenceView.bloc.getComponent(0).setPreferredSize(new Dimension(competenceView.bloc.getComponent(0).getWidth()-20,competenceView.bloc.getComponent(0).getHeight()-5));
						competenceView.tableauItem.setFont(new Font("Dialog",Font.PLAIN,competenceView.tableauItem.getFont().getSize()-2));
					}
					catch(Exception e1){}
				}
				
				if(competenceView.tableauEC!=null){
					try{
						competenceView.tableauEC.setRowHeight(competenceView.tableauEC.getRowHeight()-2);
						competenceView.tableauEC.setPreferredSize(new Dimension(competenceView.getWidth()-10,competenceView.getHeight()-1));
//						competenceView.bloc.getComponent(0).setSize(competenceView.bloc.getComponent(0).getWidth()-10,competenceView.bloc.getComponent(0).getHeight()-5);
						competenceView.bloc.getComponent(0).setPreferredSize(new Dimension(competenceView.bloc.getComponent(0).getWidth()-20,competenceView.bloc.getComponent(0).getHeight()-5));
						competenceView.tableauEC.setFont(new Font("Dialog",Font.PLAIN,competenceView.tableauEC.getFont().getSize()-2));
					}
					catch(Exception e1){}
				}
				
				if(competenceView.tableauSousItem!=null){
					try{
						competenceView.tableauSousItem.setRowHeight(competenceView.tableauSousItem.getRowHeight()-2);
						competenceView.tableauSousItem.setPreferredSize(new Dimension(competenceView.getWidth()-10,competenceView.getHeight()-1));
//						competenceView.bloc.getComponent(0).setSize(competenceView.bloc.getComponent(0).getWidth()-10,competenceView.bloc.getComponent(0).getHeight()-5);
						competenceView.bloc.getComponent(0).setPreferredSize(new Dimension(competenceView.bloc.getComponent(0).getWidth()-20,competenceView.bloc.getComponent(0).getHeight()-5));
						competenceView.tableauSousItem.setFont(new Font("Dialog",Font.PLAIN,competenceView.tableauSousItem.getFont().getSize()-2));
					}
					catch(Exception e1){}
				}
				
				if(competenceView.tableauEvaluation!=null){
					try{
						competenceView.tableauEvaluation.setRowHeight(competenceView.tableauEvaluation.getRowHeight()-2);
						competenceView.tableauEvaluation.setPreferredSize(new Dimension(competenceView.getWidth()-10,competenceView.getHeight()-1));
//						competenceView.bloc.getComponent(0).setSize(competenceView.bloc.getComponent(0).getWidth()-10,competenceView.bloc.getComponent(0).getHeight()-5);
						competenceView.bloc.getComponent(0).setPreferredSize(new Dimension(competenceView.bloc.getComponent(0).getWidth()-20,competenceView.bloc.getComponent(0).getHeight()-5));
						competenceView.tableauEvaluation.setFont(new Font("Dialog",Font.PLAIN,competenceView.tableauEvaluation.getFont().getSize()-2));
					}
					catch(Exception e1){}
				}
				
				competenceView.bloc.revalidate();
				competenceView.bloc.repaint();
				
			}
		};
	}
	
}
