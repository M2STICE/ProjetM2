package com.m2stice.model;

/**
*  Etudiant - Classe repr�sentant un �tudiant
*
* @version 1.1
*
* @author ASDRUBAL, CISNEROS, NERES
* @copyright (C) Master 2 2015
* @date 01/12/2015
* @revision 04/12
* 
*/
public class Etudiant extends Utilisateur {
 
	private String nom;
	private String prenom;

	/**
	 * Constructeur de l'objet Etudiant
	 * 
	 * @param code
	 * @param nom
	 * @param prenom
	 * @param motDePasse
	 */
	public Etudiant(int code, String nom, String prenom, String motDePasse) {
		this.setCode(code);
		this.nom = nom;
		this.prenom = prenom;
		this.setNomUtilisateur(prenom+"."+nom);
		this.setMotDePasse(motDePasse);
		this.type = "etu";
	}

	public String toString(){
		return "ID: "+getCode()+" NOM: "+nom+" PRENOM: "+prenom+" MOT DE PASSE: "+getMotDePasse()+"\n";
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
}
