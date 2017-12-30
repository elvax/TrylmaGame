package com.example.trylma.client;

import com.example.trylma.controller.TrylmaStringProtocol;
import com.example.trylma.model.AbstractPeg;
import com.example.trylma.model.Board;
import com.example.trylma.server.TrylmaServer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.Socket;

import static com.example.trylma.controller.TrylmaStringProtocol.*;

/**
 *
 */
public class TrylmaClient {
    private Socket socket;
    private BufferedReader input;
    private PrintWriter output;
    private ObjectOutputStream objectOutputStream;
    private ObjectInputStream objectInputStream;

    BufferedReader stdIn;
    String hostName = "localhost";
    Frame frame;
    Board boardOfTrylma;
    boolean canSend = false;


    public TrylmaClient() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frame = new Frame();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void run() throws IOException, ClassNotFoundException {
        // Make connection
        Socket socket = new Socket(hostName, TrylmaServer.portNumber);

        //Intitialize streams
        output = new PrintWriter(socket.getOutputStream(), true);
        input = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));
        stdIn = new BufferedReader(new InputStreamReader(System.in));
        objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
        objectInputStream = new ObjectInputStream(socket.getInputStream());

        // Read inital state of board and paint it
        boardOfTrylma = (Board) objectInputStream.readObject();
        frame.panel.setBoardToDraw(boardOfTrylma);
        frame.panel.repaint();

        while (true) {
            Object fromServer = objectInputStream.readObject();
            if (fromServer instanceof AbstractPeg[]) {
                AbstractPeg[] toChange = (AbstractPeg[]) fromServer;

                frame.panel.updateBoard(toChange);
                frame.panel.repaint();
            } else {
                Boolean bool = (Boolean) fromServer;
                canSend = bool;
            }
        }
    }

    public static void main(String[] args){
        TrylmaClient client = new TrylmaClient();
        try {
            client.run();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
    class Frame extends JFrame {

        Panel panel;

        private final int X_SIZE = 700;
        private final int Y_SIZE = 700;

        /**
         * Create the application.
         */
        public Frame() {
                super("Chinese checkers");
                initialize();
        }

        /**
         * Initialize the contents of the frame, which includes:
         * two menu buttons and panel with EndTrun's button
         */
        private void initialize() {
            setSize(X_SIZE, Y_SIZE);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setResizable(true);

            /**
             * Creating the "New Game" item, which gives an opportunity
             * to choose the number of players.
             */
            JMenuBar menubar = new JMenuBar();
            JMenuItem newGameButton = new JMenuItem("New Game");
            newGameButton.setBackground(new Color(204, 204, 204));
            newGameButton.setMnemonic(KeyEvent.VK_E);
            newGameButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    Object[] possibilities = {"2", "3", "4", "6"};
                    String s = (String)JOptionPane.showInputDialog(
                            null,
                            "Choose the number of players:\n",
                            "Number of players",
                            JOptionPane.PLAIN_MESSAGE,
                            null,
                            possibilities,
                            "2");

                    if ((s != null) && (s.length() > 0)) {
                        return;
                    }
                }
            });
            menubar.add(newGameButton);

            /**
             * Creating the "Help" item, which gives users basic information
             * about the application
             */

            JMenuItem helpGameButton = new JMenuItem("Help");
            helpGameButton.setMnemonic(KeyEvent.VK_E);
            helpGameButton.setBackground(new Color(204, 204, 204));
            helpGameButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(null, "Chinese checkers is a strategy board game of German origin,\n"
                            +"which can be played by two, three, four, or six people.\n"
                            +"The objective is to be first to race all of one's pieces across the hexagram-shaped board\n"
                            + "into the corner of the star opposite one's starting corner�using single-step moves\n"
                            + " or moves that jump over other pieces.\n", "Help", JOptionPane.INFORMATION_MESSAGE);
                }
            });
            menubar.add(helpGameButton);
            menubar.add(Box.createHorizontalGlue());
            menubar.add(Box.createHorizontalGlue());
            menubar.add(Box.createHorizontalGlue());
            menubar.add(Box.createHorizontalGlue());
            setJMenuBar(menubar);

            panel = new Panel();
            add(panel);
        }
}

    class Panel extends JPanel {

    MouseAdapter mouseAdapter;

    Board boardToDraw;
    boolean isBoardLoad = false;

    /**
     * Create a JPanel.
     */
    public Panel() {
        initialize();
    }

    /**
     * Initialize the contents of the frame, which includes
     * EndTrun's button and the board and MouseListener.
     */
    private void initialize() {
        setLayout(null);
        setBackground(Color.LIGHT_GRAY);

        mouseAdapter = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                whenMouseClicked(e);
            }
            @Override
            public void mousePressed(MouseEvent e) {
                whenMousePressed(e);
            }
            @Override
            public void mouseReleased(MouseEvent e) {
                whenMouseReleased(e);
            }
        };


        JButton endTurnButton = new JButton("End Turn");
        endTurnButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                whenEndTurnClicked();
            }
        });
        endTurnButton.setBounds(320, 20, 100, 30);
        add(endTurnButton);

        addMouseListener(mouseAdapter);


    }

    public void updateBoard(AbstractPeg[] list ) throws IOException{
        boardToDraw.updateBoard(list);
        boardToDraw.setImage();
    }

    public void setBoardLoad(boolean boardLoad) {
        isBoardLoad = boardLoad;
    }

    public void setBoardToDraw(Board board) throws IOException{
        boardToDraw = board;
        boardToDraw.setImage();
        if (board != null)
            isBoardLoad = true;
    }

    public void paint(Graphics graphics) {
        super.paint(graphics);
        if (isBoardLoad)
            boardToDraw.doDrawBoard(graphics);
    }

    private void whenMouseClicked(MouseEvent e){

    }

    private void whenMouseReleased(MouseEvent e){
        if(canSend)
           output.println("RELEASED (" + e.getX() + "," + e.getY() + ")");
    }

    private void whenMousePressed(MouseEvent e){
        if(canSend)
           output.println(sendMousePressed(e.getX(),e.getY()));
    }

    private void whenEndTurnClicked() {
        if(canSend)
            output.println(sendEndTurn());
    }


}


}



