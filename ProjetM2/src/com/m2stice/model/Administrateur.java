package com.m2stice.model;

public class Administrateur extends Utilisateur {
	
	private int code;
	
	public Administrateur() {
		
	}
	
	public Administrateur(int code,String nom,String motDePasse) {
		this.code = code;
		this.setNomUtilisateur(nom);
		this.setMotDePasse(motDePasse);
		this.type = "admin";
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
}
