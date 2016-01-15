package com.m2stice.model;

/**
*  Semestre - Classe repr�sentant un semestre d'une ann�e scolaire
*
* @version 1.1
*
* @author ASDRUBAL, CISNEROS, NERES
* @copyright (C) Master 2 2015
* @date 01/12/2015
* @revision 04/12
* 
*/
public class Semestre {

	private int code;
	private String nom;
	private int codeAnnee;
	
	/**
	 * Constructeur de l'objet Semestre
	 * 
	 * @param code
	 * @param nom
	 * @param codeAnnee
	 */

	public Semestre(int code, String nom, int codeAnnee) {
		this.code = code;
		this.nom = nom;
		this.codeAnnee = codeAnnee;
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

	public int getCodeAnnee() {
		return codeAnnee;
	}

	public void setCodeAnnee(int codeAnnee) {
		this.codeAnnee = codeAnnee;
	}

}
