package com.example.trylma.client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

class Frame extends JFrame {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the application.
	 */
	public Frame() {
		super("Chinese checkers");
		initialize();
	}

	/**
	 * Initialize the contents of the frame, which includes:
	 * two menu buttons and panel with EndTrun's button
	 */
	private void initialize() {
		setBounds(100, 100, 700, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		
		/**
		 * Creating the "New Game" button, which gives an opportunity 
		 * to choose the number of players.
		 */
		JButton newGameButton = new JButton("New Game");
		newGameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object[] possibilities = {"2", "3", "4", "6"};
				String s = (String)JOptionPane.showInputDialog(
				                    null,
				                    "Choose the number of players:\n",
				                    "Number of players",
				                    JOptionPane.PLAIN_MESSAGE,
				                    null,
				                    possibilities,
				                    "2");
				
				if ((s != null) && (s.length() > 0)) {
					return;
				}
			}
		});
		newGameButton.setBounds(0, 0, 100, 30);
		add(newGameButton);
		
		/**
		 * Creating the "Help" button, which gives users basic information 
		 * about the application
		 */
		JButton helpGameButton = new JButton("Help");
		helpGameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Chinese checkers is a strategy board game of German origin,\n"
						+"which can be played by two, three, four, or six people.\n"
						+"The objective is to be first to race all of one's pieces across the hexagram-shaped board\n"
						+ "into the corner of the star opposite one's starting corner—using single-step moves\n"
						+ " or moves that jump over other pieces.\n", "Help", JOptionPane.INFORMATION_MESSAGE);	
			}
		});
		helpGameButton.setBounds(100, 0, 100, 30);
		add(helpGameButton);
		
		Panel panel = new Panel();
		add(panel);
	}
}

