package com.m2stice.adapter;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import com.m2stice.controller.DatabaseAccess;
import com.m2stice.model.Competence;

/**
* CompetenceAdapter - Classe de requêtage pour les Competences
* @version 1.1
*
* @author ASDRUBAL & NERES
* @copyright (C) Master 2 2015
* @date 07/12/2015
* 
*/

public class CompetenceAdapter {

	/**
	 * Recuparation de la connexion
	 * @param con
	 */
	
	public CompetenceAdapter(DatabaseAccess con) {
		this.connection = (DatabaseAccess) con;
	}
	
	DatabaseAccess connection;

	/**
	 * méthode permmettant de créer la liste des Competences
	 * @param getRequete
	 * @return liste des Competences
	 */
	
	public LinkedList<Competence> getSelect(String getRequete) {
		String requete = null;
		ResultSet resultat;
		LinkedList<Competence> list = new LinkedList<Competence>(); 
				
		requete = getRequete;
		resultat = connection.getRequest(requete);
		if (resultat != null) {
			try {
				while(resultat.next()){
					list.add(new  Competence(resultat.getInt("code_competence"),resultat.getString("nom_competence"), resultat.getInt("code_domaine")));
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
