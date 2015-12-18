package com.m2stice.remplisseurbd;

import java.util.LinkedList;
import java.util.Random;

import com.m2stice.controller.Controller;
import com.m2stice.model.Evaluation;

public class Etudiant_evaluation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		/*
		 * Les evaluations d'une annee
		SELECT evaluation.code_evaluation
		FROM evaluation
		INNER JOIN sous_item_evaluation 
		ON evaluation.code_evaluation = sous_item_evaluation.code_evaluation
		INNER JOIN sous_item 
		ON sous_item.code_sous_item = sous_item_evaluation.code_sous_item
		INNER JOIN ec_sous_item 
		ON ec_sous_item.code_sous_item = sous_item.code_sous_item
		inner join ec
		on ec.code_ec = ec_sous_item.code_ec
		where ec.code_ec in
		(SELECT code_ec FROM ec WHERE code_ue IN (SELECT code_ue FROM ue where code_semestre = 1 or code_semestre = 2))*/
		
		String requete;
		Controller monController = new Controller();
		
		LinkedList<Evaluation> Eval = new LinkedList<Evaluation>();
		requete = "SELECT * FROM evaluation "
				+ "INNER JOIN sous_item_evaluation "
				+ "ON evaluation.code_evaluation = sous_item_evaluation.code_evaluation "
				+ "INNER JOIN sous_item "
				+ "ON sous_item.code_sous_item = sous_item_evaluation.code_sous_item "
				+ "INNER JOIN ec_sous_item "
				+ "ON ec_sous_item.code_sous_item = sous_item.code_sous_item "
				+ "inner join ec on ec.code_ec = ec_sous_item.code_ec "
				+ "where ec.code_ec in "
				+ "(SELECT code_ec FROM ec "
				+ "WHERE code_ue IN "
				+ "(SELECT code_ue FROM ue where code_semestre = 1 or code_semestre = 2))";
		
		Eval = monController.getEvaluation(requete);
		
		//System.out.println(Eval.size());
		
		for (int i = 0; i < Eval.size(); i++)
		{
			Random r = new Random();
			
			for (int j = 1; j < 5; j++)
			{
				int note = r.nextInt(20) + 1;
				
				requete = "insert into etudiant_evaluation (code_etudiant, code_evaluation, note_evaluation) "
						+ "values (" + j + ", " + Eval.get(i).getCode() + ", " + note + ");";
				//System.out.println(requete);
				monController.modification(requete);
			}
		}
	}

}
