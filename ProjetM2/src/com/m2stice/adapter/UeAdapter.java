package com.m2stice.adapter;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import com.m2stice.controller.DatabaseAccess;
import com.m2stice.model.Ue;
/**
*  UeAdapter - Classe de requêtage pour les Ue
*
* @version 1.1
*
* @author ASDRUBAL & NERES
* @copyright (C) Master 2 2015
* @date 07/12/2015
* 
*/
public class UeAdapter {

	/**
	 * Recuparation de la connexion
	 * @param con
	 */
	public UeAdapter(DatabaseAccess con) {
		this.connection = (DatabaseAccess) con;
	}
	
	DatabaseAccess connection;

	/**
	 * méthode permmettant de créer la liste d'Ue
	 * @param getRequete
	 * @return liste d'Ue
	 */
	public LinkedList<Ue> getSelect(String getRequete) {
		String requete = null;
		ResultSet resultat;
		LinkedList<Ue> list = new LinkedList<Ue>(); 
				
		requete = getRequete;
		resultat = connection.getRequest(requete);
		if (resultat != null) {
			try {
				while(resultat.next()){
					list.add(new  Ue( resultat.getInt("code_ue"),resultat.getString("nom_ue"), resultat.getInt("nombre_ects"), resultat.getString("resume_ue"),resultat.getFloat("coefficient_ue"), resultat.getInt("code_semestre"), resultat.getInt("code_intervenant"), resultat.getInt("code_diplome")));
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
