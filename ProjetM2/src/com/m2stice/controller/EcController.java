package com.m2stice.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import com.m2stice.model.Ec;

public class EcController {

	DatabaseAccess connection;
	
	public EcController(DatabaseAccess con) {
		this.connection = (DatabaseAccess) con;
	}
	

	public LinkedList<Ec> getSelect(String getRequete) {
		String requete = null;
		ResultSet resultat;
		LinkedList<Ec> list = new LinkedList<Ec>(); 
				
		requete = getRequete;
		resultat = connection.getRequest(requete);
		if (resultat != null) {
			try {
				while(resultat.next()){						                                                                                                                                                                                                                                  
					list.add(new Ec( resultat.getInt("code_ec"),resultat.getString("nom"), resultat.getFloat("coefficient"), resultat.getInt("nombreEcts"), resultat.getInt("volumeHeureCours"), resultat.getInt("volumeHeureTP"), resultat.getInt("volumeHeureTD"), resultat.getInt("volumeHeureBE"), resultat.getInt("volumeHeureTPerso"), resultat.getString("resume"), resultat.getInt("codeUe"), resultat.getInt("responsableEc")));
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
