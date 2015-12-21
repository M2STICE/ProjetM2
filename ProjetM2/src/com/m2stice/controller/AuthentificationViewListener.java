package com.m2stice.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import com.m2stice.graphics.AuthentificationView;
import com.m2stice.graphics.Interface;
import com.m2stice.graphics.RechercheView;
import com.m2stice.graphics.ResultatView;
import com.m2stice.model.Administrateur;
import com.m2stice.model.Diplome;
import com.m2stice.model.Etudiant;
import com.m2stice.model.Intervenant;
/**
 * AuthentificationViewListener - Classe qui gère les interactions avec la vue d'authentification.
 * @author BIABIANY
 * @version 1.0
 * @date 03/12/2015
 * @copyright (C) Master 2 2015
 */
public class AuthentificationViewListener {
	
	private Interface interfaceUtilisateur;
	private AuthentificationView authentificationView;
	private RechercheView rechercheView;
	private ResultatView resultatView;
	//private NavigationView navigationView;
	private LinkedList<Diplome> diplomes;
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
			int codeEtudiant = 0;
			etudiants = interfaceUtilisateur.getController().getEtudiant("SELECT * FROM ETUDIANT;");
			for(Etudiant e:etudiants){
				if(nomUtilisateur.compareToIgnoreCase(e.getPrenom()+"."+e.getNom())==0&&motDePasse.compareTo(e.getMotDePasse())==0){
					exist = true;
					codeEtudiant = e.getCode();
				}
			}
			if(exist){
				diplomes = interfaceUtilisateur.getController().getDiplome("SELECT diplome.code_diplome, diplome.nom_diplome, diplome.description_diplome FROM diplome JOIN etudiant_diplome ON diplome.code_diplome = etudiant_diplome.code_diplome WHERE etudiant_diplome.code_etudiant = "+codeEtudiant+";");
				resultatView = new ResultatView(interfaceUtilisateur);
				resultatView.setEntete(nomUtilisateur,diplomes.size());
			 	resultatView.setResultat(diplomes);
			 	interfaceUtilisateur.setBlocPrincipal(resultatView);
			 	resultatView.setRetourListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						authentificationView = new AuthentificationView(interfaceUtilisateur);
						interfaceUtilisateur.setBlocPrincipal(authentificationView);
					}
				});
			}
		}
		else{
			if(statut.compareToIgnoreCase("enseignant")==0){
				int codeIntervenant = 0;
				intervenants = interfaceUtilisateur.getController().getIntervenant("SELECT * FROM INTERVENANT;");
				for(Intervenant i:intervenants){
					if(nomUtilisateur.compareToIgnoreCase(i.getPrenom()+"."+i.getNom())==0&&motDePasse.compareTo(i.getMotDePasse())==0){
						exist = true;
						codeIntervenant = i.getCode();
					}
				}
				if(exist){
					diplomes = interfaceUtilisateur.getController().getDiplome("SELECT diplome.code_diplome, diplome.nom_diplome, diplome.description_diplome FROM diplome,ue,ec,intervenant_ec WHERE diplome.code_diplome = ue.code_diplome AND ue.code_ue = ec.code_ue AND ec.code_ec = intervenant_ec.code_ec AND intervenant_ec.code_intervenant = "+codeIntervenant+" GROUP BY diplome.code_diplome;");
					resultatView = new ResultatView(interfaceUtilisateur);
					resultatView.setEntete(nomUtilisateur,diplomes.size());
				 	resultatView.setResultat(diplomes);
				 	resultatView.setRetourListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							authentificationView = new AuthentificationView(interfaceUtilisateur);
							interfaceUtilisateur.setBlocPrincipal(authentificationView);
						}
					});
				 	interfaceUtilisateur.setBlocPrincipal(resultatView);
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
