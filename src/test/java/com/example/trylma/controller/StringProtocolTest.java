package com.example.trylma.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;

import static junit.framework.Assert.assertNull;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

/**
 * StringProtocolTest checks the correctness of the methods
 * included in the TrylmaStringProtocol.
 *
 * @author      Sebastian Pabich
 * @author      Maria Wita
 * @version     1.0
 * @since       1.0
 */

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

    @Test
    public void getInstanceTest() {
        TrylmaStringProtocol tmp = TrylmaStringProtocol.getInstance();
        assertNotNull(tmp);
    }

}
