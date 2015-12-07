package com.m2stice.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import com.m2stice.model.Competence;

public class CompetenceController {

	public CompetenceController(DatabaseAccess con) {
		this.connection = (DatabaseAccess) con;
	}
	
	DatabaseAccess connection;

	public LinkedList<Competence> getSelect(String getRequete) {
		String requete = null;
		ResultSet resultat;
		LinkedList<Competence> list = new LinkedList<Competence>(); 
				
		requete = getRequete;
		resultat = connection.getRequest(requete);
		if (resultat != null) {
			try {
				while(resultat.next()){
					list.add(new  Competence(resultat.getInt("code_compétence"),resultat.getString("nom_competence")));
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
