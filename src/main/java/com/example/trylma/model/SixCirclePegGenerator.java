package com.example.trylma.model;

public class SixCirclePegGenerator extends PegGenerator {
    @Override
    protected AbstractPeg initializePeg(){
        return new Peg();
    }
}
