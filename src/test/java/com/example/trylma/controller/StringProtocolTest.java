package com.example.trylma.controller;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

public class StringProtocolTest {
    TrylmaStringProtocol protocol;
    @Before
    public void initialize() throws Exception {
        protocol = TrylmaStringProtocol.getInstance();
    }

    @Test
    public void getXmousePressedTest() {
        String message = "PRESSED (123,456)";
        int result = protocol.getXmouse(message);
        assertEquals(123,result);
    }

    @Test
    public void getYmousePressedTest() {
        String message = "PRESSED (123,456)";
        int result = protocol.getYmouse(message);
        assertEquals(456,result);
    }

}
