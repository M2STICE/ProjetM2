package com.m2stice.model;

/**
*  Promotion - Classe repr�sentant une promotion
*
* @version 1.1
*
* @author ASDRUBAL, CISNEROS, NERES
* @copyright (C) Master 2 2015
* @date 01/12/2015
* @revision 04/12
* 
*/
public class Promotion {
	
	private int code;
	private String nom;
	private int anneeDebutPromotion;
	private int anneeFinPromotion;
	private int codeAnnee;
	private int codeDiplome;
	
	/**
	 * Constructeur de l'objet Promotion
	 * 
	 * @param code
	 * @param nom
	 * @param anneeDebutPromotion
	 * @param anneeFinPromotion
	 * @param codeAnnee
	 * @param codeDiplome
	 */

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
