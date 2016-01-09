package com.m2stice.controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.LinkedList;

import javax.swing.JLabel;

import com.m2stice.graphics.AuthentificationView;
import com.m2stice.graphics.Interface;
import com.m2stice.graphics.NavigationView;
import com.m2stice.graphics.RechercheView;
import com.m2stice.graphics.ResultatView;
import com.m2stice.model.Diplome;
import com.m2stice.model.Promotion;

public class ResultatViewListener {
	
	private Interface interfaceUtilisateur;
	private ResultatView resultatView;
	private AuthentificationView authentificationView;
	private RechercheView rechercheView;
	private NavigationView navigationView;
	
	public ResultatViewListener(Interface interfaceUtilisateur,ResultatView resultatView){
		this.interfaceUtilisateur = interfaceUtilisateur;
		this.resultatView = resultatView;
	}
	
	public ActionListener getRetourBoutonListener(){
		if(interfaceUtilisateur.utilisateurCourant.type.compareToIgnoreCase("admin")==0){
			resultatView.setBouton("Retour");
			return new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					rechercheView = new RechercheView(interfaceUtilisateur);
					interfaceUtilisateur.setBlocPrincipal(rechercheView);
				}
			};
		}
		else{
			resultatView.setBouton("Déconnexion");
			return new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					authentificationView = new AuthentificationView(interfaceUtilisateur);
					interfaceUtilisateur.setBlocPrincipal(authentificationView);
				
				}
			};
		}
	}
	
	public MouseListener getItemListener(JLabel jl, Diplome d, Promotion p){
		return new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				jl.setBackground(Color.decode("#66a8da"));
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				jl.setBackground(Color.decode("#ffb401"));
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				Color defaut = jl.getForeground();
				Thread th = new Thread(){
					public void run(){
						resultatView.chargementImg.setVisible(true);
						getNavigationView(d,p);
						resultatView.chargementImg.setVisible(false);
						jl.setForeground(defaut);
						jl.setText("  "+jl.getText().trim().substring(1));
					}
				};
				th.start();
				jl.setText(" >" +jl.getText().trim());
				jl.setForeground(Color.decode("#ffb401"));
			}
		};
	}
	
	public void getNavigationView(Diplome d){
		navigationView = new NavigationView(interfaceUtilisateur,d);
		interfaceUtilisateur.derniereVue = resultatView;
        interfaceUtilisateur.setBlocPrincipal(navigationView);
	}
	
	public void getNavigationView(Diplome d,Promotion p){
		navigationView = new NavigationView(interfaceUtilisateur,d,p);
		interfaceUtilisateur.derniereVue = resultatView;
        interfaceUtilisateur.setBlocPrincipal(navigationView);
	}
	
	public LinkedList<Promotion> getPromotions(Diplome d){
		if(interfaceUtilisateur.utilisateurCourant.type.compareToIgnoreCase("etu")==0)
			return interfaceUtilisateur.getController().getPromotion("SELECT PROMOTION.CODE_PROMOTION, NOM_PROMOTION, ANNEE_DEBUT_PROMOTION, ANNEE_FIN_PROMOTION, CODE_ANNEE, CODE_DIPLOME FROM PROMOTION JOIN ETUDIANT_PROMOTION ON PROMOTION.CODE_PROMOTION = ETUDIANT_PROMOTION.CODE_PROMOTION WHERE CODE_DIPLOME = "+d.getCode()+" AND CODE_ETUDIANT = "+interfaceUtilisateur.utilisateurCourant.getCode()+";");
		else
			return interfaceUtilisateur.getController().getPromotion("SELECT * FROM PROMOTION WHERE CODE_DIPLOME = "+d.getCode()+";");
	}

}
