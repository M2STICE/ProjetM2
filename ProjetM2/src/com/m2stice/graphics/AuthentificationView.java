package com.m2stice.graphics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

public class AuthentificationView extends JPanel{

	private JTextField jtIdentifiant = null;
	private JPasswordField jpMotdepasse = null;
	private JButton btnValider = null;
	private JComboBox jcUtilisateur;
	private Interface interfaceUtilisateur;	
	private JPasswordField JP = new JPasswordField();
	char defaut_char= JP.getEchoChar();
	Border border_defaut = JP.getBorder();
	private JPanel monJpanel = null;
	
	public void init()
	{
		monJpanel = new JPanel();
		monJpanel.setLayout(new GridLayout(7,1));
		monJpanel.add(getjtidentifiant());
		monJpanel.add(Box.createHorizontalGlue());
		monJpanel.add(getjtmotdepasse());
		monJpanel.add(Box.createHorizontalGlue());
		monJpanel.add(getjcquestion());
		monJpanel.add(Box.createHorizontalGlue());
		monJpanel.add(getbtnvalider());
		this.setLayout(new GridBagLayout());
		this.add(monJpanel);
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
			jtIdentifiant.setFont(new Font("TimesRoman",Font.ITALIC, 20));
			jtIdentifiant.setForeground(placeholder);
			
			
			jtIdentifiant.addFocusListener(new FocusListener(){

				@Override
				public void focusGained(FocusEvent arg0) {
					jtIdentifiant.setText("");
					jtIdentifiant.setFont(new Font("TimesRoman", Font.PLAIN, 20));
					jtIdentifiant.setForeground(new Color(0,0,0));
					jtIdentifiant.setBorder(border);
				}

				@Override
				public void focusLost(FocusEvent arg0) {
					if(jtIdentifiant.getText().trim().length()==0){
						
						jtIdentifiant.setText(defaut);
						jtIdentifiant.setFont(new Font("TimesRoman",Font.ITALIC, 20));
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
			jpMotdepasse.setFont(new Font("TimesRoman",Font.ITALIC, 20));
			jpMotdepasse.setForeground(placeholder);
		}
		char defaut_char = jpMotdepasse.getEchoChar();
		jpMotdepasse.setEchoChar('\0');
		jpMotdepasse.addFocusListener(new FocusListener(){

			@Override
			public void focusGained(FocusEvent arg0) {
				jpMotdepasse.setEchoChar(defaut_char);
				jpMotdepasse.setText("");
				jpMotdepasse.setFont(new Font("TimesRoman", Font.PLAIN, 25));
				jpMotdepasse.setForeground(new Color(0,0,0));
				jpMotdepasse.setBorder(border);
			}

			@Override
			public void focusLost(FocusEvent arg0) {
				if(jpMotdepasse.getText().trim().length()==0){
					
					jpMotdepasse.setEchoChar('\0');
					jpMotdepasse.setText(defaut);
					jpMotdepasse.setFont(new Font("TimesRoman",Font.ITALIC, 20));
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
		btnValider.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		return btnValider;
	}
	
	private JComboBox getjcquestion()
	{
		if(jcUtilisateur == null)
		{
			String[] tab = {"Admin", "Etudiant", "Enseignant"};
			jcUtilisateur = new JComboBox(tab);
			jcUtilisateur.setSelectedIndex(0);
			jcUtilisateur.setSize(new Dimension(450, 35));
			jcUtilisateur.setLocation(new Point(180, 185));
			jcUtilisateur.setBackground(new Color(255, 255, 255));
			jcUtilisateur.setFont(new Font("TimesRoman",Font.ITALIC, 20));
		}
		return jcUtilisateur;
	}
	
	
	
}
