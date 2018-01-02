package com.example.trylma.client;

import com.example.trylma.model.AbstractPeg;
import com.example.trylma.model.Board;
import com.example.trylma.server.TrylmaServer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.ConnectException;
import java.net.Socket;

import static com.example.trylma.controller.TrylmaStringProtocol.*;

/**
 * This class is client side of the project. Both sends input
 * from the user and receive information from the server. Displays
 * that information in GUI
 *
 * @author      Sebastian Pabich
 * @author      Maria Wita
 * @version     1.0
 * @since       1.0
 */
public class TrylmaClient {
    private Socket socket;
    private PrintWriter output;
    private ObjectOutputStream objectOutputStream;
    private ObjectInputStream objectInputStream;

    BufferedReader stdIn;
    String hostName = "localhost";
    Frame frame;
//    Board boardOfTrylma;
    boolean canSend = false;

    /**
     * Constructor starts client's GUI
     *
     * @since       1.0
     */
    public TrylmaClient() {
        frame = new Frame();
        frame.setVisible(true);
    }

    /**
     * Method initializes streams needed for connection with server
     *
     * @since       1.0
     */
    private void initializeStreams() throws IOException{
        output = new PrintWriter(socket.getOutputStream(), true);
        objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
        objectInputStream = new ObjectInputStream(socket.getInputStream());
    }

    /**
     * Connects to the server then enters the processing loop
     *
     * @since       1.0
     */
    private void run() throws IOException, ClassNotFoundException {
        // Make connection
        socket = new Socket(hostName, TrylmaServer.portNumber);

        //Intitialize streams
        initializeStreams();

        // Read inital state of board and paint it
        Board boardOfTrylma = (Board) objectInputStream.readObject();
        frame.panel.setBoardToDraw(boardOfTrylma);
        frame.panel.repaint();

        // Read id of player and set title of frame
        String title = (String) objectInputStream.readObject();
        frame.setTitle(title);

        //Process all objects from server
        while (true) {
            Object fromServer = objectInputStream.readObject();
            if (fromServer instanceof AbstractPeg[]) {
                AbstractPeg[] toChange = (AbstractPeg[]) fromServer;

                frame.panel.updateBoard(toChange);
                frame.panel.repaint();
            } else if (fromServer instanceof Boolean) {
                canSend = (Boolean) fromServer;
            } else if (fromServer instanceof String) {
                String textFromServer = (String) fromServer;
                frame.panel.whosTurnLabel.setText(textFromServer);
            }
        }
    }

    /**
     * Runs the client as an application with frame
     *
     * @since       1.0
     */
    public static void main(String[] args){
        TrylmaClient client = new TrylmaClient();
        try {
            client.run();
        } catch (ConnectException ee) {
            System.out.println("Can't connect");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This class is responsible for GUI frame
     *
     * @since       1.0
     */
    private class Frame extends JFrame{

        Panel panel;

        private final int X_SIZE = 500;
        private final int Y_SIZE = 650;

        JMenuBar menubar;
        JMenu gameMenu;
        JMenuItem helpGameButton;

        /**
         * Create the frame of application.
         */
        public Frame() {
                initialize();
        }

        /**
         * Initialize the contents of the frame, which includes:
         * two menu buttons and panel with EndTrun's button
         */
        private void initialize() {

            setSize(X_SIZE, Y_SIZE);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setResizable(false);

            panel = new Panel();
            add(panel);

            /**
             * Creating the "New Game" item, which gives an opportunity
             * to choose the number of players.
             */
            menubar = new JMenuBar();

            gameMenu = new JMenu("Game");

            /**
             * Creating the "Help" item, which gives users basic information
             * about the application
             */
            helpGameButton = new JMenuItem("Help");
            helpGameButton.setMnemonic(KeyEvent.VK_E);
            helpGameButton.setBackground(new Color(204, 204, 204));
            helpGameButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(null, "Chinese checkers is a strategy board game of German origin,\n"
                            +"which can be played by two, three, four, or six people.\n"
                            +"The objective is to be first to race all of one's pieces across the hexagram-shaped board\n"
                            + "into the corner of the star opposite one's starting corner using single-step moves\n"
                            + " or moves that jump over other pieces.\n", "Help", JOptionPane.INFORMATION_MESSAGE);
                }
            });

            gameMenu.add(helpGameButton);
            menubar.add(gameMenu);
            setJMenuBar(menubar);
        }
    }

    /**
     * This class creates all content of GUI frame
     *
     * @since       1.0
     */
    private class Panel extends JPanel {

        MouseAdapter mouseAdapter;
        JButton endTurnButton;
        JLabel whosTurnLabel;

        Board boardToDraw;
        boolean isBoardLoad = false;

        /**
         * Create a Panel.
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
            addMouseListener(mouseAdapter);


            endTurnButton = new JButton("End Turn");
            endTurnButton.setBounds(320, 20, 100, 30);
            endTurnButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    whenEndTurnClicked();
                }
            });
            add(endTurnButton);

            whosTurnLabel = new JLabel();
            whosTurnLabel.setBounds(320, 55, 100, 30);
            whosTurnLabel.setText("");
            add(whosTurnLabel);
        }

        /**
         * Method receives array with pegs that were changed on the
         * server side. Method updates client's state of board with
         * given pegs
         *
         * @param list          array of changed AbstractPegs
         * @since               1.0
         */
        public void updateBoard(AbstractPeg[] list ) throws IOException{
            boardToDraw.updateBoard(list);
            boardToDraw.setImage();
        }

        /**
         * Method receives board from the server which
         * will be later painted
         *
         * @param board         board from the server
         * @since               1.0
         */
        public void setBoardToDraw(Board board) throws IOException{
            if (board != null) {
                boardToDraw = board;
                boardToDraw.setImage();

                isBoardLoad = true;
            }

        }

        /**
         * Method paints board if only it was loaded
         *
         * @param graphics      Graphics
         * @since               1.0
         */
        public void paint(Graphics graphics) {
            super.paint(graphics);
            if (isBoardLoad)
                boardToDraw.doDrawBoard(graphics);
        }

        /**
         * Method invoked on mouse action clicked
         *
         * @param e             mouse event
         * @since               1.0
         */
        private void whenMouseClicked(MouseEvent e){

        }

        /**
         * Method invoked on mouse action released
         * Sends information to server according to protocol
         * {@link com.example.trylma.controller.TrylmaStringProtocol}.
         *
         * @param e             mouse event
         * @since               1.0
         */
        private void whenMouseReleased(MouseEvent e){
            if(canSend)
               output.println(sendMouseReleased(e.getX(),e.getY()));
        }

        /**
         * Method invoked on mouse action pressed
         * Sends information to server according to protocol
         * {@link com.example.trylma.controller.TrylmaStringProtocol}.
         *
         * @param e             mouse event
         * @since               1.0
         */
        private void whenMousePressed(MouseEvent e){
            if(canSend)
               output.println(sendMousePressed(e.getX(),e.getY()));
        }

        /**
         * Method invoked after click on endTurnButton
         * Sends information to server according to protocol
         * {@link com.example.trylma.controller.TrylmaStringProtocol}.
         *
         * @since               1.0
         */
        private void whenEndTurnClicked() {
            if(canSend)
                output.println(sendEndTurn());
        }


    }


}



