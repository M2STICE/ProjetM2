package com.m2stice.controller;

import com.m2stice.graphics.CompetenceView;
import com.m2stice.graphics.Interface;
import com.m2stice.graphics.NavigationView;
import com.m2stice.graphics.ResultatView;
import com.m2stice.graphics.SyllabusView;

public class NavigationViewListener {
	
	private Interface interfaceUtilisateur;
	private ResultatView resultatView;
	private NavigationView navigationView;
	private SyllabusView syllabusView;
	private CompetenceView competenceView;
	
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
		int codeDiplome = navigationView.diplome_courant.getCode();
		String requete = "select * from domaine "
				+ "inner join diplome on "
				+ "domaine.code_diplome = diplome.code_diplome "
				+ "where diplome.code_diplome = " + codeDiplome + ";";
		competenceView.setDomaineJTable(interfaceUtilisateur.getController().getDomaine(requete));
	}
	
	public void setCompetence()
	{
		int codeDomaine = navigationView.domaine_courant.getCode();
		String requete = "select * from competence "
				+ "where competence.code_domaine = " + codeDomaine + ";";
		
	}
	
	public void setItem()
	{
		int codeCompetence = navigationView.competence_courante.getCode();
		String requete = "select * from item "
				+ "where item.code_competence = " + codeCompetence + ";";
		
	}
	
	public void setEc()
	{
		int codeUe = navigationView.ue_courante.getCode();
		String requete = "select * from ec "
				+ "where Ec.code_ue = " + codeUe + ";";
		
	}
	
	public void setSousItem()
	{
		int codeEc = navigationView.ec_courant.getCode();
		String requete = "select * from sous_item"
				+ "where sous_item.code_ec = " + codeEc + ";";
		
	}
	
	public void setEvaluation()
	{
		int codeSousItem = navigationView.sous_item_courant.getCode();
		String requete = "select * from evaluation "
				+ "where evaluation.code_sous_item = " + codeSousItem + ";";
		
	}

}
