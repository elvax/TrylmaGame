package com.example.trylma.model;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

// TODO metoda do znalezienia wszystkich sąsiadów(przyjmuje obiekt Peg wybrany przez klieneta)
// TODO rekurencyjnie wywołuje w/w metode i zwraca wszystkie mozliwe ruchy w liscie
// TODO metoda move do ruszenia pegiem(przyjmuje obiekt Peg wybrany przez klieneta)
// TODO 6 metod do wypelniani sektorow

public class Game {
    private Board boardOfTrylma;
    private int currentID;
    int index;
    Random randomGenerator;
    List<Integer> activeSectorsID;

    /**
     * todo current player id
     * array of active players'id
     * random genereator
     * method next to set next player
     */

    public Game(BoardGenerator generatorB, PegGenerator generatorP) {
        boardOfTrylma = generatorB.generateBoard(generatorP);
        randomGenerator = new Random();
        activeSectorsID =new ArrayList<Integer>();
        index = 0;
    }

    public void setBoardForPlayers(int numberOfPlayers) {
        activeSectorsID = boardOfTrylma.setBoardForPlayers(numberOfPlayers);
    }

    public List<Integer> getActiveSectorsID() {
        return activeSectorsID;
    }

    public void setOrderOfMoves() {
        index = randomGenerator.nextInt(activeSectorsID.size());
        currentID = activeSectorsID.get(index);
    }

    public synchronized void nextPlayer() {
        if(++index >= activeSectorsID.size())
            index = 0;
//        index = index+1 % activeSectorsID.size();
        currentID = activeSectorsID.get(index);
    }
    public synchronized int getCurrentID() {
        return currentID;
    }

    public int getIndex() {
        return index;
    }

    public Board getBoardOfTrylma(){
        return boardOfTrylma;
    }
    public void setPegOfBoardOfTrylma(int i, int j, int Owner){
        boardOfTrylma.setPeg(i,j,Owner);
    }


//    public boolean isClicked(int x, int y) {
//        for(int i=0; i<I_BOARD_SIZE; i++) {
//            for (int j = 0; j < J_BOARD_SIZE; j++) {
//                if (board[i][j].isClicked(x,y))
//                    return true;
//            }
//        }
//        return false;
//    }

    public AbstractPeg findActive(int x, int y, int ID) {
        AbstractPeg activePeg = null;
        AbstractPeg p = getClicked(x,y);
        if(p!=null && p.getSectorID()==ID){
            //System.out.println(i + " " + j + "klikniety");
            activePeg = p;
        }
 		return activePeg;
    }

    public List<AbstractPeg> move(AbstractPeg pegToMove, int x, int y) {
        return boardOfTrylma.move(pegToMove, x, y);
    }

    public AbstractPeg getClicked(int x, int y) {
        return boardOfTrylma.getClicked(x, y);
    }

    public List<AbstractPeg> setPossibleMoves(AbstractPeg p){
        return boardOfTrylma.setPossibleMoves(p);
    }

    public void changePossibleMoves(List<AbstractPeg> list){
        boardOfTrylma.changeIdPossibleMoves(list);
    }

    public void printBoard() {
        boardOfTrylma.printBoard();
    }

    //Sprawdza czy Gracz zapełnił cały przeciwległy róg.
    public boolean isWinner(int PlayerID){
        int sector=0;
        if(PlayerID==1){ sector = 4; }
        else if(PlayerID==4){ sector = 1; }
        else if(PlayerID==6){ sector = 3; }
        else if(PlayerID==3){ sector = 6; }
        else if(PlayerID==5){ sector = 2; }
        else if(PlayerID==2){ sector = 5; }
        List<AbstractPeg> pegs = boardOfTrylma.getPegsOfSector(sector);
        for(int i=0; i<pegs.size(); i++){
            AbstractPeg p = pegs.get(i);
            if(p.getSectorID()!=PlayerID){
                return false;
            }
        }
        return true;
    }

    public AbstractPeg getPeg(int i, int j) {
        return boardOfTrylma.getPeg(i, j);
    }
    public static void main(String[] args) {
        BoardGenerator generatorB = new SixBoardGenerator();
        PegGenerator generatorP = new SixCirclePegGenerator();
        Game game = new Game(generatorB, generatorP);
//        game.printBoard();
    }


}



