package com.m2stice.graphics;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.m2stice.controller.NavigationViewListener;
import com.m2stice.model.Annee;
import com.m2stice.model.Competence;
import com.m2stice.model.Diplome;
import com.m2stice.model.Domaine;
import com.m2stice.model.Ec;
import com.m2stice.model.Item;
import com.m2stice.model.Promotion;
import com.m2stice.model.Semestre;
import com.m2stice.model.SousItem;
import com.m2stice.model.Ue;
/**
 * NavigationView - Classe qui va générer la vue de navigation.
 * @version 1.6
 * @author BIABIANY
 * @revision 21/12
 * BIABIANY, HENRY & CISNEROS
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
	private JPanel blocSyllabus = new JPanel();			//Bloc qui contient l'arborescence syllabus
	private JPanel blocCompetences = new JPanel();		//Bloc qui contient l'arborescence des compétences
	private JPanel blocDetail = new JPanel();
	
	private SyllabusView syllabusView;
	private CompetenceView competenceView;
	private DetailView detailView;
	
	private JButton clickButton = new JButton();
	private JButton zoomPlusButton = new JButton();
	private JButton zoomMoinsButton = new JButton();
	private BanniereComponent banniere;					//Bannière de la fenêtre
	public JLabel chargementImg;
	private JButton retourBouton = new JButton("Retour");
	
	private NavigationViewListener navigationViewListener;
	
	public Diplome diplomeCourant;
	public Domaine domaineCourant;
	public Competence competenceCourante;
	public Ue ueCourante;
	public Ec ecCourant;
	public SousItem sousItemCourant;
	public Item itemCourant;
	public Annee anneeCourant;
	public Semestre semestreCourant;
	public Ue ueCourant;
	public Promotion promotionCourante;
	public LinkedList<Ec> listEcCourant = null;
	public LinkedList<Item> listItemCourant = null;
	public LinkedList<Competence> listCompetenceCourant = null;
	
	
	public void init(){
		
		navigationViewListener = new NavigationViewListener(interfaceUtilisateur, this);
		
		//Paramètrage des composants
		//
		chargementImg = new JLabel(new ImageIcon(interfaceUtilisateur.loadImage("ChargementIcon.gif")));
		chargementImg.setVisible(false);
		//
		retourBouton.addActionListener(navigationViewListener.getRetourBoutonListener());
		//
		banniere = new BanniereComponent(interfaceUtilisateur,"ResultatViewBanniere.jpg");
		banniere.setPreferredSize(new Dimension(1024,69));
		banniere.setLayout(new FlowLayout(FlowLayout.TRAILING));
		banniere.add(chargementImg);
		banniere.add(retourBouton);
		//
		clickButton.setPreferredSize(new Dimension(35,35));
		clickButton.setIcon(new ImageIcon(interfaceUtilisateur.loadImage("BoutonFlecheIcon.png")));
		clickButton.setBackground(Color.decode("#eeeeee"));
		clickButton.setBorder(null);
		clickButton.setToolTipText("Sélectionner");
		//
		zoomPlusButton.setPreferredSize(new Dimension(35,35));
		zoomPlusButton.setIcon(new ImageIcon(interfaceUtilisateur.loadImage("BoutonZoomPlusIcon.png")));
		zoomPlusButton.setBackground(Color.decode("#eeeeee"));
		zoomPlusButton.setBorder(null);
		zoomPlusButton.setToolTipText("Zoom plus");
		//
		zoomMoinsButton.setPreferredSize(new Dimension(35,35));
		zoomMoinsButton.setIcon(new ImageIcon(interfaceUtilisateur.loadImage("BoutonZoomMoinsIcon.png")));
		zoomMoinsButton.setBackground(Color.decode("#eeeeee"));
		zoomMoinsButton.setBorder(null);
		zoomMoinsButton.setToolTipText("Zoom moins");
		//
		blocCommande.setLayout(new FlowLayout(FlowLayout.LEADING));
		blocCommande.setPreferredSize(new Dimension(1024,45));
//		blocCommande.add(Box.createVerticalBox());
//		blocCommande.add(Box.createVerticalBox());
//		blocCommande.add(Box.createVerticalBox());
//		blocCommande.add(clickButton);
		blocCommande.add(Box.createVerticalBox());
		blocCommande.add(Box.createVerticalBox());
		blocCommande.add(Box.createVerticalBox());
		blocCommande.add(zoomPlusButton);
		blocCommande.add(Box.createVerticalBox());
		blocCommande.add(Box.createVerticalBox());
		blocCommande.add(Box.createVerticalBox());
		blocCommande.add(zoomMoinsButton);
		blocCommande.add(Box.createVerticalBox());
		blocCommande.add(Box.createVerticalBox());
		blocCommande.add(Box.createVerticalBox());
		//
		blocEntete.setLayout(new BorderLayout());
		blocEntete.add(banniere,BorderLayout.NORTH);
		blocEntete.add(blocCommande,BorderLayout.CENTER);
		blocEntete.setPreferredSize(new Dimension(1024,115));
		blocEntete.setOpaque(false);
		//
		syllabusView = new SyllabusView(interfaceUtilisateur,this.diplomeCourant);
		syllabusView.setSyllabusListener(navigationViewListener.getSyllabusListener());
		//
		blocSyllabus.setPreferredSize(new Dimension(250,0));
		blocSyllabus.setLayout(new BorderLayout());
		blocSyllabus.setBackground(Color.WHITE);
		JLabel titreSyllabus = new JLabel("   Syllabus");
		titreSyllabus.setFont(new Font("Gill Sans MT",Font.ROMAN_BASELINE,20));
		titreSyllabus.setForeground(Color.decode("#3752c3"));
		titreSyllabus.setOpaque(true);
		titreSyllabus.setBackground(Color.decode("#ffb401"));
		blocSyllabus.add(titreSyllabus,BorderLayout.NORTH);
		blocSyllabus.add(syllabusView,BorderLayout.CENTER);
		//
		competenceView = new CompetenceView(interfaceUtilisateur);
		navigationViewListener.setCompetenceView(competenceView);
		navigationViewListener.setDomaine();
		competenceView.cellSelectionDomaine.addListSelectionListener(navigationViewListener.getDomaineTableListener(competenceView.tableauDomaine));
		setZoomPlusListener(navigationViewListener.getZoomPlusListener());
		setZoomMoinsListener(navigationViewListener.getZoomMoinsListener());
		//
		blocCompetences.setBackground(Color.WHITE);
		blocCompetences.setLayout(new BorderLayout());
		JLabel titreCompetences = new JLabel("   Compétences");
		titreCompetences.setFont(new Font("Gill Sans MT",Font.ROMAN_BASELINE,20));
		titreCompetences.setForeground(Color.decode("#ffb401"));
		titreCompetences.setOpaque(true);
		titreCompetences.setBackground(Color.decode("#3752c3"));
		blocCompetences.add(titreCompetences,BorderLayout.NORTH);
		blocCompetences.add(competenceView,BorderLayout.CENTER);
		//
		detailView = new DetailView(interfaceUtilisateur);
		navigationViewListener.setDetailView(detailView);
		
		if(interfaceUtilisateur.utilisateurCourant.type.compareToIgnoreCase("inter")==0)
		{
			navigationViewListener.modifierDetailView();
		}
		//
		blocDetail.setLayout(new BorderLayout());
		blocDetail.setPreferredSize(new Dimension(0,200));
		blocDetail.setOpaque(false);
		JLabel titreDetail = new JLabel(" Détails");
		titreDetail.setFont(new Font("Gill Sans MT",Font.ROMAN_BASELINE,20));
		titreDetail.setForeground(Color.WHITE);
		titreDetail.setOpaque(true);
		titreDetail.setBackground(Color.BLACK);
		blocDetail.add(titreDetail,BorderLayout.NORTH);
		blocDetail.add(detailView,BorderLayout.CENTER);
		//
		bloc.setLayout(new BorderLayout());
		bloc.add(blocEntete,BorderLayout.NORTH);
		bloc.add(blocSyllabus,BorderLayout.WEST);
		bloc.add(blocCompetences,BorderLayout.CENTER);
		bloc.add(blocDetail, BorderLayout.SOUTH);
		bloc.setOpaque(false);
		
		//Paramètrage de la vue
		this.setOpaque(false);
		this.setVisible(true);
		
		//Agencement de la vue
		this.setLayout(new BorderLayout());
		this.add(bloc,BorderLayout.CENTER);
	}
	
	public NavigationView(Interface interfaceUtilisateur,Diplome diplome){
		this.interfaceUtilisateur = interfaceUtilisateur;
		this.diplomeCourant = diplome;
		this.init();
	}
	
	public NavigationView(Interface interfaceUtilisateur,Diplome diplome,Promotion promotion){
		this.interfaceUtilisateur = interfaceUtilisateur;
		this.diplomeCourant = diplome;
		this.promotionCourante = promotion;
		this.init();
	}
	
	public void setActionListener(ActionListener apl){
		this.clickButton.addActionListener(apl);
	}
	
	public void setNavigationViewListener(NavigationViewListener nvl)
	{
		navigationViewListener = nvl;
	}
	
	public NavigationViewListener getNavigationViewListener()
	{
		return navigationViewListener;
	}
	
	public void setZoomPlusListener(ActionListener actionListener){
		zoomPlusButton.addActionListener(actionListener);
	}
	public void setZoomMoinsListener(ActionListener actionListener){
		zoomMoinsButton.addActionListener(actionListener);
	}

}
