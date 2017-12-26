package com.example.trylma.model;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

// TODO metoda do znalezienia wszystkich sąsiadów(przyjmuje obiekt Peg wybrany przez klieneta)
// TODO rekurencyjnie wywołuje w/w metode i zwraca wszystkie mozliwe ruchy w liscie
// TODO metoda move do ruszenia pegiem(przyjmuje obiekt Peg wybrany przez klieneta)
// TODO 6 metod do wypelniani sektorow

public class Game {
    private Board boardOfTrylma;
    private int currentID;
    int index;
    Random randomGenerator;
    List<Integer> activeSectorsID;

    /**
     * todo current player id
     * array of active players'id
     * random genereator
     * method next to set next player
     */

    public Game() {
        boardOfTrylma = new Board();
        randomGenerator = new Random();
        activeSectorsID =new ArrayList<Integer>();
        index = 0;
    }

    public void setBoardForPlayers(int numberOfPlayers) {
        if ( numberOfPlayers == 2 ) {
            boardOfTrylma.fillSectorOne();
            boardOfTrylma.fillSectorFour();

            activeSectorsID.add(1);
            activeSectorsID.add(4);
        } else if (numberOfPlayers == 3) {
            boardOfTrylma.fillSectorOne();
            boardOfTrylma.fillSectorThree();
            boardOfTrylma.fillSectorFive();

            activeSectorsID.add(1);
            activeSectorsID.add(3);
            activeSectorsID.add(5);
        } else if (numberOfPlayers == 4) {
            boardOfTrylma.fillSectorTwo();
            boardOfTrylma.fillSectorThree();
            boardOfTrylma.fillSectorFive();
            boardOfTrylma.fillSectorSix();

            activeSectorsID.add(2);
            activeSectorsID.add(3);
            activeSectorsID.add(5);
            activeSectorsID.add(6);
        } else if (numberOfPlayers == 6) {
            boardOfTrylma.fillSectorOne();
            boardOfTrylma.fillSectorTwo();
            boardOfTrylma.fillSectorThree();
            boardOfTrylma.fillSectorFour();
            boardOfTrylma.fillSectorFive();
            boardOfTrylma.fillSectorSix();

            activeSectorsID.add(1);
            activeSectorsID.add(2);
            activeSectorsID.add(3);
            activeSectorsID.add(4);
            activeSectorsID.add(5);
            activeSectorsID.add(6);
        }
    }

    public List<Integer> getActiveSectorsID() {
        return activeSectorsID;
    }

    public void setOrderOfMoves() {
        int firstToMove = randomGenerator.nextInt(activeSectorsID.size());
        Integer tmp = activeSectorsID.get(firstToMove);
        activeSectorsID.remove(firstToMove);
        activeSectorsID.add(0, tmp);

        currentID = activeSectorsID.get(0);
    }

    public void nextPlayer() {
        if(++index >= activeSectorsID.size())
            index = 0;
        currentID = activeSectorsID.get(index);
    }
    public int getCurrentID() {
        return currentID;
    }

    public Board getBoardOfTrylma(){
        return boardOfTrylma;
    }


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



