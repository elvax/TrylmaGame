package com.example.trylma.model;

import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Vector;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

public class BoardTest {
    Board board;

    @Before
    public void initialize() throws Exception {
        PegGenerator generatorP = new SixCirclePegGenerator();
        BoardGenerator generator = new SixBoardGenerator();
        board = generator.generateBoard(generatorP);
        //board.printBoard();
        board.fillSector(1);
       // board.printBoard();
        assertNotNull(board);
    }

    @Test
    public void moveTest() {
        AbstractPeg pegToMove = board.getPeg(13, 5);
        AbstractPeg pegDestiny = board.getPeg(12, 5);

        board.move(pegToMove, pegDestiny.getxDraw()+15, pegDestiny.getyDraw()+15);
        assertEquals(1, board.getPeg(12,5).getSectorID());
        //board.printBoard();
    }



//    @Test
//    public void updateTest() {
//        List<AbstractPeg> toChange = new Vector<AbstractPeg>();
//        toChange.add(new Peg(12, 6, 1));
//        board.updateBoard(toChange);
//        assertEquals(1, board.getPeg(12,6).getSectorID());
//    }
}
