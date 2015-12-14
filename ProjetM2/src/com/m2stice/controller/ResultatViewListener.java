package com.m2stice.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import com.m2stice.graphics.Interface;
import com.m2stice.graphics.NavigationView;
import com.m2stice.graphics.RechercheView;
import com.m2stice.graphics.ResultatView;
import com.m2stice.model.Diplome;

public class ResultatViewListener {
	
	private Interface interfaceUtilisateur;
	private ResultatView resultatView;
	private RechercheView rechercheView;
	private NavigationView navigationView;
	private LinkedList<Diplome> diplomes; 
	
	public ResultatViewListener(Interface interfaceUtilisateur,ResultatView resultatView){
		this.interfaceUtilisateur = interfaceUtilisateur;
		this.resultatView = resultatView;
	}
	
	public ActionListener getRetourBoutonListener(){
		return new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				rechercheView = new RechercheView(interfaceUtilisateur);
		        interfaceUtilisateur.setBlocPrincipal(rechercheView);
			}
		};
	}
	public void getNavigationView(Diplome d){
		navigationView = new NavigationView(interfaceUtilisateur,d);
        interfaceUtilisateur.setBlocPrincipal(navigationView);
	}

}
