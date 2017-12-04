package com.example.trylma.server;

import com.example.trylma.model.Game;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class TrylmaServer {
    ServerSocket serverSocket;
    public static final int portNumber = 5555;

    BufferedReader inputLineFromStdIn = new BufferedReader(new InputStreamReader(System.in));
    String fromUser;

    private List<PlayerThread> clietnsThreadsList = new ArrayList<PlayerThread>();
    private HashSet<PrintWriter> writers = new HashSet<PrintWriter>();

    public TrylmaServer() {
        try {
            serverSocket = new ServerSocket(portNumber);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    private void waitForClients() throws IOException{
        System.out.println("Server is waiting for clients");

        while (clietnsThreadsList.size() != 2) {
            clietnsThreadsList.add(new PlayerThread(serverSocket.accept()));
        }
        System.out.println("2 clients connected");

        for (PlayerThread pt : clietnsThreadsList) {
            pt.start();
            System.out.println("run client");
        }
        System.out.println("cilents are running");



        while ((fromUser = inputLineFromStdIn.readLine()) != null) {
            for (PrintWriter pw : writers) {
                pw.println(fromUser);
            }
            if(fromUser.equals("koniec"))
                break;
        }

    }

    public static void main(String[] args) throws Exception {
        TrylmaServer server = new TrylmaServer();
        server.waitForClients();
    }

    private class PlayerThread extends Thread {

        String name;
        Socket socket;
        BufferedReader input;
        PrintWriter output;

        public PlayerThread(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                //Initalize streams
                input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                output = new PrintWriter(socket.getOutputStream(), true);

                writers.add(output);
//                while (true) {
//                    String line = input.readLine();
//                }
            } catch (IOException e) {

            }
        }
    }
}

