package com.m2stice.model;

/**
*  Etudiant - Classe représentant un étudiant
*
* @version 1.1
*
* @author ASDRUBAL, CISNEROS & NERES
* @copyright (C) Master 2 2015
* @date 01/12/2015
* @revision 04/12
* 
*/
public class Etudiant {
 
	private int code;
	private String nom;
	private String prenom;
	private String motDePasse;

	/**
	 * Constructeur de l'objet Etudiant
	 * 
	 * @param code
	 * @param nom
	 * @param prenom
	 * @param motDePasse
	 */
	public Etudiant(int code, String nom, String prenom, String motDePasse) {
		this.code = code;
		this.nom = nom;
		this.prenom = prenom;
		this.motDePasse = motDePasse;
	}

	public String toString(){
		return "ID: "+code+" NOM: "+nom+" PRENOM: "+prenom+" MOT DE PASSE: "+motDePasse+"\n";
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

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

}
