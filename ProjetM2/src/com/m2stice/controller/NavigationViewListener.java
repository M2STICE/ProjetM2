package com.m2stice.controller;

import java.util.LinkedList;

import com.m2stice.adapter.DomaineAdapter;
import com.m2stice.graphics.CompetenceView;
import com.m2stice.graphics.Interface;
import com.m2stice.graphics.NavigationView;
import com.m2stice.graphics.ResultatView;
import com.m2stice.graphics.SyllabusView;
import com.m2stice.model.Diplome;
import com.m2stice.model.Domaine;

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
	
	public void setDomaine()
	{
		int codeDiplome = navigationView.diplome_courant.getCode();
		
		String requete = "select * from domaine "
				+ "inner join diplome on "
				+ "domaine.code_diplome = diplome.code_diplome "
				+ "where code_diplome = " + codeDiplome + ";";
		
		competenceView.setDomaineJTable(interfaceUtilisateur.getController().getDomaine(requete));
	}
	

}
