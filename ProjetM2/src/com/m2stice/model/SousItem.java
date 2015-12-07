package com.m2stice.model;

public class SousItem {

	private int code;
	private String nom;
	private int codeItem;
	
	public SousItem() {
		// TODO Auto-generated constructor stub
	}

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
