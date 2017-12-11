package com.example.trylma.client;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

class Frame extends JFrame {

	private static final long serialVersionUID = 1L;
	private final int X_SIZE = 700;
	private final int Y_SIZE = 700;

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
		setSize(X_SIZE, Y_SIZE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(true);
		
		/**
		 * Creating the "New Game" item, which gives an opportunity 
		 * to choose the number of players.
		 */
		JMenuBar menubar = new JMenuBar();
		JMenuItem newGameButton = new JMenuItem("New Game");
		newGameButton.setBackground(new Color(204, 204, 204));
		newGameButton.setMnemonic(KeyEvent.VK_E);
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
		menubar.add(newGameButton);
		
		/**
		 * Creating the "Help" item, which gives users basic information 
		 * about the application
		 */
		 
		JMenuItem helpGameButton = new JMenuItem("Help");
		helpGameButton.setMnemonic(KeyEvent.VK_E);
		helpGameButton.setBackground(new Color(204, 204, 204));
		helpGameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Chinese checkers is a strategy board game of German origin,\n"
						+"which can be played by two, three, four, or six people.\n"
						+"The objective is to be first to race all of one's pieces across the hexagram-shaped board\n"
						+ "into the corner of the star opposite one's starting corner�using single-step moves\n"
						+ " or moves that jump over other pieces.\n", "Help", JOptionPane.INFORMATION_MESSAGE);	
			}
		});
		menubar.add(helpGameButton);
		menubar.add(Box.createHorizontalGlue());
        menubar.add(Box.createHorizontalGlue());
        menubar.add(Box.createHorizontalGlue());
        menubar.add(Box.createHorizontalGlue());
        setJMenuBar(menubar);
		
		Panel panel = new Panel();
		add(panel);
	}
}

