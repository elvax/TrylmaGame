package com.example.trylma.client;

import com.example.trylma.server.TrylmaServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.Buffer;

/**
 *
 */
public class TrylmaClient {
    private Socket socket;
    BufferedReader input;
    PrintWriter output;
    String fromServer;
    String fromUser;
    BufferedReader StdIn;
    Frame frame;


    public TrylmaClient() {
        frame = new Frame();
    }

    private void run() throws IOException {
        //TODO zrobic jakies gettery na paramtery do tworzenia socketu

        // Make connection and initialize streams
        Socket socket = new Socket("localhost", TrylmaServer.portNumber);
        output = new PrintWriter(socket.getOutputStream(), true);
        input = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));
        StdIn = new BufferedReader(new InputStreamReader(System.in));

        // Process all messages from server
        while (!(fromServer = input.readLine()).equals("koniec")) {
            System.out.println(fromServer);
            fromUser = StdIn.readLine();
            if (fromUser != null) {
                System.out.println("From user: " + fromUser);
                output.println(fromUser);
            }
        }

    }

    public static void main(String[] args) throws Exception{
        TrylmaClient client = new TrylmaClient();
        client.frame.setVisible(true);
        client.run();
    }

}

