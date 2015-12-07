package com.m2stice.model;

public class Ue {

	private int code;
	private String nom;
	private String resume;
	private float coefficient;
	private int nombreEcts;
	private int codeSemestre;
	private int codeIntervenant;
	private int codeDiplome;
	
	public Ue() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Ue(int code, String nom, int nombreEcts, String resume, float coefficient, int codeSemestre, int codeIntervenant, int codeDiplome) {
		this.code = code;
		this.nom = nom;
		this.nombreEcts = nombreEcts;
		this.resume = resume;
		this.coefficient = coefficient;
		this.codeSemestre = codeSemestre;
		this.codeIntervenant = codeIntervenant;
		this.setCodeDiplome(codeDiplome);
	}


	public String toString(){
		return "ID: "+code+" NOM: "+nom+"RESUME: "+resume+"COEFFICIENT: "+coefficient+"NOMBRE ECTS: "+nombreEcts+"\n";
	}


	public int getCodeSemestre() {
		return codeSemestre;
	}


	public void setCodeSemestre(int codeSemestre) {
		this.codeSemestre = codeSemestre;
	}


	public int getCodeIntervenant() {
		return codeIntervenant;
	}


	public void setCodeIntervenant(int codeIntervenant) {
		this.codeIntervenant = codeIntervenant;
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


	public int getCodeDiplome() {
		return codeDiplome;
	}


	public void setCodeDiplome(int codeDiplome) {
		this.codeDiplome = codeDiplome;
	}

}
