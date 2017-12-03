package com.example.trylma.client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Panel extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create a JPanel.
	 */
	public Panel() {
		initialize();
	}
	
	/**
	 * Initialize the contents of the frame, which includes 
	 * EndTrun's button and the board.
	 */
	private void initialize() {
		setLayout(null);
		
		JButton endTurnButton = new JButton("End Turn");
		endTurnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		endTurnButton.setBounds(500, 30, 100, 30);
		add(endTurnButton);
	}
}
