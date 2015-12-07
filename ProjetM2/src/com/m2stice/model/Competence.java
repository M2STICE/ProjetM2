package com.m2stice.model;

public class Competence {

	private int code;
	private String nom;
	
	public Competence() {
		// TODO Auto-generated constructor stub
	}
	
	public Competence(int code, String nom) {
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
