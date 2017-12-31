package com.example.trylma.model;

import java.io.Serializable;

public abstract class PegGenerator implements Serializable {
    public AbstractPeg generatePeg(int i, int j, int OwnerID) {
        AbstractPeg generatedPeg = initializePeg();
        generatedPeg.generatePeg(i,j,OwnerID);
        return generatedPeg;
    }
    protected abstract AbstractPeg initializePeg();
}
