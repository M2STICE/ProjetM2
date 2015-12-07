package com.m2stice.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import com.m2stice.model.Evaluation;

public class EvaluationController {

	public EvaluationController(DatabaseAccess con) {
		this.connection = (DatabaseAccess) con;
	}
	
	DatabaseAccess connection;

	public LinkedList<Evaluation> getSelect(String getRequete) {
		String requete = null;
		ResultSet resultat;
		LinkedList<Evaluation> list = new LinkedList<Evaluation>(); 
				
		requete = getRequete;
		resultat = connection.getRequest(requete);
		if (resultat != null) {
			try {
				while(resultat.next()){
					list.add(new Evaluation(resultat.getInt("code_evaluation"), resultat.getString("note_evaluation"), resultat.getFloat("note_maximale"), resultat.getFloat("coefficient_evaluation"), resultat.getString("type_epreuve"), resultat.getInt("code_sous_item")));
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
