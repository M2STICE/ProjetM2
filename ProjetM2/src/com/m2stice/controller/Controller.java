package com.m2stice.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
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
* @version 1.1
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
	
	/*
	 * 
	 */
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
	
	/**
	 * Cette fonction va récupérer les objets de type Annee dans la base de donnée
	 * @param getRequete
	 * @return liste d'objet du type de la donnée
	 */
	public LinkedList <Annee> getAnnee(String getRequete){
		DatabaseAccess con;
		con = getConnection();
		annee = new AnneeController(con);
		return annee.getSelect(getRequete);
	}
	
	/**
	 * Cette fonction va récupérer les objets de type Competence dans la base de donnée
	 * @param getRequete
	 * @return liste d'objet du type de la donnée
	 */
	public LinkedList <Competence> getCompetence(String getRequete){
		DatabaseAccess con;
		con = getConnection();
		competence = new CompetenceController(con);
		return competence.getSelect(getRequete);
	}
	
	/**
	 * Cette fonction va récupérer les objets de type Domaine dans la base de donnée
	 * @param getRequete
	 * @return liste d'objet du type de la donnée
	 */
	public LinkedList <Domaine> getDomaine(String getRequete){
		DatabaseAccess con;
		con = getConnection();
		domaine = new DomaineController(con);
		return domaine.getSelect(getRequete);
	}
	
	/**
	 * Cette fonction va récupérer les objets de type Item dans la base de donnée
	 * @param getRequete
	 * @return liste d'objet du type de la donnée
	 */
	public LinkedList <SousItem> getSousItem(String getRequete){
		DatabaseAccess con;
		con = getConnection();
		sousItem = new SousItemController(con);
		return sousItem.getSelect(getRequete);
	}
	
	/**
	 * Cette fonction va récupérer les objets de type Etudiant dans la base de donnée
	 * @param getRequete
	 * @return liste d'objet du type de la donnée
	 */
	public LinkedList <Etudiant> getEtudiant(String getRequete){
		DatabaseAccess con;
		con = getConnection();
		etudiant = new EtudiantController(con);
		return etudiant.getSelect(getRequete);
	}
	
	/**
	 * Cette fonction va récupérer les objets de type Evaluation dans la base de donnée
	 * @param getRequete
	 * @return liste d'objet du type de la donnée
	 */
	public LinkedList <Evaluation> getEvaluation(String getRequete){
		DatabaseAccess con;
		con = getConnection();
		evaluation = new EvaluationController(con);
		return evaluation.getSelect(getRequete);
	}
	
	/**
	 * Cette fonction va récupérer les objets de type EvaluationEtudiant dans la base de donnée
	 * @param getRequete
	 * @return liste d'objet du type de la donnée
	 */
	//Sera px etre supprimé
	public LinkedList <EvaluationEtudiant> getEvaluationEtudiant(String getRequete){
		DatabaseAccess con;
		con = getConnection();
		evaluationEtudiant = new EvaluationEtudiantController(con);
		return evaluationEtudiant.getSelect(getRequete);
	}
	
	/**
	 * Cette fonction va récupérer les objets de type Interrvenant dans la base de donnée
	 * @param getRequete
	 * @return liste d'objet du type de la donnée
	 */
	public LinkedList <Intervenant> getIntervenant(String getRequete){
		DatabaseAccess con;
		con = getConnection();
		intervenant = new IntervenantController(con);
		return intervenant.getSelect(getRequete);
	}
	
	/**
	 * Cette fonction va récupérer les objets de type Item dans la base de donnée
	 * @param getRequete
	 * @return liste d'objet du type de la donnée
	 */
	public LinkedList <Item> getItem(String getRequete){
		DatabaseAccess con;
		con = getConnection();
		item = new ItemController(con);
		return item.getSelect(getRequete);
	}
	
	/**
	 * Cette fonction va récupérer les objets de type Semestre dans la base de donnée
	 * @param getRequete
	 * @return liste d'objet du type de la donnée
	 */
	public LinkedList <Semestre> getSemestre(String getRequete){
		DatabaseAccess con;
		con = getConnection();
		semestre = new SemestreController(con);
		return semestre.getSelect(getRequete);
	}
	
	/**
	 * Cette fonction va récupérer les objets de type Ue dans la base de donnée
	 * @param getRequete
	 * @return liste d'objet du type de la donnée
	 */
	public LinkedList <Ue> getUe(String getRequete){
		DatabaseAccess con;
		con = getConnection();
		ue = new UeController(con);
		return ue.getSelect(getRequete);
	}
	
	/**
	 * Cette fonction va récupérer les objets de type Diplome dans la base de donnée
	 * @param getRequete
	 * @return liste d'objet du type de la donnée
	 */
	public LinkedList <Diplome> getDiplome(String getRequete){
		DatabaseAccess con;
		con = getConnection();
		diplome = new DiplomeController(con);
		return diplome.getSelect(getRequete);
	}
	
	/**
	 * Cette fonction va récupérer les objets de type Ec dans la base de donnée
	 * @param getRequete
	 * @return liste d'objet du type de la donnée
	 */
	public LinkedList <Ec> getEc(String getRequete){
		DatabaseAccess con;
		con = getConnection();
		ec = new EcController(con);
		return ec.getSelect(getRequete);
	}
	
	/**
	 * Cette fonction va récupérer les objets de type Promotion dans la base de donnée
	 * @param getRequete
	 * @return liste d'objet du type de la donnée
	 */
	public LinkedList <Promotion> getPromotion(String getRequete){
		DatabaseAccess con;
		con = getConnection();
		promotion = new PromotionController(con);
		return promotion.getSelect(getRequete);
	}
	
	//Get Sql functions
	/**
	 * Cette fonction permet de compter les éléments
	 * @param getRequete
	 * @param champAs
	 * @return liste d'objet du type de la donnée
	 */
	public LinkedList<Double> getSqlFunctions(String getRequete, String champAs){
		DatabaseAccess con;
		con = getConnection();
		String requete = null;
		requete = getRequete;
		ResultSet resultat;
		LinkedList<Double> list = new LinkedList<Double>(); 
		resultat = con.getRequest(requete);
		if (resultat != null) {
			try {
				while(resultat.next()){
					list.add( (double) resultat.getInt(champAs));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		else{
			System.out.println("vide");
		}

		return list;
	}
	//insert
	
	//update
	
	public void updateEtudiant(String getRequete) {
		DatabaseAccess con;
		con = getConnection();
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
		
		String Requete = "select *, count(nom_diplome) as onNom from diplome ";
//		control.updateEtudiant(Requete);
		LinkedList<Double> l = control.getSqlFunctions(Requete, "onNom");
		
		
		Iterator<Double> it= l.iterator(); 
		
		while(it.hasNext()){
			System.out.println(it.next());
		}
		
		System.out.println("Nou fini");
		
	}


}
