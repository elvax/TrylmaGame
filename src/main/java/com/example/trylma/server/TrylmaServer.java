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
    public static final int portNumber = 5555;
    private List<PlayerThread> clietnsThreadsList = new ArrayList<PlayerThread>();


    public void main(String[] args) throws Exception {
        ServerSocket listener = new ServerSocket(portNumber);
        System.out.println("Trylma server is running");
        try {
            while (true) {
                Game game = new Game();
                clietnsThreadsList.add(new PlayerThread(listener.accept()));
                // start all threads from the list
            }
        } finally {
            listener.close();
        }
    }


    private class PlayerThread extends Thread {
        String name;
        Socket socket;
        BufferedReader input;
        PrintWriter output;

        public PlayerThread(Socket socket) {
            this.socket = socket;
            try {
                input = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));
                output = new PrintWriter(socket.getOutputStream(), true);
                output.println("WELCOME playerThread");
            } catch (IOException e) {
                System.err.println(e);
            }
        }

        public void run() {
            try {
                while (input.readLine() != "bye") {
                    output.println("doszło cos");
                }
            } catch (IOException e) {

            }
        }
    }
}

