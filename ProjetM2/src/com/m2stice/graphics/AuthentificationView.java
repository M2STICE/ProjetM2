package com.m2stice.graphics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;

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
	
	private JTextField jtIdentifiant;
	private JPasswordField jpMotdepasse;
	private JButton btnValider;
	private JComboBox<String> jcUtilisateur;
	private Interface interfaceUtilisateur;	
	private JPasswordField jpDefaut = new JPasswordField();
	private Border border_defaut = jpDefaut.getBorder();
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
		
		Border border = BorderFactory.createLineBorder(Color.BLACK,2);
		if(jtIdentifiant == null){
		 	
			Color placeholder = new Color(160,160,160);
			String defaut = "Identifiant";
			
			jtIdentifiant = new JTextField();
			jtIdentifiant.setSize(new Dimension(250, 35));
			jtIdentifiant.setBackground(new Color(255, 255, 255));
			jtIdentifiant.setHorizontalAlignment(JTextField.CENTER);
			jtIdentifiant.setText(defaut);
			jtIdentifiant.setFont(new Font("TimesRoman",Font.ITALIC, 15));
			jtIdentifiant.setForeground(placeholder);
			
			jtIdentifiant.addFocusListener(new FocusListener(){

				@Override
				public void focusGained(FocusEvent arg0) {
					jtIdentifiant.setText("");
					jtIdentifiant.setFont(new Font("TimesRoman", Font.PLAIN, 15));
					jtIdentifiant.setForeground(new Color(0,0,0));
					jtIdentifiant.setBorder(border);
				}

				@Override
				public void focusLost(FocusEvent arg0) {
					if(jtIdentifiant.getText().trim().length()==0){
						jtIdentifiant.setText(defaut);
						jtIdentifiant.setFont(new Font("TimesRoman",Font.ITALIC, 15));
						jtIdentifiant.setForeground(placeholder);
						
					}
					jtIdentifiant.setBorder(border_defaut);
					
				}
				
			});
		}
		return jtIdentifiant;
	}
	
	private JPasswordField getjtmotdepasse(){
		
		Color placeholder = new Color(160,160,160);
		String defaut = "Mot de passe";
		Border border = BorderFactory.createLineBorder(Color.BLACK,2);
		
		if(jpMotdepasse == null){
		 	
			jpMotdepasse = new JPasswordField();
			jpMotdepasse.setSize(new Dimension(250, 35));
			jpMotdepasse.setBackground(new Color(255, 255, 255));
			jpMotdepasse.setHorizontalAlignment(JTextField.CENTER);
			jpMotdepasse.setText(defaut);
			jpMotdepasse.setFont(new Font("TimesRoman",Font.ITALIC, 15));
			jpMotdepasse.setForeground(placeholder);
		}
		char defaut_char = jpMotdepasse.getEchoChar();
		jpMotdepasse.setEchoChar('\0');
		jpMotdepasse.addFocusListener(new FocusListener(){

			@Override
			public void focusGained(FocusEvent arg0) {
				jpMotdepasse.setEchoChar(defaut_char);
				jpMotdepasse.setText("");
				jpMotdepasse.setFont(new Font("TimesRoman", Font.PLAIN, 15));
				jpMotdepasse.setForeground(new Color(0,0,0));
				jpMotdepasse.setBorder(border);
			}

			@Override
			public void focusLost(FocusEvent arg0) {
				if(jpMotdepasse.getPassword().toString().trim().length()==0){
					jpMotdepasse.setEchoChar('\0');
					jpMotdepasse.setText(defaut);
					jpMotdepasse.setFont(new Font("TimesRoman",Font.ITALIC, 15));
					jpMotdepasse.setForeground(placeholder);
				}
				jpMotdepasse.setBorder(border_defaut);
			}
		});
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
