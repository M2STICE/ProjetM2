package com.m2stice.model;

public class Semestre {

	private int code;
	private String nom;
	private int codeAnnee;
	
	public Semestre() {
		// TODO Auto-generated constructor stub
	}

	public Semestre(int code, String nom, int codeAnnee) {
		this.code = code;
		this.nom = nom;
		this.codeAnnee = codeAnnee;
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

	public int getCodeAnnee() {
		return codeAnnee;
	}

	public void setCodeAnnee(int codeAnnee) {
		this.codeAnnee = codeAnnee;
	}

}
