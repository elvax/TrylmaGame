package com.example.trylma.controller;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

public class StringProtocolTest {
    TrylmaStringProtocol protocol;
    @Before
    public void initialize(){
        protocol = new TrylmaStringProtocol();
    }

    @Test
    public void getXmousePressedTest() {
        String message = "PRESSED (123,456)";
        int result = protocol.getXmousePressed(message);
        assertEquals(123,result);
    }

    @Test
    public void getYmousePressedTest() {
        String message = "PRESSED (123,456)";
        int result = protocol.getYmousePressed(message);
        assertEquals(456,result);
    }

}
