package com.example.trylma.client;

import com.example.trylma.server.TrylmaServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 */
public class TrylmaClient {
    private Socket socket;
    BufferedReader input;
    PrintWriter output;



    public TrylmaClient() {
        //TODO odpalic GUI
    }

    private void run() throws IOException {
        //TODO zrobic jakies gettery na paramtery do tworzenia socketu

        // Make connection and initialize streams
        Socket socket = new Socket("localhost", TrylmaServer.portNumber);
        output = new PrintWriter(socket.getOutputStream(), true);
        input = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));

        // Process all messages from server
        while (true) {
            String line = input.readLine();
            System.out.println(line);
        }

    }

    public static void main(String[] args) throws Exception{
        TrylmaClient client = new TrylmaClient();
        client.run();
    }

}

