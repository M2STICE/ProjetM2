package com.m2stice.model;

/**
* Domaine - Classe représentant un domaine de compétence
*
* @version 1.1
*
* @author ASDRUBAL, CISNEROS & NERES
* @copyright (C) Master 2 2015
* @date 01/12/2015
* @revision 04/12
* 
*/
public class Domaine {

	private int code;
	private String nom;
	private int codeDiplome;
	
	/**
	 * Constructeur de l'objet Domaine
	 * 
	 * @param code
	 * @param nom
	 * @param codeDiplome
	 */
	public Domaine(int code, String nom, int codeDiplome) {
		this.code = code;
		this.nom = nom;
		this.codeDiplome = codeDiplome;
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

	public int getCodeDiplome() {
		return codeDiplome;
	}

	public void setCodeDiplome(int codeDiplome) {
		this.codeDiplome = codeDiplome;
	}

}
