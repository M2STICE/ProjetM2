package com.m2stice.remplisseurbd;

import java.util.LinkedList;
import java.util.Random;

import com.m2stice.controller.Controller;

public class Ec_intervenant {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String requete; 
		Controller monController = new Controller();
		
		for (int i = 1474; i < 1575; i++)
		{
			Random r = new Random();
			
			int qte = r.nextInt(7) + 1;
			LinkedList<Integer> liste = new LinkedList<Integer>();
			
			for (int j = 0; j < qte; j++)
			{
				Random r1 = new Random();
				
				int intervenant;
				
				do
				{
					intervenant = r1.nextInt(7) + 1;
				}	
				while (liste.indexOf(intervenant) != -1);	
				liste.add(intervenant);
			}
			
			for (int j = 0; j < qte; j++)
			{
				requete = "insert into intervenant_ec (code_ec, code_intervenant) value ("+ i + ", " + liste.get(j) +");";
				monController.modification(requete);
				//System.out.println(requete);
			}
		}
	}

}
