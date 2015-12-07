package com.m2stice.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import com.m2stice.model.Semestre;

public class SemestreController {


	public SemestreController(DatabaseAccess con) {
		this.connection = (DatabaseAccess) con;
	}
	
	DatabaseAccess connection;

	public LinkedList<Semestre> getSelect(String getRequete) {
		String requete = null;
		ResultSet resultat;
		LinkedList<Semestre> list = new LinkedList<Semestre>(); 
				
		requete = getRequete;
		resultat = connection.getRequest(requete);
		if (resultat != null) {
			try {
				while(resultat.next()){
					list.add(new  Semestre(resultat.getInt("code_semestre"),resultat.getString("nom_semestre"),resultat.getInt("code_annee")));
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
