package com.m2stice.graphics;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

/**
 * BannièreComponent - Classe qui permet de générer une bannière
 * @author BIABIANY
 * @date 25/11/2015
 * @copyright (C) Master 2 2015
 */
public class BanniereComponent extends JPanel{
	
	/**
	 * Numéro de série
	 */
	private static final long serialVersionUID = 971L;
	
	private Interface iu;					//Le lien avec l'interface utilisateur
	private String nomImageFond;			//Le nom de l'image en fond de bannière
	
	/**
	 * Constructeur par defaut
	 */
	public BanniereComponent(){
		this.setOpaque(false);
	}
	
	/**
	 * Constructeur de la classe
	 * @param L'interface utilisateur et nom de l'image de fond
	 */
	public BanniereComponent(Interface iu, String nomImageFond){
		this.setMinimumSize(new Dimension(1024,69));
		this.iu = iu;
		this.nomImageFond = nomImageFond;
		this.setOpaque(false);
	}
	
	/**
	 * Genère le composant graphique
	 * @param Le context graphique
	 */
	public void paint(Graphics g){
		g.drawImage(iu.loadImage(nomImageFond), 0, 0,(int)getBounds().getWidth(), (int)getBounds().getHeight(), this);
		super.paint(g);
	}
}
