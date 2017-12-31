package com.example.trylma.model;

public class SixBoardGenerator extends BoardGenerator {
    @Override
    protected Board initializeBoard(){
        return new SixBoard();
    }
}
