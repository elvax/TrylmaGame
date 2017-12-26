package com.example.trylma.model;

import com.example.trylma.model.Game;
import com.example.trylma.model.Peg;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static junit.framework.TestCase.assertNotNull;

public class GameTest {
    Game game;

    @Before
    public void initialize() throws Exception {
        game = new Game();
        assertNotNull(game);
    }
}
