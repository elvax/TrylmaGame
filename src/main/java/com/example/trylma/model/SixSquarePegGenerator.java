package com.example.trylma.model;

public class SixSquarePegGenerator extends PegGenerator {
    @Override
    protected AbstractPeg initializePeg() {
        return new SixSquarePeg();
    }
}
