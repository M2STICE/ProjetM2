package com.m2stice.graphics;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

import javax.swing.ImageIcon;
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
	
	private JPanel bloc;
	private JPanel blocEntete;
	private BanniereComponent bannière;
	private JPanel acces;
	private JLabel titreParametre;
    private JHintTextField username = null;
    private JHintTextField server = null;
    private JHintTextField databaseName = null;
    private JHintPasswordField password = null;
    public JButton valide;
    
    private boolean active = false;
    
    private Properties propriete = new Properties();
    OutputStream output = null;
    
	public DatabaseInfoView(Interface interfaceUtilisateur) {
		this.interfaceUtilisateur = interfaceUtilisateur;
		this.init();
	}

	public void init(){
		this.bloc = new JPanel();
		this.blocEntete = new JPanel();
		this.titreParametre = new JLabel("Paramètres");
		this.bannière = new BanniereComponent(interfaceUtilisateur, "ResultatViewBanniere.jpg");
		this.acces = new JPanel();
		
		this.setLayout(new BorderLayout());
		this.bloc.setLayout(new BorderLayout());
		this.blocEntete.setLayout(new BorderLayout());
		
		//Paramétrage des composants
		//
		bannière.setPreferredSize(new Dimension(1024,69));
		//
		titreParametre.setIcon(new ImageIcon(interfaceUtilisateur.loadImage("ParametrageIcon.png")));
		titreParametre.setFont(new Font("Gill Sans MT",Font.BOLD,30));
		//
		blocEntete.setPreferredSize(new Dimension(1024,120));
		//
		bloc.setOpaque(false);
		//
		acces.setPreferredSize(new Dimension(500,400));
		acces.setOpaque(false);
		 
		 this.setOpaque(false);
		 this.setVisible(true);
		 
		 acces.setLayout(new FlowLayout(FlowLayout.LEADING));
		 JLabel userName = new JLabel("Nom d'utilisateur:");
		 userName.setPreferredSize(new Dimension(1024,15));
		 userName.setForeground(Color.decode("#ffb401"));
		 userName.setFont(new Font("Gill Sans MT",Font.BOLD,18));
		 acces.add(userName);
		 acces.add(getJtextUserName());
		 JLabel passwordLab = new JLabel("Mot de Passe:");
		 passwordLab.setPreferredSize(new Dimension(1024,15));
		 passwordLab.setForeground(Color.decode("#ffb401"));
		 passwordLab.setFont(new Font("Gill Sans MT",Font.BOLD,18));
		 acces.add(passwordLab);
		 acces.add(getJtextPassword());
		 JLabel serverName = new JLabel("Serveur:");
		 serverName.setPreferredSize(new Dimension(1024,15));
		 serverName.setForeground(Color.decode("#66a8da"));
		 serverName.setFont(new Font("Gill Sans MT",Font.BOLD,18));
		 acces.add(serverName);
		 acces.add(getJtextServer());
		 JLabel database = new JLabel("Nom de la base :");
		 database.setForeground(Color.decode("#66a8da"));
		 database.setPreferredSize(new Dimension(1024,15));
		 database.setFont(new Font("Gill Sans MT",Font.BOLD,18));
		 acces.add(database);
		 acces.add(getJtextDatabase());
		 
		 this.blocEntete.add(bannière,BorderLayout.NORTH);
		 this.blocEntete.add(titreParametre,BorderLayout.CENTER);
		 this.bloc.add(blocEntete, BorderLayout.NORTH);
		 this.bloc.add(acces,BorderLayout.CENTER);
		 this.bloc.add(getButton(),BorderLayout.SOUTH);
		 this.add(bloc,BorderLayout.CENTER);
	}
	
	private JTextField getJtextDatabase() {
		if(databaseName == null){
			databaseName = new JHintTextField("nom_base..");
			databaseName.setPreferredSize(new Dimension(300, 30));
			databaseName.setHorizontalAlignment(JTextField.CENTER);
		}
		return databaseName;
	}
	
	private JTextField getJtextServer() {
		if(server == null){
			server = new JHintTextField("mysql.serveur.com ou localhost");
			server.setPreferredSize(new Dimension(300, 30));
			server.setHorizontalAlignment(JTextField.CENTER);
		}
		return server;
	}
	
	private JPasswordField getJtextPassword() {
		   if(password == null){
				password = new JHintPasswordField("mot_de_passe..");
				password.setPreferredSize(new Dimension(300, 30));
				password.setHorizontalAlignment(JTextField.CENTER);
			}
		   return password;
	}
	
	private JTextField getJtextUserName() {
			if(username == null){
				username = new JHintTextField("nom_utilisateur..");
				username.setPreferredSize(new Dimension(300, 30));
				username.setHorizontalAlignment(JTextField.CENTER);
			}
			return username;
	}
	   
	private JButton getButton() {
		if(valide == null){
			valide = new JButton();
			valide.setFont(new Font("Gill Sans MT", Font.BOLD,40));
			valide.setForeground(Color.WHITE);
			valide.setBackground(Color.BLACK);
			valide.setPreferredSize(new Dimension(0,50));
			valide.setBorder(null);
			valide.setText("Valider");
			valide.addMouseListener(new MouseListener() {
				
				@Override
				public void mouseReleased(MouseEvent arg0) {
					
				}
				
				@Override
				public void mousePressed(MouseEvent arg0) {
					
				}
				
				@Override
				public void mouseExited(MouseEvent arg0) {
					if(!active){
						valide.setForeground(Color.WHITE);
						valide.setBackground(Color.BLACK);
					}
				}
				
				@Override
				public void mouseEntered(MouseEvent arg0) {
					if(!active){
						valide.setForeground(Color.BLACK);
						valide.setBackground(Color.WHITE);
					}
				}
				
				@Override
				public void mouseClicked(MouseEvent arg0) {
					
					
				}
			});
		}
		valide.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Thread th = new Thread(){
					public void run(){
						active = true;
						valide.setText("Chargement...");
						setBackground(Color.WHITE);
						System.out.println("[Log-DATABASE_INFO]: Informations saisies");
						System.out.println("Nom d'utilisateur: "+username.getText());
						System.out.println("Mot de passe: "+String.valueOf(password.getPassword()));
						System.out.println("Serveur: "+server.getText());
						System.out.println("Nom de la base: "+databaseName.getText());
						
						if(!username.isEmpty()&&!String.valueOf(password.getPassword()).isEmpty()&&!server.isEmpty()&&!databaseName.isEmpty()){
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
								valide.setForeground(Color.decode("#70db70"));
								valide.setBackground(Color.WHITE);
								valide.setText("Correct");
								restart();
							} catch (FileNotFoundException e1) {
								System.err.println("[Log-DATABASE_INFO]: Le fichier \"res/config.db\" n'a pas pu être généré.");
								e1.printStackTrace();
							}
						}
						else{
							valide.setText("Informations manquantes..");
							valide.setForeground(Color.decode("#ff4d4d"));
							valide.setBackground(Color.WHITE);
						}
					}
				};
				th.start();
			}
		});
		return valide;
	}
	
	private void restart(){
		Thread th = new Thread(){
			public void run(){
				try{
					Thread.sleep(1500);
				}
				catch(Exception e){}
				interfaceUtilisateur.stop();
				interfaceUtilisateur.removeAll();
				interfaceUtilisateur.init();
				interfaceUtilisateur.start();
				interfaceUtilisateur.repaint();
			}
		};
		th.start();
	}
	
}
