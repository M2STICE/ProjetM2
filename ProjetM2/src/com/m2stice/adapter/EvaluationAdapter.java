package com.m2stice.adapter;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import com.m2stice.controller.DatabaseAccess;
import com.m2stice.model.Evaluation;

/**
* EvaluationAdapter - Classe de requêtage pour les Evaluations
*
* @version 1.1
*
* @author ASDRUBAL & NERES
* @copyright (C) Master 2 2015
* @date 07/12/2015
* 
*/

public class EvaluationAdapter {

	/**
	 * Recuparation de la connexion
	 * @param con
	 */
	
	public EvaluationAdapter(DatabaseAccess con) {
		this.connection = (DatabaseAccess) con;
	}
	
	DatabaseAccess connection;

	/**
	 * méthode permmettant de créer la liste des Evaluations
	 * @param getRequete
	 * @return liste des Evaluations
	 */
	
	public LinkedList<Evaluation> getSelect(String getRequete) {
		String requete = null;
		ResultSet resultat;
		LinkedList<Evaluation> list = new LinkedList<Evaluation>(); 
				
		requete = getRequete;
		resultat = connection.getRequest(requete);
		if (resultat != null) {
			try {
				while(resultat.next()){
					list.add(new Evaluation(resultat.getInt("code_evaluation"), resultat.getString("nom_evaluation"), resultat.getFloat("note_maximale"), resultat.getFloat("coefficient_evaluation"), resultat.getString("type_epreuve")));
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
