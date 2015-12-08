package com.m2stice.adapter;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import com.m2stice.controller.DatabaseAccess;
import com.m2stice.model.Etudiant;

public class EtudiantAdapter {

	public EtudiantAdapter(DatabaseAccess con) {
		this.connection = (DatabaseAccess) con;
	}
	
	DatabaseAccess connection;

	public LinkedList<Etudiant> getSelect(String getRequete) {
		String requete = null;
		ResultSet resultat;
		LinkedList<Etudiant> list = new LinkedList<Etudiant>(); 
				
		requete = getRequete;
		resultat = connection.getRequest(requete);
		if (resultat != null) {
			try {
				while(resultat.next()){
					list.add(new Etudiant(resultat.getInt("code_etudiant"), resultat.getString("nom_etudiant"), resultat.getString("prenom_etudiant"), resultat.getString("mot_de_passe_etudiant")));
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
