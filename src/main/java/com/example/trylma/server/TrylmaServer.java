package com.example.trylma.server;

import java.net.ServerSocket;

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
}
