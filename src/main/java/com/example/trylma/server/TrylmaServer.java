package com.example.trylma.server;

import com.example.trylma.controller.TrylmaStringProtocol;
import com.example.trylma.model.AbstractPeg;
import com.example.trylma.model.Game;
import com.example.trylma.model.Peg;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import static com.example.trylma.controller.TrylmaStringProtocol.*;

public class TrylmaServer {

    ServerSocket serverSocket;
    public static final int portNumber = 5555;
    TrylmaStringProtocol protocol;
    Game currentGame;
    int currentPlayer=0;
    int numberOfPlayers;
    AbstractPeg activePeg;

    BufferedReader inputLineFromStdIn = new BufferedReader(new InputStreamReader(System.in));
    String fromUser;



    // List of clients connected to server
    private List<PlayerThread> clietnsThreadsList = new ArrayList<PlayerThread>();

    // TODO new HashSet.. pewnie do konstrukora przenieść
    // TODO trzeba bedzie przerobic na (KEY, VALUYE) gdzie key to IDclienta
    // sets of inputs and outputs for every client connected
    private HashSet<PrintWriter> writers = new HashSet<PrintWriter>();
    private HashSet<BufferedReader> readers = new HashSet<BufferedReader>();
    private HashSet<ObjectOutputStream> objectOutput = new HashSet<ObjectOutputStream>();

    // TODO rzucic wyjatek a nie lapac
    public TrylmaServer() {
        protocol = new TrylmaStringProtocol();
        currentGame = new Game();


        try {
            serverSocket = new ServerSocket(portNumber);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void waitForClients(int numberOfPlayers) throws IOException{
        System.out.println("Server is waiting for clients");
        this.numberOfPlayers = numberOfPlayers;
        currentGame.setBoardForPlayers(numberOfPlayers);
        currentGame.setOrderOfMoves();


        for (Integer id : currentGame.getActiveSectorsID()) {
            clietnsThreadsList.add(new PlayerThread(serverSocket.accept(), id));
        }

        System.out.println(numberOfPlayers + " clients connected");

        for (PlayerThread pt : clietnsThreadsList) {
            pt.start();
        }


    }

    public static void main(String[] args) throws Exception {
        TrylmaServer server = new TrylmaServer();
        server.waitForClients(2);
    }

    private class PlayerThread extends Thread {

        int id;
        Socket socket;
        BufferedReader input;
        PrintWriter output;
        ObjectInputStream objectInputStream;
        ObjectOutputStream objectOutputStream;

        public PlayerThread(Socket socket, int id) {
            this.socket = socket;
            this.id = id;
        }

        public void run() {
            try {
                //Initalize streams
                input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                output = new PrintWriter(socket.getOutputStream(), true);
                objectInputStream = new ObjectInputStream(socket.getInputStream());
                objectOutputStream = new ObjectOutputStream(socket.getOutputStream());

                // add stream to sets
                writers.add(output);
                readers.add(input);
                objectOutput.add(objectOutputStream);

                //send initial board state to connected client
                objectOutputStream.writeObject(currentGame.getBoardOfTrylma());

                while (true) {

                    if (currentGame.getCurrentID() == this.id) {
                        String fromClient = input.readLine();
                        System.out.println("from client " + id + " " + fromClient);
                        //wciśnięty : to ustawiam aktywny pionek i
                        if (fromClient.equals(sendMousePressed(protocol.getXmousePressed(fromClient),protocol.getYmousePressed(fromClient)))){
                            activePeg = currentGame.findActive(protocol.getXmousePressed(fromClient), protocol.getYmousePressed(fromClient),currentGame.getCurrentID());
                            if(activePeg!=null){
                                currentGame.getBoardOfTrylma().move((Peg)activePeg, protocol.getXmousePressed(fromClient), protocol.getYmousePressed(fromClient));
                            }
                        }
                        //puszczony to nanoszę ruch metodą move, ktora sprawdza czy ruch jest ok jesli ok to nanosi zmiany
                        // a jesli nie jest ok to ich nie nanosi do tablicy
                        if (fromClient.equals("RELEASED (" + protocol.getXmousePressed(fromClient) + "," + protocol.getYmousePressed(fromClient) + ")")){
                            if(activePeg!=null){
                                currentGame.getBoardOfTrylma().move((Peg)activePeg, protocol.getXmousePressed(fromClient), protocol.getYmousePressed(fromClient));
                            }
                            //currentGame.getBoardOfTrylma().printBoard();
                            // nie wiem myslalam ze w ten sposób naniosę zmiany do klientów ale chyba nie tak to sie robi
                            // bo chociaz tablica sie zmienia to klient nawet po uzyciu petli(while w kliencie) jej nie dostaje
                            objectOutputStream.writeObject(currentGame.getBoardOfTrylma());
                        }
                        if (fromClient.equals(sendEndTurn())) {
                            currentGame.nextPlayer();
                        }
                    }

                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}

