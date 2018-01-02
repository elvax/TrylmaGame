package com.example.trylma.controller;

import com.sun.xml.internal.ws.api.message.MessageWritable;

import java.security.SecureRandom;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// TODO klasa ma być singletonem
public class TrylmaStringProtocol {

    private static TrylmaStringProtocol instance;

    private String regex = "(\\d+),(\\d+)";
    private Pattern pattern;
    private Matcher m;

    private TrylmaStringProtocol() {
    }

    /**
     * Get a single instance of type ReportBuilder
     *
     * @return A single instance
     */
    public static TrylmaStringProtocol getInstance() {
        if (instance == null) {
            synchronized (TrylmaStringProtocol.class) {
                if (instance == null)
                    instance = new TrylmaStringProtocol();
            }
        }
        return instance;
    }

    public static void resetInstance() {
        instance = null;
    }

    public static String sendMousePressed(int x, int y) {
        return "PRESSED (" + x + "," + y + ")";
    }

    public static String sendEndTurn() {
        return "ENDTURN";
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



