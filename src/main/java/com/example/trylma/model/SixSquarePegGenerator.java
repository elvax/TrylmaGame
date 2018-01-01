package com.example.trylma.model;

/**
 * SixSquarePegGenerator class extends PegGenerator class and
 * includes method initializePeg(), which
 * returns the object of SixSquarePeg class.
 * @author      Sebastian Pabich
 * @author      Maria Wita
 * @version     1.0
 * @since       1.0
 */
public class SixSquarePegGenerator extends PegGenerator {
    /**
     * Method which returns the object of SixSquarePeg class.
     *
     * @return              the object of SixSquarePeg class,
     *                      which extends AbstractPeg class.
     * @since               1.0
     */
    @Override
    protected AbstractPeg initializePeg() {
        return new SixSquarePeg();
    }
}
