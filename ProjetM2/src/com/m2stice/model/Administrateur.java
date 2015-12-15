package com.m2stice.model;

public class Administrateur {
	
	private int code;
	private String nom;
	private String motDePasse;
	
	public Administrateur() {
		
	}
	
	public Administrateur(int code,String nom,String motDePasse) {
		this.code = code;
		this.nom = nom;
		this.motDePasse = motDePasse;
	}
	
	/**
	 * @return the code
	 */
	public int getCode() {
		return code;
	}
	/**
	 * @param code the code to set
	 */
	public void setCode(int code) {
		this.code = code;
	}
	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}
	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
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
	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

}
