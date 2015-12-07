package com.m2stice.controller;

import java.util.Iterator;
import java.util.LinkedList;

import com.m2stice.model.Annee;
import com.m2stice.model.Competence;
import com.m2stice.model.Diplome;
import com.m2stice.model.Domaine;
import com.m2stice.model.Ec;
import com.m2stice.model.Etudiant;
import com.m2stice.model.Evaluation;
import com.m2stice.model.EvaluationEtudiant;
import com.m2stice.model.Intervenant;
import com.m2stice.model.Item;
import com.m2stice.model.Promotion;
import com.m2stice.model.Semestre;
import com.m2stice.model.SousItem;
import com.m2stice.model.Ue;

/*
* Nom de classe : Controller
*
* Description: Classe controller
*
* Version : 1.0
*
* Date : 02/12/2015
*
* Copyright : (C) Master 2 2015
*/

/**
*  Controller - Classe de controle pour réaliser les actions sur la base de donnée
*
* @version 1.0
*
* @author ASDRUBAL & NERES
* @copyright (C) Master 2 2015
* @date 02/12/2015
* @see DatabaseAccess
* @revision 04/12
* 
*/
public class Controller {

	private DatabaseAccess connection = null;
	
	private String username;
	private String pass;
	private String server;
	private String databaseName;
	
	private AnneeController annee;
	private CompetenceController competence ;
	private DiplomeController diplome;
	private DomaineController domaine ;
	private EcController ec ;
	private EtudiantController etudiant ;
	private EvaluationController evaluation ;
	private EvaluationEtudiantController evaluationEtudiant ;
	private IntervenantController intervenant ;
	private ItemController item ;
	private SemestreController semestre  ;
	private SousItemController sousItem ;
	private UeController ue ;
	private PromotionController promotion ;
	
	public Controller() {
		databaseName = "u960093295_stice";
		username = "u960093295_m2";
		pass = "pm2_2015";
		server = "sql37.hostinger.fr";
//		databaseName = "m2stice";
//		username = "root";
//		pass = "";
//		server = "localhost";
		setConnection(new DatabaseAccess(username, pass, server, databaseName));
	}
	
	//Select 
	public LinkedList <Annee> getAnnee(String getRequete){
		DatabaseAccess con;
		con = getConnection();
		annee = new AnneeController(con);
		return annee.getSelect(getRequete);
	}
	
	public LinkedList <Competence> getCompetence(String getRequete){
		DatabaseAccess con;
		con =  getConnection();
		competence = new CompetenceController(con);
		return competence.getSelect(getRequete);
	}
	
	public LinkedList <Domaine> getDomaine(String getRequete){
		DatabaseAccess con;
		con =  getConnection();
		domaine = new DomaineController(con);
		return domaine.getSelect(getRequete);
	}
	
	public LinkedList <SousItem> getSousItem(String getRequete){
		DatabaseAccess con;
		con =  getConnection();
		sousItem = new SousItemController(con);
		return sousItem.getSelect(getRequete);
	}
	
	public LinkedList <Etudiant> getEtudiant(String getRequete){
		DatabaseAccess con;
		con =  getConnection();
		etudiant = new EtudiantController(con);
		return etudiant.getSelect(getRequete);
	}
	
	public LinkedList <Evaluation> getEvaluation(String getRequete){
		DatabaseAccess con;
		con =  getConnection();
		evaluation = new EvaluationController(con);
		return evaluation.getSelect(getRequete);
	}
	
	public LinkedList <EvaluationEtudiant> getEvaluationEtudiant(String getRequete){
		DatabaseAccess con;
		con =  getConnection();
		evaluationEtudiant = new EvaluationEtudiantController(con);
		return evaluationEtudiant.getSelect(getRequete);
	}
	
	public LinkedList <Intervenant> getIntervenant(String getRequete){
		DatabaseAccess con;
		con =  getConnection();
		intervenant = new IntervenantController(con);
		return intervenant.getSelect(getRequete);
	}
	
	public LinkedList <Item> getItem(String getRequete){
		DatabaseAccess con;
		con =  getConnection();
		item = new ItemController(con);
		return item.getSelect(getRequete);
	}
	
	public LinkedList <Semestre> getSemestre(String getRequete){
		DatabaseAccess con;
		con =  getConnection();
		semestre = new SemestreController(con);
		return semestre.getSelect(getRequete);
	}
	
	public LinkedList <Ue> getUe(String getRequete){
		DatabaseAccess con;
		con =  getConnection();
		ue = new UeController(con);
		return ue.getSelect(getRequete);
	}
	
	public LinkedList <Diplome> getDiplome(String getRequete){
		DatabaseAccess con;
		con =  getConnection();
		diplome = new DiplomeController(con);
		return diplome.getSelect(getRequete);
	}
	
	public LinkedList <Ec> getEc(String getRequete){
		DatabaseAccess con;
		con =  getConnection();
		ec = new EcController(con);
		return ec.getSelect(getRequete);
	}
	
	public LinkedList <Promotion> getPromotion(String getRequete){
		DatabaseAccess con;
		con =  getConnection();
		promotion = new PromotionController(con);
		return promotion.getSelect(getRequete);
	}
	
	//insert
	
	//update
	
	public void updateEtudiant(String getRequete) {
		DatabaseAccess con;
		con =  getConnection();
		etudiant = new EtudiantController(con);
		etudiant.doUpdate(getRequete);
	}
	
	/*
	 *  Zô pa Conserné 
	 *    
	 *  java et reflexcivité - Instanciation dynamique
	 * 
	 */
	
	public DatabaseAccess getConnection() {
		return connection;
	}

	public void setConnection(DatabaseAccess connection) {
		this.connection = connection;
	}
	
	public static void main(String[] args) {
		Controller control = new Controller();
		
		String Requete = "select * from etudiant";
//		control.updateEtudiant(Requete);
		LinkedList<Etudiant> l = control.getEtudiant(Requete);
		
		
		Iterator<Etudiant> it= l.iterator(); 
		
		while(it.hasNext()){
			System.out.println(it.next());
		}
		
		System.out.println("Nou fini");
		
	}


}
