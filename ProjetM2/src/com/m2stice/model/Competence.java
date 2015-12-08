package com.m2stice.model;

/**
*  Competence - Classe représentant une compétence
*
* @version 1.1
*
* @author ASDRUBAL, CISNEROS & NERES
* @copyright (C) Master 2 2015
* @date 01/12/2015
* @revision 04/12
* 
*/
public class Competence {

	private int code;
	private String nom;
	private int codeDomaine;
	
	/**
	 * Constructeur de la classe Competence
	 * 
	 * @param code
	 * @param nom
	 * @param codeDomaine
	 */
	public Competence(int code, String nom, int codeDomaine) {
		this.code = code;
		this.nom = nom;
		this.setCodeDomaine(codeDomaine);
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

	public int getCodeDomaine() {
		return codeDomaine;
	}

	public void setCodeDomaine(int codeDomaine) {
		this.codeDomaine = codeDomaine;
	}

}
