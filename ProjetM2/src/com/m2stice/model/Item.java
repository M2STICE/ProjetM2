package com.m2stice.model;

import com.m2stice.controller.DatabaseAccess;

/**
*  Item - Classe représentant une sous-compétence
*
* @version 1.1
*
* @author ASDRUBAL, CISNEROS & NERES
* @copyright (C) Master 2 2015
* @date 01/12/2015
* @see DatabaseAccess
* @revision 04/12
* 
*/
public class Item {

	private int code;
	private String nom;
	private int codeCompetence;
	private int codeEvaluation;
	
	/**
	 * Constructeur de l'objet Item
	 * 
	 * @param code
	 * @param nom
	 * @param codeCompetence
	 * @param codeEvaluation
	 */
	public Item(int code, String nom, int codeCompetence, int codeEvaluation) {
		this.code = code;
		this.nom = nom;
		this.codeCompetence = codeCompetence;
		this.codeEvaluation = codeEvaluation;
	}
	
	public String toString(){
		return null;
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
	
	public int getCodeCompetence() {
		return codeCompetence;
	}

	public void setCodeCompetence(int codeCompetence) {
		this.codeCompetence = codeCompetence;
	}

	public int getCodeEvaluation() {
		return codeEvaluation;
	}

	public void setCodeEvaluation(int codeEvaluation) {
		this.codeEvaluation = codeEvaluation;
	}

}
