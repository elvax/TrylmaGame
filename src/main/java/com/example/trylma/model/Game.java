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
    private Board boardOfTrylma;

    public Game() {
        boardOfTrylma = new Board();
    }


    /**
     * Returns whether the current state of the board is such that one of the players is a winner
     */
    public boolean hasWinner() {
        //TODO ma zwrocic true jak jakis gracz zapelni przeciwlegly rog
        return false;
    }


    public Board getBoardOfTrylma(){
        return boardOfTrylma;
    }

//    public void setPegsForOnePlayer() {
//        int i;
//        i=13;
//        for(int j=5; j<9; j++) { board[i][j].changeOwnerID(1); }
//
//        i=14;
//        for(int j=5; j<8; j++) { board[i][j].changeOwnerID(1); }
//
//        i=15;
//        for(int j=6; j<8; j++) { board[i][j].changeOwnerID(1); }
//
//        i=16;
//        board[i][6].changeOwnerID(1);
//
//    }

//    public boolean isClicked(int x, int y) {
//        for(int i=0; i<I_BOARD_SIZE; i++) {
//            for (int j = 0; j < J_BOARD_SIZE; j++) {
//                if (board[i][j].isClicked(x,y))
//                    return true;
//            }
//        }
//        return false;
//    }

    public static void main(String[] args) {
        Game game = new Game();
//        game.printBoard();
    }


}



