package com.example.trylma.client;

import com.example.trylma.model.Game;
import com.example.trylma.model.Peg;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
	 * EndTrun's button and the board and MouseListener.
	 */
	private void initialize() {
		setLayout(null);
		setBackground(Color.LIGHT_GRAY);
		
		JButton endTurnButton = new JButton("End Turn");
		endTurnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		endTurnButton.setBounds(320, 20, 100, 30);
		add(endTurnButton);

		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				whenMouseClicked(e);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				whenMousePressed(e);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				whenMouseReleased(e);
			}
		});
	}


	public void paint(Graphics graphics) {
		super.paint(graphics);
		board.doDraw(graphics);
	}

	private void whenMouseClicked(MouseEvent e){
		/*for(int i=0; i<17; i++) {
			for(int j=0; j<13; j++) {
				Peg p = board.getPeg(i,j);
				if(p.isClicked(e.getX(),e.getY()) == true){
					System.out.println(i + " " + j + "kilikety" );
				}
			}
		}*/
		System.out.println(e.getX());
		System.out.println(e.getY());
	}

	private void whenMouseReleased(MouseEvent e){ }

	private void whenMousePressed(MouseEvent e){ }
}
