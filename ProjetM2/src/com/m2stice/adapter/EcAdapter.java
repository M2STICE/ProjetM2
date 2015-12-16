package com.m2stice.adapter;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import com.m2stice.controller.DatabaseAccess;
import com.m2stice.model.Ec;

/**
* EcAdapter - Classe de requêtage pour les Ec
*
* @version 1.1
*
* @author ASDRUBAL & NERES
* @copyright (C) Master 2 2015
* @date 07/12/2015
* 
*/

public class EcAdapter {

	DatabaseAccess connection;
	
	/**
	 * Recuparation de la connexion
	 * @param con
	 */
	
	public EcAdapter(DatabaseAccess con) {
		this.connection = (DatabaseAccess) con;
	}
	

	/**
	 * méthode permmettant de créer la liste des Ec
	 * @param getRequete
	 * @return liste des Ec
	 */
	
	public LinkedList<Ec> getSelect(String getRequete) {
		String requete = null;
		ResultSet resultat;
		LinkedList<Ec> list = new LinkedList<Ec>(); 
				
		requete = getRequete;
		resultat = connection.getRequest(requete);
		if (resultat != null) {
			try {
				while(resultat.next()){						                                                                                                                                                                                                                                  
					list.add(new Ec( resultat.getInt("code_ec"),resultat.getString("nom_ec"), resultat.getFloat("coefficient_ec"), resultat.getInt("nom_ects"), resultat.getFloat("volume_heure_cours"), resultat.getFloat("volume_heure_TP"), resultat.getFloat("volume_heure_TD"), resultat.getFloat("volume_heure_BE"), resultat.getFloat("volume_heure_TPERSO"), resultat.getString("resume_ec"), resultat.getInt("code_ue"), resultat.getInt("responsable_ec"), resultat.getInt("code_semestre")));
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
