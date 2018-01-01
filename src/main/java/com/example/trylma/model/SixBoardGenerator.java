package com.example.trylma.model;
/**
 * SixBoardGenerator class extends BoardGenerator class and
 * includes method initializeBoard(), which
 * returns the object of SixBoard class.
 * @author      Sebastian Pabich
 * @author      Maria Wita
 * @version     1.0
 * @since       1.0
 */
public class SixBoardGenerator extends BoardGenerator {
    /**
     * Method which returns the object of SixBoard class.
     *
     * @return              the object of SixBoard class,
     *                      which extends Board class.
     * @since               1.0
     */
    @Override
    protected Board initializeBoard(){
        return new SixBoard();
    }
}
