package com.m2stice.graphics;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.m2stice.controller.NavigationViewListener;
import com.m2stice.model.Competence;
import com.m2stice.model.Diplome;
import com.m2stice.model.Domaine;
import com.m2stice.model.Ec;
import com.m2stice.model.Item;
import com.m2stice.model.SousItem;
import com.m2stice.model.Ue;
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
	private JPanel blocSyllabus = new JPanel();			//Bloc qui contient l'arborescence syllabus
	private JPanel blocCompetences = new JPanel();		//Bloc qui contient l'arborescence des compétences
	private SyllabusView syllabusView;
	private CompetenceView competenceView;
	private JButton clickButton = new JButton();
	private JButton zoomPlusButton = new JButton();
	private JButton zoomMoinsButton = new JButton();
	private BanniereComponent banniere;					//Bannière de la fenêtre
	private NavigationViewListener navigationViewListener;
	
	public Diplome diplomeCourant;
	public Domaine domaineCourant;
	public Competence competenceCourante;
	public Ue ueCourante;
	public Ec ecCourant;
	public SousItem sousItemCourant;
	public Item itemCourant;
	
	
	public void init(){
		
		navigationViewListener = new NavigationViewListener(interfaceUtilisateur, this);
		
		//Paramètrage des composants
		//
		banniere = new BanniereComponent(interfaceUtilisateur,"ResultatViewBanniere.jpg");
		banniere.setPreferredSize(new Dimension(1024,69));
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
		blocCommande.add(Box.createVerticalBox());
		blocCommande.add(Box.createVerticalBox());
		blocCommande.add(Box.createVerticalBox());
		blocCommande.add(clickButton);
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
		bloc.setLayout(new BorderLayout());
		bloc.add(blocEntete,BorderLayout.NORTH);
		bloc.add(blocSyllabus,BorderLayout.WEST);
		bloc.add(blocCompetences,BorderLayout.CENTER);
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
	
	public void setActionListener(ActionListener apl){
		this.clickButton.addActionListener(apl);
	}

}
