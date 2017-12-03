package com.example.trylma.server;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TrylmaServer {
    public static final int portNumber = 5555;


    public static void main(String[] args) throws Exception {
        ServerSocket listener = new ServerSocket(portNumber);
        System.out.println("Trylma server is running");
        try {

        } finally {
            listener.close();
        }
    }


    private class PlayerThread extends Thread{

    }
}

