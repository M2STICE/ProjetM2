package com.m2stice.adapter;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import com.m2stice.controller.DatabaseAccess;
import com.m2stice.model.Annee;

/**
* AnneeAdapter - Classe de requêtage pour les Annees
*
* @version 1.1
*
* @author ASDRUBAL & NERES
* @copyright (C) Master 2 2015
* @date 07/12/2015
* 
*/
public class AnneeAdapter {
	
	DatabaseAccess connection;

	/**
	 * Recuparation de la connexion
	 * @param con
	 */
	
	public AnneeAdapter(DatabaseAccess con) {
		this.connection = (DatabaseAccess) con;
	}

	/**
	 * méthode permmettant de créer la liste des Annees
	 * @param getRequete
	 * @return liste des Annees
	 */
	
	public LinkedList<Annee> getSelect(String getRequete) {
		String requete = null;
		ResultSet resultat;
		LinkedList<Annee> list = new LinkedList<Annee>(); 
				
		requete = getRequete;
		resultat = connection.getRequest(requete);
		if (resultat != null) {
			try {
				while(resultat.next()){
					list.add(new Annee(resultat.getInt("code_annee") , resultat.getString("nom_annee")));
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
