package com.m2stice.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import com.m2stice.model.Ue;

public class UeController {

	public UeController(DatabaseAccess con) {
		this.connection = (DatabaseAccess) con;
	}
	
	DatabaseAccess connection;

	public LinkedList<Ue> getSelect(String getRequete) {
		String requete = null;
		ResultSet resultat;
		LinkedList<Ue> list = new LinkedList<Ue>(); 
				
		requete = getRequete;
		resultat = connection.getRequest(requete);
		if (resultat != null) {
			try {
				while(resultat.next()){
					list.add(new  Ue( resultat.getInt("code_ue"),resultat.getString("nom_ue"), resultat.getInt("nombre_ects"), resultat.getString("resume_ue"),resultat.getFloat("coefficient_ue"), resultat.getInt("code_semestre"), resultat.getInt("code_intervenant"), resultat.getInt("code_diplome")));
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
