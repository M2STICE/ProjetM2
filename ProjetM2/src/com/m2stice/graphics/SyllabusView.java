package com.m2stice.graphics;

import java.awt.BorderLayout;
import java.awt.Component;
import java.util.Iterator;
import java.util.LinkedList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;

import com.m2stice.controller.Controller;
import com.m2stice.model.Annee;
import com.m2stice.model.Diplome;
import com.m2stice.model.Ec;
import com.m2stice.model.Semestre;
import com.m2stice.model.Ue;
import com.m2stice.utils.Requetes;

/**
*  Syllabus - Classe d'affichage de la partie syllabus
*
* @version 1.1
*
* @author ASDRUBAL, NERES
* @copyright (C) Master 2 2015
* @date 11/12/2015
* @see Requetes
* 
*/

public class SyllabusView extends JPanel {

	/**
	 * Numéro de série
	 */
	private static final long serialVersionUID = 971L;
	
	private Interface interfaceUtilisateur;
	private JTree tree;
	   
	private LinkedList<Diplome> listD;
	private LinkedList<Annee> listA;
	private LinkedList<Semestre> listS;
	private LinkedList<Ue> listUe;
	private LinkedList<Ec> listEc;
	private Controller dip;
	private Diplome diplomeChoisi;
	
	public void init() {
		this.setLayout(new BorderLayout());
		dip = interfaceUtilisateur.getController();

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
		   
		   
		listD = dip.getDiplome(Requetes.FORMATION.toString(diplomeChoisi.getNom()));
		it= listD.iterator(); 
	       
		while(it.hasNext()){
			Diplome diplome=it.next();
			formation = new DefaultMutableTreeNode(diplome.getNom().toUpperCase());
			
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
					//System.out.println("======\n\n"+Requetes.UE.toString(ann.getCode(), sem.getCode(), diplome.getCode())+"\n\n========");
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
	   tree.setRootVisible(false);
	   tree.setCellRenderer(new  DefaultTreeCellRenderer(){
		 /**
		 * Numero de serie
		 */
		   private static final long serialVersionUID = 9711L;
		   public Component getTreeCellRendererComponent(JTree tree ,Object value, boolean sel, boolean expanded, boolean leaf, int row, boolean hasFocus){
			   super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);
			   DefaultMutableTreeNode node = (DefaultMutableTreeNode)value; 
			   if(node.getParent()!=null){
				   if(((DefaultMutableTreeNode) node.getParent()).isRoot())
					   this.setIcon(new ImageIcon((interfaceUtilisateur.loadImage("puce2.png"))));
			   }	   
			   return this;
			}
	   });
	   DefaultTreeCellRenderer puce  = (DefaultTreeCellRenderer) tree.getCellRenderer();
	   Icon image = new ImageIcon((interfaceUtilisateur.loadImage("puce3.png")));
	   puce.setLeafIcon(image);
	   this.add(new JScrollPane(tree),BorderLayout.CENTER);
	}
	
	/**
	 * Constructeur de la vue 
	 * @param interfaceUtilisateur
	 */
	public SyllabusView(Interface interfaceUtilisateur, Diplome diplome){
		this.interfaceUtilisateur = interfaceUtilisateur;
		this.diplomeChoisi = diplome;
		init();
	}
	
	public void setSyllabusListener(TreeSelectionListener treeSelectionListener){
		tree.addTreeSelectionListener(treeSelectionListener);
	}

}
