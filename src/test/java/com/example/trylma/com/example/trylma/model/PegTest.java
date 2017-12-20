package com.example.trylma.com.example.trylma.model;

import com.example.trylma.model.Peg;
import junit.framework.TestCase;
import org.junit.Before;

public class PegTest extends TestCase {
    Peg p = null;
    int i = 8;
    int j = 8;
    int xDraw = 30;
    int yDraw = 35;
    int ownerID = 1;

    @Before
    public void setUp() throws Exception {
        p = new Peg(i,j,ownerID);
        p.setXY(xDraw, yDraw);
        assertNotNull(p);
    }

    public void testIsClicked() {
        boolean result = p.isClicked(55,50);
        boolean result2 = p.isClicked(60,35);
        assertTrue(result);
        assertFalse(result2);
    }
}