package com.m2stice.adapter;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import com.m2stice.controller.DatabaseAccess;
import com.m2stice.model.SousItem;
/**
*  SousItemAdapter - Classe de requêtage pour les SousItem
*
* @version 1.1
*
* @author ASDRUBAL & NERES
* @copyright (C) Master 2 2015
* @date 07/12/2015
* 
*/
public class SousItemAdapter {
	
	/**
	 * Recuparation de la connexion
	 * @param con
	 */
	
	public SousItemAdapter(DatabaseAccess con) {
		this.connection = (DatabaseAccess) con;
	}
	
	DatabaseAccess connection;

	/**
	 * méthode permmettant de créer la liste des sous items
	 * @param getRequete
	 * @return liste de sous item
	 */
	
	public LinkedList<SousItem> getSelect(String getRequete) {
		String requete = null;
		ResultSet resultat;
		LinkedList<SousItem> list = new LinkedList<SousItem>(); 
				
		requete = getRequete;
		resultat = connection.getRequest(requete);
		if (resultat != null) {
			try {
				while(resultat.next()){
					list.add(new  SousItem(resultat.getInt("code_sous_item"),resultat.getString("nom_sous_item")));
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
