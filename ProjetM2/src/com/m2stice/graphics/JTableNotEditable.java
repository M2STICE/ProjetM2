package com.m2stice.graphics;

import javax.swing.JTable;


/**
 * JTableNotEditable - Classe qui permet de personnalise la classe JTable.
 * @author Didier
 * @version 1.0
 * @copyright (C) Master 2 2015
 * @date 11/12/2015
 * @notes Elle va creer l'interface utilisateur.
 * @revision 21/12/2015
 * Emmanuel
 */
public class JTableNotEditable extends JTable {
 
	/**
	 * Numero de serie
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

