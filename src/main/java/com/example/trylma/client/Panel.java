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
import java.util.List;

public class Panel extends JPanel {

	private static final long serialVersionUID = 1L;

	//TODO usunac
	Game board = new Game();
	public Peg p;
	public Peg pp;
	public List<Peg> list;
	boolean active=false;

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
		/*board.fillSectorOne();
		board.fillSectorTwo();
		board.fillSectorThree();
		board.fillSectorFour();
		board.fillSectorFive();
		board.fillSectorSix();*/
		//System.out.println(e.getX());
		//System.out.println(e.getY());
	}

	private void whenMouseReleased(MouseEvent e){
		/*if(active) {
			int i = e.getX();
			int j = e.getY();
			//System.out.println(e.getX() + " " + i);
			//System.out.println(e.getY() + " " + j);
			board.move(pp, i, j, list);
			repaint();
		}*/
	}

	private void whenMousePressed(MouseEvent e){
		/*for(int i=0; i<17; i++) {
			for(int j=0; j<13; j++) {
				p = board.getPeg(i,j);
				if(p.isClicked(e.getX(),e.getY()) == true){
					//System.out.println(i + " " + j + "klikniety");
					pp = p;
					active = true;
					list = board.findNeighbours(p);
					for(int y=0; y<list.size(); y++) {
						//System.out.println(list.get(y).geti() + " " + list.get(y).getj() + "sasiad");
					}
				}
			}
		}*/
	}
}
