package com.m2stice.controller;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/*
* Nom de classe : DatabaseAccess
*
* Description: Classe permettant l'accées à la base de donnée
*
* Version : 1.0
*
* Date : 03/12/2015
*
* Copyright : (C) Master 2 2015
*/

/**
*  DatabaseAccess - Classe de controle pour réaliser les actions sur la base de donnée
*
* @version 1.0
*
* @author ASDRUBAL & NERES
* @copyright (C) Master 2 2015
* @date 03/12/2015
*/


public class DatabaseAccess {

	private String userName;		/**Pseudo utilisateur pour l'accès à la base de donnée*/
	private String password;		/**Password pour l'accès à la base de donnée*/
	private String serverName;		/**Nom du serveur hébergeant la base*/
	private String dbName;			/**Nom de la base de donnée*/
//	private String tableName;		/***/
	
	private Connection connector = null;
	
	private int portNumber = 3306;	/*......*/
	
	/**
	 * Constructeur pour l'accès à la base de donnée 
	 * @param username
	 * @param pass
	 * @param server
	 * @param databaseName
	 */
	
	public DatabaseAccess(String username, String pass, String server, String databaseName) {
		this.userName = username;
		this.password = pass;
		this.serverName = server;
		this.dbName = databaseName;
		
		try {
			connector = getConnection();
			System.out.println("Connected to database");
		} catch (SQLException e) {
			System.out.println("ERROR: Could not connect to the database");
			e.printStackTrace();
		}
	}
	
	/**
	 * Cette fonction permet d'obtenir l'accès à la base de donnée
	 * @return Connection
	 * @throws SQLException
	 */
	
	public Connection getConnection() throws SQLException {
		Connection conn = null;
		
		Properties connectionProps = new Properties();
		connectionProps.put("user", this.userName);
		connectionProps.put("password", this.password);

		conn = DriverManager.getConnection("jdbc:mysql://"+ this.serverName + ":" + this.portNumber + "/" + this.dbName,connectionProps);
		return conn;
	}
	
	/**
	 * Fonction permettant l'éxécution des requêtes lié à toutes actions de mise à jour sur la base de donnée
	 * @param conn
	 * @param requete
	 * @return boolean
	 * @throws SQLException
	 */
	public boolean executeUpdate(Connection conn, String requete) throws SQLException {
	    Statement stmt = null;
	    try {
	        stmt = conn.createStatement();
	        stmt.executeUpdate(requete); // This will throw a SQLException if it fails
	        return true;
	    } catch(SQLException e){
	    	e.printStackTrace();
	    }
		return false;
	}
	
	/**
	 * fonction permettant de faire les requêtes select sur la base
	 * @param conn
	 * @param command
	 * @return ResultSet
	 * @throws SQLException
	 */
	public ResultSet executeQuery(Connection conn, String command) throws SQLException{
		Statement stmt = null;
		ResultSet query = null;
	    try {
	        stmt = conn.createStatement();
	        query = stmt.executeQuery(command); // This will throw a SQLException if it fails
	        return query;
	    } catch(SQLException e){
	    	e.printStackTrace();
	    }
		return null;
	}
	
	/**
	 * 
	 * fonction appelé pour faire une insertion dans la base de donnée
	 * @param toInsert
	 * @return boolean
	 */
	public boolean insertData(String toInsert){
		boolean insertion = false;
		try {
			String insertString = toInsert;
			this.executeUpdate(connector, insertString);
			insertion = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return insertion;
	}

	/**
	 * fonction permettant de faire un Select au niveau de la base de donnée
	 * @param select
	 * @return ResultSet
	 */
	public ResultSet getRequest(String select){
		ResultSet rs = null;
		try {
			String requestString = select;
			rs = this.executeQuery(connector, requestString);
		}
		catch(SQLException ex){
			ex.printStackTrace();
		}
		return rs;
	}
	
	/**
	 * fonction permettant de faire un update sur une table
	 * @param upToDate
	 * @return boolean
	 */
	public boolean update(String upToDate){
		boolean update = false;
		try {
			String updateString = upToDate;
			this.executeUpdate(connector, updateString);
			update = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return update;
	}
	
}
