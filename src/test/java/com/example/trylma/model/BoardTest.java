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
        board = new Board();
        board.fillSectorOne();
        assertNotNull(board);
    }

    @Test
    public void moveTest() {
        AbstractPeg pegToMove = board.getPeg(13, 5);
        AbstractPeg pegDestiny = board.getPeg(12, 6);

        board.move(pegToMove, pegDestiny.getxDraw(), pegDestiny.getyDraw());
        assertEquals(1, board.getPeg(12,6).getSectorID());
    }

//    @Test
//    public void updateTest() {
//        List<AbstractPeg> toChange = new Vector<AbstractPeg>();
//        toChange.add(new Peg(12, 6, 1));
//        board.updateBoard(toChange);
//        assertEquals(1, board.getPeg(12,6).getSectorID());
//    }
}
