package com.m2stice.graphics;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


/**
*  DatabaseInfoView - Classe pour mettre à jour les infos de connexion de la base de donnée
*
* @version 1.0
*
* @author ASDRUBAL & NERES
* @copyright (C) Master 2 2015
* @date 15/12/2015
*/
public class DatabaseInfoView extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 971L;
	
	private Interface interfaceUtilisateur;
	private JPanel acces;
   
    private JHintTextField username = null;
    private JHintTextField server = null;
    private JHintTextField databaseName = null;
    private JHintPasswordField password = null;
   
    public JButton valide;
    
    private Properties propriete = new Properties();
    OutputStream output = null;
    
	public DatabaseInfoView(Interface interfaceUtilisateur) {
		this.interfaceUtilisateur = interfaceUtilisateur;
		this.init();
	}

	public void init(){

		 acces = new JPanel();
		 this.setOpaque(false);
		 this.setVisible(true);
		 
		 acces.setLayout(new GridLayout(12,1));
		 JLabel userName = new JLabel("Nom d'utilisateur:");
		 acces.add(userName);
		 acces.add(getJtextUserName());
		 JLabel passwordLab = new JLabel("Mot de Passe:");
		 acces.add(passwordLab);
		 acces.add(getJtextPassword());
		 JLabel serverName = new JLabel("Server:");
		 acces.add(serverName);
		 acces.add(getJtextServer());
		 JLabel database = new JLabel("Nom de la base :");
		 acces.add(database);
		 acces.add(getJtextDatabase());
		 acces.add(getButton());
		 
		 this.add(acces);
	}
	
	private JTextField getJtextDatabase() {
		if(databaseName == null){
			databaseName = new JHintTextField("Nom base de donnée");
			databaseName.setSize(new Dimension(300, 35));
			databaseName.setHorizontalAlignment(JTextField.CENTER);
		}
		return databaseName;
	}
	
	private JTextField getJtextServer() {
		if(server == null){
			server = new JHintTextField("serverName");
			server.setSize(new Dimension(300, 35));
			server.setHorizontalAlignment(JTextField.CENTER);
		}
		return server;
	}
	
	private JPasswordField getJtextPassword() {
		   if(password == null){
				password = new JHintPasswordField("Mot de passe");
				password.setSize(new Dimension(300, 35));
				password.setHorizontalAlignment(JTextField.CENTER);
			}
		   return password;
	}
	
	private JTextField getJtextUserName() {
			if(username == null){
				username = new JHintTextField("userName");
				username.setSize(new Dimension(300, 35));
				username.setHorizontalAlignment(JTextField.CENTER);
			}
			return username;
	}
	   
	private JButton getButton() {
		if(valide == null){
			valide = new JButton();
			valide.setFont(new Font("Dialog", Font.PLAIN, 14));
			valide.setSize(new Dimension(120, 40));
			valide.setText("Valider");
		}
		valide.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				System.out.println("[Log-DATABASE_INFO]: Informations saisies");
				System.out.println("Nom d'utilisateur: "+username.getText());
				System.out.println("Mot de passe: "+String.valueOf(password.getPassword()));
				System.out.println("Serveur: "+server.getText());
				System.out.println("Nom de la base: "+databaseName.getText());
				try {
					output = new FileOutputStream("../res/config.db");
					propriete.setProperty("username", username.getText());
					propriete.setProperty("password", String.valueOf(password.getPassword()));
					propriete.setProperty("server", server.getText());
					propriete.setProperty("databaseName",databaseName.getText());
					try {
						propriete.store(output, null);
					} catch (IOException e1) {
						e1.printStackTrace();
					}finally {
						if(output != null){
							try {
								output.close();
							} catch (IOException e1) {
								e1.printStackTrace();
							}
						}
					}
					System.out.println("[Log-DATABASE_INFO]: Le fichier \"res/config.db\" a été généré.");
					interfaceUtilisateur.stop();
					interfaceUtilisateur.start();
				} catch (FileNotFoundException e1) {
					System.err.println("[Log-DATABASE_INFO]: Le fichier \"res/config.db\" n'a pas pu être généré.");
					e1.printStackTrace();
				}
			}
		});
		
		return valide;
	}
}
