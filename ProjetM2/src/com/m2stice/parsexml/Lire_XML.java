package com.m2stice.parsexml;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.jdom2.Document;         // |
import org.jdom2.Element;          // |\ Libreries
import org.jdom2.JDOMException;    // |/ JDOM
import org.jdom2.input.SAXBuilder; // |

import com.m2stice.controller.Controller;
import com.m2stice.model.Annee;
import com.m2stice.model.Competence;
import com.m2stice.model.Diplome;
import com.m2stice.model.Domaine;
import com.m2stice.model.Ec;
import com.m2stice.model.Evaluation;
import com.m2stice.model.Item;
import com.m2stice.model.Semestre;
import com.m2stice.model.SousItem;
import com.m2stice.model.Ue;

/*
* Nom de classe : Lire_XML
*
* Description: Lit un fichier xml et met l'information dans la base de données
*
* Version : 1.0
*
* Date : 09/12/2015
*
* Copyright : (C) Master 2 2015
*/

/**
*  Lire_XML - Lit un fichier xml et met l'information dans la base de données
*
* @version 1.1
*
* @author CISNEROS BRIDON & HENRY
* @copyright (C) Master 2 2015
* @date 09/12/2015
* @revision 09/12
* 
*/

public class Lire_XML {
		
	public static void Xml_vers_DB()
	{		
	    // Créer un SAXBuilder pour pouvoir parser le fichier
	    SAXBuilder builder = new SAXBuilder();
	    File xmlFile = new File("competences_1.xml");
	    try
	    {
	    	Controller monController = new Controller();
	    	String requete = new String();
	    	
	        // Créer un document par le biais du fichier
	        Document document = (Document) builder.build( xmlFile );
	 
	        // On obtient la racine
	        Element rootNodes = document.getRootElement();
	        List<Element> listNodesRacine = rootNodes.getChildren("node");
	        Element tableRacine = (Element) listNodesRacine.get(0);
	        String nomDiplome = tableRacine.getAttributeValue("TEXT");
            //System.out.println( "Diplome: " + nomDiplome);
            
            String diplomeComplet = null;
            LinkedList<Diplome> codeDiplome = new LinkedList<Diplome>();
 
            // RACINE
            List<Element> niveauPosition = tableRacine.getChildren("node");
            Element cote_competences = (Element) niveauPosition.get(0);
            //System.out.println( "Coté: " + cote_competences.getAttributeValue("TEXT"));
            Element cote_syllabus = (Element) niveauPosition.get(1);
            //System.out.println( "Coté: " + cote_syllabus.getAttributeValue("TEXT"));
            
			requete = "delete from sous item_evaluation;";
			monController.modification(requete);
			requete = "delete from ec_sous_item;";
			monController.modification(requete);
			requete = "delete from sous_item;";
			monController.modification(requete);
			requete = "delete from sous_item;";
			monController.modification(requete);
			requete = "delete from ec_item;";
			monController.modification(requete);
			requete = "delete from item;";
			monController.modification(requete);
			requete = "delete from intervenant_ec;";
			monController.modification(requete);
			requete = "delete from ec;";
			monController.modification(requete);
			requete = "delete from ue;";
			monController.modification(requete);
			requete = "delete from etudiant_evaluation;";
			monController.modification(requete);
			requete = "delete from evaluation;";
			monController.modification(requete);
			requete = "delete from etudiant_promotion;";
			monController.modification(requete);
			requete = "delete from etudiant_diplome;";
			monController.modification(requete);
			requete = "delete from promotion;";
			monController.modification(requete);
			requete = "delete from diplome_annee;";
			monController.modification(requete);
			requete = "delete from competence;";
			monController.modification(requete);
			requete = "delete from domaine;";
			monController.modification(requete);
			requete = "delete from diplome;";
			monController.modification(requete);
        
            
            // COTE SYLLABUS
            System.out.println("\nCOTE SYLLABUS");
            List<Element> liste01NiveauAIgnorerPourBD = cote_syllabus.getChildren("node");
            
            // NIVEAU A IGNORER POUR LA BD (Fait partie du nom du diplome)
            for (int u = 0; u < liste01NiveauAIgnorerPourBD.size(); u++)
            {
            	Element niveau01AIgnorerPourBD = (Element) liste01NiveauAIgnorerPourBD.get(u);
            	
            	List<Element> listeAnnees = niveau01AIgnorerPourBD.getChildren("node");
            	//System.out.println("(" + (u+1) + ") NIVEAU A IGNORER: " + niveau01AIgnorerPourBD.getAttributeValue("TEXT"));
            	
            	diplomeComplet = nomDiplome + " " + niveau01AIgnorerPourBD.getAttributeValue("TEXT");
            	diplomeComplet.replace("'", "`");
            	
            	requete = "insert into diplome (nom_diplome) values ('"+ diplomeComplet  + "');";
                monController.modification(requete);
                   
                requete = "select * FROM diplome ORDER BY code_diplome DESC LIMIT 1;";
                codeDiplome = monController.getDiplome(requete);
                
                for (int w = 0; w < listeAnnees.size(); w++)
            	{
            		// ANNEES
            		Element annees = (Element) listeAnnees.get(w);
            		//System.out.println("Annee: " + annees.getAttributeValue("TEXT"));
            		
            		LinkedList<Annee> codeAnnee = new LinkedList<Annee>();
            		requete = "select * from annee where nom_annee = '" + annees.getAttributeValue("TEXT") + "';";
            		codeAnnee = monController.getAnnee(requete);
            		
            		requete = "insert into diplome_annee (code_diplome, code_annee) values (" + codeDiplome.get(0).getCode() + ", " + codeAnnee.get(0).getCode() + ")";
            		monController.modification(requete);
            		
            		List<Element> listeSemestres = annees.getChildren("node");
            		for (int a = 0; a < listeSemestres.size(); a++)
            		{
            			// SEMESTRE
            			Element semestres = (Element) listeSemestres.get(a);
            			
            			LinkedList<Semestre> codeSemestre = new LinkedList<Semestre>();
            			String nomSemestre = semestres.getAttributeValue("TEXT");
            			requete = "select * from semestre where nom_semestre = '" + nomSemestre + "';";
            			codeSemestre = monController.getSemestre(requete);
            			
            			List<Element> listeUE = semestres.getChildren("node");
            			for (int b = 0; b < listeUE.size(); b++)
            			{
            				// UE
            				Element ue = (Element) listeUE.get(b);
            				//System.out.println("UE-> " + ue.getAttributeValue("TEXT"));
            				
            				String nomUe = ue.getAttributeValue("TEXT").replace("'", "`");
            				requete = "insert into ue (nom_ue, code_semestre, code_diplome) values ('" + nomUe + "', " + codeSemestre.get(0).getCode() + ", " + codeDiplome.get(0).getCode() + ");";
            				monController.modification(requete);
            				
            				List<Element> listeEC = ue.getChildren("node");
            				for (int c = 0; c < listeEC.size(); c++)
            				{
            					// EC
            					Element ec = (Element) listeEC.get(c);
            					
            					LinkedList<Ue> codeUe = new LinkedList<Ue>();   
            	                requete = "select * FROM ue ORDER BY code_ue DESC LIMIT 1;";
            	                codeUe = monController.getUe(requete);
            					
            					//System.out.println("EC: " + ec.getAttributeValue("TEXT"));
            					String nomEc = ec.getAttributeValue("TEXT").replace("'", "`");
            					
            					requete = "insert into ec (nom_ec, code_ue, code_semestre) values ('" + nomSemestre + " - " + nomEc + "', " + codeUe.get(0).getCode() + ", " + codeSemestre.get(0).getCode() + ")";
            					monController.modification(requete);
            				}
            			}
            		}
            	}
            }
            
            
            // COTE COMPETENCES
            System.out.println("\nCOTE COMPETENCES");
            List<Element> liste11NiveauAIgnorerPourBD = cote_competences.getChildren("node");
           
            // NIVEAU A IGNORER POUR LA BD
            for (int i = 0; i < liste11NiveauAIgnorerPourBD.size(); i++)
            {
            	Element niveau11AIgnorerPourBD = (Element) liste11NiveauAIgnorerPourBD.get(i);
            	
            	List<Element> listeDomaines = niveau11AIgnorerPourBD.getChildren("node");
            	//System.out.println("(" + (i+1) + ") NIVEAU A IGNORER: "+ niveau11AIgnorerPourBD.getAttributeValue("TEXT"));
            	
            	diplomeComplet = nomDiplome + " " + niveau11AIgnorerPourBD.getAttributeValue("TEXT");
            	
            	requete = "select * from diplome where nom_diplome = '" + diplomeComplet + "';";
        		codeDiplome = monController.getDiplome(requete);
            	
        		if (codeDiplome.size() == 0)
        		{
        			requete = "insert into diplome (nom_diplome) values ('"+ diplomeComplet  + "');";
                    monController.modification(requete);
                    
                    requete = "select * FROM diplome ORDER BY code_diplome DESC LIMIT 1;";
                    codeDiplome = monController.getDiplome(requete);
        		}
        		
            	for (int j = 0; j < listeDomaines.size(); j++)
            	{   
            		// DOMAINE
            		Element domaine = (Element) listeDomaines.get(j);
            		String nomDomaine = domaine.getAttributeValue("TEXT").replace("'", "`");
            		//System.out.println("Nom domaine: " + nomDomaine);
            		
            		
            		
            		List<Element> listeCompetences = domaine.getChildren("node");
            		for (int k = 0; k < listeCompetences.size(); k++)
            		{
            			// DOMAINES DE COMPETENCE
            			Element competences = (Element) listeCompetences.get(k);
            			String nomCompetence = competences.getAttributeValue("TEXT").replace("'", "`");
            			//System.out.println("Competence: " + competences.getAttributeValue("TEXT"));
            			
            			
            			
            			List<Element> listeItems = competences.getChildren("node");
            			for (int f = 0; f < listeItems.size(); f++)
            			{
            				// ITEMS
            				Element items = (Element) listeItems.get(f);
            				String nomItem = items.getAttributeValue("TEXT").replace("'", "`");
            				//System.out.println("Item: " + items.getAttributeValue("TEXT"));
            				
            				
            				
            				List<Element> liste12NiveauAIgnorerPourBD = items.getChildren("node");
        					for (int t = 0; t < liste12NiveauAIgnorerPourBD.size(); t++)
        					{
        						// NIVEAU A IGNORER POUR LA BD
        						Element niveau12AIgnorerPourBD = (Element) liste12NiveauAIgnorerPourBD.get(t);
        						String nomEcC = niveau12AIgnorerPourBD.getAttributeValue("TEXT").replace("'", "`");
        						//nomEcC = nomEcC.replace("´", "`");
        						//nomEcC = nomEcC.substring(5);
        						System.out.println("(" + (t+1) + ") NIVEAU A IGNORER: "+ nomEcC);
        						
        						LinkedList<Ec> codeEcC = new LinkedList<Ec>();
        						requete = "select * from Ec where nom_ec = '" + nomEcC.toLowerCase() + "'";
        						codeEcC = monController.getEc(requete);
        						
        						if (codeEcC.size() != 0)
            					{
        							//On ajoute le domaine, la compétence, l'item seulement si l'ec est présent
        							requete = "insert into domaine (nom_domaine, code_diplome) values ('" + nomDomaine + "', " + codeDiplome.get(0).getCode() + ");";
                            		monController.modification(requete);
                            		
                            		requete = "select * FROM domaine ORDER BY code_domaine DESC LIMIT 1;";
                                    LinkedList<Domaine> codeDomaine = new LinkedList<Domaine>();
                                    codeDomaine = monController.getDomaine(requete);
                                    
                        			requete = "insert into competence (nom_competence, code_domaine) values ('"+ nomCompetence + "', " + codeDomaine.get(0).getCode() + ");";
                        			monController.modification(requete);
                        			
                        			LinkedList<Competence> codeCompetence = new LinkedList<Competence>();
                        			requete = "select * FROM competence ORDER BY code_competence DESC LIMIT 1;";
                        			codeCompetence = monController.getCompetence(requete);
                    				
                    				requete = "insert into item (nom_item, code_competence) values ('" + nomItem + "', " + codeCompetence.get(0).getCode() + ");";
                    				monController.modification(requete);
                    				
                    				LinkedList<Item> codeItem = new LinkedList<Item>();
                    				requete = "select * FROM item ORDER BY code_item DESC LIMIT 1;";
                    				codeItem = monController.getItem(requete);
        							
	        						requete = "insert into ec_item (code_ec, code_item) values ("+ codeEcC.get(0).getCode() + ", " + codeItem.get(0).getCode() + ");";
	        						monController.modification(requete);
	        						
	        						List<Element> listeSousItems = niveau12AIgnorerPourBD.getChildren("node");
	        						for (int h = 0; h < listeSousItems.size(); h++)
	                				{
		            					// SOUS-ITEMS
		            					Element sousItems = (Element) listeSousItems.get(h);
		            					String nomSousItem = sousItems.getAttributeValue("TEXT").replace("'", "`");
		            					System.out.println("Sous-items: " + sousItems.getAttributeValue("TEXT"));
		            					
		            					requete = "insert into sous_item (nom_sous_item) values ('" + nomSousItem + "');";
		            					monController.modification(requete);
		            					
		            					LinkedList<SousItem> codeSousItem = new LinkedList<SousItem>();
		            					requete = "select * FROM sous_item ORDER BY code_sous_item DESC LIMIT 1;";
		            					codeSousItem = monController.getSousItem(requete);
		            					
		            					requete = "insert into ec_sous_item (code_ec, code_sous_item) values ("+ codeEcC.get(0).getCode() + ", " + codeSousItem.get(0).getCode() +");";
		            					monController.modification(requete);
		            					
		            					requete = "insert into item_sous_item (code_item, code_sous_item) values ("+ codeItem.get(0).getCode()+", "+codeSousItem.get(0).getCode()+");";
		            					monController.modification(requete);
		            					
	            						List<Element> listeEvaluations = sousItems.getChildren("node");
	            						for (int x = 0; x < listeEvaluations.size(); x++)
	            						{
	            							// EVALUATIONS
	            							Element evaluations = (Element) listeEvaluations.get(x);
	            							
	            							if (evaluations.getAttributeValue("TEXT") != null)
	            							{
		            							System.out.println(evaluations.getAttributeValue("TEXT"));
		            							String nomEvaluation = evaluations.getAttributeValue("TEXT").replace("'", "`");
		            							//System.out.println("Evaluations: " + evaluations.getAttributeValue("TEXT"));
		            							
		            							requete = "insert into evaluation (nom_evaluation) values ('" + nomEvaluation + "');";
			            						monController.modification(requete);
			            						
			            						LinkedList<Evaluation> codeEvaluation = new LinkedList<Evaluation>();
			            						requete = "select * FROM evaluation ORDER BY code_evaluation DESC LIMIT 1;";
					            				codeEvaluation = monController.getEvaluation(requete);
		            							
		            							requete = "insert into sous_item_evaluation (code_sous_item, code_evaluation) values (" + codeSousItem.get(0).getCode() + ", " + codeEvaluation.get(0).getCode() + ");";
		            							monController.modification(requete);
	            							}
	            						}
	            					}
            					}
            				}
            			}
            		}	
            	}
            }
      
	        
	    }catch ( IOException io ) {
	        System.out.println( io.getMessage() );
	    }catch ( JDOMException jdomex ) {
	        System.out.println( jdomex.getMessage() );
	    }
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Xml_vers_DB();
	}

}
