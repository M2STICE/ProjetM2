package com.m2stice.model;

public class Domaine {

	private int code;
	private String nom;
	
	public Domaine() {
		// TODO Auto-generated constructor stub
	}
	
	public Domaine(int code, String nom) {
		// TODO Auto-generated constructor stub
		this.code = code;
		this.nom = nom;
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

}
