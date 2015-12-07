package com.m2stice.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import com.m2stice.model.Annee;

public class AnneeController {
DatabaseAccess connection;
	public AnneeController(DatabaseAccess con) {
		this.connection = (DatabaseAccess) con;
	}

	public LinkedList<Annee> getSelect(String getRequete) {
		String requete = null;
		ResultSet resultat;
		LinkedList<Annee> list = new LinkedList<Annee>(); 
				
		requete = getRequete;
		resultat = connection.getRequest(requete);
		if (resultat != null) {
			try {
				while(resultat.next()){
					System.out.println(resultat.getString("code_annee") + " " +resultat.getString("nom_anne"));
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
