package com.m2stice.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import com.m2stice.model.Intervenant;

public class IntervenantController {

	public IntervenantController(DatabaseAccess con) {
		this.connection = (DatabaseAccess) con;
	}
	
	DatabaseAccess connection;

	public LinkedList<Intervenant> getSelect(String getRequete) {
		String requete = null;
		ResultSet resultat;
		LinkedList<Intervenant> list = new LinkedList<Intervenant>(); 
				
		requete = getRequete;
		resultat = connection.getRequest(requete);
		if (resultat != null) {
			try {
				while(resultat.next()){
					list.add(new Intervenant(resultat.getInt("code_intervenant"), resultat.getString("nom_intervenant"), resultat.getString("mot_de_passe")));
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
