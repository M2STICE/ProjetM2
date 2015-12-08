package com.m2stice.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import com.m2stice.model.Diplome;

/*
 * Gestion d'exception à faire
 */
public class DiplomeController {

	public DiplomeController(DatabaseAccess con) {
		this.connection = (DatabaseAccess) con;
	}
	
	DatabaseAccess connection;

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
