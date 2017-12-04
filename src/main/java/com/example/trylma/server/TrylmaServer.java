package com.example.trylma.server;

import com.example.trylma.model.Game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class TrylmaServer {
    ServerSocket serverSocket;
    public static final int portNumber = 5555;
    private List<PlayerThread> clietnsThreadsList = new ArrayList<PlayerThread>();

    public TrylmaServer() {
        try {
            serverSocket = new ServerSocket(portNumber);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    private void waitForClients() throws IOException{
        System.out.println("Server is waiting for clients");
        while (true) {
            clietnsThreadsList.add(new PlayerThread(serverSocket.accept()));
        }
    }

    public static void main(String[] args) throws Exception {
        TrylmaServer server = new TrylmaServer();
        server.waitForClients();
    }
}

