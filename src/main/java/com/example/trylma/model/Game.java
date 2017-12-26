package com.example.trylma.model;

import java.awt.*;

public class Game {
    public static final int I_BOARD_SIZE = 17;
    public static final int J_BOARD_SIZE = 13;
    private final int DISTANCE_FROM_EDGES = 10;


    // TODO metoda do znalezienia wszystkich sąsiadów(przyjmuje obiekt Peg wybrany przez klieneta)
    // TODO rekurencyjnie wywołuje w/w metode i zwraca wszystkie mozliwe ruchy w liscie
    // TODO metoda move do ruszenia pegiem(przyjmuje obiekt Peg wybrany przez klieneta)
    // TODO 6 metod do wypelniani sektorow

    /**
     * A board has 61 fields
     */
    private AbstractPeg[][] board;
    private Board boardOfTrylma;

    public Game() {
        initalizeBoard();
        setXYDraws();
        boardOfTrylma = new Board();
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
     * and + means "-1" wass passed to sectorID
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

    public void doDrawBoard(Graphics g) {

        for(int i=0; i<I_BOARD_SIZE; i++) {
            for(int j=0; j<J_BOARD_SIZE; j++) {
                board[i][j].doDraw(g);
            }
        }
    }

    public void printBoard() {
        for(int i=0; i<I_BOARD_SIZE; i++) {
            for (int j = 0; j < J_BOARD_SIZE; j++) {
                if(board[i][j].getSectorID() == -1){
                    System.out.print("+");
                } else{
                    System.out.print("0");
                }
            }
            System.out.println();
        }
    }

    public AbstractPeg getPeg(int i, int j) throws IllegalArgumentException{
        if ( i<0 || i>I_BOARD_SIZE-1
                || j<0 || j>J_BOARD_SIZE-1 )
            throw new IllegalArgumentException();
        return board[i][j];
    }

    public AbstractPeg[][] getBoard() {
        return board;
    }

    public Board getBoardOfTrylma(){
        return boardOfTrylma;
    }

    public void setPegsForOnePlayer() {
        int i;
        i=13;
        for(int j=5; j<9; j++) { board[i][j].changeOwnerID(1); }

        i=14;
        for(int j=5; j<8; j++) { board[i][j].changeOwnerID(1); }

        i=15;
        for(int j=6; j<8; j++) { board[i][j].changeOwnerID(1); }

        i=16;
        board[i][6].changeOwnerID(1);

    }

    public boolean isClicked(int x, int y) {
        for(int i=0; i<I_BOARD_SIZE; i++) {
            for (int j = 0; j < J_BOARD_SIZE; j++) {
                if (board[i][j].isClicked(x,y))
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.printBoard();
    }


}



