package com.example.trylma.client;

import com.example.trylma.server.TrylmaServer;

import java.net.Socket;

/**
 * Constructs client by connecting to server
 */
//TODO tu ma byc GUI
public class TrylmaClient {
    private Socket socket;

    public TrylmaClient(String serverAdress) throws Exception{

        // Setup networking
        socket = new Socket(serverAdress, TrylmaServer.portNumber);
    }

}

