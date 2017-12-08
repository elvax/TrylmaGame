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
		
		JButton endTurnButton = new JButton("End Turn");
		endTurnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		endTurnButton.setBounds(500, 30, 100, 30);
		add(endTurnButton);

		//do wyrzucenia w przyszlosci obrazuje jedynie przezroczystosc ikon :D 
		ImageIcon icon = new ImageIcon("src/main/resources/r.png");
		JLabel label = new JLabel();
		label.setBounds(200, 20, 35, 35);
		label.setIcon(icon);
		add(label);
		ImageIcon icon2 = new ImageIcon("src/main/resources/y.png");
		JLabel label2 = new JLabel();
		label2.setBounds(200+35, 20, 35, 35);
		label2.setIcon(icon2);
		add(label2);
		ImageIcon icon3 = new ImageIcon("src/main/resources/g.png");
		JLabel label3 = new JLabel();
		label3.setBounds(200+70, 20, 35, 35);
		label3.setIcon(icon3);
		add(label3);
		ImageIcon icon4 = new ImageIcon("src/main/resources/p.png");
		JLabel label4 = new JLabel();
		label4.setBounds(200+105, 20, 35, 35);
		label4.setIcon(icon4);
		add(label4);

	}


	public void paint(Graphics graphics) {
		super.paint(graphics);
		board.doDraw(graphics);
	}
}
