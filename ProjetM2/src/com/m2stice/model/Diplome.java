package com.m2stice.model;

public class Diplome {

	private int code;
	private String nom;
	private String description;
	
	public Diplome() {
		// TODO Auto-generated constructor stub
	}

	public Diplome(int code, String nom, String description) {
		// TODO Auto-generated constructor stub
		this.code=code;
		this.nom=nom;
		this.description=description;
	}
	
	public String toString(){
		return "ID: "+code+" NOM: "+nom+" DESCRIPTION: "+description+"\n";
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
