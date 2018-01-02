package com.example.trylma.model;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
/**
 * SixBoardTest checks the correctness of the methods
 * included in the SixBoard class.
 *
 * @author      Sebastian Pabich
 * @author      Maria Wita
 * @version     1.0
 * @since       1.0
 */
public class SixBoardTest {
    Board board;
    PegGenerator generatorP;
    BoardGenerator generator;

    @Before
    public void initialize() throws Exception {
        generatorP = new SixCirclePegGenerator();
        generator = new SixBoardGenerator();
        board = generator.generateBoard(generatorP);
        board.fillSector(1);
        assertNotNull(board);
    }

    @Test
    public void move() {
        AbstractPeg pegToMove = board.getPeg(13, 5);
        AbstractPeg pegDestiny = board.getPeg(12, 5);

        board.move(pegToMove, pegDestiny.getxDraw()+15, pegDestiny.getyDraw()+15);
        assertEquals(1, board.getPeg(12,5).getSectorID());
    }

    @Test
    public void generateBoard() {
        generatorP = new SixCirclePegGenerator();
        generator = new SixBoardGenerator();
        board = generator.generateBoard(generatorP);
        board.fillSector(1);
        assertNotNull(board);
    }

    @Test
    public void setBoardForPlayers() {
        board = generator.generateBoard(generatorP);
        board.setBoardForPlayers(6);
        assertNotNull(board);
        for(int i=1; i<7; i++){
            List<AbstractPeg> list = board.getPegsOfID(i);
            assertEquals(10,list.size());
        }
    }

    @Test
    public void updateTest() {
        AbstractPeg[] toChange = new AbstractPeg[1];
        toChange[0] = generatorP.generatePeg(12, 6, 1);
        board.updateBoard(toChange);
        assertEquals(1, board.getPeg(12,6).getSectorID());
    }

    @Test
    public void getPegsOfID() {
        List<AbstractPeg> list = board.getPegsOfID(1);
        assertEquals(10,list.size());
    }

    @Test
    public void fillSector() {
        int OwnerID = 4;
        PegGenerator generatorP = new SixCirclePegGenerator();
        board = generator.generateBoard(generatorP);
        board.fillSector(4);
        List<AbstractPeg> list = board.getPegsOfSector(4);
        for(int i=0; i< list.size(); i++){
            AbstractPeg p = list.get(i);
            assertEquals(4,p.getSectorID());
        }
    }

    @Test
    public void getPeg() {
        assertNotNull(board.getPeg(7,7));
    }

    @Test
    public void correctMoves() {
        generatorP = new SixCirclePegGenerator();
        generator = new SixBoardGenerator();
        board = generator.generateBoard(generatorP);
        board.fillSector(4);
        List<AbstractPeg> list = board.correctMoves(board.getPeg(3,6));
        assertEquals(2, list.size());
    }

    @Test
    public void setPossibleMoves() {
        generatorP = new SixCirclePegGenerator();
        generator = new SixBoardGenerator();
        board = generator.generateBoard(generatorP);
        board.fillSector(4);
        List<AbstractPeg> list = board.correctMoves(board.getPeg(3,6));
        board.setPossibleMoves(board.getPeg(3,6));
        for(int i=0;i<list.size();i++){
            AbstractPeg p = list.get(i);
            assertEquals(7,board.getPeg(p.geti(),p.getj()).getSectorID());
        }
    }

    @Test
    public void changeIdPossibleMoves() {
        generatorP = new SixCirclePegGenerator();
        generator = new SixBoardGenerator();
        board = generator.generateBoard(generatorP);
        board.fillSector(4);
        List<AbstractPeg> list = board.correctMoves(board.getPeg(3,6));
        board.setPossibleMoves(board.getPeg(3,6));
        board.changeIdPossibleMoves(list);
        for(int i=0;i<list.size();i++){
            AbstractPeg p = list.get(i);
            assertEquals(0,board.getPeg(p.geti(),p.getj()).getSectorID());
        }
    }

    @Test
    public void getPegsOfSector() {
        for(int i=1; i<7; i++){
            List<AbstractPeg> list = board.getPegsOfSector(i);
            assertEquals(10,list.size());
        }
    }

    @Test
    public void setPeg() {
        board = generator.generateBoard(generatorP);
        board.setPeg(7,7,1);
        assertEquals(7,board.getPeg(7,7).geti());
        assertEquals(7,board.getPeg(7,7).getj());
        assertEquals(1,board.getPeg(7,7).getSectorID());
    }

    @Test
    public void isWinner() {
        int OwnerID = 6;
        PegGenerator generatorP = new SixCirclePegGenerator();
        board = generator.generateBoard(generatorP);
        List<AbstractPeg> list = board.getPegsOfSector(3);
        for(int i=0; i< list.size(); i++){
            AbstractPeg p = list.get(i);
            board.setPeg(p.geti(),p.getj(),OwnerID);
        }
        boolean a = board.isWinner(OwnerID);
        assertEquals(true, a);
    }

}
