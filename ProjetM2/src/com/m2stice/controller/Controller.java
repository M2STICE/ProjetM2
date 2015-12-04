package com.m2stice.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

/*
* Nom de classe : Controller
*
* Description: Classe controller
*
* Version : 1.0
*
* Date : 02/12/2015
*
* Copyright : (C) Master 2 2015
*/

/**
*  Controller - Classe de controle pour réaliser les actions sur la base de donnée
*
* @version 1.0
*
* @author ASDRUBAL & NERES
* @copyright (C) Master 2 2015
* @date 02/12/2015
* @see DatabaseAccess
* @revision 04/12
* 
*/
public class Controller {

	private DatabaseAccess connection = null;
	
	private String username;
	private String pass;
	private String server;
	private String databaseName;
	
	public Controller() {
		databaseName = "u960093295_stice";
		username = "u960093295_m2";
		pass = "pm2_2015";
		server = "sql37.hostinger.fr";
//		databaseName = "m2stice";
//		username = "root";
//		pass = "";
//		server = "localhost";
		setConnection(new DatabaseAccess(username, pass, server, databaseName));
		System.out.println("connection");
	}
	
	public LinkedList<Object> getSelect(String getRequete){
		String requete = null;
		ResultSet resultat;
		LinkedList<Object> list = new LinkedList<Object>(); 
		Object object = null;
				
		requete = getRequete;
		resultat = connection.getRequest(requete);
		if (resultat != null) {
			try {
				while(resultat.next()){
					System.out.println(resultat.getString("nom_diplome") + " " +resultat.getString("description_diplome"));
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

	public DatabaseAccess getConnection() {
		return connection;
	}

	public void setConnection(DatabaseAccess connection) {
		this.connection = connection;
	}
	
	public static void main(String[] args) {
		Controller control = new Controller();
		String Requete = "SELECT * FROM diplome";
		control.getSelect(Requete);
	}

}
