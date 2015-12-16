package com.m2stice.model;

/**
*  Ec - Classe repr�sentant un �lement constitutif d'une unit� d'enseignement
*
* @version 1.1
*
* @author ASDRUBAL, CISNEROS & NERES
* @copyright (C) Master 2 2015
* @date 01/12/2015
* @revision 04/12
* 
*/
public class Ec {

	private int code;
	private String nom;
	private float coefficient;
	private int nombreEcts;
	private float volumeHeureCours;
	private float volumeHeureTP;
	private float volumeHeureTD;
	private float volumeHeureBE;
	private float volumeHeureTPerso;
	private String resume;
	private int codeUe;
	private int responsableEc;
	private int codeSemestre;
	

	/**
	 * Constructeur de l'objet Ec
	 * 
	 * @param code
	 * @param nom
	 * @param coefficient
	 * @param nombreEcts
	 * @param volumeHeureCours
	 * @param volumeHeureTP
	 * @param volumeHeureTD
	 * @param volumeHeureBE
	 * @param volumeHeureTPerso
	 * @param resume
	 * @param codeUe
	 * @param responsableEc
	 * @param codeSemestre
	 */
	public Ec(int code, String nom, float coefficient, int nombreEcts, float volumeHeureCours, float volumeHeureTP, float volumeHeureTD, float volumeHeureBE, float volumeHeureTPerso, String resume, int codeUe, int responsableEc, int codeSemestre) {
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

	public float getVolumeHeureCours() {
		return volumeHeureCours;
	}

	public void setVolumeHeureCours(float volumeHeureCours) {
		this.volumeHeureCours = volumeHeureCours;
	}

	public float getVolumeHeureTP() {
		return volumeHeureTP;
	}

	public void setVolumeHeureTP(float volumeHeureTP) {
		this.volumeHeureTP = volumeHeureTP;
	}

	public float getVolumeHeureTD() {
		return volumeHeureTD;
	}

	public void setVolumeHeureTD(float volumeHeureTD) {
		this.volumeHeureTD = volumeHeureTD;
	}

	public float getVolumeHeureBE() {
		return volumeHeureBE;
	}

	public void setVolumeHeureBE(float volumeHeureBE) {
		this.volumeHeureBE = volumeHeureBE;
	}

	public float getVolumeHeureTPerso() {
		return volumeHeureTPerso;
	}

	public void setVolumeHeureTPerso(float volumeHeureTPerso) {
		this.volumeHeureTPerso = volumeHeureTPerso;
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
