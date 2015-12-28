package com.m2stice.graphics;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.BorderFactory;
import javax.swing.JTextField;

public class JHintTextField extends JTextField {
	/**
	 * Numéro de série
	 */
	private static final long serialVersionUID = 971L;
	
	private String hintText;
	private int textSize = 18;
	
	public JHintTextField() {
		
	}
	
	public JHintTextField(String hintText){
		this.hintText = hintText;
		setText(hintText);
		setForeground(Color.LIGHT_GRAY);
		setFont(new Font("Gill Sans MT",Font.ITALIC, textSize));
		setBorder(null);
		setFocus();
	}
	
	public void setHintText(String hintText){
		this.hintText = hintText;
		setText(hintText);
		setForeground(Color.LIGHT_GRAY);
		setFont(new Font("Gill Sans MT",Font.ITALIC, textSize));
		setBorder(null);
		setFocus();
	}
	
	public void setTextSize(int size){
		this.textSize = size;
	}
	
	private void setFocus(){
		this.addFocusListener(new FocusListener(){

			@Override
			public void focusGained(FocusEvent arg0) {
				setText("");
				setFont(new Font("Gill Sans MT", Font.ROMAN_BASELINE, textSize));
				setForeground(Color.BLACK);
				setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
			}

			@Override
			public void focusLost(FocusEvent arg0) {
				if(getText().trim().length()==0){
					setText(hintText);
					setFont(new Font("Gill Sans MT",Font.ITALIC, textSize));
					setForeground(Color.LIGHT_GRAY);
				}
				setBorder(null);
			}
			
		});
	}
	
	public boolean isEmpty(){
		return getText().isEmpty()||getText().trim().compareToIgnoreCase(hintText)==0;
	}

}
