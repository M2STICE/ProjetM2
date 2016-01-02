package com.m2stice.graphics;

import java.awt.Color;
import java.util.LinkedList;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.Component;

/**
 * JTableCodeCouleur - Classe qui permet d'afficher les couleurs dans le JTable.
 * @author Didier
 * @version 1.0
 * @copyright (C) Master 2 2015
 * @date 01/01/2016
 *
 */

public class JTableCodeCouleur extends DefaultTableCellRenderer {

	/**
	 * Numéro de série
	 */
	private static final long serialVersionUID = 971L;
	public LinkedList<String> liste;
	public JTableCodeCouleur(LinkedList<String> l)
	{
		liste=l;
	}
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        for(int i = 0, taille = table.getColumnCount(); i< taille; i++){
        	Object o = table.getValueAt(row, i);
        	if (o != null && component instanceof JLabel) {
                JLabel label = (JLabel) component;
                for(int cpt = 0; cpt <liste.size(); cpt++)
                {
                	String tab[]= liste.get(cpt).split(";");
                	int codeCouleur = Integer.parseInt(tab[1]);
                	if(tab.length == 3)
                	{
	                	if(label.getText().contains(tab[2]))
	                	{
	                		if(codeCouleur == 1)
	                		{
	                            component.setBackground(Color.decode("#ff4d4d"));
	                		}
	                		if(codeCouleur == 2)
	                		{
	                            component.setBackground(Color.decode("#ff9999"));
	                		}
	                		if(codeCouleur == 3)
	                		{
	                            component.setBackground(Color.decode("#ffb84d"));
	                		}
	                		if(codeCouleur == 4)
	                		{
	                            component.setBackground(Color.decode("#ffcc66"));
	                		}
	                		if(codeCouleur == 5)
	                		{
	                            component.setBackground(Color.decode("#99e599"));
	                		}
	                	}
                	}
                }
        	}
        }
        return component;
    }
}
