package com.m2stice.model;

/**
*  Evaluation - Classe repr�sentant une �valuation 
*
* @version 1.1
*
* @author ASDRUBAL, CISNEROS & NERES
* @copyright (C) Master 2 2015
* @date 01/12/2015
* @revision 04/12
* 
*/
public class Evaluation {

	private int code;
	private String nom;
	private float noteMaximale;
	private float coefficient;
	private String typeEpreuve;
	
	/**
	 * Constructeur de la classe Evaluation
	 * 
	 * @param code
	 * @param nom
	 * @param notemaximale
	 * @param coefficient
	 * @param typeEpreuve
	 * @param codeSousItem
	 */

	public Evaluation(int code, String nom, float notemaximale, float coefficient, String typeEpreuve) {
		this.code = code;
		this.nom = nom;
		this.noteMaximale = notemaximale;
		this.coefficient = coefficient;
		this.typeEpreuve = typeEpreuve;
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


}
