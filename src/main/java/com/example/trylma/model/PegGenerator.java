package com.example.trylma.model;

import java.io.Serializable;

/**
 * PegGenerator class includes method generatePeg, which
 * returns the peg with the appropriate properties using the
 * factory method generatePeg, which depends on the peg factory.
 * @author      Sebastian Pabich
 * @author      Maria Wita
 * @version     1.0
 * @since       1.0
 */

public abstract class PegGenerator implements Serializable {
    /**
     * Method which uses the factory method generatePeg(int i, int j, int OwnerID)
     * to generate a peg with appropriate properties depending on
     * the selection of PegGenerator.
     *
     * @param i             the row number of the board in which
     *                      the peg is placed
     * @param j             the column number of the board in which
     *                      the peg is placed
     * @param OwnerID       an integer indicating the ID of the player
     *                      to which the peg belongs.
     * @return              the AbstractPeg, for example the SixSquarePeg
     *                      or SixCirclePeg.
     * @since               1.0
     */
    public AbstractPeg generatePeg(int i, int j, int OwnerID) {
        AbstractPeg generatedPeg = initializePeg();
        generatedPeg.generatePeg(i,j,OwnerID);
        return generatedPeg;
    }
    /**
     * Method which returns the appropriate object of class AbstractPeg.
     *
     * @return              the AbstractPeg, for example the SixSquarePeg
     *                      or SixCirclePeg.
     * @since               1.0
     */
    protected abstract AbstractPeg initializePeg();
}
