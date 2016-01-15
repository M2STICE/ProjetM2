package com.m2stice.adapter;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import com.m2stice.controller.DatabaseAccess;
import com.m2stice.model.EvaluationEtudiant;

/**
* EvaluationEtudiantAdapter - Classe de requetage pour les Evaluation Etudiants
*
* @version 1.1
*
* @author ASDRUBAL, NERES
* @copyright (C) Master 2 2015
* @date 07/12/2015
* 
*/

public class EvaluationEtudiantAdapter {

	/**
	 * Recuparation de la connexion
	 * @param con
	 */
	
	public EvaluationEtudiantAdapter(DatabaseAccess con) {
		this.connection = (DatabaseAccess) con;
	}
	
	DatabaseAccess connection;

	/**
	 * methode permmettant de creer la liste des Evaluation Etudiants
	 * @param getRequete
	 * @return liste des Evaluation Etudiants
	 */
	
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
