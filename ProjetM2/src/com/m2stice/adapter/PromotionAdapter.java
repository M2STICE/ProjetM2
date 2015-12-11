package com.m2stice.adapter;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import com.m2stice.controller.DatabaseAccess;
import com.m2stice.model.Promotion;

/**
* PromotionAdapter - Classe de requêtage pour les Promotions
*
* @version 1.1
*
* @author ASDRUBAL & NERES
* @copyright (C) Master 2 2015
* @date 07/12/2015
* 
*/

public class PromotionAdapter {
DatabaseAccess connection;
	
	/**
	 * Recuparation de la connexion
	 * @param con
	 */

	public PromotionAdapter(DatabaseAccess con) {
		// TODO Auto-generated constructor stub
		this.connection = (DatabaseAccess) con;
	}
	
	/**
	 * méthode permmettant de créer la liste des Promotions
	 * @param getRequete
	 * @return liste de promotions
	 */
	
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
