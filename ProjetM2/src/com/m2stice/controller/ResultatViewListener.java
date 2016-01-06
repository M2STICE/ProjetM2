package com.m2stice.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import com.m2stice.graphics.Interface;
import com.m2stice.graphics.NavigationView;
import com.m2stice.graphics.RechercheView;
import com.m2stice.graphics.ResultatView;
import com.m2stice.model.Diplome;
import com.m2stice.model.Promotion;

public class ResultatViewListener {
	
	private Interface interfaceUtilisateur;
	@SuppressWarnings("unused")
	private ResultatView resultatView;
	private RechercheView rechercheView;
	private NavigationView navigationView;
	//private LinkedList<Diplome> diplomes; 
	
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
	
	public void getNavigationView(Diplome d,Promotion p){
		navigationView = new NavigationView(interfaceUtilisateur,d,p);
        interfaceUtilisateur.setBlocPrincipal(navigationView);
	}
	
	public LinkedList<Promotion> getPromotions(Diplome d){
		if(interfaceUtilisateur.utilisateurCourant.type.compareToIgnoreCase("etu")==0)
			return interfaceUtilisateur.getController().getPromotion("SELECT PROMOTION.CODE_PROMOTION, NOM_PROMOTION, ANNEE_DEBUT_PROMOTION, ANNEE_FIN_PROMOTION, CODE_ANNEE, CODE_DIPLOME FROM PROMOTION JOIN ETUDIANT_PROMOTION ON PROMOTION.CODE_PROMOTION = ETUDIANT_PROMOTION.CODE_PROMOTION WHERE CODE_DIPLOME = "+d.getCode()+" AND CODE_ETUDIANT = "+interfaceUtilisateur.utilisateurCourant.getCode()+";");
		else
			return interfaceUtilisateur.getController().getPromotion("SELECT * FROM PROMOTION WHERE CODE_DIPLOME = "+d.getCode()+";");
	}

}
