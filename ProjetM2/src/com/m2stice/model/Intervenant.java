package com.m2stice.model;

/**
*  Intervenant - Classe repr�sentant un intervenant dans un �lement constitutif d'une unit� d'enseignement
*
* @version 1.1
*
* @author ASDRUBAL, CISNEROS & NERES
* @copyright (C) Master 2 2015
* @date 01/12/2015
* @revision 15/12
* Emmanuel
* 
*/
public class Intervenant {
	
	private int code;
	private String nom;
	private String prenom;
	private String motDePasse;
	
	/**
	 * Constructeur de l'objet Intervenant 
	 * 
	 * @param code
	 * @param nom
	 * @param motDePasse
	 */
	public Intervenant(int code, String nom, String prenom, String motDePasse) {
		this.code = code;
		this.nom = nom;
		this.prenom = prenom;
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

	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * @param prenom the prenom to set
	 */
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
