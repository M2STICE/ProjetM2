package com.m2stice.graphics;

import java.awt.Color;
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
	private static final long serialVersionUID = 7287536978951691528L;
	
	private Interface interfaceUtilisateur;
	private JPanel acces;
   
    private JTextField username = null;
    private JTextField server = null;
    private JTextField databaseName = null;
    private JPasswordField password = null;
   
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
			Color placeholder = new Color(160,160,160);
			String defaut = "Nom base de donnée";
			
			databaseName = new JTextField();
			databaseName.setSize(new Dimension(250, 35));
			databaseName.setBackground(new Color(255, 255, 255));
			databaseName.setHorizontalAlignment(JTextField.CENTER);
			databaseName.setText(defaut);
			databaseName.setFont(new Font("TimesRoman",Font.ITALIC, 15));
			databaseName.setForeground(placeholder);
		}
		return databaseName;
	}
	
	private JTextField getJtextServer() {
		if(server == null){
			Color placeholder = new Color(160,160,160);
			String defaut = "serverName";
			
			server = new JTextField();
			server.setSize(new Dimension(250, 35));
			server.setBackground(new Color(255, 255, 255));
			server.setHorizontalAlignment(JTextField.CENTER);
			server.setText(defaut);
			server.setFont(new Font("TimesRoman",Font.ITALIC, 15));
			server.setForeground(placeholder);
		}
		return server;
	}
	
	private JPasswordField getJtextPassword() {
		   if(password == null){
			   	Color placeholder = new Color(160,160,160);
				String defaut = "Mot de passe";
				
				password = new JPasswordField();
				password.setSize(new Dimension(250, 35));
				password.setBackground(new Color(255, 255, 255));
				password.setHorizontalAlignment(JTextField.CENTER);
				password.setText(defaut);
				password.setFont(new Font("TimesRoman",Font.ITALIC, 15));
				password.setForeground(placeholder);
			}
		   return password;
	}
	
	private JTextField getJtextUserName() {
		
			if(username == null){
				Color placeholder = new Color(160,160,160);
				String defaut = "userName";
				
				username = new JTextField();
				username.setSize(new Dimension(250, 35));
				username.setBackground(new Color(255, 255, 255));
				username.setHorizontalAlignment(JTextField.CENTER);
				username.setText(defaut);
				username.setFont(new Font("TimesRoman",Font.ITALIC, 15));
				username.setForeground(placeholder);
			}
			return username;
			
	}
	   
	private JButton getButton() {
		if(valide == null)
		{
			valide = new JButton();
			valide.setFont(new Font("Dialog", Font.PLAIN, 14));
			valide.setSize(new Dimension(120, 40));
			valide.setText("Valider");
		}
		valide.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				System.out.println(username.getText());
				System.out.println(password.getText());
				System.out.println(server.getText());
				System.out.println(databaseName.getText());
				try {
					output = new FileOutputStream("config.db");
					propriete.setProperty("username", username.getText());
					propriete.setProperty("password", password.getText());
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
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		return valide;
	}
}
