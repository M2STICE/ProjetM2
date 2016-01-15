package com.m2stice.adapter;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import com.m2stice.controller.DatabaseAccess;
import com.m2stice.model.Intervenant;

/**
* IntervenantAdapter - Classe de requetage pour les Intervenants
*
* @version 1.1
*
* @author ASDRUBAL, NERES
* @copyright (C) Master 2 2015
* @date 07/12/2015
* 
*/

public class IntervenantAdapter {

	/**
	 * Recuparation de la connexion
	 * @param con
	 */
	
	public IntervenantAdapter(DatabaseAccess con) {
		this.connection = (DatabaseAccess) con;
	}
	
	DatabaseAccess connection;

	/**
	 * methode permmettant de creer la liste des intervenants
	 * @param getRequete
	 * @return liste des intervenants
	 */
	
	public LinkedList<Intervenant> getSelect(String getRequete) {
		String requete = null;
		ResultSet resultat;
		LinkedList<Intervenant> list = new LinkedList<Intervenant>(); 
				
		requete = getRequete;
		resultat = connection.getRequest(requete);
		if (resultat != null) {
			try {
				while(resultat.next()){
					list.add(new Intervenant(resultat.getInt("code_intervenant"), resultat.getString("nom_intervenant"), resultat.getString("prenom_intervenant"), resultat.getString("mot_de_passe")));
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
