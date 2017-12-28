package com.example.trylma.model;

import com.example.trylma.model.Game;
import com.example.trylma.model.Peg;
import org.junit.Before;
import org.junit.Test;

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
        AbstractPeg pegDestiny = game.getPeg(12, 6);

        game.move(pegToMove, pegDestiny.getxDraw(), pegDestiny.getyDraw());
        assertEquals(1, game.getPeg(12,6).getSectorID());
    }
}
