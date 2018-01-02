package com.example.trylma.model;

import com.example.trylma.model.Game;
import com.example.trylma.model.Peg;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Random;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;

public class GameTest {
    Game game;

    @Before
    public void initialize() throws Exception {
        BoardGenerator generator = new SixBoardGenerator();
        PegGenerator generatorP = new SixCirclePegGenerator();
        game = new Game(generator,generatorP);
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
        PegGenerator generatorP = new SixCirclePegGenerator();
        BoardGenerator generator = new SixBoardGenerator();
        game = new Game(generator, generatorP);
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


    @Test
    public void setBoardForPlayers() {
    }

    @Test
    public void getRandomPeg() {
    }

    @Test
    public void getPegsOfID() {

    }

    @Test
    public void getBoardOfTrylma() {
        assertNotNull(game.getBoardOfTrylma());
        assertTrue(game.getBoardOfTrylma() instanceof Board);
    }

    @Test
    public void setPegOfBoardOfTrylma() {
    }

    @Test
    public void findActive() {
    }

    @Test
    public void getClicked() {
    }

    @Test
    public void setPossibleMoves() {
        /*BoardGenerator generator = new SixBoardGenerator();
        PegGenerator generatorP = new SixCirclePegGenerator();
        game = new Game(generator,generatorP);
        Board board = game.getBoardOfTrylma();
        List<AbstractPeg> list = board.correctMoves(board.getPeg(3,6));
        board.setPossibleMoves(board.getPeg(3,6));
        board = game.getBoardOfTrylma();
        board.setPossibleMoves(board.getPeg(3,6));
        for(int i=0;i<list.size();i++){
            AbstractPeg p = list.get(i);
            assertEquals(7,board.getPeg(p.geti(),p.getj()).getSectorID());
        }
        board.changeIdPossibleMoves(list);*/
    }

    @Test
    public void changePossibleMoves() {
        /*Board board = game.getBoardOfTrylma();
        board.fillSector(4);
        List<AbstractPeg> list = board.correctMoves(board.getPeg(3,6));
        board.setPossibleMoves(board.getPeg(3,6));
        board.changeIdPossibleMoves(list);
        for(int i=0;i<list.size();i++){
            AbstractPeg p = list.get(i);
            assertEquals(0,board.getPeg(p.geti(),p.getj()).getSectorID());
        }*/
    }

    @Test
    public void getPeg() {
        assertNotNull(game.getPeg(7,7));
    }
}
