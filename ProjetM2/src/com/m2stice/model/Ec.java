package com.m2stice.model;

public class Ec {

	private int code;
	private String nom;
	private String resume;
	private float coefficient;
	
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

	private int volumeHeureCours;
	private int volumeHeureTP;
	private int volumeHeureTD;
	private int volumeHeureBE;
	private int volumeHeureTPerso;
	
	public Ec() {
		// TODO Auto-generated constructor stub
	}

}
