package com.example.trylma.model;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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

    public Collection setBoardForPlayers(int numberOfPlayers) {
        List<Integer> secotrosID =new ArrayList<Integer>();
        if ( numberOfPlayers == 2 ) {
            boardOfTrylma.fillSectorOne();
            boardOfTrylma.fillSectorFour();

            secotrosID.add(1);
            secotrosID.add(4);
            return secotrosID;
        } else if (numberOfPlayers == 3) {
            boardOfTrylma.fillSectorOne();
            boardOfTrylma.fillSectorThree();
            boardOfTrylma.fillSectorFive();

            secotrosID.add(1);
            secotrosID.add(3);
            secotrosID.add(5);
            return secotrosID;
        } else if (numberOfPlayers == 4) {
            boardOfTrylma.fillSectorTwo();
            boardOfTrylma.fillSectorThree();
            boardOfTrylma.fillSectorFive();
            boardOfTrylma.fillSectorSix();

            secotrosID.add(2);
            secotrosID.add(3);
            secotrosID.add(5);
            secotrosID.add(6);
            return secotrosID;
        } else if (numberOfPlayers == 6) {
            boardOfTrylma.fillSectorOne();
            boardOfTrylma.fillSectorTwo();
            boardOfTrylma.fillSectorThree();
            boardOfTrylma.fillSectorFour();
            boardOfTrylma.fillSectorFive();
            boardOfTrylma.fillSectorSix();

            secotrosID.add(1);
            secotrosID.add(2);
            secotrosID.add(3);
            secotrosID.add(4);
            secotrosID.add(5);
            secotrosID.add(6);
            return secotrosID;
        }
        return null;
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



