package com.m2stice.model;

public class Evaluation {

	private int code;
	private String nom;
	private int noteMaximale;
	private float coefficient;
	private String typeEpreuve;
	
	public Evaluation() {
		// TODO Auto-generated constructor stub
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

	public int getNoteMaximale() {
		return noteMaximale;
	}

	public void setNoteMaximale(int noteMaximale) {
		this.noteMaximale = noteMaximale;
	}

	public float getCoefficient() {
		return coefficient;
	}

	public void setCoefficient(float coefficient) {
		this.coefficient = coefficient;
	}

	public String getTypeEpreuve() {
		return typeEpreuve;
	}

	public void setTypeEpreuve(String typeEpreuve) {
		this.typeEpreuve = typeEpreuve;
	}

}
