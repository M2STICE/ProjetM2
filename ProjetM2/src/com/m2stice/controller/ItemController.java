package com.m2stice.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import com.m2stice.model.Item;

public class ItemController {

	public ItemController(DatabaseAccess con) {
		this.connection = (DatabaseAccess) con;
	}
	
	DatabaseAccess connection;

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
