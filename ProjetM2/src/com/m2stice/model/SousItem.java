package com.m2stice.model;

import com.m2stice.controller.DatabaseAccess;

/**
*  SousItem - Classe représentant une sous compétence secondaire
*
* @version 1.1
*
* @author ASDRUBAL, CISNEROS & NERES
* @copyright (C) Master 2 2015
* @date 01/12/2015
* @revision 04/12
* 
*/
public class SousItem {

	private int code;
	private String nom;
	private int codeItem;
	
	/**
	 * Constructeur de l'objet SousItem
	 * 
	 * @param code
	 * @param nom
	 * @param codetItem
	 */
	public SousItem(int code, String nom, int codetItem) {
		this.code = code;
		this.nom = nom;
		this.codeItem = codetItem;
	}

	public String toString(){
		return "ID: "+code+" NOM: "+nom+" CODE_ITEM: "+ codeItem +"\n";
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

	public int getCodeItem() {
		return codeItem;
	}

	public void setCodeItem(int codeItem) {
		this.codeItem = codeItem;
	}

}
