package com.example.trylma.model;

/**
 * BoardGenerator class includes method generateBoard, which
 * returns the board with the appropriate properties using the
 * factory method generateBoard, which depends on the board factory.
 * @author      Sebastian Pabich
 * @author      Maria Wita
 * @version     1.0
 * @since       1.0
 */
public abstract class BoardGenerator {
    /**
     * Method which uses the factory method generateBoard(PegGenerator P)
     * to generate a board with appropriate properties depending on
     * the selection of PegGenerator and BoardGenerator.
     *
     * @param P             PegGenerator, which is needed to fill the board with
     *                      appropriate pawns.
     * @return              the Board, for example the object of SixBoard class,
     *                      which extends Board class.
     * @since               1.0
     */
    public Board generateBoard(PegGenerator P){
        Board generatedBoard = initializeBoard();
        generatedBoard.generateBoard(P);
        return generatedBoard;
    }
    /**
     * Method which returns the appropriate object of class Board.
     *
     * @return              the Board, for example the object of SixBoard
     *                      class, which extends Board class.
     * @since               1.0
     */
    protected abstract Board initializeBoard();
}
