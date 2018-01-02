package com.example.trylma.model;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * SixCirclePegGeneratorTest class check the correctness of the method initializePeg()
 * which returns the object of Peg class - circle pegs.
 * @author      Sebastian Pabich
 * @author      Maria Wita
 * @version     1.0
 * @since       1.0
 */
public class SixCirclePegGeneratorTest {

    @Test
    public void initializePeg() {
        PegGenerator p = new SixCirclePegGenerator();
        assertTrue(p.initializePeg() instanceof Peg);
    }
}