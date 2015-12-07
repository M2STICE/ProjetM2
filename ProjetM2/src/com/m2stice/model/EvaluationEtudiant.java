package com.m2stice.model;

import java.sql.Date;

public class EvaluationEtudiant {

	private int codeEvaluation;
	private int codeEtudiant;
	private Date dateEvaluation;
	private float noteEvaluation;
	
	public EvaluationEtudiant() {
		// TODO Auto-generated constructor stub
	}


	public EvaluationEtudiant(int codeEvaluation, int codeEtudiant, Date dateEvaluation, float noteEvaluation) {
		this.codeEvaluation = codeEvaluation;
		this.codeEtudiant = codeEtudiant;
		this.dateEvaluation = dateEvaluation;
		this.noteEvaluation = noteEvaluation;
	}


	public String toString(){
		return "CODE EVALUATION: "+codeEvaluation+" CODE ETUDIANT: "+codeEtudiant+"\n";
	}
	
	public int getCodeEvaluation() {
		return codeEvaluation;
	}

	public void setCodeEvaluation(int codeEvaluation) {
		this.codeEvaluation = codeEvaluation;
	}

	public int getCodeEtudiant() {
		return codeEtudiant;
	}

	public void setCodeEtudiant(int codeEtudiant) {
		this.codeEtudiant = codeEtudiant;
	}

	public Date getDateEvaluation() {
		return dateEvaluation;
	}

	public void setDateEvaluation(Date dateEvaluation) {
		this.dateEvaluation = dateEvaluation;
	}

	public float getNoteEvaluation() {
		return noteEvaluation;
	}

	public void setNoteEvaluation(float noteEvaluation) {
		this.noteEvaluation = noteEvaluation;
	}
	
}
