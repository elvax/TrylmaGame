package com.example.trylma.model;

import java.awt.*;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Board implements Serializable{
    public static int I_BOARD_SIZE = 17;
    public static int J_BOARD_SIZE = 13;
    public static final int DISTANCE_FROM_EDGES = 10;

    private AbstractPeg[][] board;

    public Board() {
        board = new AbstractPeg[I_BOARD_SIZE][J_BOARD_SIZE];
        initalizeBoard();
        setXYDraws();
    }

    /**
     * Fills board with Peg instances
     *  ++++++0++++++
     *  ++++++00+++++
     *  +++++000+++++
     *  +++++0000++++
     *  0000000000000
     *  +000000000000
     *  +00000000000+
     *  ++0000000000+
     *  ++000000000++
     *  ++0000000000+
     *  +00000000000+
     *  +000000000000
     *  0000000000000
     *  +++++0000++++
     *  +++++000+++++
     *  ++++++00+++++
     *  ++++++0++++++
     * Where 0 means "0" was passed to ownerId
     * and + means "-1" wass passed to sectorID
     * in constructor
     */
    private void initalizeBoard() {
        board = new Peg[I_BOARD_SIZE][J_BOARD_SIZE];

        int i = 0;
        for(int j=0; j<6; j++) { board[i][j]=new Peg(i,j,-1); }
        board[i][6] = new Peg(i, 6, 0);
        for(int j=7; j<13; j++) { board[i][j]=new Peg(i,j,-1); }

        i=1;
        for(int j=0; j<6; j++) { board[i][j]=new Peg(i,j,-1); }
        for(int j=6; j<8; j++) { board[i][j]=new Peg(i,j,0); }
        for(int j=8; j<13; j++) { board[i][j]=new Peg(i,j,-1); }

        i=2;
        for(int j=0; j<5; j++) { board[i][j]=new Peg(i,j,-1); }
        for(int j=5; j<8; j++) { board[i][j]=new Peg(i,j,0); }
        for(int j=8; j<13; j++) { board[i][j]=new Peg(i,j,-1); }

        i=3;
        for(int j=0; j<5; j++) { board[i][j]=new Peg(i,j,-1); }
        for(int j=5; j<9; j++) { board[i][j]=new Peg(i,j,0); }
        for(int j=9; j<13; j++) { board[i][j]=new Peg(i,j,-1); }

        i=4;
        // for(int j=0; j<5; j++) { board[i][j]=new Peg(i,j,-1); }
        for(int j=0; j<13; j++) { board[i][j]=new Peg(i,j,0); }
        // for(int j=9; j<13; j++) { board[i][j]=new Peg(i,j,-1); }

        i=5;
        for(int j=0; j<1; j++) { board[i][j]=new Peg(i,j,-1); }
        for(int j=1; j<13; j++) { board[i][j]=new Peg(i,j,0); }
        // for(int j=12; j<13; j++) { board[i][j]=new Peg(i,j,-1); }

        i=6;
        for(int j=0; j<1; j++) { board[i][j]=new Peg(i,j,-1); }
        for(int j=1; j<12; j++) { board[i][j]=new Peg(i,j,0); }
        for(int j=12; j<13; j++) { board[i][j]=new Peg(i,j,-1); }

        i=7;
        for(int j=0; j<2; j++) { board[i][j]=new Peg(i,j,-1); }
        for(int j=2; j<12; j++) { board[i][j]=new Peg(i,j,0); }
        for(int j=12; j<13; j++) { board[i][j]=new Peg(i,j,-1); }

        i=8;
        for(int j=0; j<2; j++) { board[i][j]=new Peg(i,j,-1); }
        for(int j=2; j<11; j++) { board[i][j]=new Peg(i,j,0); }
        for(int j=11; j<13; j++) { board[i][j]=new Peg(i,j,-1); }

        i=9;
        for(int j=0; j<2; j++) { board[i][j]=new Peg(i,j,-1); }
        for(int j=2; j<12; j++) { board[i][j]=new Peg(i,j,0); }
        for(int j=12; j<13; j++) { board[i][j]=new Peg(i,j,-1); }

        i=10;
        for(int j=0; j<1; j++) { board[i][j]=new Peg(i,j,-1); }
        for(int j=1; j<12; j++) { board[i][j]=new Peg(i,j,0); }
        for(int j=12; j<13; j++) { board[i][j]=new Peg(i,j,-1); }

        i=11;
        for(int j=0; j<1; j++) { board[i][j]=new Peg(i,j,-1); }
        for(int j=1; j<13; j++) { board[i][j]=new Peg(i,j,0); }
        // for(int j=12; j<13; j++) { board[i][j]=new Peg(i,j,-1); }

        i=12;
        //  for(int j=0; j<1; j++) { board[i][j]=new Peg(i,j,-1); }
        for(int j=0; j<13; j++) { board[i][j]=new Peg(i,j,0); }
        // for(int j=12; j<13; j++) { board[i][j]=new Peg(i,j,-1); }

        i=13;
        for(int j=0; j<5; j++) { board[i][j]=new Peg(i,j,-1); }
        for(int j=5; j<9; j++) { board[i][j]=new Peg(i,j,0); }
        for(int j=9; j<13; j++) { board[i][j]=new Peg(i,j,-1); }

        i=14;
        for(int j=0; j<5; j++) { board[i][j]=new Peg(i,j,-1); }
        for(int j=5; j<8; j++) { board[i][j]=new Peg(i,j,0); }
        for(int j=8; j<13; j++) { board[i][j]=new Peg(i,j,-1); }

        i=15;
        for(int j=0; j<6; j++) { board[i][j]=new Peg(i,j,-1); }
        for(int j=6; j<8; j++) { board[i][j]=new Peg(i,j,0); }
        for(int j=8; j<13; j++) { board[i][j]=new Peg(i,j,-1); }

        i=16;
        for(int j=0; j<6; j++) { board[i][j]=new Peg(i,j,-1); }
        board[i][6] = new Peg(i, 6, 0);
        for(int j=7; j<13; j++) { board[i][j]=new Peg(i,j,-1); }
    }

    private void setXYDraws() {
        for(int i=0; i<I_BOARD_SIZE; i++) {
            for(int j=0; j<J_BOARD_SIZE; j++) {
                if (i % 2 == 0) {
                    board[i][j].setXY((j * 35) + DISTANCE_FROM_EDGES, (i * 35) + DISTANCE_FROM_EDGES);
                } else {
                    board[i][j].setXY((j * 35) - 40/2 + DISTANCE_FROM_EDGES, (i * 35) + DISTANCE_FROM_EDGES);
                }
            }
        }
    }

    public void setImage() throws IOException{
        for(int i=0; i<I_BOARD_SIZE; i++) {
            for(int j=0; j<J_BOARD_SIZE; j++) {
                board[i][j].setImage();
            }
        }
    }
    public void doDrawBoard(Graphics g) {
        for(int i=0; i<I_BOARD_SIZE; i++) {
            for(int j=0; j<J_BOARD_SIZE; j++) {
                board[i][j].doDraw(g);
            }
        }
    }

    //red
    public void fillSectorOne(){
        for(int j=5; j<9; j++) {
            board[13][j]=new Peg(13,j,1);
        }
        for(int j=5; j<8; j++){
            board[14][j]=new Peg(14,j,1);
        }
        for(int j=6; j<8; j++){
            board[15][j]=new Peg(15,j,1);
        }
        board[16][6]=new Peg(16,6,1);

    }

    //blue
    public void fillSectorTwo(){
        for(int j=0; j<4; j++) {
            board[12][j]=new Peg(12,j,2);
        }
        for(int j=1; j<4; j++){
            board[11][j]=new Peg(11,j,2);
        }
        for(int j=1; j<3; j++){
            board[10][j]=new Peg(10,j,2);
        }
        board[9][2]=new Peg(9,2,2);
    }
    //pink
    public void fillSectorThree(){
        for(int j=0; j<4; j++) {
            board[4][j]=new Peg(4,j,3);
        }
        for(int j=1; j<4; j++){
            board[5][j]=new Peg(5,j,3);
        }
        for(int j=1; j<3; j++){
            board[6][j]=new Peg(6,j,3);
        }
        board[7][2]=new Peg(7,2,3);
    }

    //yellow
    public void fillSectorFour(){
        for(int j=5; j<9; j++) {
            board[3][j]=new Peg(3,j,4);
        }
        for(int j=5; j<8; j++){
            board[2][j]=new Peg(2,j,4);
        }
        for(int j=6; j<8; j++){
            board[1][j]=new Peg(1,j,4);
        }
        board[0][6]=new Peg(0,6,4);
    }

    //orange
    public void fillSectorFive(){

        for(int j=9; j<13; j++) {
            board[4][j]=new Peg(4,j,5);
        }
        for(int j=10; j<13; j++){
            board[5][j]=new Peg(5,j,5);
        }
        for(int j=10; j<12; j++){
            board[6][j]=new Peg(6,j,5);
        }
        board[7][11]=new Peg(7,11,5);
    }

    //green
    public void fillSectorSix() {
        for (int j = 9; j < 13; j++) {
            board[12][j] = new Peg(12, j, 6);
        }
        for (int j = 10; j < 13; j++) {
            board[11][j] = new Peg(11, j, 6);
        }
        for (int j = 10; j < 12; j++) {
            board[10][j] = new Peg(10, j, 6);
        }
        board[9][11] = new Peg(9, 2, 6);
    }

    public AbstractPeg getClicked(int x, int y) {
        for (int i = 0; i < I_BOARD_SIZE; i++) {
            for (int j = 0; j < J_BOARD_SIZE; j++) {
                if (board[i][j].isClicked(x, y))
                    return board[i][j];
            }
        }
        return null;
    }

    public AbstractPeg getPeg(int i, int j){
        return board[i][j];
    }

    //Metoda szukająca wszystkich sąsiadów tych zajętych i pustych
    public List<AbstractPeg> findNeighbours(AbstractPeg peg){
        List<AbstractPeg> neighbours = new ArrayList<AbstractPeg>();
        int i = peg.geti();
        int j = peg.getj();
        int bi = i - 1;
        int ei = i + 1;
        int bj = j - 1;
        int ej = j + 1;
        if (i == 0) { bi = i; }
        else if (i == I_BOARD_SIZE - 1) { ei = i; }
        if (j == 0) { bj = j; }
        else if (j == J_BOARD_SIZE - 1) { bj = j; }
        for (int k = bi; k <= ei; k++) {
            for (int t = bj; t <= ej; t++) {
                if (((t == j - 1 && i % 2 == 0) && (k == i - 1 || k == i + 1)) || k == i && t == j) {}
                else if ((t == j + 1 && i % 2 != 0) && (k == i + 1 || k == i - 1)) {}
                else { neighbours.add(board[k][t]);
                    //System.out.println("Sasiad :" + k + " " + t);
                }
            }
        }
        return neighbours;
    }
    //zwraca pustych sąsiadów czyli tych które mają ID 0 i może się tam przemieścić od razu
    public List<AbstractPeg> findEmptyNeighbours(AbstractPeg peg){
        List<AbstractPeg> neighbours = findNeighbours(peg);
        List<AbstractPeg> emptyNeighbours = new ArrayList<AbstractPeg>();
        for(int i = 0; i < neighbours.size(); i++){
            AbstractPeg p = neighbours.get(i);
            if(p.getSectorID() == 0){
                emptyNeighbours.add(p);
                //System.out.println("Sąsiad pusty: " + neighbours.get(i).geti() + " " + neighbours.get(i).getj());
            }
        }
        return emptyNeighbours;
    }

    //zwraca sąsiadów którzy są zajęci tzn mają id rózny od 0 i -1, należą do jakiegoś gracza.
    public List<AbstractPeg> findNotEmptyNeighbours(AbstractPeg peg){
        List<AbstractPeg> neighbours = findNeighbours(peg);
        List<AbstractPeg> notEmptyNeighbours = new ArrayList<AbstractPeg>();
        for(int i = 0; i < neighbours.size(); i++){
            AbstractPeg p = neighbours.get(i);
            if(p.getSectorID() != 0 && p.getSectorID() != -1){
                notEmptyNeighbours.add(p);
                //System.out.println("Sąsiad pełny: " + p.geti() + " " + p.getj());
            }
        }
        return notEmptyNeighbours;
    }

    //sprawdza czy ruch był poprawny, tzn czy jest w liscie mozliwych ruchów i jeśli jest zmienia identyfikatory
    // czyli nanosi ruch na planszę.
    public void move(AbstractPeg p, int i, int j){
        List<AbstractPeg> neighbours = correctMoves(p);
        for(int t=0; t<neighbours.size(); t++){
            AbstractPeg temp = neighbours.get(t);
            //System.out.println("Sasiad: " + temp.geti() + " " + temp.getj());
            if(temp.isClicked(i,j)==true && temp.getSectorID()==0){
                board[temp.geti()][temp.getj()]=new Peg(temp.geti(),temp.getj(),p.getSectorID());
                board[p.geti()][p.getj()]=new Peg(p.geti(),p.getj(),0);
            }
        }
    }
    //zwraca listę wszystkich możliwych ruchów tzn, sasiadów którzy mają id=0 uzupełnionych o skoki.
    public List<AbstractPeg> correctMoves(AbstractPeg p){
        List<AbstractPeg> moves = findEmptyNeighbours(p);
        List<AbstractPeg> notEmpty = findNotEmptyNeighbours(p);
        for(int i=0; i < notEmpty.size(); i++){
            AbstractPeg neighbour = notEmpty.get(i);
            int j_move = -1;
            int i_move = -1;
            int i_neighbour = neighbour.geti();
            int j_neighbour = neighbour.getj();
            if (p.geti() < i_neighbour && p.geti() < I_BOARD_SIZE - 2) {
                i_move = p.geti() + 2;
            } else if (p.geti() > i_neighbour && p.geti() > 1){
                i_move = p.geti() - 2;
            }
            if(p.getj() < j_neighbour && p.getj() < J_BOARD_SIZE - 1){
                j_move = p.getj() + 1;
            } else if(p.getj() > j_neighbour && p.getj() > 0) {
                j_move = p.getj() - 1;
            }
            if(p.geti()%2!=0 && p.getj() == j_neighbour){
                j_move = p.getj() + 1;
            } else if(p.geti()%2==0 && p.getj() == j_neighbour){
                j_move = p.getj() - 1;
            }
            if(p.geti() == i_neighbour){
                i_move=p.geti();
                if(p.getj() <= j_neighbour && p.getj() < J_BOARD_SIZE - 2){
                    j_move = p.getj() + 2;
                } else if(p.getj() > j_neighbour && p.getj() > 1) {
                    j_move = p.getj() - 2;
                }
            }
            if(i_move!=-1 && j_move!=-1 && board[i_move][j_move].getSectorID()==0){
                moves.add(board[i_move][j_move]);
            }
        }
        return moves;
    }



    public void printBoard(){
        for(int o=0; o<17; o++){
            for(int k=0; k<13; k++){
                if (board[o][k].getSectorID() < 0) {
                    System.out.print("-");
                } else {
                    System.out.print(board[o][k].getSectorID());
                }

            }
            System.out.println("");
        }
    }

}
