package com.example.trylma.com.example.trylma.model;

import com.example.trylma.model.Game;
import com.example.trylma.model.Peg;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertNotNull;

public class GameTest {
    Game game;

    @Before
    public void initialize() throws Exception {
        game = new Game();
        assertNotNull(game);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetPeg() {
        game.getPeg(-1, -1);
    }
}
