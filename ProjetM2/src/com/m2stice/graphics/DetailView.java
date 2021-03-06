package com.m2stice.graphics;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.LinkedList;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.m2stice.controller.NavigationViewListener;
import com.m2stice.model.Competence;
import com.m2stice.model.Domaine;
import com.m2stice.model.Ec;
import com.m2stice.model.Etudiant;
import com.m2stice.model.Intervenant;
import com.m2stice.model.Item;
import com.m2stice.model.SousItem;

public class DetailView extends JPanel {

	/**
	 * Numéro de série
	 */
	private static final long serialVersionUID = 971L;
	private Interface interfaceUtilisateur;
	private JPanel bloc;
	private JScrollPane blocInferieur;
	//private JScrollPane bloc;
	//private JScrollPane blocEtudiant;
	private JLabel entete;
	private JTextArea contenu;
	private JList<String> listeEtudiant;
	
	public DetailView(Interface interfaceUtilisateur) {
		this.interfaceUtilisateur = interfaceUtilisateur;
		init();
	}
	
	public void init(){
		this.bloc = new JPanel();
		this.entete = new JLabel();
		this.contenu = new JTextArea();
		this.listeEtudiant = new JList<>();
		
		entete.setPreferredSize(new Dimension(0,20));
		entete.setOpaque(true);
		entete.setFont(new Font("Gill Sans MT",Font.BOLD,15));
		entete.setBackground(Color.WHITE);
		
		contenu.setOpaque(true);
		contenu.setFont(new Font("Gill Sans MT",Font.ROMAN_BASELINE,11));
		contenu.setBackground(Color.WHITE);
		contenu.setEditable(false);
		
		listeEtudiant.setPreferredSize(new Dimension(200,0));
		
		bloc.setLayout(new BorderLayout());
		bloc.add(entete,BorderLayout.NORTH);
		bloc.add(contenu,BorderLayout.CENTER);
		bloc.setOpaque(false);
		
		blocInferieur = new JScrollPane(bloc);
		blocInferieur.setOpaque(false);
		
		this.setLayout(new BorderLayout());
		this.add(blocInferieur,BorderLayout.CENTER);
		this.setOpaque(false);
		
		this.interfaceUtilisateur.revalidate();
	}
	
	public void setDetail(String entete,String contenu){
		this.entete.setText(entete);
		this.contenu.setText(contenu);
	}
	
	public void afficher(Domaine domaine){
		setDetail(" Domaine: "+domaine.getNom().toUpperCase(), "  Code: "+domaine.getCode()
			+"\n  Code du diplome: "+domaine.getCodeDiplome());
	}
	
	public void afficher(Competence competence){
		setDetail(" Compétence: "+competence.getNom().toUpperCase(), "  Code: "+competence.getCode()
			+"\n  Code du domaine: "+competence.getCodeDomaine());
	}
	
	public void afficher(Ec ec, LinkedList<Intervenant> listIntervenant){
		String intervenant = new String("\n  LISTE D'INTERVENANTS: \n");
		for (int i = 0; i < listIntervenant.size(); i++)
		{
			intervenant += "\n  (" + listIntervenant.get(i).getCode() + ") - " + listIntervenant.get(i).getNom() + " " +listIntervenant.get(i).getPrenom();
		}
		
		setDetail(" EC: "+ec.getNom().toUpperCase(), "  Code: "+ec.getCode()
			+"\n  Coefficent: "+ec.getCoefficient()
			+"\n  Descriptions: "+ec.getResume()
			+"\n  Nombres ECTS: "+ec.getNombreEcts()
			+"\n" + intervenant);
	}
	
	public void afficher(Item item){
		setDetail(" Item: " + item.getNom().toUpperCase(), "  Code: "+item.getCode());
	}
	
	public void afficher(SousItem sousitem){
		setDetail(" Sous-item: " + sousitem.getNom().toUpperCase(), "  Code: "+sousitem.getCode());
	}
	
	public void afficher(float moyenne){
		setDetail("Moyenne : ",""+moyenne);
	}
	
	public void afficherEtudiants(LinkedList<Etudiant> etudiants,NavigationViewListener navigationViewListener){
		remove(listeEtudiant);
		String[] liste = new String[etudiants.size()+1];
		liste[0] = "Tous les étudiants";
		for(int i=0;i<etudiants.size();i++){
			liste[i+1] = etudiants.get(i).getNom().toUpperCase()+" "+etudiants.get(i).getPrenom().substring(0,1).toUpperCase()+etudiants.get(i).getPrenom().substring(1).toLowerCase();
		}
		listeEtudiant = new JList<>(liste);
		listeEtudiant.addListSelectionListener(navigationViewListener.getListeEtudiantListener(listeEtudiant));
		this.bloc.add(listeEtudiant,BorderLayout.EAST);
		this.revalidate();
		this.repaint();
	}
}
