package com.m2stice.graphics;

import javax.swing.JTable;


/**
 * JTableNotEditable - Classe qui permet de personnalisé la classe JTable.
 * @author Didier
 * @version 1.0
 * @copyright (C) Master 2 2015
 * @date 11/12/2015
 * @notes Elle va créer l'interface utilisateur.
 * @revision 21/12/2015
 * Emmanuel
 */
public class JTableNotEditable extends JTable {
 
	/**
	 * Numéro de série
	 */
	private static final long serialVersionUID = 971L;

	public JTableNotEditable(Object[][] data, String[] title) {
		// TODO Auto-generated constructor stub
		super(data,title);
	}
	
	public JTableNotEditable()
	{
		super();
	}

	public boolean isCellEditable(int row, int col){
		return false;
	}
}

