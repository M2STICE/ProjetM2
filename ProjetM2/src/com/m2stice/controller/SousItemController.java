package com.m2stice.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import com.m2stice.model.SousItem;

public class SousItemController {

	public SousItemController(DatabaseAccess con) {
		this.connection = (DatabaseAccess) con;
	}
	
	DatabaseAccess connection;

	public LinkedList<SousItem> getSelect(String getRequete) {
		String requete = null;
		ResultSet resultat;
		LinkedList<SousItem> list = new LinkedList<SousItem>(); 
				
		requete = getRequete;
		resultat = connection.getRequest(requete);
		if (resultat != null) {
			try {
				while(resultat.next()){
					list.add(new  SousItem(resultat.getInt("code_sous_item"),resultat.getString("nom_sous_item"),resultat.getInt("code_item")));
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
