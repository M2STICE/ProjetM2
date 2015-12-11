package com.m2stice.adapter;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import com.m2stice.controller.DatabaseAccess;
import com.m2stice.model.Domaine;

/**
* DomaineAdapter - Classe de requêtage pour les Domaines
*
* @version 1.1
*
* @author ASDRUBAL & NERES
* @copyright (C) Master 2 2015
* @date 07/12/2015
* 
*/

public class DomaineAdapter {

	DatabaseAccess connection;
	
	/**
	 * Recuparation de la connexion
	 * @param con
	 */
	
	public DomaineAdapter(DatabaseAccess con) {
		// TODO Auto-generated constructor stub
		this.connection = (DatabaseAccess) con;
	}
	
	/**
	 * méthode permmettant de créer la liste des Domaines
	 * @param getRequete
	 * @return liste des Domaines
	 */
	
	public LinkedList<Domaine> getSelect(String getRequete) {
		String requete = null;
		ResultSet resultat;
		LinkedList<Domaine> list = new LinkedList<Domaine>(); 
				
		requete = getRequete;
		resultat = connection.getRequest(requete);
		if (resultat != null) {
			try {
				while(resultat.next()){						                                                                                                                                                                                                                                  
					list.add(new Domaine( resultat.getInt("code_domaine"), resultat.getString("nom_domaine"), resultat.getInt("code_diplome")));
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
