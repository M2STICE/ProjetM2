package com.m2stice.adapter;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import com.m2stice.controller.DatabaseAccess;
import com.m2stice.model.Semestre;

/**
* SemestreAdapter - Classe de requetage pour les Semestres
*
* @version 1.1
*
* @author ASDRUBAL NERES
* @copyright (C) Master 2 2015
* @date 07/12/2015
* 
*/

public class SemestreAdapter {

	/**
	 * Recuparation de la connexion
	 * @param con
	 */
	
	public SemestreAdapter(DatabaseAccess con) {
		this.connection = (DatabaseAccess) con;
	}
	
	DatabaseAccess connection;

	/**
	 * méthode permmettant de creer la liste des sous items
	 * @param getRequete
	 * @return liste de semestre
	 */
	
	public LinkedList<Semestre> getSelect(String getRequete) {
		String requete = null;
		ResultSet resultat;
		LinkedList<Semestre> list = new LinkedList<Semestre>(); 
				
		requete = getRequete;
		resultat = connection.getRequest(requete);
		if (resultat != null) {
			try {
				while(resultat.next()){
					list.add(new  Semestre(resultat.getInt("code_semestre"),resultat.getString("nom_semestre"),resultat.getInt("code_annee")));
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
