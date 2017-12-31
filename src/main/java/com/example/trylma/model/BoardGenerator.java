package com.example.trylma.model;

public abstract class BoardGenerator {
    public Board generateBoard(PegGenerator P){
        Board generatedBoard = initializeBoard();
        generatedBoard.generateBoard(P);
        return generatedBoard;
    }
    protected abstract Board initializeBoard();
}
