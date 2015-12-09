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
import com.m2stice.model.Diplome;


public class Lire_XML {
		
	public static void Xml_vers_DB()
	{		
	    // Créer un SAXBuilder pour pouvoir parser le fichier
	    SAXBuilder builder = new SAXBuilder();
	    File xmlFile = new File("competences.xml");
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
            System.out.println( "Diplome: " + nomDiplome);
 
            // RACINE
            List<Element> niveauPosition = tableRacine.getChildren("node");
            Element cote_competences = (Element) niveauPosition.get(0);
            System.out.println( "Coté: " + cote_competences.getAttributeValue("TEXT"));
            Element cote_syllabus = (Element) niveauPosition.get(1);
            System.out.println( "Coté: " + cote_syllabus.getAttributeValue("TEXT"));
            
            
            // COTE SYLLABUS
            System.out.println("\nCOTE SYLLABUS");
            List<Element> liste01NiveauAIgnorerPourBD = cote_syllabus.getChildren("node");
            
            // NIVEAU A IGNORER POUR LA BD (Fait partie du nom du diplome)
            for (int u = 0; u < liste01NiveauAIgnorerPourBD.size(); u++)
            {
            	Element niveau01AIgnorerPourBD = (Element) liste01NiveauAIgnorerPourBD.get(u);
            	
            	List<Element> listeAnnees = niveau01AIgnorerPourBD.getChildren("node");
            	//System.out.println("(" + (u+1) + ") NIVEAU A IGNORER: " + niveau01AIgnorerPourBD.getAttributeValue("TEXT"));
            	
            	String diplomeComplet = nomDiplome + " " + niveau01AIgnorerPourBD.getAttributeValue("TEXT");
            	
            	requete = "insert into diplome (nom_diplome) values ('"+ diplomeComplet  + "');";
                monController.modification(requete);
                
                LinkedList<Diplome> codeDiplome = new LinkedList<Diplome>();   
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
            			System.out.println("Semestre: " + semestres.getAttributeValue("TEXT"));
            			
            			List<Element> listeUE = semestres.getChildren("node");
            			for (int b = 0; b < listeUE.size(); b++)
            			{
            				// UE
            				Element ue = (Element) listeUE.get(b);
            				System.out.println("UE-> " + ue.getAttributeValue("TEXT"));
            				
            				List<Element> listeEC = ue.getChildren("node");
            				for (int c = 0; c < listeEC.size(); c++)
            				{
            					// EC
            					Element ec = (Element) listeEC.get(c);
            					System.out.println("EC: " + ec.getAttributeValue("TEXT"));
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
            	System.out.println("(" + (i+1) + ") NIVEAU A IGNORER: "+ niveau11AIgnorerPourBD.getAttributeValue("TEXT"));
            	for (int j = 0; j < listeDomaines.size(); j++)
            	{
            		// DOMAINE
            		Element domaine = (Element) listeDomaines.get(j);
            		System.out.println("Nom domaine: " + domaine.getAttributeValue("TEXT"));
            		
            		List<Element> listeCompetences = domaine.getChildren("node");
            		for (int k = 0; k < listeCompetences.size(); k++)
            		{
            			// DOMAINES DE COMPETENCE
            			Element competences = (Element) listeCompetences.get(k);
            			System.out.println("Competence: " + competences.getAttributeValue("TEXT"));
            			
            			List<Element> listeItems = competences.getChildren("node");
            			for (int f = 0; f < listeItems.size(); f++)
            			{
            				// ITEMS
            				Element items = (Element) listeItems.get(f);
            				System.out.println("Item: " + items.getAttributeValue("TEXT"));
            				
            				List<Element> liste12NiveauAIgnorerPourBD = items.getChildren("node");
        					for (int t = 0; t < liste12NiveauAIgnorerPourBD.size(); t++)
        					{
        						// NIVEAU A IGNORER POUR LA BD
        						Element niveau12AIgnorerPourBD = (Element) liste12NiveauAIgnorerPourBD.get(t);
        						System.out.println("(" + (t+1) + ") NIVEAU A IGNORER: "+ niveau12AIgnorerPourBD.getAttributeValue("TEXT"));
        						
        						List<Element> listeSousItems = niveau12AIgnorerPourBD.getChildren("node");
        						for (int h = 0; h < listeSousItems.size(); h++)
                				{
	            					// SOUS-ITEMS
	            					Element sousItems = (Element) listeSousItems.get(h);
	            					System.out.println("Sous-items: " + sousItems.getAttributeValue("TEXT"));
            					
            						List<Element> listeEvaluations = sousItems.getChildren("node");
            						for (int x = 0; x < listeEvaluations.size(); x++)
            						{
            							// EVALUATIONS
            							Element evaluations = (Element) listeEvaluations.get(x);
            							System.out.println("Evaluations: " + evaluations.getAttributeValue("TEXT"));
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
