package com.michael.calculator.main;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Yeeth extends JFrame {

	JPanel panel = new JPanel();
	
	public static void main(String[] args) {
		Yeeth yeeth = new Yeeth();

	}
	
	Yeeth() {
		setTitle("Calculator");
		setSize(480, 600);
		
		panel.setLayout(new GridLayout(4, 6));
		
		getContentPane().add(panel);
		
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

}
