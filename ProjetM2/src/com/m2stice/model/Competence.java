package com.m2stice.model;

public class Competence {

	private int code;
	private String nom;
	private int codeDomaine;
	
	public Competence() {
		// TODO Auto-generated constructor stub
	}
	
	public Competence(int code, String nom, int codeDomaine) {
		this.code = code;
		this.nom = nom;
		this.setCodeDomaine(codeDomaine);
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

	public int getCodeDomaine() {
		return codeDomaine;
	}

	public void setCodeDomaine(int codeDomaine) {
		this.codeDomaine = codeDomaine;
	}

}
