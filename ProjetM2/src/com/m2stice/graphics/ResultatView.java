package com.m2stice.graphics;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

import com.m2stice.controller.ResultatViewListener;
import com.m2stice.model.Diplome;
import com.m2stice.model.Promotion;
/*
 * Classe ResultatView
 */
/**
 * ResultatView - Génère la vue des résultats de la recherche
 * @author BIABIANY
 * @version 1.0
 * @copyright (C) Master 2 2015
 * @date 03/12/2015
 */
public class ResultatView extends JPanel {

	/**
	 * Numéro de série
	 */
	private static final long serialVersionUID = 971L;
	
	private Interface interfaceUtilisateur;					//Lien vers l'applet
	private ResultatViewListener resultatViewListener;
	
	private JPanel bloc = new JPanel();						//Bloc container transparent
	private JPanel blocEntete = new JPanel();				//Bloc contenant l'entete
	private JPanel blocResultat = new JPanel();				//Bloc contenant les résultats
	private JPanel blocRecherche = new JPanel();			//Bloc contenant le sujet de recherche et le détal
	private JLabel titreRecherche = new JLabel(" 🔍  Résultat de la recherche: '...'");
	private JLabel detailRecherche = new JLabel("     X résultats trouvés");
	private BanniereComponent banniere;						//La banniere de la vue
	public JLabel chargementImg;
	private JButton retourBouton = new JButton("retour");
	
	/**
	 * Mise en place de la vue
	 */
	public void init(){
		//Paramétrage de la vue
		this.resultatViewListener = new ResultatViewListener(interfaceUtilisateur, this);
		this.setLayout(new BorderLayout());
		this.setOpaque(false);
		
		//Paramétrage des composants de la vue
		chargementImg = new JLabel(new ImageIcon(interfaceUtilisateur.loadImage("ChargementIcon.gif")));
		chargementImg.setVisible(false);
		//
		retourBouton.addActionListener(resultatViewListener.getRetourBoutonListener());
		//
		banniere = new BanniereComponent(interfaceUtilisateur,"ResultatViewBanniere.jpg");
		banniere.setPreferredSize(new Dimension(1024,69));
		banniere.setLayout(new FlowLayout(FlowLayout.TRAILING));
		banniere.add(chargementImg);
		banniere.add(retourBouton);
		//
		titreRecherche.setFont(new Font("Gill Sans MT",Font.BOLD,30));
		titreRecherche.setPreferredSize(new Dimension(1024,40));
		//
		detailRecherche.setFont(new Font("Gill Sans MT",Font.ROMAN_BASELINE,15));
		detailRecherche.setPreferredSize(new Dimension(1024,25));
		//
		blocRecherche.setLayout(new BorderLayout());
		blocRecherche.add(titreRecherche,BorderLayout.NORTH);
		blocRecherche.add(new JSeparator(SwingConstants.HORIZONTAL),BorderLayout.CENTER);
		blocRecherche.add(detailRecherche,BorderLayout.SOUTH);
		blocRecherche.setPreferredSize(new Dimension(1024,70));
		//
		blocEntete.setPreferredSize(new Dimension(1024,150));
		blocEntete.add(banniere,BorderLayout.NORTH);
		blocEntete.add(blocRecherche,BorderLayout.CENTER);
		//
		blocResultat.setLayout(new FlowLayout());
		blocResultat.setOpaque(false);
		//
		bloc.setLayout(new BorderLayout());
		bloc.add(blocEntete, BorderLayout.NORTH);
		bloc.add(blocResultat, BorderLayout.CENTER);
		bloc.setOpaque(false);
		bloc.setVisible(true);
		
		//Agencement de la vue
		this.add(bloc,BorderLayout.CENTER);
	}
	
	/**
	 * @param L'interface d'utilisateur
	 */
	public ResultatView(Interface interfaceUtilisateur){
		this.setInterfaceUtilisateur(interfaceUtilisateur);
		
		init();
	}

	/**
	 * @return L'interface d'utilisateur
	 */
	public Interface getInterfaceUtilisateur() {
		return interfaceUtilisateur;
	}

	/**
	 * @param Modifier l'interface
	 */
	public void setInterfaceUtilisateur(Interface interfaceUtilisateur) {
		this.interfaceUtilisateur = interfaceUtilisateur;
	}
	
	/**
	 * @param Le titre de la recherche
	 */
	public void setEntete(String titreRecherche,int nombreTrouvés){
		this.titreRecherche.setText(" >  Résultat de la recherche \""+titreRecherche+"\"");
		this.detailRecherche.setText("     "+nombreTrouvés+" résultats trouvés");
	}
	
	/**
	 * @param Le titre de la recherche
	 */
	public void setEntete(int nombreTrouvés){
		this.detailRecherche.setText("     "+nombreTrouvés+" résultats trouvés");
	}
	
	public void setResultat(LinkedList<Diplome> diplomes){
		if(interfaceUtilisateur.utilisateurCourant.type.compareToIgnoreCase("etu")==0){
			for(Diplome d:diplomes){
				JLabel jl = new JLabel("  "+d.getNom().substring(0,1).toUpperCase()+d.getNom().substring(1));
				jl.setPreferredSize(new Dimension(interfaceUtilisateur.getWidth(),40));
				jl.setOpaque(true);
				jl.setFont(new Font("Gill Sans MT",Font.BOLD,20));
				jl.setBackground(Color.decode("#66a8da"));
				jl.addMouseListener(resultatViewListener.getItemListener(jl,d));
				this.blocResultat.add(jl);
			}
			setEntete(diplomes.size());
		}
		else{
			int somme = 0;
			for(Diplome d:diplomes){
				LinkedList<Promotion> promotions = resultatViewListener.getPromotions(d);
				for(Promotion p:promotions){
					somme++;
					JLabel jl = new JLabel("  "+d.getNom().substring(0,1).toUpperCase()+d.getNom().substring(1)+" "+p.getAnneeDebutPromotion()+"-"+p.getAnneeFinPromotion());
					jl.setPreferredSize(new Dimension(interfaceUtilisateur.getWidth(),40));
					jl.setOpaque(true);
					jl.setFont(new Font("Gill Sans MT",Font.BOLD,20));
					jl.setBackground(Color.decode("#66a8da"));
					jl.addMouseListener(resultatViewListener.getItemListener(jl,d,p));
					this.blocResultat.add(jl);
				}
			}
			setEntete(somme);
		}
	}
	
	
	public void setRetourListener(ActionListener actionListener){
		retourBouton.addActionListener(actionListener);
	}
	
	/**
	 * 
	 */
	public void repaint(){
		try{
			int largeur = interfaceUtilisateur.getWidth();
			titreRecherche.setPreferredSize(new Dimension(largeur,40));
			detailRecherche.setPreferredSize(new Dimension(largeur,25));
			blocRecherche.setPreferredSize(new Dimension(largeur,70));
			blocEntete.setPreferredSize(new Dimension(largeur,150));
		}
		catch(Exception e){
			//e.printStackTrace();
		}
		super.repaint();
	}
	
	public void setBouton(String titre){
		retourBouton.setText(titre);
	}
	
	public void clear(){
		this.blocEntete.removeAll();
		this.blocRecherche.removeAll();
		this.bloc.removeAll();
		this.removeAll();
	}
	
}
