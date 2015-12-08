package com.m2stice.adapter;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import com.m2stice.controller.DatabaseAccess;
import com.m2stice.model.Ec;

public class EcAdapter {

	DatabaseAccess connection;
	
	public EcAdapter(DatabaseAccess con) {
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
					list.add(new Ec( resultat.getInt("code_ec"),resultat.getString("nom_ec"), resultat.getFloat("coefficient_ec"), resultat.getInt("nom_ects"), resultat.getInt("volume_heure_cours"), resultat.getInt("volume_heure_TP"), resultat.getInt("volume_heure_TD"), resultat.getInt("volume_heure_BE"), resultat.getInt("volume_heure_TPERSO"), resultat.getString("resume_ec"), resultat.getInt("code_ue"), resultat.getInt("responsable_ec"), resultat.getInt("code_semestre")));
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
