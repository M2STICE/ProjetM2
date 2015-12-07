package com.m2stice.model;

public class Promotion {
	
	private int code;
	private String nom;
	private int anneeDebutPromotion;
	private int anneeFinPromotion;
	private int codeAnnee;
	private int codeDiplome;
	
	public Promotion() {
		// TODO Auto-generated constructor stub
	}

	public Promotion(int code, String nom, int anneeDebutPromotion, int anneeFinPromotion, int codeAnnee, int codeDiplome) {
		this.code = code;
		this.nom = nom;
		this.anneeDebutPromotion = anneeDebutPromotion;
		this.anneeFinPromotion = anneeFinPromotion;
		this.codeAnnee = codeAnnee;
		this.codeDiplome = codeDiplome;
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

	public int getAnneeDebutPromotion() {
		return anneeDebutPromotion;
	}

	public void setAnneeDebutPromotion(int anneeDebutPromotion) {
		this.anneeDebutPromotion = anneeDebutPromotion;
	}

	public int getAnneeFinPromotion() {
		return anneeFinPromotion;
	}

	public void setAnneeFinPromotion(int anneeFinPromotion) {
		this.anneeFinPromotion = anneeFinPromotion;
	}

	public int getCodeAnnee() {
		return codeAnnee;
	}

	public void setCodeAnnee(int codeAnnee) {
		this.codeAnnee = codeAnnee;
	}

	public int getCodeDiplome() {
		return codeDiplome;
	}

	public void setCodeDiplome(int codeDiplome) {
		this.codeDiplome = codeDiplome;
	}



}
