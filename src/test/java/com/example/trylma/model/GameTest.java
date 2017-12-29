package com.example.trylma.model;

import com.example.trylma.model.Game;
import com.example.trylma.model.Peg;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Random;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

public class GameTest {
    Game game;

    @Before
    public void initialize() throws Exception {
        game = new Game();
        game.setBoardForPlayers(6);
        assertNotNull(game);
    }

    @Test
    public void moveTest() {
        AbstractPeg pegToMove = game.getPeg(13, 5);
        AbstractPeg pegDestiny = game.getPeg(12, 5);

        game.move(pegToMove, pegDestiny.getxDraw()+15, pegDestiny.getyDraw()+15);
        assertEquals(1, game.getPeg(12,5).getSectorID());
    }

    @Test
    public void isWinnerTest() {
        int OwnerID = 6;
        game = new Game();
        Board board = game.getBoardOfTrylma();
        List<AbstractPeg> list = board.getPegsOfSector(3);

        for(int i=0; i< list.size(); i++){
            AbstractPeg p = list.get(i);
            game.setPegOfBoardOfTrylma(p.geti(),p.getj(),OwnerID);
        }
        game.printBoard();
        boolean a = game.isWinner(OwnerID);
        System.out.println(a);
        assertEquals(true, a);
    }


}
