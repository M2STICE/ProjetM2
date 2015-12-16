package com.m2stice.graphics;

import javax.swing.JTable;

public class JTableNotEditable extends JTable {
 
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

