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
	

}
