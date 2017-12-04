package com.example.trylma.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class PlayerThread extends Thread {

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

