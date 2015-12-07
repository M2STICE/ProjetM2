package com.m2stice.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import com.m2stice.model.Promotion;

public class PromotionController {
DatabaseAccess connection;
	
	public PromotionController(DatabaseAccess con) {
		// TODO Auto-generated constructor stub
		this.connection = (DatabaseAccess) con;
	}
	
	public LinkedList<Promotion> getSelect(String getRequete) {
		String requete = null;
		ResultSet resultat;
		LinkedList<Promotion> list = new LinkedList<Promotion>(); 
				
		requete = getRequete;
		resultat = connection.getRequest(requete);
		if (resultat != null) {
			try {
				while(resultat.next()){						                                                                                                                                                                                                                                  
					list.add(new Promotion(resultat.getInt("code_promotion"), resultat.getString("nom_promotion"), resultat.getInt("annee_debut_promotion"), resultat.getInt("annee_fin_promotion"), resultat.getInt("code_annee"), resultat.getInt("code_diplome")));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		else{
			System.out.println("vide");
		}

		return list;
	}

}
