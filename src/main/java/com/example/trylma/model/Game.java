package com.example.trylma.model;

public class Game {
    /**
     * A board has 61 fields
     */
    // TODO 1.ogarnac sposob na przechowanie lista czy 1- czy 2- wymiarowa tablica
    // 2. czy kazde pole ma byc zainicjalizowanie Peg czy Peg tylko tam gdzie gracze maja pionki a reszta to null
    private Peg[][] board;

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

}
