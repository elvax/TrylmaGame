package com.example.trylma.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class SixCirclePegGeneratorTest {

    @Test
    public void initializePeg() {
        PegGenerator p = new SixCirclePegGenerator();
        assertTrue(p.initializePeg() instanceof Peg);
    }
}