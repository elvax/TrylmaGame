package com.example.trylma.model;

import java.awt.*;
import java.io.Serializable;

public class Board implements Serializable{
    public static int I_BOARD_SIZE = 17;
    public static int J_BOARD_SIZE = 13;
    public static final int DISTANCE_FROM_EDGES = 10;

    private AbstractPeg[][] board;

    public Board() {
        board = new AbstractPeg[I_BOARD_SIZE][J_BOARD_SIZE];
        initalizeBoard();
        setXYDraws();
    }

    /**
     * Fills board with Peg instances
     *  ++++++0++++++
     *  ++++++00+++++
     *  +++++000+++++
     *  +++++0000++++
     *  0000000000000
     *  +000000000000
     *  +00000000000+
     *  ++0000000000+
     *  ++000000000++
     *  ++0000000000+
     *  +00000000000+
     *  +000000000000
     *  0000000000000
     *  +++++0000++++
     *  +++++000+++++
     *  ++++++00+++++
     *  ++++++0++++++
     * Where 0 means "0" was passed to ownerId
     * and + means "-1" wass passed to sectorID
     * in constructor
     */
    private void initalizeBoard() {
        board = new Peg[I_BOARD_SIZE][J_BOARD_SIZE];

        int i = 0;
        for(int j=0; j<6; j++) { board[i][j]=new Peg(i,j,-1); }
        board[i][6] = new Peg(i, 6, 0);
        for(int j=7; j<13; j++) { board[i][j]=new Peg(i,j,-1); }

        i=1;
        for(int j=0; j<6; j++) { board[i][j]=new Peg(i,j,-1); }
        for(int j=6; j<8; j++) { board[i][j]=new Peg(i,j,0); }
        for(int j=8; j<13; j++) { board[i][j]=new Peg(i,j,-1); }

        i=2;
        for(int j=0; j<5; j++) { board[i][j]=new Peg(i,j,-1); }
        for(int j=5; j<8; j++) { board[i][j]=new Peg(i,j,0); }
        for(int j=8; j<13; j++) { board[i][j]=new Peg(i,j,-1); }

        i=3;
        for(int j=0; j<5; j++) { board[i][j]=new Peg(i,j,-1); }
        for(int j=5; j<9; j++) { board[i][j]=new Peg(i,j,0); }
        for(int j=9; j<13; j++) { board[i][j]=new Peg(i,j,-1); }

        i=4;
        // for(int j=0; j<5; j++) { board[i][j]=new Peg(i,j,-1); }
        for(int j=0; j<13; j++) { board[i][j]=new Peg(i,j,0); }
        // for(int j=9; j<13; j++) { board[i][j]=new Peg(i,j,-1); }

        i=5;
        for(int j=0; j<1; j++) { board[i][j]=new Peg(i,j,-1); }
        for(int j=1; j<13; j++) { board[i][j]=new Peg(i,j,0); }
        // for(int j=12; j<13; j++) { board[i][j]=new Peg(i,j,-1); }

        i=6;
        for(int j=0; j<1; j++) { board[i][j]=new Peg(i,j,-1); }
        for(int j=1; j<12; j++) { board[i][j]=new Peg(i,j,0); }
        for(int j=12; j<13; j++) { board[i][j]=new Peg(i,j,-1); }

        i=7;
        for(int j=0; j<2; j++) { board[i][j]=new Peg(i,j,-1); }
        for(int j=2; j<12; j++) { board[i][j]=new Peg(i,j,0); }
        for(int j=12; j<13; j++) { board[i][j]=new Peg(i,j,-1); }

        i=8;
        for(int j=0; j<2; j++) { board[i][j]=new Peg(i,j,-1); }
        for(int j=2; j<11; j++) { board[i][j]=new Peg(i,j,0); }
        for(int j=11; j<13; j++) { board[i][j]=new Peg(i,j,-1); }

        i=9;
        for(int j=0; j<2; j++) { board[i][j]=new Peg(i,j,-1); }
        for(int j=2; j<12; j++) { board[i][j]=new Peg(i,j,0); }
        for(int j=12; j<13; j++) { board[i][j]=new Peg(i,j,-1); }

        i=10;
        for(int j=0; j<1; j++) { board[i][j]=new Peg(i,j,-1); }
        for(int j=1; j<12; j++) { board[i][j]=new Peg(i,j,0); }
        for(int j=12; j<13; j++) { board[i][j]=new Peg(i,j,-1); }

        i=11;
        for(int j=0; j<1; j++) { board[i][j]=new Peg(i,j,-1); }
        for(int j=1; j<13; j++) { board[i][j]=new Peg(i,j,0); }
        // for(int j=12; j<13; j++) { board[i][j]=new Peg(i,j,-1); }

        i=12;
        //  for(int j=0; j<1; j++) { board[i][j]=new Peg(i,j,-1); }
        for(int j=0; j<13; j++) { board[i][j]=new Peg(i,j,0); }
        // for(int j=12; j<13; j++) { board[i][j]=new Peg(i,j,-1); }

        i=13;
        for(int j=0; j<5; j++) { board[i][j]=new Peg(i,j,-1); }
        for(int j=5; j<9; j++) { board[i][j]=new Peg(i,j,0); }
        for(int j=9; j<13; j++) { board[i][j]=new Peg(i,j,-1); }

        i=14;
        for(int j=0; j<5; j++) { board[i][j]=new Peg(i,j,-1); }
        for(int j=5; j<8; j++) { board[i][j]=new Peg(i,j,0); }
        for(int j=8; j<13; j++) { board[i][j]=new Peg(i,j,-1); }

        i=15;
        for(int j=0; j<6; j++) { board[i][j]=new Peg(i,j,-1); }
        for(int j=6; j<8; j++) { board[i][j]=new Peg(i,j,0); }
        for(int j=8; j<13; j++) { board[i][j]=new Peg(i,j,-1); }

        i=16;
        for(int j=0; j<6; j++) { board[i][j]=new Peg(i,j,-1); }
        board[i][6] = new Peg(i, 6, 0);
        for(int j=7; j<13; j++) { board[i][j]=new Peg(i,j,-1); }
    }

    private void setXYDraws() {
        for(int i=0; i<I_BOARD_SIZE; i++) {
            for(int j=0; j<J_BOARD_SIZE; j++) {
                if (i % 2 == 0) {
                    board[i][j].setXY((j * 35) + DISTANCE_FROM_EDGES, (i * 35) + DISTANCE_FROM_EDGES);
                } else {
                    board[i][j].setXY((j * 35) - 40/2 + DISTANCE_FROM_EDGES, (i * 35) + DISTANCE_FROM_EDGES);
                }
            }
        }
    }

    public void doDrawBoard(Graphics g) {
        for(int i=0; i<I_BOARD_SIZE; i++) {
            for(int j=0; j<J_BOARD_SIZE; j++) {
                board[i][j].doDraw(g);
            }
        }
    }

    //red
    public void fillSectorOne(){
        for(int j=5; j<9; j++) {
            board[13][j]=new Peg(13,j,1);
        }
        for(int j=5; j<8; j++){
            board[14][j]=new Peg(14,j,1);
        }
        for(int j=6; j<8; j++){
            board[15][j]=new Peg(15,j,1);
        }
        board[16][6]=new Peg(16,6,1);

    }

    //blue
    public void fillSectorTwo(){
        for(int j=0; j<4; j++) {
            board[12][j]=new Peg(12,j,2);
        }
        for(int j=1; j<4; j++){
            board[11][j]=new Peg(11,j,2);
        }
        for(int j=1; j<3; j++){
            board[10][j]=new Peg(10,j,2);
        }
        board[9][2]=new Peg(9,2,2);
    }
    //pink
    public void fillSectorThree(){
        for(int j=0; j<4; j++) {
            board[4][j]=new Peg(4,j,3);
        }
        for(int j=1; j<4; j++){
            board[5][j]=new Peg(5,j,3);
        }
        for(int j=1; j<3; j++){
            board[6][j]=new Peg(6,j,3);
        }
        board[7][2]=new Peg(7,2,3);
    }

    //yellow
    public void fillSectorFour(){
        for(int j=5; j<9; j++) {
            board[3][j]=new Peg(3,j,4);
        }
        for(int j=5; j<8; j++){
            board[2][j]=new Peg(2,j,4);
        }
        for(int j=6; j<8; j++){
            board[1][j]=new Peg(1,j,4);
        }
        board[0][6]=new Peg(0,6,4);
    }

    //orange
    public void fillSectorFive(){

        for(int j=9; j<13; j++) {
            board[4][j]=new Peg(4,j,5);
        }
        for(int j=10; j<13; j++){
            board[5][j]=new Peg(5,j,5);
        }
        for(int j=10; j<12; j++){
            board[6][j]=new Peg(6,j,5);
        }
        board[7][11]=new Peg(7,11,5);
    }

    //green
    public void fillSectorSix(){
        for(int j=9; j<13; j++) {
            board[12][j]=new Peg(12,j,6);
        }
        for(int j=10; j<13; j++){
            board[11][j]=new Peg(11,j,6);
        }
        for(int j=10; j<12; j++){
            board[10][j]=new Peg(10,j,6);
        }
        board[9][11]=new Peg(9,2,6);
    }

}
