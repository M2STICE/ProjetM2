package com.m2stice.model;

public class Utilisateur {
	
	private String nomUtilisateur;
	private String motDePasse;
	public String type;
	
	/**
	 * @return the nomUtilisateur
	 */
	public String getNomUtilisateur() {
		return nomUtilisateur;
	}
	/**
	 * @param nomUtilisateur the nomUtilisateur to set
	 */
	public void setNomUtilisateur(String nomUtilisateur) {
		this.nomUtilisateur = nomUtilisateur;
	}
	/**
	 * @return the motDePasse
	 */
	public String getMotDePasse() {
		return motDePasse;
	}
	/**
	 * @param motDePasse the motDePasse to set
	 */
	protected void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}
	
	
}
