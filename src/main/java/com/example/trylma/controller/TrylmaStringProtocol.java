package com.example.trylma.controller;

import com.sun.xml.internal.ws.api.message.MessageWritable;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

// TODO klasa ma być singletonem
public class TrylmaStringProtocol {
    private static int xPressed, yPressed;
    private String regex = "(\\d+),(\\d+)";
    private Pattern pattern;
    private Matcher m;

    public TrylmaStringProtocol() {
        pattern = Pattern.compile(regex);
    }

    public static String mousePressed(int x, int y) {
        xPressed = x;
        yPressed = y;
        return "PRESSED (" + x + "," + y + ")";
    }

    public int getXmousePressed(String message) {
        m = pattern.matcher(message);
        m.find();
        return Integer.parseInt(m.group(1));
    }

    public int getYmousePressed(String message) {
        m = pattern.matcher(message);
        m.find();
        return Integer.parseInt(m.group(2));
    }

}



