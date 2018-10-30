package com.michael.calculator.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ProgrammerCalculator extends JFrame {

	JPanel panel = new JPanel();
	JTextField mainDisplay = new JTextField();
	JButton calcButton = new JButton("Calculate!");
	
	private int num = 0;
	
	public static void main(String[] args) {
		ProgrammerCalculator proCalc = new ProgrammerCalculator();

	}
	
	ProgrammerCalculator() {
		setTitle("Programmer Calculator");
		setSize(600, 200);
		
		panel.setLayout(new GridLayout(2, 2));
		
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		createInterface();
	}

	void createInterface() {
		mainDisplay.setBackground(new Color(0.8f, 0.8f, 0.8f));
		mainDisplay.setOpaque(true);
		mainDisplay.setFont(new Font("", 5, 35));
		panel.add(mainDisplay);
		
		calcButton.setFont(new Font("", 5, 35));
		calcButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				buttonPressed(calcButton);
				
			}
		});
		panel.add(calcButton);

		getContentPane().add(panel);
	}
	
	void buttonPressed(JButton sender) {
		try {
			int val = 0;
			String operator = null;
			String[] commands = mainDisplay.getText().split("\\s+");
			if(commands.length > 1) {
				for(int i = 0; i < commands.length; i++) {
					if(i == 0) val = Integer.parseInt(commands[i]);
					else {
						boolean op = false;
						for(String string : operators) if(commands[i].equals(string)) {
							operator = string;
							op = true;
						}
						if(!op) {
							     if(operator.equals("+")) val += Integer.parseInt(commands[i]);
							else if(operator.equals("-")) val -= Integer.parseInt(commands[i]);
							else if(operator.equals("*")) val *= Integer.parseInt(commands[i]);
							else if(operator.equals("/")) val /= Integer.parseInt(commands[i]);
							else if(operator.equals("%")) val %= Integer.parseInt(commands[i]);
						}
					}
				}
				mainDisplay.setText(Integer.toString(val));
			}
		} catch(Exception e) {
			mainDisplay.setText(e.getMessage());
		}
	}
}
