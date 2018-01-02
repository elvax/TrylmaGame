package com.example.trylma.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * TrylmaStringProtocol contains string which are send
 * from client to server. Contains also methods to
 * retrieve x and y which were send
 *
 * @author      Sebastian Pabich
 * @author      Maria Wita
 * @version     1.0
 * @since       1.0
 */
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

    /**
     * Method constructs string with information "pressed" and
     * x,y coordinates
     *
     * @param x             the x - coordinate x from mouse event pressed
     * @param y             the y - coordinate y from mouse event pressed
     * @return              string "pressed" with x,y coordinates
     * @since               1.0
     */
    public static String sendMousePressed(int x, int y) {
        return "PRESSED (" + x + "," + y + ")";
    }

    /**
     * Method constructs string with information "released" and
     * x,y coordinates
     *
     * @param x             the x - coordinate x from mouse event released
     * @param y             the y - coordinate y from mouse event released
     * @return              string "released" with x,y coordinates
     * @since               1.0
     */
    public static String sendMouseReleased(int x, int y) {
        return "RELEASED (" + x + "," + y + ")";
    }

    /**
     * Sends endturn string
     *
     * @return              string "endturn"
     * @since               1.0
     */
    public static String sendEndTurn() {
        return "ENDTURN";
    }

    /**
     * Method allows to retrieve x from given string
     *
     * @param message       string sent from client
     * @return              x coordinate from given string
     * @since               1.0
     */
    public int getXmouse(String message) {
        pattern = Pattern.compile(regex);
        m = pattern.matcher(message);
        m.find();
        return Integer.parseInt(m.group(1));
    }

    /**
     * Method allows to retrieve y from given string
     *
     * @param message       string sent from client
     * @return              y coordinate from given string
     * @since               1.0
     */
    public int getYmouse(String message) {
        pattern = Pattern.compile(regex);
        m = pattern.matcher(message);
        m.find();
        return Integer.parseInt(m.group(2));
    }

}



