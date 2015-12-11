package com.m2stice.adapter;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import com.m2stice.controller.DatabaseAccess;
import com.m2stice.model.Diplome;
/**
* DiplomeAdapter - Classe de requêtage pour les Diplomes
*
* @version 1.1
*
* @author ASDRUBAL & NERES
* @copyright (C) Master 2 2015
* @date 07/12/2015
* 
*/

public class DiplomeAdapter {

	/**
	 * Recuparation de la connexion
	 * @param con
	 */
	
	public DiplomeAdapter(DatabaseAccess con) {
		this.connection = (DatabaseAccess) con;
	}
	
	DatabaseAccess connection;

	/**
	 * méthode permmettant de créer la liste des Diplomes
	 * @param getRequete
	 * @return liste des Diplomes
	 */
	
	public LinkedList<Diplome> getSelect(String getRequete) {
		String requete = null;
		ResultSet resultat;
		LinkedList<Diplome> list = new LinkedList<Diplome>(); 
				
		requete = getRequete;
		resultat = connection.getRequest(requete);
		if (resultat != null) {
			try {
				while(resultat.next()){
					list.add(new  Diplome( resultat.getInt("code_diplome"),resultat.getString("nom_diplome"), resultat.getString("description_diplome")));
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
