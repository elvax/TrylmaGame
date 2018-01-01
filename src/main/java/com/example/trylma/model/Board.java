package com.example.trylma.model;

import java.awt.*;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * The abstract Board class contains all the basic methods,
 * which the application needs to draw the board of the game.
 *
 * @author      Sebastian Pabich
 * @author      Maria Wita
 * @version     1.0
 * @since       1.0
 */
public abstract class Board implements Serializable{
    /**
     * Abstract factory method which generates a board
     * with appropriate peg depending on
     * the selection of {@link PegGenerator} and {@link BoardGenerator}.
     *
     * @param P             PegGenerator, which return the appropriate
     *                      Peg to board.
     * @since               1.0
     */
    public abstract void generateBoard(PegGenerator P);
    /**
     * Abstract method which sets the appropriate image of
     * all pegs in the board.
     * @throws IOException      If an input or output
     *                          exception occurred
     * @since                   1.0
     */
    public abstract void setImage() throws IOException;
    /**
     * Abstract method which sets the board for players,
     * fill the board which pegs with correct sector ID
     * and returns the list of active sectors.
     *
     * @param numberOfPlayers      the number of players in game
     * @return                     the list of the active sectors
     *                             (sectors using in game)
     * @since                      1.0
     */
    public abstract List setBoardForPlayers(int numberOfPlayers);
    /**
     * Abstract method doDrawBoard draws a board with appropriate properties.
     *
     * @param g             graphics
     * @since               1.0
     */
    public abstract void doDrawBoard(Graphics g);
    /**
     * Abstract method updates the Board by changing pawns on the board
     * with pawns from the list.
     *
     * @param list          list of the pegs, which changed their properties,
     *                      for example the OwnerID
     * @since               1.0
     */
    public abstract void updateBoard(AbstractPeg[] list);
    /**
     * Abstract method which fill one of the sector of the board with correct pawns.
     *
     * @param i             the sector ID
     * @since               1.0
     */
    public abstract void fillSector(int i);
    /**
     * Method getClicked returns the peg from the board which was clicked.
     *
     * @param x         the clicked x-coordinate in pixels
     * @param y         the clicked y-coordinate in pixels.
     * @return          peg from the board which was clicked.
     * @since           1.0
     */
    public abstract AbstractPeg getClicked(int x, int y);
    /**
     * Abstract method which returns the peg which is in the i - row
     * and j - column in the board.
     *
     * @param i             the row number
     * @param j             the column number
     * @return              peg from the board
     * @since               1.0
     */
    public abstract AbstractPeg getPeg(int i, int j);
    /**
     * Abstract method which checks if the move on the board is correct
     * and then returns two pegs that should be change or null,
     * when the move was't correct.
     *
     * @param p             the clicked peg which we want to move
     * @param x             the x - coordinate of the destiny peg
     * @param y             the y - coordinate of the destiny peg
     * @return              list of pegs that should be change
     * @since               1.0
     */
    public abstract List<AbstractPeg> move(AbstractPeg p, int x, int y);
    /**
     * Abstract method which checks if the move on the board is correct
     * and then returns two pegs that should be change or null,
     * when the move was't correct.
     *
     * @param p             the clicked peg which we want to move
     * @param d             the destiny place(peg which sectorID=0),
     *                      where we want to put the clicked peg
     * @return              list of pegs that should be change
     * @since               1.0
     */
    public abstract List<AbstractPeg> move(AbstractPeg p, AbstractPeg d);
    /**
     * Abstract method which return the list of possible pegs that
     * can be replace by the clicked peg.
     *
     * @param p             the clicked peg which we want to move
     * @return              peg's list of possible moves
     * @since               1.0
     */
    public abstract List<AbstractPeg> correctMoves(AbstractPeg p);
    /**
     * Abstract method which return the list of possible pegs that
     * can be replace by the clicked peg and change the sectorID of
     * this pegs in the board to number which means possible moves.
     *
     * @param p             the clicked peg which we want to move
     * @return              peg's list of possible moves
     * @since               1.0
     */
    public abstract List<AbstractPeg> setPossibleMoves(AbstractPeg p);
    /**
     * Abstract method which change the sectorID of pegs in the board
     * to number which means that they are empty.
     *
     * @param list          the list of pegs to change their sectorID
     * @since               1.0
     */
    public abstract void changeIdPossibleMoves(List<AbstractPeg> list);
    /**
     * Abstract method which returns all pegs that belongs to the sector.
     *
     * @param sectorID      the number of sector ID
     * @return              list of pegs of the selected sector
     * @since               1.0
     */
    public abstract List<AbstractPeg> getPegsOfSector(int sectorID);
    /**
     * Abstract method which returns all pegs that belongs to
     * the selected player.
     *
     * @param id            the number of owner ID
     * @return              list all of pegs of the selected player
     * @since               1.0
     */
    public abstract List<AbstractPeg> getPegsOfID(int id);
    /**
     * Abstract method which sets peg with new properties in the board.
     *
     * @param i             the row number of peg in the board
     * @param j             the column number of peg in the board
     * @param Owner         the Owner ID of the peg
     * @since               1.0
     */
    public abstract void setPeg(int i, int j, int Owner);
    /**
     * Abstract method prints the board.
     * @since               1.0
     */
    public abstract void printBoard();
    /**
     * Abstract method which returns true if the correct corner
     * is filled by the pegs of player.
     *
     * @param PlayerID            the number of player ID
     * @return                    list all of pegs of the selected player
     * @since                     1.0
     */
    public abstract boolean isWinner(int PlayerID);
}
