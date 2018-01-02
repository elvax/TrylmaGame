package com.example.trylma.server;


import com.example.trylma.controller.TrylmaStringProtocol;
import com.example.trylma.model.*;

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
    BoardGenerator generatorB;
    PegGenerator generatorP;

    // List of clients connected to server
    private List<Thread> clietnsThreadsList = new ArrayList<Thread>();

    // sets of inputs and outputs for every client connected
    private HashSet<PrintWriter> writers = new HashSet<PrintWriter>();
    private HashSet<BufferedReader> readers = new HashSet<BufferedReader>();
    private HashSet<ObjectOutputStream> objectOutput = new HashSet<ObjectOutputStream>();


    public TrylmaServer() {
        protocol = TrylmaStringProtocol.getInstance();
        generatorB = new SixBoardGenerator();
        generatorP = new SixCirclePegGenerator();
        //generatorP = new SixSquarePegGenerator();
        currentGame = new Game(generatorB, generatorP);
        try {
            serverSocket = new ServerSocket(portNumber);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    private void waitForPlayers(int numberOfPlayers) throws IOException {
        System.out.println("Server is waiting for clients");
        this.numberOfPlayers = numberOfPlayers;
        currentGame.setBoardForPlayers(numberOfPlayers);
        currentGame.setOrderOfMoves();

        do {
            clietnsThreadsList.add(new PlayerThread(serverSocket.accept(), currentGame.getCurrentID()));
            currentGame.nextPlayer();
        } while (false);

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
        for (Thread pt : clietnsThreadsList) {
            pt.start();
        }

    }

    private void waitForClientWithBot() throws IOException{
        System.out.println("Server is waiting for clients");
        currentGame.setBoardForPlayers(2);
        currentGame.setOrderOfMoves();

        PlayerThread player = new PlayerThread(serverSocket.accept(), 1);
        BotThread bot = new BotThread(4);

        player.start();
        bot.start();

        System.out.println("client and bot connected");

        // Start client's threads


    }

    public static void main(String[] args) {
        TrylmaServer server = new TrylmaServer();

        try {
            server.waitForClients(2);
//            server.waitForClientWithBot();
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

        public PlayerThread(Socket socket, int id) throws IOException{
            this.socket = socket;
            this.id = id;
            initializeStreams();
        }

        @Override
        public String toString() {
            return "Palyer " + id;
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

        private void sendPermissionToMove(Boolean permission) throws IOException{
            objectOutputStream.writeObject(permission);
        }

        public void run() {
            try {


                //send initial board state to connected client
                objectOutputStream.writeObject(currentGame.getBoardOfTrylma());

                objectOutputStream.writeObject("Player " + Integer.toString(id));

                List<AbstractPeg> pegsToChange = new ArrayList<AbstractPeg>();
                while (true) {
                    if (currentGame.getCurrentID() == this.id) {

                        String whosTurnIs = "Player" + currentGame.getCurrentID();
                        for (ObjectOutputStream out : objectOutput) {
                            out.writeObject(whosTurnIs);
                        }
                        sendPermissionToMove(true);

                        String fromClient = input.readLine();

                        if (fromClient.startsWith("PRESSED")) {

                            AbstractPeg pegClicked = currentGame.findActive(protocol.getXmouse(fromClient),
                                                                            protocol.getYmouse(fromClient),
                                                                            id);
                            if(pegClicked!=null) {
                                List<AbstractPeg> possibilities = currentGame.setPossibleMoves(pegClicked);
                                if (possibilities.size() > 0) {
                                    AbstractPeg[] array2 = new AbstractPeg[possibilities.size()];
                                    for (int i = 0; i < possibilities.size(); i++) {
                                        AbstractPeg p = possibilities.get(i);
                                        pegsToChange.add(p);
                                        array2[i] = generatorP.generatePeg(p.geti(), p.getj(), p.getSectorID());
                                    }
                                    objectOutputStream.writeObject(array2);
                                }
                            }
                            fromClient = input.readLine();
                            if (fromClient.startsWith("RELEASED") && pegClicked != null) {
                                currentGame.changePossibleMoves(pegsToChange);
                                List<AbstractPeg> pegs = currentGame.move(pegClicked,
                                                                              protocol.getXmouse(fromClient),
                                                                              protocol.getYmouse(fromClient));

                                if (pegs.size() == 2) {
                                    pegsToChange.add(pegs.get(0));
                                    pegsToChange.add(pegs.get(1));
                                }
                                if (pegsToChange.size() > 0) {
                                    AbstractPeg[] array3 = new AbstractPeg[pegsToChange.size()];
                                    array3 = pegsToChange.toArray(array3);
                                    for (ObjectOutputStream objectOut : objectOutput) { objectOut.writeObject(array3); }
                                }
                                pegsToChange.clear();
                                if (currentGame.isWinner(this.id)) {
                                    objectOutputStream.writeObject("You win");
                                    currentGame.removePlayer(this.id);
                                    socket.close();
                                    input.close();
                                    output.close();
                                    objectOutputStream.close();
                                    objectInputStream.close();
                                    objectOutput.remove(this.objectOutputStream);
                                    currentGame.nextPlayer();
                                }
                                if (pegs.size() == 2){
                                    currentGame.nextPlayer();
                                    sendPermissionToMove(false);
                                }
                            }
                        }
                        if (fromClient.equals(sendEndTurn())) {
                            sendPermissionToMove(false);
                            currentGame.nextPlayer();
                        }
                    }

                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private class BotThread extends Thread {
        int id;

        public BotThread( int id) {
            this.id = id;
        }

        public void run() {
            try {
                List<AbstractPeg> pegsToChange = new ArrayList<AbstractPeg>();
                while (true) {
                    if (currentGame.getCurrentID() == this.id) {

                        String whosTurnIs = "Bot" + currentGame.getCurrentID();
                        for (ObjectOutputStream out : objectOutput) {
                            out.writeObject(whosTurnIs);
                        }
                        List<AbstractPeg> possibilities;
                        AbstractPeg pegClicked;
                        do {
                            pegClicked = currentGame.getRandomPeg(currentGame.getPegsOfID(this.id));
                            System.out.println("peg clicked " + pegClicked);
                            possibilities = currentGame.setPossibleMoves(pegClicked);
                            System.out.println(possibilities.size());
                        } while (possibilities.size() < 1);
                        //System.out.println("BEFORE");
                            //currentGame.printBoard();
                            //System.out.println("BOT POSIBILITIES: " + possibilities);
                            //System.out.println("BOT SIZE POSIBILITIES: " + possibilities.size());
                            AbstractPeg[] array2 = new AbstractPeg[possibilities.size()];
                            for (int i = 0; i < possibilities.size(); i++) {
                                AbstractPeg p = possibilities.get(i);
                                pegsToChange.add(p);
                                array2[i] = generatorP.generatePeg(p.geti(), p.getj(), p.getSectorID());
                            }
                            currentGame.changePossibleMoves(pegsToChange);
                            AbstractPeg pegDestiny = currentGame.getRandomPeg(possibilities);
                            System.out.println("peg destiny " + pegDestiny);
                            List<AbstractPeg> pegs = currentGame.move(pegClicked, pegDestiny);

                        if (pegs.size() == 2) {
                            pegClicked = pegs.get(0);
                            pegsToChange.add(pegClicked);
                            pegDestiny = pegs.get(1);
                            pegsToChange.add(pegDestiny);
                        }
                        if (pegsToChange.size() > 0) {
                            AbstractPeg[] array3 = new AbstractPeg[pegsToChange.size()];
                            array3 = pegsToChange.toArray(array3);
                            for (ObjectOutputStream objectOut : objectOutput) {
                                objectOut.writeObject(array3);
                            }
                        }
                        pegsToChange.clear();
                        if (currentGame.isWinner(this.id)) {
                            currentGame.removePlayer(this.id);
                            currentGame.nextPlayer();
                        }
                        currentGame.nextPlayer();
                        currentGame.printBoard();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        }

    }

