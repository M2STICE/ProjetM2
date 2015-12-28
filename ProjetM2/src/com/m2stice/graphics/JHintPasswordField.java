package com.m2stice.graphics;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.BorderFactory;
import javax.swing.JPasswordField;

public class JHintPasswordField extends JPasswordField{

	/**
	 * Numéro de série
	 */
	private static final long serialVersionUID = 971L;
	
	private String hintPassword;
	
	public JHintPasswordField() {
		
	}
	
	public JHintPasswordField(String hintPassword) {
		this.setHintPassword(hintPassword);
	}

	/**
	 * @param hintPassword the hintPassword to set
	 */
	public void setHintPassword(String hintPassword) {
		this.hintPassword = hintPassword;
		setText(hintPassword);
		setFont(new Font("Gill Sans MT",Font.ITALIC, 18));
		setForeground(Color.LIGHT_GRAY);
		setBorder(null);
		setFocus();
	}
	
	private void setFocus(){
		char defaut_char = getEchoChar();
		setEchoChar('\0');
		this.addFocusListener(new FocusListener(){

			@Override
			public void focusGained(FocusEvent arg0) {
				setEchoChar(defaut_char);
				setText("");
				setFont(new Font("Gill Sans MT", Font.ROMAN_BASELINE,18));
				setForeground(Color.BLACK);
				setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
			}

			@Override
			public void focusLost(FocusEvent arg0) {
				if(String.valueOf(getPassword()).length()==0){
					setEchoChar('\0');
					setText(hintPassword);
					setFont(new Font("Gill Sans MT",Font.ITALIC, 18));
					setForeground(Color.LIGHT_GRAY);
				}
				setBorder(null);
			}
		});
	}
	

}
