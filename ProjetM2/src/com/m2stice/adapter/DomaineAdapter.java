package com.m2stice.adapter;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import com.m2stice.controller.DatabaseAccess;
import com.m2stice.model.Domaine;

public class DomaineAdapter {

	DatabaseAccess connection;
	
	public DomaineAdapter(DatabaseAccess con) {
		// TODO Auto-generated constructor stub
		this.connection = (DatabaseAccess) con;
	}
	
	public LinkedList<Domaine> getSelect(String getRequete) {
		String requete = null;
		ResultSet resultat;
		LinkedList<Domaine> list = new LinkedList<Domaine>(); 
				
		requete = getRequete;
		resultat = connection.getRequest(requete);
		if (resultat != null) {
			try {
				while(resultat.next()){						                                                                                                                                                                                                                                  
					list.add(new Domaine( resultat.getInt("code_domaine"), resultat.getString("nom"), resultat.getInt("code_diplome")));
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
