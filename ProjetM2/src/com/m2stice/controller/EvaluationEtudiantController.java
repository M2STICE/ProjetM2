package com.m2stice.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import com.m2stice.model.EvaluationEtudiant;

public class EvaluationEtudiantController {

	public EvaluationEtudiantController(DatabaseAccess con) {
		this.connection = (DatabaseAccess) con;
	}
	
	DatabaseAccess connection;

	public LinkedList<EvaluationEtudiant> getSelect(String getRequete) {
		String requete = null;
		ResultSet resultat;
		LinkedList<EvaluationEtudiant> list = new LinkedList<EvaluationEtudiant>(); 
				
		requete = getRequete;
		resultat = connection.getRequest(requete);
		if (resultat != null) {
			try {
				while(resultat.next()){
					list.add(new EvaluationEtudiant(resultat.getInt("code_etudiant"), resultat.getInt("code_evaluation"), resultat.getDate("date_evaluation"), resultat.getFloat("note_evaluation")));
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
