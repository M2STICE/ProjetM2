package com.m2stice.model;

/**
*  Annee - Classe repr�sentant une ann�e scolaire
*
* @version 1.1
*
* @author ASDRUBAL, CISNEROS & NERES
* @copyright (C) Master 2 2015
* @date 01/12/2015
* @revision 04/12
* 
*/
public class Annee {
	
	private int code;
	private String nom;

	/**
	 * Constructeur de l'objet Annee
	 */
	public Annee() {
		// TODO Auto-generated constructor stub
	}

	public Annee(int code, String nom) {
		this.code = code;
		this.nom = nom;
	}

	public String toString(){
		return "ID: "+code+" NOM: "+nom+"\n";
	}
	
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

}
