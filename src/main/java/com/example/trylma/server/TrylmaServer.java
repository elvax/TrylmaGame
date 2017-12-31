package com.example.trylma.server;


import com.example.trylma.controller.TrylmaStringProtocol;
import com.example.trylma.model.AbstractPeg;
import com.example.trylma.model.Game;
import com.example.trylma.model.Peg;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

import static com.example.trylma.controller.TrylmaStringProtocol.*;

//TODO pozwalać na jeden ruch pionkiem
public class TrylmaServer {

    ServerSocket serverSocket;
    public static final int portNumber = 5555;
    TrylmaStringProtocol protocol;
    Game currentGame;
    int numberOfPlayers;

    // List of clients connected to server
    private List<PlayerThread> clietnsThreadsList = new ArrayList<PlayerThread>();

    // sets of inputs and outputs for every client connected
    private HashSet<PrintWriter> writers = new HashSet<PrintWriter>();
    private HashSet<BufferedReader> readers = new HashSet<BufferedReader>();
    private HashSet<ObjectOutputStream> objectOutput = new HashSet<ObjectOutputStream>();


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

        // Wait for clients to connect
        for (Integer id : currentGame.getActiveSectorsID()) {
            clietnsThreadsList.add(new PlayerThread(serverSocket.accept(), id));
        }

        System.out.println(numberOfPlayers + " clients connected");

        // Start client's threads
        for (PlayerThread pt : clietnsThreadsList) {
            pt.start();
        }

    }

    public static void main(String[] args) {
        TrylmaServer server = new TrylmaServer();
        try {
            server.waitForClients(3);
        } catch (IOException e) {
            e.printStackTrace();
        }
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

        private void initializeStreams() throws IOException{
            //Initalize streams
            input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            output = new PrintWriter(socket.getOutputStream(), true);
            objectInputStream = new ObjectInputStream(socket.getInputStream());
            objectOutputStream = new ObjectOutputStream(socket.getOutputStream());

            // add stream to sets
            writers.add(output);
            readers.add(input);
            objectOutput.add(objectOutputStream);
        }

        public void run() {
            try {
                initializeStreams();

                //send initial board state to connected client
                objectOutputStream.writeObject(currentGame.getBoardOfTrylma());

                List<AbstractPeg> pegsToChange = new ArrayList<AbstractPeg>();
                Boolean permission;
                while (true) {
                    if (currentGame.getCurrentID() == this.id) {
                        permission = true;
                        objectOutputStream.writeObject(permission);

                        String fromClient = input.readLine();

                        if (fromClient.startsWith("PRESSED")) {

                            AbstractPeg pegClicked = currentGame.findActive(protocol.getXmousePressed(fromClient),
                                                                            protocol.getYmousePressed(fromClient),
                                                                            id);
                            if(pegClicked!=null) {
                                List<AbstractPeg> possibilities = currentGame.setPossibleMoves(pegClicked);
                                if (possibilities.size() > 0) {
                                    AbstractPeg[] array2 = new AbstractPeg[possibilities.size()];
                                    for (int i = 0; i < possibilities.size(); i++) {
                                        AbstractPeg p = possibilities.get(i);
                                        //pegsToChange.add(possibilities.get(i));
                                        pegsToChange.add(p);
                                        //array2[i] = p;
                                        //System.out.println("ECH:" + p);
                                        array2[i] = new Peg(p.geti(), p.getj(), p.getSectorID());
                                        //System.out.println("ToSEND1: i="+ array2[i].geti() + " j= " + array2[i].getj() + " id=" + array2[i].getSectorID());

                                    }
                                    objectOutputStream.writeObject(array2);
                                }

                            }
                            fromClient = input.readLine();
                            if (fromClient.startsWith("RELEASED") && pegClicked!=null) {
                                //System.out.println("Clicked2: i="+ pegClicked.geti() + " j= " + pegClicked.getj());
                                currentGame.changePossibleMoves(pegsToChange);
                                //currentGame.printBoard();
                                int xD = protocol.getXmousePressed(fromClient);
                                int yD = protocol.getYmousePressed(fromClient);
                                AbstractPeg pegDestiny = currentGame.getClicked(xD, yD);

                                List<AbstractPeg> pegs = currentGame.move(pegClicked, xD, yD);

                                if (pegs.size()==2) {
                                    pegClicked = pegs.get(0);
                                    pegsToChange.add(pegClicked);
                                    pegDestiny = pegs.get(1);
                                    pegsToChange.add(pegDestiny);
                                }
                                if(pegsToChange.size()>0){
                                    AbstractPeg[] array3 = new AbstractPeg[pegsToChange.size()];
                                    for(int i=0; i<pegsToChange.size(); i++){
                                        array3[i]=pegsToChange.get(i);
                                        //System.out.println("ToSEND2: i="+ array3[i].geti() + " j= " + array3[i].getj() + " id=" + array3[i].getSectorID());
                                    }
                                    for (ObjectOutputStream objectOut : objectOutput) {
                                        objectOut.writeObject(array3);
                                    }
                                }
                                pegsToChange.clear();
                                //currentGame.printBoard();
                            }

                        }
                        if (fromClient.equals(sendEndTurn())) {
                            permission = false;
                            objectOutputStream.writeObject(permission);
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

