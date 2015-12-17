package com.m2stice.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import com.m2stice.graphics.AuthentificationView;
import com.m2stice.graphics.Interface;
import com.m2stice.graphics.RechercheView;
import com.m2stice.model.Administrateur;
import com.m2stice.model.Etudiant;
import com.m2stice.model.Intervenant;

public class AuthentificationViewListener {
	
	private Interface interfaceUtilisateur;
	private AuthentificationView authentificationView;
	private RechercheView rechercheView;
	//private NavigationView navigationView;
	private LinkedList<Etudiant> etudiants;
	private LinkedList<Intervenant> intervenants;
	private LinkedList<Administrateur> administrateurs;
	
	public AuthentificationViewListener(Interface interfaceUtilisateur,AuthentificationView authentificationView){
		this.interfaceUtilisateur = interfaceUtilisateur;
		this.authentificationView = authentificationView;
	}
	
	private boolean connect(String nomUtilisateur,String motDePasse,String statut){
		boolean exist = false;
		if(statut.compareToIgnoreCase("etudiant")==0){
			etudiants = interfaceUtilisateur.getController().getEtudiant("SELECT * FROM ETUDIANT;");
			for(Etudiant e:etudiants){
				if(nomUtilisateur.compareTo(e.getPrenom()+"."+e.getNom())==0&&motDePasse.compareTo(e.getMotDePasse())==0){
					exist = true;
				}
			}
		}
		else{
			if(statut.compareToIgnoreCase("intervenant")==0){
				intervenants = interfaceUtilisateur.getController().getIntervenant("SELECT * FROM INTERVENANT;");
				for(Intervenant i:intervenants){
					if(nomUtilisateur.compareTo(i.getPrenom()+"."+i.getNom())==0&&motDePasse.compareTo(i.getMotDePasse())==0){
						exist = true;
					}
				}
			}
			else{
				administrateurs = interfaceUtilisateur.getController().getAdministrateur("SELECT * FROM ADMINISTRATEUR;");
				for(Administrateur a:administrateurs){
					if(nomUtilisateur.compareTo(a.getNom())==0&&motDePasse.compareTo(a.getMotDePasse())==0){
						exist = true;
						rechercheView = new RechercheView(interfaceUtilisateur);
						interfaceUtilisateur.setBlocPrincipal(rechercheView);
					}
				}
			}
		}
		return exist;
	}
	public ActionListener getValiderListener(){
		return new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				connect(authentificationView.getNomUtilisateur(), authentificationView.getMotDePasse(), authentificationView.getUtilisateur());
			}
		};
	}
}
