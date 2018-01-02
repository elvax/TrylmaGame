package com.example.trylma.model;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

/**
 * The class Game contains all the basic methods,
 * which the application needs to run a game.
 *
 * @author      Sebastian Pabich
 * @author      Maria Wita
 * @version     1.0
 * @since       1.0
 */
public class Game {
    private Board boardOfTrylma;
    private int currentID;
    int index;
    Random randomGenerator;
    List<Integer> activeSectorsID;

    /**
     * Constructor is responsible for preparing everything to start a new game.
     *
     * @param generatorB    Board generator
     * @param generatorP    Peg generator
     */
    public Game(BoardGenerator generatorB, PegGenerator generatorP) {
        boardOfTrylma = generatorB.generateBoard(generatorP);
        randomGenerator = new Random();
        activeSectorsID =new ArrayList<Integer>();
        index = 0;
    }
    /**
     * Method which sets the board for players,
     * fill the board which pegs with correct sector ID
     * and returns the list of active sectors by using the board method
     * setBoardForPlayers(int numberOfPlayers).
     *
     * @param numberOfPlayers      the number of players in game
     * @since                      1.0
     */
    public void setBoardForPlayers(int numberOfPlayers) {
        activeSectorsID = boardOfTrylma.setBoardForPlayers(numberOfPlayers);
    }
    /**
     * Method checks if the Player can be remove from the game
     * and returns true when it's removed and false otherwise.
     *
     * @param id                   the ID of player
     * @return                     true when the player is removed
     *                             and false otherwise
     * @since                      1.0
     */
    public boolean removePlayer(int id) {
        for (int i = 0; i < activeSectorsID.size(); i++) {
            if (activeSectorsID.get(i) == id) {
                activeSectorsID.remove(i);
                return true;
            }
        }
        return false;
    }
    /**
     * Method returns the ID of active sector.
     *
     * @return      the number of active sector
     * @since       1.0
     */
    public List<Integer> getActiveSectorsID() {
        return activeSectorsID;
    }

    /**
     * Method returns the random Peg from the lists of pegs.
     *
     * @return      the random peg from the list of pegs
     * @since       1.0
     */
    public AbstractPeg getRandomPeg(List<AbstractPeg> listOfPegs) {
        return listOfPegs.get(randomGenerator.nextInt(listOfPegs.size()));
    }
    /**
     * Method which returns all pegs that belongs to
     * the selected player.
     *
     * @param id            the number of owner ID
     * @return              list all of pegs of the selected player
     * @since               1.0
     */
    public List<AbstractPeg> getPegsOfID(int id) {
        return boardOfTrylma.getPegsOfID(id);
    }

    /**
     * Method sets the order of moves of the players.
     *
     * @since       1.0
     */
    public void setOrderOfMoves() {
        index = randomGenerator.nextInt(activeSectorsID.size());
        currentID = activeSectorsID.get(index);
    }

    /**
     * Method sets the next player.
     *
     * @return      the current player's ID
     * @since       1.0
     */
    public synchronized void nextPlayer() {
        if(++index >= activeSectorsID.size())
            index = 0;
        currentID = activeSectorsID.get(index);
    }

    /**
     * Method returns the current ID of player.
     *
     * @return      the current player's ID
     * @since       1.0
     */
    public synchronized int getCurrentID() {
        return currentID;
    }

    public int getIndex() {
        return index;
    }

    /**
     * Method returns the current state of board of the game.
     *
     * @return      the current board of game
     * @since       1.0
     */
    public Board getBoardOfTrylma(){
        return boardOfTrylma;
    }

    /**
     * Method which sets peg with new properties in the current board of game.
     *
     * @param i             the row number of peg in the board
     * @param j             the column number of peg in the board
     * @param Owner         the Owner ID of the peg
     * @since               1.0
     */
    public void setPegOfBoardOfTrylma(int i, int j, int Owner){
        boardOfTrylma.setPeg(i,j,Owner);
    }
    /**
     * Method findActive returns the peg from the current board when
     * belongs to the player which can make the move now.
     *
     * @param x         the clicked x-coordinate in pixels
     * @param y         the clicked y-coordinate in pixels.
     * @param ID        the ID of player.
     * @return          peg from the board which was clicked by
     *                  a current player and belongs to him.
     * @since           1.0
     */
    public AbstractPeg findActive(int x, int y, int ID) {
        AbstractPeg activePeg = null;
        AbstractPeg p = getClicked(x,y);
        if(p!=null && p.getSectorID()==ID){
            activePeg = p;
        }
 		return activePeg;
    }

    /**
     * Abstract method which checks if the move on the board is correct
     * and then returns two pegs that should be change or null,
     * when the move was't correct.
     *
     * @param pegToMove             the clicked peg which we want to move
     * @param x                     the x - coordinate of the destiny peg
     * @param y                     the y - coordinate of the destiny peg
     * @return                      list of pegs that should be change
     * @since                       1.0
     */
    public List<AbstractPeg> move(AbstractPeg pegToMove, int x, int y) {
        return boardOfTrylma.move(pegToMove, x, y);
    }

    /**
     * Method which checks if the move on the current board is correct
     * and then returns two pegs that should be change or null,
     * when the move was't correct.
     *
     * @param pegToMove             the clicked peg which we want to move
     * @param pegDestiny            the destiny place(peg which sectorID=0),
     *                              where we want to put the clicked peg
     * @return                      list of pegs that should be change
     * @since                       1.0
     */
    public List<AbstractPeg> move(AbstractPeg pegToMove, AbstractPeg pegDestiny) {
        return boardOfTrylma.move(pegToMove, pegDestiny);
    }

    /**
     * Method getClicked returns the peg from the current board which was clicked.
     *
     * @param x         the clicked x-coordinate in pixels
     * @param y         the clicked y-coordinate in pixels.
     * @return          peg from the board which was clicked.
     * @since           1.0
     */
    public AbstractPeg getClicked(int x, int y) {
        return boardOfTrylma.getClicked(x, y);
    }

    /**
     * Method which return the list of possible pegs that
     * can be replace by the clicked peg and change the sectorID of
     * this pegs in the board to number which means possible moves.
     *
     * @param p             the clicked peg which we want to move
     * @return              peg's list of possible moves
     * @since               1.0
     */
    public List<AbstractPeg> setPossibleMoves(AbstractPeg p){
        return boardOfTrylma.setPossibleMoves(p);
    }

    /**
     * Method which change the sectorID of pegs in the board
     * to number which means that they are empty.
     *
     * @param list          the list of pegs to change their sectorID
     * @since               1.0
     */
    public void changePossibleMoves(List<AbstractPeg> list){
        boardOfTrylma.changeIdPossibleMoves(list);
    }
    /**
     * Method prints the current board.
     * @since               1.0
     */
    public void printBoard() {
        boardOfTrylma.printBoard();
    }

    /**
     * Method which returns true if the player won the game.
     *
     * @param PlayerID            the number of player ID
     * @return                    list all of pegs of the selected player
     * @since                     1.0
     */
    public boolean isWinner(int PlayerID){
       return  boardOfTrylma.isWinner(PlayerID);
    }
    /**
     * Method which returns the peg which is in the i - row
     * and j - column in the board.
     *
     * @param i             the row number
     * @param j             the column number
     * @return              peg from the current board
     * @since               1.0
     */
    public AbstractPeg getPeg(int i, int j) {
        return boardOfTrylma.getPeg(i, j);
    }

    public static void main(String[] args) {
        BoardGenerator generatorB = new SixBoardGenerator();
        PegGenerator generatorP = new SixCirclePegGenerator();
        Game game = new Game(generatorB, generatorP);
    }

}



