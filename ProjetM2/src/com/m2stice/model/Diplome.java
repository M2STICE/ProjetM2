package com.m2stice.model;

/**
*  Diplome - Classe repr�sentant un dipl�me
*
* @version 1.1
*
* @author ASDRUBAL, CISNEROS, NERES
* @copyright (C) Master 2 2015
* @date 01/12/2015
* @revision 04/12
* 
*/
public class Diplome {

	private int code;
	private String nom;
	private String description;
	
	/**
	 * Constructeur de l'objet Diplome
	 * 
	 * @param code
	 * @param nom
	 * @param description
	 */
	public Diplome(int code, String nom, String description) {
		// TODO Auto-generated constructor stub
		this.code=code;
		this.nom=nom;
		this.description=description;
	}
	
	public String toString(){
		return "ID: "+code+" NOM: "+nom+" DESCRIPTION: "+description+"\n";
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
