package com.m2stice.graphics;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
/**
 * 
 * @author Emmanuel
 *
 */
public class NavigationView extends JPanel {
	/**
	 * Numéro de série
	 */
	private static final long serialVersionUID = 971L;
	
	//private String mouseMode = "click"; 				//Type de pointeur (click ou zoom_plus ou zoom_moins)
	
	private Interface interfaceUtilisateur;				//Liaison avec l'applet
	private JPanel bloc = new JPanel();					//Bloc de container transparent
	private JPanel blocEntete = new JPanel();   		//Bloc de l'entete
	private JPanel blocCommande = new JPanel(); 		//Bloc qui contient les boutons
	private JInternalFrame blocSyllabus = new JInternalFrame("Syllabus",true, false, false);//Bloc qui contient l'arborescence syllabus
	private JInternalFrame blocCompetences = new JInternalFrame("Compétences",true, false, false);//Bloc qui contient l'arborescence des compétences
	
	private JButton clickButton = new JButton();
	private JButton zoomPlusButton = new JButton();
	private JButton zoomMoinsButton = new JButton();
	private BanniereComponent banniere;					//Bannière de la fenêtre
	
	public void init(){
		
		//Paramètrage des composants
		//
		banniere = new BanniereComponent(interfaceUtilisateur,"ResultatViewBanniere.jpg");
		banniere.setPreferredSize(new Dimension(1024,69));
		//
		clickButton.setPreferredSize(new Dimension(50,50));
		clickButton.setIcon(new ImageIcon(interfaceUtilisateur.loadImage("BoutonFlecheIcon.png")));
		clickButton.setBackground(Color.LIGHT_GRAY);
		clickButton.setBorder(null);
		clickButton.setToolTipText("Sélectionner");
		//
		zoomPlusButton.setPreferredSize(new Dimension(50,50));
		zoomPlusButton.setIcon(new ImageIcon(interfaceUtilisateur.loadImage("BoutonZoomPlusIcon.png")));
		zoomPlusButton.setBackground(Color.LIGHT_GRAY);
		zoomPlusButton.setBorder(null);
		zoomPlusButton.setToolTipText("Zoom plus");
		//
		zoomMoinsButton.setPreferredSize(new Dimension(50,50));
		zoomMoinsButton.setIcon(new ImageIcon(interfaceUtilisateur.loadImage("BoutonZoomMoinsIcon.png")));
		zoomMoinsButton.setBackground(Color.LIGHT_GRAY);
		zoomMoinsButton.setBorder(null);
		zoomMoinsButton.setToolTipText("Zoom moins");
		//
		blocCommande.setLayout(new FlowLayout());
		blocCommande.setPreferredSize(new Dimension(1024,60));
		blocCommande.add(zoomMoinsButton,FlowLayout.LEFT);
		blocCommande.add(zoomPlusButton,FlowLayout.LEFT);
		blocCommande.add(clickButton,FlowLayout.LEFT);
		//
		blocEntete.setLayout(new BorderLayout());
		blocEntete.add(banniere,BorderLayout.NORTH);
		blocEntete.add(blocCommande,BorderLayout.CENTER);
		blocEntete.setPreferredSize(new Dimension(1024,130));
		blocEntete.setOpaque(false);
		//
		blocSyllabus.setPreferredSize(new Dimension(250,0));
		blocSyllabus.setBackground(Color.WHITE);
		//blocSyllabus.setBorder(null);
		blocSyllabus.setVisible(true);
		//
		blocCompetences.setBackground(Color.WHITE);
		//blocCompetences.setBorder(null);
		blocCompetences.setVisible(true);
		//
		bloc.setLayout(new BorderLayout());
		bloc.add(blocEntete,BorderLayout.NORTH);
		bloc.add(blocSyllabus, BorderLayout.WEST);
		bloc.add(blocCompetences, BorderLayout.CENTER);
		bloc.setOpaque(false);
		
		//Paramètrage de la vue
		this.setOpaque(false);
		this.setVisible(true);
		
		//Agencement de la vue
		this.setLayout(new BorderLayout());
		this.add(bloc,BorderLayout.CENTER);
	}
	
	public NavigationView(Interface interfaceUtilisateur){
		this.interfaceUtilisateur = interfaceUtilisateur;
		this.init();
	}
	
	public void setActionListener(ActionListener apl){
		this.clickButton.addActionListener(apl);
	}

}
