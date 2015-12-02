package com.m2stice.model;

public class Ue {

	private int code;
	private String nom;
	private String resume;
	private float coefficient;
	private int nombreEcts;
	
	public Ue() {
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
	public String getResume() {
		return resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}

	public float getCoefficient() {
		return coefficient;
	}

	public void setCoefficient(float coefficient) {
		this.coefficient = coefficient;
	}

	public int getNombreEcts() {
		return nombreEcts;
	}

	public void setNombreEcts(int nombreEcts) {
		this.nombreEcts = nombreEcts;
	}

}
