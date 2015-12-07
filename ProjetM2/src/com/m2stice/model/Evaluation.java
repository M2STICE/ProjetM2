package com.m2stice.model;

public class Evaluation {

	private int code;
	private String nom;
	private float noteMaximale;
	private float coefficient;
	private String typeEpreuve;
	private int codeSousItem;
	
	public Evaluation() {
		// TODO Auto-generated constructor stub
	}

	public Evaluation(int code, String nom, float notemaximale, float coefficient, String typeEpreuve, int codeSousItem) {
		this.code = code;
		this.nom = nom;
		this.noteMaximale = notemaximale;
		this.coefficient = coefficient;
		this.typeEpreuve = typeEpreuve;
		this.codeSousItem = codeSousItem;
	}

	public String toString(){
		return "ID: "+code+" NOM: "+nom+" NOTE MAXIMALE: "+noteMaximale+" COEFFECIENT: "+coefficient+"\n";
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

	public float getNoteMaximale() {
		return noteMaximale;
	}

	public void setNoteMaximale(float noteMaximale) {
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

	public int getCodeSousItem() {
		return codeSousItem;
	}

	public void setCodeSousItem(int codeSousItem) {
		this.codeSousItem = codeSousItem;
	}

}
