package com.m2stice.graphics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Point;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.m2stice.controller.AuthentificationViewListener;
/**
 * AuthentificationView - Classe qui génère la vue d'authentification des utilisateurs.
 * @author Emmanuel & Didier
 * @version 1.0
 * @date 02/12/2015
 * @copyright (C) Master 2 2015
 */
public class AuthentificationView extends JPanel{

	/**
	 * Numéro de série
	 */
	private static final long serialVersionUID = 971L;
	
	private JHintTextField jtIdentifiant;
	private JHintPasswordField jpMotdepasse;
	private JButton btnValider;
	private JComboBox<String> jcUtilisateur;
	private Interface interfaceUtilisateur;
	private JPanel bloc = new JPanel();
	private AuthentificationViewListener authentificationViewListener;
	
	public void init(){
		//Paramètrage de la vue
		this.authentificationViewListener = new AuthentificationViewListener(interfaceUtilisateur, this);
		this.setOpaque(false);
		this.setVisible(true);
		
		//Paramètrage des composants de la vue
		bloc.setLayout(new GridLayout(7,1));
		bloc.add(getjtidentifiant());
		bloc.add(Box.createHorizontalGlue());
		bloc.add(getjtmotdepasse());
		bloc.add(Box.createHorizontalGlue());
		bloc.add(getjcquestion());
		bloc.add(Box.createHorizontalGlue());
		bloc.add(getbtnvalider());
		bloc.setOpaque(false);
		
		//Agencement de la vue
		this.setLayout(new GridBagLayout());
		this.add(bloc);
	}
	
	public AuthentificationView(Interface interfaceUtilisateur){
		this.interfaceUtilisateur = interfaceUtilisateur;
		this.init();
	}
	
	
	private JTextField getjtidentifiant(){
		if(jtIdentifiant == null){
			jtIdentifiant = new JHintTextField("Identifiant");
			jtIdentifiant.setSize(new Dimension(300, 35));
			jtIdentifiant.setHorizontalAlignment(JTextField.CENTER);
		}
		return jtIdentifiant;
	}
	
	private JPasswordField getjtmotdepasse(){
		if(jpMotdepasse == null){
			jpMotdepasse = new JHintPasswordField("Mot de passe");
			jpMotdepasse.setSize(new Dimension(300, 35));
			jpMotdepasse.setHorizontalAlignment(JTextField.CENTER);
		}
		return jpMotdepasse;
	}

	private JButton getbtnvalider(){
		
		if(btnValider == null)
		{
			btnValider = new JButton();
			btnValider.setFont(new Font("Dialog", Font.PLAIN, 14));
			btnValider.setSize(new Dimension(120, 40));
			btnValider.setText("Valider");
		}
		btnValider.addActionListener(authentificationViewListener.getValiderListener());
		
		return btnValider;
	}
	
	private JComboBox<String> getjcquestion()
	{
		if(jcUtilisateur == null)
		{
			String[] tab = {"Admin", "Etudiant", "Enseignant"};
			jcUtilisateur = new JComboBox<String>(tab);
			jcUtilisateur.setSelectedIndex(0);
			jcUtilisateur.setSize(new Dimension(450, 35));
			jcUtilisateur.setLocation(new Point(180, 185));
			jcUtilisateur.setBackground(new Color(255, 255, 255));
			jcUtilisateur.setFont(new Font("TimesRoman",Font.ITALIC, 15));
		}
		return jcUtilisateur;
	}
	
	/**
	 * Permet d'avoir le nom d'utilisateur
	 * @return le nom qu'a saisi l'utilisateur
	 */
	public String getNomUtilisateur(){
		return jtIdentifiant.getText();
	}
	
	/**
	 * Permet d'avoir le mot de passe
	 * @return le mot de passe qu'a saisi l'utilisateur
	 */
	public String getMotDePasse(){
		return new String(jpMotdepasse.getPassword());
	}
	
	/**
	 * 
	 * @return
	 */
	public String getUtilisateur(){
		return jcUtilisateur.getSelectedItem().toString();
	}
	
	/**
	 * Affiche le composant
	 * @param le paramétre graphique
	 */
	public void paint(Graphics g){
		g.drawImage(interfaceUtilisateur.loadImage("RechercheViewImage.jpg"), 0, 0,(int)getBounds().getWidth(), (int)getBounds().getHeight(), this);
		super.paint(g);
	}
	
}
