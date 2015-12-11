package com.m2stice.graphics;

import java.util.Iterator;
import java.util.LinkedList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

import com.m2stice.controller.Controller;
import com.m2stice.model.Annee;
import com.m2stice.model.Diplome;
import com.m2stice.model.Ec;
import com.m2stice.model.Semestre;
import com.m2stice.model.Ue;
import com.m2stice.utils.Requetes;

public class SyllabusView extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 528033812897381067L;

	private JTree tree;
	   
	   public LinkedList<Diplome> listD;
	   public LinkedList<Annee> listA;
	   public LinkedList<Semestre> listS;
	   public LinkedList<Ue> listUe;
	   public LinkedList<Ec> listEc;
	   public Controller dip = new Controller();
	
	public SyllabusView() {
		// TODO Auto-generated constructor stub
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("Syllabus");
	       DefaultMutableTreeNode formation = null;
	       DefaultMutableTreeNode annee = null;
	       DefaultMutableTreeNode semestre = null;
	       DefaultMutableTreeNode ue = null;
	       DefaultMutableTreeNode ec = null;
	       
	       Iterator<Diplome> it= null; 
	       Iterator<Annee> it2 = null;
	       Iterator<Semestre> it3 = null;
	       Iterator<Ue> it4 = null;
	       
	       
	       listD = dip.getDiplome(Requetes.FORMATION.toString());
	       it= listD.iterator(); 
	       
			while(it.hasNext()){
				Diplome diplome=it.next();
				formation = new DefaultMutableTreeNode(diplome.getNom());
				
				listA = dip.getAnnee(Requetes.ANNEE.toString(diplome.getCode()));
				it2 = listA.iterator(); 
				
				while(it2.hasNext()){
					Annee ann = (Annee)it2.next();
					annee = new DefaultMutableTreeNode(ann.getNom());
					
					listS = dip.getSemestre(Requetes.SEMESTRE.toString(ann.getCode()));
					it3 = listS.iterator(); 
					
					while(it3.hasNext()){
						Semestre sem = (Semestre)it3.next();
						semestre = new DefaultMutableTreeNode(sem.getNom());
						listUe = dip.getUe(Requetes.UE.toString(ann.getCode(), sem.getCode(), diplome.getCode()));
						it4 = listUe.iterator();
						
						while (it4.hasNext()) {
							Ue uE = (Ue)it4.next();
							ue = new DefaultMutableTreeNode(uE.getNom());
							listEc = dip.getEc(Requetes.EC.toString(uE.getCode()));
								for (Ec eC : listEc) {
									ec = new DefaultMutableTreeNode(eC.getNom());
									ue.add(ec);
								}
							semestre.add(ue);
						}
						annee.add(semestre);
					}
					
					formation.add(annee);
				}
				
				root.add(formation);
			}
			
	       tree = new JTree(root);
	       this.add(new JScrollPane(tree));
	}

}
