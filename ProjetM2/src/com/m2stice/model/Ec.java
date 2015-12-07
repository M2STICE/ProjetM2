package com.m2stice.model;

public class Ec {

	private int code;
	private String nom;
	private float coefficient;
	private int nombreEcts;
	private int volumeHeureCours;
	private int volumeHeureTP;
	private int volumeHeureTD;
	private int volumeHeureBE;
	private int volumeHeureTPerso;
	private String resume;
	private int codeUe;
	private int responsableEc;
	private int codeSemestre;
	

	public Ec() {
		// TODO Auto-generated constructor stub
	}
	
	public Ec(int code, String nom, float coefficient, int nombreEcts, int volumeHeureCours, int volumeHeureTP, int volumeHeureTD, int volumeHeureBE,int volumeHeureTPerso, String resume, int codeUe, int responsableEc, int codeSemestre) {
		// TODO Auto-generated constructor stub
		this.code = code;
		this.nom = nom;
		this.coefficient = coefficient;
		this.nombreEcts = nombreEcts;
		this.volumeHeureCours = volumeHeureCours;
		this.volumeHeureTP = volumeHeureTP;
		this.volumeHeureTD = volumeHeureTD;
		this.volumeHeureBE = volumeHeureBE;
		this.volumeHeureTPerso = volumeHeureTPerso;
		this.resume = resume;
		this.codeUe = codeUe;
		this.responsableEc = responsableEc;
		this.codeSemestre = codeSemestre;
	}
	
	public int getCode() {
		return code;
	}

	public String toString(){
		return "ID: "+code+" NOM: "+nom+"RESUME: "+resume+"COEFFICIENT: "+coefficient+"\n";
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

	public int getVolumeHeureCours() {
		return volumeHeureCours;
	}

	public void setVolumeHeureCours(int volumeHeureCours) {
		this.volumeHeureCours = volumeHeureCours;
	}

	public int getVolumeHeureTP() {
		return volumeHeureTP;
	}

	public void setVolumeHeureTP(int volumeHeureTP) {
		this.volumeHeureTP = volumeHeureTP;
	}

	public int getVolumeHeureTD() {
		return volumeHeureTD;
	}

	public void setVolumeHeureTD(int volumeHeureTD) {
		this.volumeHeureTD = volumeHeureTD;
	}

	public int getVolumeHeureBE() {
		return volumeHeureBE;
	}

	public void setVolumeHeureBE(int volumeHeureBE) {
		this.volumeHeureBE = volumeHeureBE;
	}

	public int getVolumeHeureTPerso() {
		return volumeHeureTPerso;
	}

	public void setVolumeHeureTPerso(int volumeHeureTPerso) {
		this.volumeHeureTPerso = volumeHeureTPerso;
	}

	public int getNombreEcts() {
		return nombreEcts;
	}

	public void setNombreEcts(int nombreEcts) {
		this.nombreEcts = nombreEcts;
	}

	public int getCodeUe() {
		return codeUe;
	}

	public void setCodeUe(int codeUe) {
		this.codeUe = codeUe;
	}

	public int getResponsableEc() {
		return responsableEc;
	}

	public void setResponsableEc(int responsableEc) {
		this.responsableEc = responsableEc;
	}

	public int getCodeSemestre() {
		return codeSemestre;
	}

	public void setCodeSemestre(int codeSemestre) {
		this.codeSemestre = codeSemestre;
	}

}
