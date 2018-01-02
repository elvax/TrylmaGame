package com.example.trylma.model;

import junit.framework.TestCase;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * SixSquarePegGenerator class checks the correctness of the method initializePeg()
 * which returns the object of SixSquarePeg class.
 * @author      Sebastian Pabich
 * @author      Maria Wita
 * @version     1.0
 * @since       1.0
 */
public class SixSquarePegGeneratorTest {

    @Test
    public void initializePeg() {
        PegGenerator p = new SixSquarePegGenerator();
        assertTrue(p.initializePeg() instanceof SixSquarePeg);
    }
}