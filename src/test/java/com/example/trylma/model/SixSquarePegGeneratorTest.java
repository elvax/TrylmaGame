package com.example.trylma.model;

import junit.framework.TestCase;
import org.junit.Test;

import static org.junit.Assert.*;

public class SixSquarePegGeneratorTest {

    @Test
    public void initializePeg() {
        PegGenerator p = new SixSquarePegGenerator();
        assertTrue(p.initializePeg() instanceof SixSquarePeg);
    }
}