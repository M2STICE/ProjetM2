package com.m2stice.model;

/**
*  Intervenant - Classe représentant un intervenant dans un élement constitutif d'une unité d'enseignement
*
* @version 1.1
*
* @author ASDRUBAL, CISNEROS & NERES
* @copyright (C) Master 2 2015
* @date 01/12/2015
* @revision 04/12
* 
*/
public class Intervenant {
	
	private int code;
	private String nom;
	private String motDePasse;
	
	/**
	 * Constructeur de l'objet Intervenant 
	 * 
	 * @param code
	 * @param nom
	 * @param motDePasse
	 */
	public Intervenant(int code, String nom, String motDePasse) {
		this.code = code;
		this.nom = nom;
		this.motDePasse = motDePasse;
	}

	public String toString(){
		return "ID: "+code+" NOM: "+nom+" MOT DE PASSE: "+motDePasse+"\n";
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

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

}
