package com.m2stice.controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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
		competenceView.setCompetenceJTable(interfaceUtilisateur.getController().getCompetence(requete));
	}
	
	public void setItem(){
		int codeCompetence = navigationView.competenceCourante.getCode();
		String requete = "select * from item "
				+ "where item.code_competence = " + codeCompetence + ";";
		competenceView.setItemJTable(interfaceUtilisateur.getController().getItem(requete));
	}
	
	public void setEc(){
		int codeUe = navigationView.ueCourante.getCode();
		String requete = "select * from ec "
				+ "where Ec.code_ue = " + codeUe + ";";
		competenceView.setEcJTable(interfaceUtilisateur.getController().getEc(requete));
	}
	
	public void setSousItem(){
		int codeEc = navigationView.ecCourant.getCode();
		String requete = "select * from sous_item"
				+ "where sous_item.code_ec = " + codeEc + ";";
		competenceView.setSousItemJTable(interfaceUtilisateur.getController().getSousItem(requete));
	}
	
	public void setEvaluation(){
		int codeSousItem = navigationView.sousItemCourant.getCode();
		String requete = "select * from evaluation "
				+ "where evaluation.code_sous_item = " + codeSousItem + ";";
		competenceView.setEvaluationJTable(interfaceUtilisateur.getController().getEvaluation(requete));
	}
	
}
