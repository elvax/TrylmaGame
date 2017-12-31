package com.example.trylma.model;

public abstract class BoardGenerator {
    public Board generateBoard(){
        Board generatedBoard = initializeBoard();
        generatedBoard.generateBoard();
        return generatedBoard;
    }
    protected abstract Board initializeBoard();
}
