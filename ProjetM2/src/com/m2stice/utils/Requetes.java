package com.m2stice.utils;

/**
*  Requetes - ENUM
*
* @version 1.1
*
* @author ASDRUBAL & NERES
* @copyright (C) Master 2 2015
* @date 11/12/2015
* 
*/

public enum Requetes {
	
	FORMATION("SELECT * from diplome"),
	   ANNEE("select * "
				+ "from annee,diplome,diplome_annee "
				+ "where annee.code_annee = diplome_annee.code_annee "
				+ "and diplome.code_diplome = diplome_annee.code_diplome "
				+ "and diplome.code_diplome = %d"),
	   
	   SEMESTRE("select * "
				+ "from semestre "
				+ "where semestre.code_annee = %d"),
	   
	   UE("SELECT * FROM diplome, annee, semestre, ue "
	   		+ "WHERE diplome.code_diplome = ue.code_diplome "
	   		+ "AND semestre.code_semestre = ue.code_semestre "
	   		+ "AND annee.code_annee = %d "
	   		+ "AND semestre.code_semestre = %d "
	   		+ "AND diplome.code_diplome = %d "),
	   
	   EC("select * from ec where ec.code_ue = %d");
	   
	   String req="";
	   
	   Requetes(String req){
		   this.req=req;
	   }
	   
	   public String toString(){
		   
		   return this.req;
	   }
	   
	   public String toString(int code){
		   
		   return String.format(this.req, code);
	   }
	   
	   public String toString(int codeAnnee, int codeSemestre, int codeDiplome){
		   
		   return String.format(this.req, codeAnnee, codeSemestre, codeDiplome);
	   }
	   
}
