package com.m2stice.model;

public class Intervenant {
	
	private int code;
	private String nom;
	private String motDePasse;
	
	public Intervenant() {
		// TODO Auto-generated constructor stub
	}

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
