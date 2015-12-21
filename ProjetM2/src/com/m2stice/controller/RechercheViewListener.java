package com.m2stice.controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;

import com.m2stice.graphics.Interface;
import com.m2stice.graphics.RechercheView;
import com.m2stice.graphics.ResultatView;
import com.m2stice.model.Diplome;


/**
 *Classe RechercheViewListener qui gère les actions 
 *@author Emmanuel
 *@version 1.0
 *@version 1.0
 *@copyright (C) Master 2 2015
 *@date 03/12/2015
 */
public class RechercheViewListener {
	
	private Interface interfaceUtilisateur;
	private RechercheView rechercheView;
	private ResultatView resultatView;
	private LinkedList<Diplome> diplomes;

	public RechercheViewListener(Interface interfaceUtilisateur, RechercheView rechercheView){
		this.interfaceUtilisateur = interfaceUtilisateur;
		this.rechercheView = rechercheView;
	}
	
	public KeyListener getKeyListener(){
		return new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				 if (e.getKeyCode()==KeyEvent.VK_ENTER){
					 	diplomes = interfaceUtilisateur.getController().getDiplome("SELECT * FROM DIPLOME WHERE NOM_DIPLOME LIKE '%"+rechercheView.getRecherche()+"%' AND NOM_DIPLOME NOT LIKE '%null%';");
					 	resultatView = new ResultatView(interfaceUtilisateur);
					 	resultatView.setEntete(rechercheView.getRecherche(),diplomes.size());
					 	resultatView.setResultat(diplomes);
				        interfaceUtilisateur.setBlocPrincipal(resultatView);
				 }
			}
		};
	}
	
}
