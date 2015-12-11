package com.m2stice.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.m2stice.graphics.Interface;
import com.m2stice.graphics.RechercheView;
import com.m2stice.graphics.ResultatView;

public class ResultatViewListener {
	
	private Interface interfaceUtilisateur;
	private ResultatView resultatView;
	private RechercheView rechercheView;
	
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

}
