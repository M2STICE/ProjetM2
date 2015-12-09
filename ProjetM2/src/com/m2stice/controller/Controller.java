package com.m2stice.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.LinkedList;

import com.m2stice.adapter.AnneeAdapter;
import com.m2stice.adapter.CompetenceAdapter;
import com.m2stice.adapter.DiplomeAdapter;
import com.m2stice.adapter.DomaineAdapter;
import com.m2stice.adapter.EcAdapter;
import com.m2stice.adapter.EtudiantAdapter;
import com.m2stice.adapter.EvaluationAdapter;
import com.m2stice.adapter.EvaluationEtudiantAdapter;
import com.m2stice.adapter.IntervenantAdapter;
import com.m2stice.adapter.ItemAdapter;
import com.m2stice.adapter.PromotionAdapter;
import com.m2stice.adapter.SemestreAdapter;
import com.m2stice.adapter.SousItemAdapter;
import com.m2stice.adapter.UeAdapter;
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
* Description: Classe Controller
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
	
	private AnneeAdapter annee;
	private CompetenceAdapter competence ;
	private DiplomeAdapter diplome;
	private DomaineAdapter domaine ;
	private EcAdapter ec ;
	private EtudiantAdapter etudiant ;
	private EvaluationAdapter evaluation ;
	private EvaluationEtudiantAdapter evaluationEtudiant ;
	private IntervenantAdapter intervenant ;
	private ItemAdapter item ;
	private SemestreAdapter semestre  ;
	private SousItemAdapter sousItem ;
	private UeAdapter ue ;
	private PromotionAdapter promotion ;
	
	/**
	 * Classe qui permet d'interfacer la base de données
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
		annee = new AnneeAdapter(con);
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
		competence = new CompetenceAdapter(con);
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
		domaine = new DomaineAdapter(con);
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
		sousItem = new SousItemAdapter(con);
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
		etudiant = new EtudiantAdapter(con);
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
		evaluation = new EvaluationAdapter(con);
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
		evaluationEtudiant = new EvaluationEtudiantAdapter(con);
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
		intervenant = new IntervenantAdapter(con);
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
		item = new ItemAdapter(con);
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
		semestre = new SemestreAdapter(con);
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
		ue = new UeAdapter(con);
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
		diplome = new DiplomeAdapter(con);
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
		ec = new EcAdapter(con);
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
		promotion = new PromotionAdapter(con);
		return promotion.getSelect(getRequete);
	}
	
	//Get Sql functions
	/**
	 * Cette fonction permet de compter les éléments
	 * @param getRequete
	 * @param champs
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
			System.out.println("[Log-CONTROLLER]: Resultat vide.");
		}

		return list;
	}
	
	//update, insert, delete .....
	/**
	 * Fonction permettatnt de faire toute requête de modification (insert, update, delete ....)
	 * @param getRequete
	 */
	public void modification(String getRequete) {
		boolean done = false;
		DatabaseAccess con;
		con = getConnection();
		String requete = null;
		requete = getRequete;
		done = con.modification(requete);
		if(done){
			System.out.println("[Log-CONTROLLER]: Les modifications ont ete effectuees.");
		}
		else{
			System.err.println("[Log-CONTROLLER]: Les modifications n'ont pas ete effectuees.");
		}
	}
	
	/*
	 *  Zo pa Conserné 
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
