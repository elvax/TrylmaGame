package com.example.trylma.client;

import com.example.trylma.model.Game;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Panel extends JPanel {

	private static final long serialVersionUID = 1L;

	//TODO usunac
	Game board = new Game();

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
		setBackground(Color.LIGHT_GRAY);
		
		JButton endTurnButton = new JButton("End Turn");
		endTurnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		endTurnButton.setBounds(500, 30, 100, 30);
		add(endTurnButton);


	}


	public void paint(Graphics graphics) {
		super.paint(graphics);
		board.doDraw(graphics);
	}
}
