package com.example.trylma.model;

import java.awt.*;
import java.io.IOException;
import java.io.Serializable;

/**
 * The Abstract Peg class contains all the basic methods,
 * which the application needs to draw one peg in the game.
 *
 * @author      Sebastian Pabich
 * @author      Maria Wita
 * @version     %I%, %G%
 * @since       1.0
 */
public abstract class AbstractPeg implements Serializable {
    /**
     * Abstract factory method which generates a peg
     * with appropriate properties depending on
     * the selection of {@link PegGenerator}.
     *
     * @param i             the row number of the board in which
     *                      the peg is placed
     * @param j             the column number of the board in which
     *                      the peg is placed
     * @param OwnerID       an integer indicating the ID of the player
     *                      to which the peg belongs.
     * @since               1.0
     */
    abstract public void generatePeg(int i, int j, int OwnerID);
    /**
     * Abstract method doDraw draws a peg with appropriate properties.
     *
     * @param g             graphics
     * @since               1.0
     */
    abstract public void doDraw(Graphics g);
    /**
     * Abstract method setImage sets an image of a peg that is closely
     * related to the OwnerID.
     *
     * @throws IOException      If an input or output
     *                          exception occurred
     * @since                   1.0
     */
    abstract public void setImage() throws IOException;
    /**
     * Abstract method getSectorID returns the sector number of the peg
     * which is the same as a number of the player to which it belongs.
     *
     * @returns     OwnerID which is the same as the sectorID.
     * @since       1.0
     */
    abstract public int getSectorID();
    /**
     * Abstract method geti returns the row number of the board in which
     * the peg is placed.
     *
     * @returns     the row number of the board.
     * @since       1.0
     */
    abstract public int geti();
    /**
     * Abstract method getj returns the column number of the board in which
     * the peg is placed.
     *
     * @returns     the column number of the board.
     * @since       1.0
     */
    abstract public int getj();
    /**
     * Abstract method getxDraw returns the x-coordinate of the northwest corner
     * of the destination peg in pixels.
     *
     * @returns     the x-coordinate.
     * @since       1.0
     */
    abstract public int getxDraw();
    /**
     * Abstract method getyDraw returns the y-coordinate of the northwest corner
     * of the destination peg in pixels.
     *
     * @returns     the y-coordinate.
     * @since       1.0
     */
    abstract public int getyDraw();
    /**
     * Abstract method setXY sets the x-coordinate and y-coordinate of the northwest
     * corner of the destination peg in pixels.
     *
     * @since       1.0
     */
    abstract public void setXY(int x, int y);
    /**
     * Abstract method changeOwnerID changes the owner of the peg.
     *
     * @param newOwnerID    the new player ID
     * @since               1.0
     */
    abstract public void changeOwnerID(int newOwnerID);
    /**
     * Abstract method isClicked returns true, when the peg includes
     * clicked x-coordinate and y-coordinate and false otherwise.
     *
     * @param x         the clicked x-coordinate in pixels
     * @param y         the clicked y-coordinate in pixels.
     * @return          <code>true</code> if the peg is clicked
     *                  by the Owner and <code>false</code> otherwise.
     * @since           1.0
     */
    abstract public boolean isClicked(int x, int y);
}
