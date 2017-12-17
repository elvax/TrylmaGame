package com.example.trylma.server;

import com.example.trylma.controller.TrylmaStringProtocol;
import com.example.trylma.model.Game;
import com.example.trylma.model.TestPegToSend;

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

    Game currentGame;

    private List<PlayerThread> clietnsThreadsList = new ArrayList<PlayerThread>();
    private HashSet<PrintWriter> writers = new HashSet<PrintWriter>();
    private HashSet<BufferedReader> readers = new HashSet<BufferedReader>();
    private HashSet<ObjectOutputStream> objectOutput = new HashSet<ObjectOutputStream>();

    public TrylmaServer() {
        try {
            serverSocket = new ServerSocket(portNumber);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    private void waitForClients() throws IOException{
        System.out.println("Server is waiting for clients");

        int numberOfPlayers = 1;
        while (clietnsThreadsList.size() != numberOfPlayers) {
            clietnsThreadsList.add(new PlayerThread(serverSocket.accept()));
        }
        System.out.println(numberOfPlayers + " clients connected");

        for (PlayerThread pt : clietnsThreadsList) {
            pt.start();
            System.out.println("run client");
        }
        System.out.println("cilents are running");

        currentGame = new Game();
        currentGame.setPegsForOnePlayer();

        TrylmaStringProtocol protocol = new TrylmaStringProtocol();


        while (true) {
//            fromUser = inputLineFromStdIn.readLine();
//            for (PrintWriter pw : writers) {
//                pw.println(fromUser);
//            }
//            if(fromUser.equals("koniec"))
//                break;
            for (ObjectOutputStream oos : objectOutput) {
//                oos.writeObject(testPegToSend);
                oos.writeObject(currentGame.getBoard());
            }

            for (BufferedReader bf : readers) {
                String fromClient = bf.readLine();
                System.out.println(fromClient);
                if (fromClient.startsWith("PRESSED")) {
                    if(currentGame.isClicked(protocol.getXmousePressed(fromClient),
                            protocol.getYmousePressed(fromClient)))
                        System.out.println("true");
                }
            }

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
        ObjectInputStream objectInputStream;
        ObjectOutputStream objectOutputStream;

        public PlayerThread(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                //Initalize streams
                input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                output = new PrintWriter(socket.getOutputStream(), true);
                objectInputStream = new ObjectInputStream(socket.getInputStream());
                objectOutputStream = new ObjectOutputStream(socket.getOutputStream());

                writers.add(output);
                readers.add(input);
                objectOutput.add(objectOutputStream);
//                while (true) {
//                    String line = input.readLine();
//                }
            } catch (IOException e) {

            }
        }
    }
}

