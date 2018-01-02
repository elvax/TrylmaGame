package com.example.trylma.model;

import com.example.trylma.model.Peg;
import junit.framework.TestCase;

import java.io.IOException;
/**
 * The PegTest class checks the correctness of the methods
 * needed to draw a square peg for the board, which is a six-pointed star.
 * @author      Sebastian Pabich
 * @author      Maria Wita
 * @version     1.0
 * @since       1.0
 */
public class PegTest extends TestCase {
    AbstractPeg p = null;
    int i = 8;
    int j = 8;
    int xDraw = 30;
    int yDraw = 35;
    int ownerID = 1;

    protected void setUp() throws Exception {
        PegGenerator generatorP = new SixCirclePegGenerator();
        p = generatorP.generatePeg(i,j,ownerID);
        p.setXY(xDraw, yDraw);
        assertNotNull(p);
    }

    public void testIsClicked() {
        boolean result = p.isClicked(55,50);
        boolean result2 = p.isClicked(60,35);
        assertTrue(result);
        assertFalse(result2);
    }

    public void testGeneratePeg() {
        PegGenerator generatorP = new SixCirclePegGenerator();
        p = generatorP.generatePeg(i,j,ownerID);
        p.setXY(xDraw, yDraw);
        assertNotNull(p);
    }

    public void testSetXY() {
        p.setXY(10,10);
        assertEquals(10,p.getxDraw());
        assertEquals(10,p.getyDraw());
    }

    public void testGetxDraw() {
        p.setXY(10,10);
        assertEquals(10,p.getxDraw());
    }

    public void testGetyDraw() {
        p.setXY(10,10);
        assertEquals(10,p.getyDraw());
    }

    public void testGeti() {
        assertEquals(8,p.geti());
    }

    public void testGetj() {
        assertEquals(8,p.getj());
    }

    public void testGetSectorID() {
        assertEquals(1,p.getSectorID());
    }

    public void testSetImage() throws IOException {
        p.setImage();
    }

    public void testChangeOwnerID() {
        p.changeOwnerID(2);
        assertEquals(2,p.getSectorID());
        p.changeOwnerID(1);
        assertEquals(1,p.getSectorID());
    }
}