package com.m2stice.adapter;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import com.m2stice.controller.DatabaseAccess;
import com.m2stice.model.Item;

/**
* ItemAdapter - Classe de requêtage pour les Items
*
* @version 1.1
*
* @author ASDRUBAL & NERES
* @copyright (C) Master 2 2015
* @date 07/12/2015
* 
*/

public class ItemAdapter {

	/**
	 * Recuparation de la connexion
	 * @param con
	 */
	
	public ItemAdapter(DatabaseAccess con) {
		this.connection = (DatabaseAccess) con;
	}
	
	DatabaseAccess connection;

	/**
	 * méthode permmettant de créer la liste des items
	 * @param getRequete
	 * @return liste des items
	 */
	
	public LinkedList<Item> getSelect(String getRequete) {
		String requete = null;
		ResultSet resultat;
		LinkedList<Item> list = new LinkedList<Item>(); 
				
		requete = getRequete;
		resultat = connection.getRequest(requete);
		if (resultat != null) {
			try {
				while(resultat.next()){
					list.add(new Item(resultat.getInt("code_item"), resultat.getString("nom_item"), resultat.getInt("code_competence"), resultat.getInt("code_evaluation")));
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
