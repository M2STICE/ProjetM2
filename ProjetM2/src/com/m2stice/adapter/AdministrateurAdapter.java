package com.m2stice.adapter;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import com.m2stice.controller.DatabaseAccess;
import com.m2stice.model.Administrateur;

public class AdministrateurAdapter {

	DatabaseAccess connection;

	/**
	 * Recuparation de la connexion
	 * @param con
	 */
	public AdministrateurAdapter(DatabaseAccess con) {
		this.connection = (DatabaseAccess) con;
	}

	/**
	 * méthode permmettant de créer la liste des Administrateurs
	 * @param getRequete
	 * @return liste des Administrateur
	 */
	public LinkedList<Administrateur> getSelect(String getRequete) {
		String requete = null;
		ResultSet resultat;
		LinkedList<Administrateur> list = new LinkedList<Administrateur>(); 
				
		requete = getRequete;
		resultat = connection.getRequest(requete);
		if (resultat != null) {
			try {
				while(resultat.next()){
					list.add(new Administrateur(resultat.getInt("code_administrateur"), resultat.getString("nom_administrateur"), resultat.getString("mot_de_passe_administrateur")));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		else{
			System.out.println("[Log-ADMINISTRATEUR_ADAPTER]: Résultat vide..");
		}
		return list;
	}

	
}
