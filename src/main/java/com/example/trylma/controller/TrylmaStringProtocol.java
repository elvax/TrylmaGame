package com.example.trylma.controller;

import com.sun.xml.internal.ws.api.message.MessageWritable;

import java.security.SecureRandom;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// TODO klasa ma być singletonem
public class TrylmaStringProtocol {
    private static int xPressed, yPressed;
    private String regex = "(\\d+),(\\d+)";
    String regex2 = "(\\d+),(\\d+)\\d";
    private Pattern pattern;
    private Matcher m;

    public TrylmaStringProtocol() {

    }

    public static String sendMousePressed(int x, int y) {
        xPressed = x;
        yPressed = y;
        return "PRESSED (" + x + "," + y + ")";
    }

    public static String sendEndTurn() {
        return "ENDTURN";
    }

    public static String sendChange(int i, int j, int id) {
        return "CHANGE (" + i + "," + j + ")" + id;
    }

    public int DecodeMoveX(String message) {
        pattern = Pattern.compile(regex2);
        m = pattern.matcher(message);
        m.find();
        return Integer.parseInt(m.group(1));
    }

    public int DecodeMoveY(String message) {
        pattern = Pattern.compile(regex2);
        m = pattern.matcher(message);
        m.find();
        return Integer.parseInt(m.group(2));
    }

    public int DecodeMoveID(String message) {
        pattern = Pattern.compile(regex2);
        m = pattern.matcher(message);
        m.find();
        return Integer.parseInt(m.group(3));
    }

    public int getXmousePressed(String message) {
        pattern = Pattern.compile(regex);
        m = pattern.matcher(message);
        m.find();
        return Integer.parseInt(m.group(1));
    }

    public int getYmousePressed(String message) {
        pattern = Pattern.compile(regex);
        m = pattern.matcher(message);
        m.find();
        return Integer.parseInt(m.group(2));
    }

}



