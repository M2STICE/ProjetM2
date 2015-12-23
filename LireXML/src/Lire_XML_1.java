
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.jdom2.Document;         // |
import org.jdom2.Element;          // |\ Libreries
import org.jdom2.JDOMException;    // |/ JDOM
import org.jdom2.input.SAXBuilder; // |


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

public class Lire_XML_1 {
	
	
	public static void Xml_vers_DB()
	{		
		LinkedList <String> listEc = new LinkedList<String>();
		int nb_evaluation = 0;
		int nb_ec = 0;		
		int nb_sous_items = 0;
	    int nb_items = 0;
	    
		// Créer un SAXBuilder pour pouvoir parser le fichier
	    SAXBuilder builder = new SAXBuilder();
	    File xmlFile = new File("competences_1_1.xml");
	    try
	    {
	   
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
           
 
            // RACINE
            List<Element> niveauPosition = tableRacine.getChildren("node");
            Element cote_competences = (Element) niveauPosition.get(0);
            //System.out.println( "Coté: " + cote_competences.getAttributeValue("TEXT"));
            Element cote_syllabus = (Element) niveauPosition.get(1);
            //System.out.println( "Coté: " + cote_syllabus.getAttributeValue("TEXT"));
            
            
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
                
                   
                requete = "select * FROM diplome ORDER BY code_diplome DESC LIMIT 1;";
                
                
                for (int w = 0; w < listeAnnees.size(); w++)
            	{
            		// ANNEES
            		Element annees = (Element) listeAnnees.get(w);
            		//System.out.println("Annee: " + annees.getAttributeValue("TEXT"));
            		
            		
            		requete = "select * from annee where nom_annee = '" + annees.getAttributeValue("TEXT") + "';";
            		
            		
            		
            		
            		List<Element> listeSemestres = annees.getChildren("node");
            		for (int a = 0; a < listeSemestres.size(); a++)
            		{
            			// SEMESTRE
            			Element semestres = (Element) listeSemestres.get(a);
            			
            			
            			String nomSemestre = semestres.getAttributeValue("TEXT");
            			requete = "select * from semestre where nom_semestre = '" + nomSemestre + "';";
            			
            			
            			List<Element> listeUE = semestres.getChildren("node");
            			for (int b = 0; b < listeUE.size(); b++)
            			{
            				// UE
            				Element ue = (Element) listeUE.get(b);
            				//System.out.println("UE-> " + ue.getAttributeValue("TEXT"));
            				
            				String nomUe = ue.getAttributeValue("TEXT").replace("'", "`");
            				
         
            				
            				List<Element> listeEC = ue.getChildren("node");
            				for (int c = 0; c < listeEC.size(); c++)
            				{
            					// EC
            					Element ec = (Element) listeEC.get(c);
            					
            					   
            	                requete = "select * FROM ue ORDER BY code_ue DESC LIMIT 1;";
            	                
            					
            					//System.out.println("EC: " + ec.getAttributeValue("TEXT"));
            					String nomEc = ec.getAttributeValue("TEXT").replace("'", "`");
            					System.out.println(nomEc);
            					
            					//On ajoute les nom des Ec à la liste
            					listEc.add(nomEc);
            					
            					
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
      
            	
        		
            	for (int j = 0; j < listeDomaines.size(); j++)
            	{   
            		// DOMAINE
            		Element domaine = (Element) listeDomaines.get(j);
            		String nomDomaine = domaine.getAttributeValue("TEXT").replace("'", "`");
            		//System.out.println("Nom domaine: " + nomDomaine);
            		
            		
            	
            		
            		requete = "select * FROM domaine ORDER BY code_domaine DESC LIMIT 1;";
                    
            		
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
            				nb_items ++;
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
        						nomEcC = nomEcC.substring(5);
        						System.out.println("EC: "+ nomEcC);
        						
        						
        						//Si l'Ec est présent dans la liste des Ec alors on ajoute les sous-items et les évaluations associés
        						if(listEc.indexOf(nomEcC)!=-1)
        						{		nb_ec++;
	        							requete = "select * from Ec where nom_ec = '" + nomEcC.toLowerCase() + "'";
	        						
	        						
	        						
		        						
		        						
		        						List<Element> listeSousItems = niveau12AIgnorerPourBD.getChildren("node");
		        						for (int h = 0; h < listeSousItems.size(); h++)
		                				{
			            					// SOUS-ITEMS
			            					Element sousItems = (Element) listeSousItems.get(h);
			            					String nomSousItem = sousItems.getAttributeValue("TEXT").replace("'", "`");
			            					System.out.println("Sous-items: " + sousItems.getAttributeValue("TEXT"));
			            					nb_sous_items++;
			            					requete = "insert into sous_item (nom_sous_item) values ('" + nomSousItem + "');";
			            					
			            					
			            					
			            					requete = "select * FROM sous_item ORDER BY code_sous_item DESC LIMIT 1;";
			            					
			            					
		            						List<Element> listeEvaluations = sousItems.getChildren("node");
		            						//System.out.println("Taille : "+ listeEvaluations.size());
		            						for (int x = 0; x < listeEvaluations.size(); x++)
		            						{
		            							// EVALUATIONS
		            							Element evaluations = (Element) listeEvaluations.get(x);
		            							
		            							
		            							if (evaluations.getAttributeValue("TEXT") != null)
		            							{
			            							//System.out.println(evaluations.getAttributeValue("TEXT"));
			            							String nomEvaluation = evaluations.getAttributeValue("TEXT").replace("'", "`");
			            							//System.out.println("Evaluations: " + evaluations.getAttributeValue("TEXT"));
			            							nb_evaluation ++;
			            							
			            							requete = "insert into evaluation (nom_evaluation) values ('" + nomEvaluation + "');";
			            							
		            							}
		            							
		            						}
		            					}
        						}
            					}
            				}
            			}
            		}	
            	}
            System.out.println("Nombre items: "+nb_items);
            System.out.println("Nombre EC sélectionné: "+nb_ec);
            System.out.println("Nombre sous items sélectionné: "+nb_sous_items);
            System.out.println("Nombre evaluation sélectionnée:" +nb_evaluation);
            
      
	        
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
