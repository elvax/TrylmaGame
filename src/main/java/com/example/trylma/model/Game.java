package com.example.trylma.model;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.GregorianCalendar;

public class Game {
    private final int I_BOARD_SIZE = 17;
    private final int J_BOARD_SIZE = 13;
    private final int DISTANCE_FROM_EDGES = 10;
    // TODO metoda do znalezienia wszystkich sąsiadów(przyjmuje obiekt Peg wybrany przez klieneta)
    // TODO rekurencyjnie wywołuje w/w metode i zwraca wszystkie mozliwe ruchy w liscie
    // TODO metoda move do ruszenia pegiem(przyjmuje obiekt Peg wybrany przez klieneta)
    // TODO 6 metod do wypelniani sektorow

    /**
     * A board has 61 fields
     */
    private Peg[][] board;

    public Game() {
        initalizeBoard();
        setXYDraws();
    }

    /**
     * The current player
     */


    /**
     * Returns whether the current state of the board is such that one of the players is a winner
     */
    public boolean hasWinner() {
        //TODO ma zwrocic true jak jakis gracz zapelni przeciwlegly rog
        return false;
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
     * and + means "-1" wass passed to ownerID
     * in constructor
     */
    public void initalizeBoard() {
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

    public void doDraw(Graphics g) {

        for(int i=0; i<I_BOARD_SIZE; i++) {
            for(int j=0; j<J_BOARD_SIZE; j++) {
                    board[i][j].doDraw(g);
            }
        }

    }

    public void printBoard() {
        for(int i=0; i<I_BOARD_SIZE; i++) {
            for (int j = 0; j < J_BOARD_SIZE; j++) {
                if(board[i][j].getOwnerID() == -1){
                    System.out.print("+");
                } else{
                    System.out.print("0");
                }
            }
            System.out.println();
        }
    }

    public Peg getPeg(int i, int j) throws IllegalArgumentException{
        if ( i<0 || i>I_BOARD_SIZE-1
                || j<0 || j>J_BOARD_SIZE-1 )
            throw new IllegalArgumentException();
        return board[i][j];
    }

    //red
    public void fillSectorOne(){
        Peg p;
        int x,y;
        for(int j=5; j<9; j++) {
            p = board[13][j];
            x = p.getxDraw();
            y = p.getyDraw();
            board[13][j]=new Peg(13,j,1);
            board[13][j].setXY(x,y);
        }
        for(int j=5; j<8; j++){
            p = board[14][j];
            x = p.getxDraw();
            y = p.getyDraw();
            board[14][j]=new Peg(14,j,1);
            board[14][j].setXY(x,y);
        }
        for(int j=6; j<8; j++){
            p = board[15][j];
            x = p.getxDraw();
            y = p.getyDraw();
            board[15][j]=new Peg(15,j,1);
            board[15][j].setXY(x,y);
        }
        p = board[16][6];
        x = p.getxDraw();
        y = p.getyDraw();
        board[16][6]=new Peg(16,6,1);
        board[16][6].setXY(x,y);
    }

    //blue
    public void fillSectorTwo(){
        Peg p;
        int x,y;
        for(int j=0; j<4; j++) {
            p = board[12][j];
            x = p.getxDraw();
            y = p.getyDraw();
            board[12][j]=new Peg(12,j,2);
            board[12][j].setXY(x,y);
        }
        for(int j=1; j<4; j++){
            p = board[11][j];
            x = p.getxDraw();
            y = p.getyDraw();
            board[11][j]=new Peg(11,j,2);
            board[11][j].setXY(x,y);
        }
        for(int j=1; j<3; j++){
            p = board[10][j];
            x = p.getxDraw();
            y = p.getyDraw();
            board[10][j]=new Peg(10,j,2);
            board[10][j].setXY(x,y);
        }
        p = board[9][2];
        x = p.getxDraw();
        y = p.getyDraw();
        board[9][2]=new Peg(9,2,2);
        board[9][2].setXY(x,y);
    }
    //pink
    public void fillSectorThree(){
        Peg p;
        int x,y;
        for(int j=0; j<4; j++) {
            p = board[4][j];
            x = p.getxDraw();
            y = p.getyDraw();
            board[4][j]=new Peg(4,j,3);
            board[4][j].setXY(x,y);
        }
        for(int j=1; j<4; j++){
            p = board[5][j];
            x = p.getxDraw();
            y = p.getyDraw();
            board[5][j]=new Peg(5,j,3);
            board[5][j].setXY(x,y);
        }
        for(int j=1; j<3; j++){
            p = board[6][j];
            x = p.getxDraw();
            y = p.getyDraw();
            board[6][j]=new Peg(6,j,3);
            board[6][j].setXY(x,y);
        }
        p = board[7][2];
        x = p.getxDraw();
        y = p.getyDraw();
        board[7][2]=new Peg(7,2,3);
        board[7][2].setXY(x,y);
    }

    //yellow
    public void fillSectorFour(){
        Peg p;
        int x,y;
        for(int j=5; j<9; j++) {
            p = board[3][j];
            x = p.getxDraw();
            y = p.getyDraw();
            board[3][j]=new Peg(3,j,4);
            board[3][j].setXY(x,y);
        }
        for(int j=5; j<8; j++){
            p = board[2][j];
            x = p.getxDraw();
            y = p.getyDraw();
            board[2][j]=new Peg(2,j,4);
            board[2][j].setXY(x,y);
        }
        for(int j=6; j<8; j++){
            p = board[1][j];
            x = p.getxDraw();
            y = p.getyDraw();
            board[1][j]=new Peg(1,j,4);
            board[1][j].setXY(x,y);
        }
        p = board[0][6];
        x = p.getxDraw();
        y = p.getyDraw();
        board[0][6]=new Peg(0,6,4);
        board[0][6].setXY(x,y);
    }

    //orange
    public void fillSectorFive(){
        Peg p;
        int x,y;
        for(int j=9; j<13; j++) {
            p = board[4][j];
            x = p.getxDraw();
            y = p.getyDraw();
            board[4][j]=new Peg(4,j,5);
            board[4][j].setXY(x,y);
        }
        for(int j=10; j<13; j++){
            p = board[5][j];
            x = p.getxDraw();
            y = p.getyDraw();
            board[5][j]=new Peg(5,j,5);
            board[5][j].setXY(x,y);
        }
        for(int j=10; j<12; j++){
            p = board[6][j];
            x = p.getxDraw();
            y = p.getyDraw();
            board[6][j]=new Peg(6,j,5);
            board[6][j].setXY(x,y);
        }
        p = board[7][11];
        x = p.getxDraw();
        y = p.getyDraw();
        board[7][11]=new Peg(7,11,5);
        board[7][11].setXY(x,y);
    }

    //green
    public void fillSectorSix(){
        Peg p;
        int x,y;
        for(int j=9; j<13; j++) {
            p = board[12][j];
            x = p.getxDraw();
            y = p.getyDraw();
            board[12][j]=new Peg(12,j,6);
            board[12][j].setXY(x,y);
        }
        for(int j=10; j<13; j++){
            p = board[11][j];
            x = p.getxDraw();
            y = p.getyDraw();
            board[11][j]=new Peg(11,j,6);
            board[11][j].setXY(x,y);
        }
        for(int j=10; j<12; j++){
            p = board[10][j];
            x = p.getxDraw();
            y = p.getyDraw();
            board[10][j]=new Peg(10,j,6);
            board[10][j].setXY(x,y);
        }
        p = board[9][11];
        x = p.getxDraw();
        y = p.getyDraw();
        board[9][11]=new Peg(9,2,6);
        board[9][11].setXY(x,y);
    }

    /*public List<Peg> findNeighbors(Peg peg){
        List<Peg> neighbours = new ArrayList<Peg>();
        int i = peg.geti();
        int j = peg.getj();
        int bi = i-1;
        int ei = i+1;
        int bj = j-1;
        int ej = j+1;
        if ( i == 0 ){ bi = i; }
        else if( i == I_BOARD_SIZE - 1){ ei = i; }
        if( j  == 0 ){ bj = j; }
        else if( j == J_BOARD_SIZE - 1 ){ bj = j; }
        for( int k = bi; k <= ei; k++ ){
            for( int t = bj; t <= ej; t++){
                if(board[k][t].getOwnerID() != -1) {
                    neighbours.add(board[k][t]);
                }
            }
        }
        return neighbours;
    }*/


    public static void main(String[] args) {
        Game game = new Game();
        game.printBoard();
    }


}



