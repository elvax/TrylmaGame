package com.example.trylma.model;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SixBoard extends Board {
    public static int I_BOARD_SIZE = 17;
    public static int J_BOARD_SIZE = 13;
    public static final int DISTANCE_FROM_EDGES = 10;
    public PegGenerator generator;

    private AbstractPeg[][] board;

    public SixBoard() {
        board = new AbstractPeg[I_BOARD_SIZE][J_BOARD_SIZE];
    }

    @Override
    public void generateBoard(PegGenerator P){
        this.generator = P;
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
        //board = new Peg[I_BOARD_SIZE][J_BOARD_SIZE];

        int i = 0;
        for(int j=0; j<6; j++) { board[i][j]=generator.generatePeg(i,j,-1); }
        board[i][6] = generator.generatePeg(i, 6, 0);
        for(int j=7; j<13; j++) { board[i][j]=generator.generatePeg(i,j,-1); }

        i=1;
        for(int j=0; j<6; j++) { board[i][j]=generator.generatePeg(i,j,-1); }
        for(int j=6; j<8; j++) { board[i][j]=generator.generatePeg(i,j,0); }
        for(int j=8; j<13; j++) { board[i][j]=generator.generatePeg(i,j,-1); }

        i=2;
        for(int j=0; j<5; j++) { board[i][j]=generator.generatePeg(i,j,-1); }
        for(int j=5; j<8; j++) { board[i][j]=generator.generatePeg(i,j,0); }
        for(int j=8; j<13; j++) { board[i][j]=generator.generatePeg(i,j,-1); }

        i=3;
        for(int j=0; j<5; j++) { board[i][j]=generator.generatePeg(i,j,-1); }
        for(int j=5; j<9; j++) { board[i][j]=generator.generatePeg(i,j,0); }
        for(int j=9; j<13; j++) { board[i][j]=generator.generatePeg(i,j,-1); }

        i=4;
        // for(int j=0; j<5; j++) { board[i][j]=new Peg(i,j,-1); }
        for(int j=0; j<13; j++) { board[i][j]=generator.generatePeg(i,j,0); }
        // for(int j=9; j<13; j++) { board[i][j]=new Peg(i,j,-1); }

        i=5;
        for(int j=0; j<1; j++) { board[i][j]=generator.generatePeg(i,j,-1); }
        for(int j=1; j<13; j++) { board[i][j]=generator.generatePeg(i,j,0); }
        // for(int j=12; j<13; j++) { board[i][j]=new Peg(i,j,-1); }

        i=6;
        for(int j=0; j<1; j++) { board[i][j]=generator.generatePeg(i,j,-1); }
        for(int j=1; j<12; j++) { board[i][j]=generator.generatePeg(i,j,0); }
        for(int j=12; j<13; j++) { board[i][j]=generator.generatePeg(i,j,-1); }

        i=7;
        for(int j=0; j<2; j++) { board[i][j]=generator.generatePeg(i,j,-1); }
        for(int j=2; j<12; j++) { board[i][j]=generator.generatePeg(i,j,0); }
        for(int j=12; j<13; j++) { board[i][j]=generator.generatePeg(i,j,-1); }

        i=8;
        for(int j=0; j<2; j++) { board[i][j]=generator.generatePeg(i,j,-1); }
        for(int j=2; j<11; j++) { board[i][j]=generator.generatePeg(i,j,0); }
        for(int j=11; j<13; j++) { board[i][j]=generator.generatePeg(i,j,-1); }

        i=9;
        for(int j=0; j<2; j++) { board[i][j]=generator.generatePeg(i,j,-1); }
        for(int j=2; j<12; j++) { board[i][j]=generator.generatePeg(i,j,0); }
        for(int j=12; j<13; j++) { board[i][j]=generator.generatePeg(i,j,-1); }

        i=10;
        for(int j=0; j<1; j++) { board[i][j]=generator.generatePeg(i,j,-1); }
        for(int j=1; j<12; j++) { board[i][j]=generator.generatePeg(i,j,0); }
        for(int j=12; j<13; j++) { board[i][j]=generator.generatePeg(i,j,-1); }

        i=11;
        for(int j=0; j<1; j++) { board[i][j]=generator.generatePeg(i,j,-1); }
        for(int j=1; j<13; j++) { board[i][j]=generator.generatePeg(i,j,0); }
        // for(int j=12; j<13; j++) { board[i][j]=new Peg(i,j,-1); }

        i=12;
        //  for(int j=0; j<1; j++) { board[i][j]=new Peg(i,j,-1); }
        for(int j=0; j<13; j++) { board[i][j]=generator.generatePeg(i,j,0); }
        // for(int j=12; j<13; j++) { board[i][j]=new Peg(i,j,-1); }

        i=13;
        for(int j=0; j<5; j++) { board[i][j]=generator.generatePeg(i,j,-1); }
        for(int j=5; j<9; j++) { board[i][j]=generator.generatePeg(i,j,0); }
        for(int j=9; j<13; j++) { board[i][j]=generator.generatePeg(i,j,-1); }

        i=14;
        for(int j=0; j<5; j++) { board[i][j]=generator.generatePeg(i,j,-1); }
        for(int j=5; j<8; j++) { board[i][j]=generator.generatePeg(i,j,0); }
        for(int j=8; j<13; j++) { board[i][j]=generator.generatePeg(i,j,-1); }

        i=15;
        for(int j=0; j<6; j++) { board[i][j]=generator.generatePeg(i,j,-1); }
        for(int j=6; j<8; j++) { board[i][j]=generator.generatePeg(i,j,0); }
        for(int j=8; j<13; j++) { board[i][j]=generator.generatePeg(i,j,-1); }

        i=16;
        for(int j=0; j<6; j++) { board[i][j]=generator.generatePeg(i,j,-1); }
        board[i][6] = generator.generatePeg(i, 6, 0);
        for(int j=7; j<13; j++) { board[i][j]=generator.generatePeg(i,j,-1); }
    }

    public List setBoardForPlayers(int numberOfPlayers) {
        List<Integer> activeSectorsID = new ArrayList<Integer>();
        if (numberOfPlayers == 1) {
            fillSector(1);

            activeSectorsID.add(1);
        } else if ( numberOfPlayers == 2 ) {
            fillSector(1);
            fillSector(4);

            activeSectorsID.add(1);
            activeSectorsID.add(4);
        } else if (numberOfPlayers == 3) {
            fillSector(1);
            fillSector(3);
            fillSector(5);

            activeSectorsID.add(1);
            activeSectorsID.add(3);
            activeSectorsID.add(5);
        } else if (numberOfPlayers == 4) {
            fillSector(2);
            fillSector(3);
            fillSector(5);
            fillSector(6);

            activeSectorsID.add(2);
            activeSectorsID.add(3);
            activeSectorsID.add(5);
            activeSectorsID.add(6);
        } else if (numberOfPlayers == 6) {
            fillSector(1);
            fillSector(2);
            fillSector(3);
            fillSector(4);
            fillSector(5);
            fillSector(6);

            activeSectorsID.add(1);
            activeSectorsID.add(2);
            activeSectorsID.add(3);
            activeSectorsID.add(4);
            activeSectorsID.add(5);
            activeSectorsID.add(6);
        }
        return activeSectorsID;
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
    @Override
    public void setImage() throws IOException {
        for(int i=0; i<I_BOARD_SIZE; i++) {
            for(int j=0; j<J_BOARD_SIZE; j++) {
                board[i][j].setImage();
            }
        }
    }
    @Override
    public void doDrawBoard(Graphics g) {
        for(int i=0; i<I_BOARD_SIZE; i++) {
            for(int j=0; j<J_BOARD_SIZE; j++) {
                board[i][j].doDraw(g);
            }
        }
    }
    @Override
    public void updateBoard(AbstractPeg[] list) {
        for (AbstractPeg newPeg : list) {
            for (int i = 0; i < I_BOARD_SIZE; i++) {
                for (int j = 0; j < J_BOARD_SIZE; j++) {
                    if (board[i][j].geti() == newPeg.geti()
                            && board[i][j].getj() == newPeg.getj()) {
                        board[i][j] = newPeg;
                    }

                }
            }
        }
    }

    @Override
    public List<AbstractPeg> getPegsOfID(int id) {
        List<AbstractPeg> result = new ArrayList<AbstractPeg>();
        for(int i=0; i<I_BOARD_SIZE; i++) {
            for(int j=0; j<J_BOARD_SIZE; j++) {
                if(board[i][j].getSectorID() == id)
                    result.add(board[i][j]);
            }
        }
        return result;
    }

    @Override
    public void fillSector(int i){
        if(i==1){
            fillSectorOne();
        }else if(i==2){
            fillSectorTwo();
        }else if(i==3){
            fillSectorThree();
        }else if(i==4){
            fillSectorFour();
        }else if(i==5){
            fillSectorFive();
        }else if(i==6) {
            fillSectorSix();
        }
    }

    //red
    public void fillSectorOne(){
        for(int j=5; j<9; j++) {
            board[13][j]=generator.generatePeg(13,j,1);
        }
        for(int j=5; j<8; j++){
            board[14][j]=generator.generatePeg(14,j,1);
        }
        for(int j=6; j<8; j++){
            board[15][j]=generator.generatePeg(15,j,1);
        }
        board[16][6]=generator.generatePeg(16,6,1);

    }

    //blue
    public void fillSectorTwo(){
        for(int j=0; j<4; j++) {
            board[12][j]=generator.generatePeg(12,j,2);
        }
        for(int j=1; j<4; j++){
            board[11][j]=generator.generatePeg(11,j,2);
        }
        for(int j=1; j<3; j++){
            board[10][j]=generator.generatePeg(10,j,2);
        }
        board[9][2]=generator.generatePeg(9,2,2);
    }
    //pink
    public void fillSectorThree(){
        for(int j=0; j<4; j++) {
            board[4][j]=generator.generatePeg(4,j,3);
        }
        for(int j=1; j<4; j++){
            board[5][j]=generator.generatePeg(5,j,3);
        }
        for(int j=1; j<3; j++){
            board[6][j]=generator.generatePeg(6,j,3);
        }
        board[7][2]=generator.generatePeg(7,2,3);
    }

    //yellow
    public void fillSectorFour(){
        for(int j=5; j<9; j++) {
            board[3][j]=generator.generatePeg(3,j,4);
        }
        for(int j=5; j<8; j++){
            board[2][j]=generator.generatePeg(2,j,4);
        }
        for(int j=6; j<8; j++){
            board[1][j]=generator.generatePeg(1,j,4);
        }
        board[0][6]=generator.generatePeg(0,6,4);
    }

    //orange
    public void fillSectorFive(){

        for(int j=9; j<13; j++) {
            board[4][j]=generator.generatePeg(4,j,5);
        }
        for(int j=10; j<13; j++){
            board[5][j]=generator.generatePeg(5,j,5);
        }
        for(int j=10; j<12; j++){
            board[6][j]=generator.generatePeg(6,j,5);
        }
        board[7][11]=generator.generatePeg(7,11,5);
    }

    //green
    public void fillSectorSix() {
        for (int j = 9; j < 13; j++) {
            board[12][j] = generator.generatePeg(12, j, 6);
        }
        for (int j = 10; j < 13; j++) {
            board[11][j] = generator.generatePeg(11, j, 6);
        }
        for (int j = 10; j < 12; j++) {
            board[10][j] =generator.generatePeg(10, j, 6);
        }
        board[9][11] =generator.generatePeg(9, 11, 6);
    }

    @Override
    public AbstractPeg getClicked(int x, int y) {
        for (int i = 0; i < I_BOARD_SIZE; i++) {
            for (int j = 0; j < J_BOARD_SIZE; j++) {
                if (board[i][j].isClicked(x, y))
                    return board[i][j];
            }
        }
        return null;
    }

    @Override
    public AbstractPeg getPeg(int i, int j){
        return board[i][j];
    }

    //Metoda szukająca wszystkich sąsiadów tych zajętych i pustych
    public java.util.List<AbstractPeg> findNeighbours(AbstractPeg peg){
        java.util.List<AbstractPeg> neighbours = new ArrayList<AbstractPeg>();
        int i = peg.geti();
        int j = peg.getj();
        int bi = i - 1;
        int ei = i + 1;
        int bj = j - 1;
        int ej = j + 1;
        if (i == 0) { bi = i; }
        else if (i == I_BOARD_SIZE - 1) { ei = i; }
        if (j == 0) { bj = j; }
        else if (j == J_BOARD_SIZE - 1) { ej = j; }
        for (int k = bi; k <= ei; k++) {
            for (int t = bj; t <= ej; t++) {
                //System.out.println("k i t :" + k + " " + t);
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
    public java.util.List<AbstractPeg> findEmptyNeighbours(AbstractPeg peg){
        java.util.List<AbstractPeg> neighbours = findNeighbours(peg);
        java.util.List<AbstractPeg> emptyNeighbours = new ArrayList<AbstractPeg>();
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
    public java.util.List<AbstractPeg> findNotEmptyNeighbours(AbstractPeg peg){
        java.util.List<AbstractPeg> neighbours = findNeighbours(peg);
        java.util.List<AbstractPeg> notEmptyNeighbours = new ArrayList<AbstractPeg>();
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
    @Override
    public java.util.List<AbstractPeg> move(AbstractPeg p, int i, int j){

        java.util.List<AbstractPeg> pegs = new ArrayList<AbstractPeg>();
        java.util.List<AbstractPeg> neighbours = correctMoves(p);
        for(int t=0; t<neighbours.size(); t++){
            AbstractPeg temp = neighbours.get(t);

            if(temp.isClicked(i,j)==true && temp.getSectorID()==0){
                board[temp.geti()][temp.getj()]=generator.generatePeg(temp.geti(),temp.getj(),p.getSectorID());
                board[p.geti()][p.getj()]=generator.generatePeg(p.geti(),p.getj(),0);
                pegs.add(board[p.geti()][p.getj()]);
                pegs.add(board[temp.geti()][temp.getj()]);
                return pegs;
            }
        }
        return pegs;
    }

    @Override
    public List<AbstractPeg> move(AbstractPeg p, AbstractPeg d) {
        java.util.List<AbstractPeg> pegs = new ArrayList<AbstractPeg>();
        java.util.List<AbstractPeg> neighbours = correctMoves(p);
        for(int t=0; t<neighbours.size(); t++){
            AbstractPeg temp = neighbours.get(t);
            if(temp.equals(d)){
                board[temp.geti()][temp.getj()]=generator.generatePeg(temp.geti(),temp.getj(),p.getSectorID());
                board[p.geti()][p.getj()]=generator.generatePeg(p.geti(),p.getj(),0);
                pegs.add(board[p.geti()][p.getj()]);
                pegs.add(board[temp.geti()][temp.getj()]);
                return pegs;
            }
        }
        return pegs;
    }

    public List<AbstractPeg> correctMoves(AbstractPeg p){
//        System.out.println("CORRECT MOVE FIRST PEG" + p);
        List<AbstractPeg> moves = findEmptyNeighbours(p);
        List<AbstractPeg> notEmpty = findNotEmptyNeighbours(p);
        List<AbstractPeg> correctmoves = new ArrayList<AbstractPeg>();
        //LinkedHashSet<AbstractPeg> leaps = new LinkedHashSet<AbstractPeg>();
        //LinkedHashSet<AbstractPeg> leaps2 = new LinkedHashSet<AbstractPeg>();
        List<AbstractPeg> leaps = new ArrayList<AbstractPeg>();
        leaps.add(p);
        //while(leaps.isEmpty()==false) {
            //for (AbstractPeg h : leaps) {
        for(int z=0; z<leaps.size(); z++){
                AbstractPeg h = leaps.get(z);
//                System.out.println("CORRECT MOVE PĘTLA" + h);
                notEmpty = findNotEmptyNeighbours(h);
                for (int i = 0; i < notEmpty.size(); i++) {
//                    System.out.println("CORRECT MOVE PĘTLA2" + h);
                    AbstractPeg neighbour = notEmpty.get(i);
                    int j_move = -1;
                    int i_move = -1;
                    int i_neighbour = neighbour.geti();
                    int j_neighbour = neighbour.getj();
                    if (h.geti() < i_neighbour && h.geti() < I_BOARD_SIZE - 2) {
                        i_move = h.geti() + 2;
                    } else if (h.geti() > i_neighbour && h.geti() > 1) {
                        i_move = h.geti() - 2;
                    }
                    if (h.getj() < j_neighbour && h.getj() < J_BOARD_SIZE - 1) {
                        j_move = h.getj() + 1;
                    } else if (h.getj() > j_neighbour && h.getj() > 0) {
                        j_move = h.getj() - 1;
                    }
                    if (h.geti() % 2 != 0 && h.getj() == j_neighbour) {
                        j_move = h.getj() + 1;
                    } else if (h.geti() % 2 == 0 && h.getj() == j_neighbour) {
                        j_move = h.getj() - 1;
                    }
                    if (h.geti() == i_neighbour) {
                        i_move = h.geti();
                        if (h.getj() <= j_neighbour && h.getj() < J_BOARD_SIZE - 2) {
                            j_move = h.getj() + 2;
                        } else if (h.getj() > j_neighbour && h.getj() > 1) {
                            j_move = h.getj() - 2;
                        }
                    }
                    if (i_move != -1 && j_move != -1 && board[i_move][j_move].getSectorID() == 0 && leaps.contains(board[i_move][j_move])==false) {
                        moves.add(board[i_move][j_move]);
//                        System.out.println("LEAP" + board[i_move][j_move]);
                        leaps.add(board[i_move][j_move]);
                    }
                }
                //leaps.remove(h);
            }
        //}
//        System.out.println(leaps);

        //System.out.println("ISinCORNER" +isInCorner(p)+ " " +  p);
        if(isInCorner(p)==true){
            for(int k=0; k<moves.size(); k++){
                //System.out.println("ISinCORNER sasiad" +isInCorner(moves.get(k))+ " " +  moves.get(k));
                if(isInCorner(moves.get(k))==true){
                    correctmoves.add(moves.get(k));
//                    System.out.println(moves.get(k));
                }
            }
            return correctmoves;
        }
        return moves;
    }


    @Override
    public java.util.List<AbstractPeg> setPossibleMoves(AbstractPeg p){
        java.util.List<AbstractPeg> moves = correctMoves(p);
        for(int i = 0; i < moves.size(); i++){
            AbstractPeg m = moves.get(i);
            //System.out.println(m);
            m.changeOwnerID(7);
            System.out.println("NEWBOARD");
            board[m.geti()][m.getj()]=m;
            printBoard();
        }
        return moves;
    }

    @Override
    public void changeIdPossibleMoves(java.util.List<AbstractPeg> list){
        for(int i = 0; i < list.size(); i++){
            AbstractPeg m = list.get(i);
            //System.out.println(m);
            m.changeOwnerID(0);
            System.out.println("OLDBOARD");
            this.board[m.geti()][m.getj()]=m;
            printBoard();
        }
    }

    public boolean isInCorner(AbstractPeg p){
        int id = p.getSectorID();
        java.util.List<AbstractPeg> pegs = new ArrayList();
        if((id==1 && p.geti()<4) || (id==0 && p.geti()<4)){
            return true;
        }
        if((id==4 && p.geti()>12) || (id==0 && p.geti()>12)){
            return true;
        }
        if(id==5 || id==0){
            pegs = getPegsOfSector(2);
            for(int i=0; i<pegs.size(); i++){
                AbstractPeg peg = pegs.get(i);
                if(p.geti()==peg.geti() && p.getj()==peg.getj()){
                    return true;
                }
            }
            /*for(int j=0; j<4; j++) {
                if(p.geti()==12 && p.getj()==j){ return true; }
            }
            for(int j=1; j<4; j++){
                if(p.geti()==11 && p.getj()==j){ return true; }
            }
            for(int j=1; j<3; j++){
                if(p.geti()==10 && p.getj()==j){ return true; }
            }
            if(p.geti()==9 && p.getj()==2){ return true; }*/
        }
        if(id==2 || id==0){
            pegs = getPegsOfSector(5);
            for(int i=0; i<pegs.size(); i++){
                AbstractPeg peg = pegs.get(i);
                if(p.geti()==peg.geti() && p.getj()==peg.getj()){
                    return true;
                }
            }
            /*for(int j=9; j<13; j++) {
                if(p.geti()==4 && p.getj()==j){ return true; }
            }
            for(int j=10; j<13; j++){
                if(p.geti()==5 && p.getj()==j){ return true; }
            }
            for(int j=10; j<12; j++){
                if(p.geti()==6 && p.getj()==j){ return true; }
            }
            if(p.geti()==7 && p.getj()==11){ return true; }*/
        }
        if(id==3 || id==0){
            pegs = getPegsOfSector(6);
            for(int i=0; i<pegs.size(); i++){
                AbstractPeg peg = pegs.get(i);
                if(p.geti()==peg.geti() && p.getj()==peg.getj()){
                    return true;
                }
            }
            /*for(int j=9; j<13; j++) {
                if(p.geti()==12 && p.getj()==j){ return true; }
            }
            for(int j=10; j<13; j++){
                if(p.geti()==11 && p.getj()==j){ return true; }
            }
            for(int j=10; j<12; j++){
                if(p.geti()==10 && p.getj()==j){ return true; }
            }
            if(p.geti()==9 && p.getj()==11){ return true; }*/
        }
        if(id==6 || id==0) {
            pegs = getPegsOfSector(3);
            for(int i=0; i<pegs.size(); i++){
                AbstractPeg peg = pegs.get(i);
                if(p.geti()==peg.geti() && p.getj()==peg.getj()){
                    return true;
                }
            }
            /*for (int j = 0; j < 4; j++) {
                if (p.geti() == 4 && p.getj() == j) { return true; }
            }
            for (int j = 1; j < 4; j++) {
                if (p.geti() == 5 && p.getj() == j) { return true; }
            }
            for (int j = 1; j < 3; j++) {
                if (p.geti() == 6 && p.getj() == j) { return true; }
            }
            if (p.geti() == 7 && p.getj() == 2) { return true; }*/
        }
        return false;
    }

    @Override
    public java.util.List<AbstractPeg> getPegsOfSector(int sectorID){
        List<AbstractPeg> pegs = new ArrayList<AbstractPeg>();
        if(sectorID == 1){
            for(int j=5; j<9; j++){ pegs.add(board[13][j]); }
            for(int j=5; j<8; j++){ pegs.add(board[14][j]); }
            for(int j=6; j<8; j++){ pegs.add(board[15][j]); }
            pegs.add(board[16][6]);
        }else if(sectorID == 2){
            for(int j=0; j<4; j++){ pegs.add(board[12][j]); }
            for(int j=1; j<4; j++){ pegs.add(board[11][j]); }
            for(int j=1; j<3; j++){ pegs.add(board[10][j]); }
            pegs.add(board[9][2]);
        }else if(sectorID == 3){
            for (int j = 0; j < 4; j++) { pegs.add(board[4][j]); }
            for (int j = 1; j < 4; j++) { pegs.add(board[5][j]); }
            for (int j = 1; j < 3; j++) { pegs.add(board[6][j]); }
            pegs.add(board[7][2]);
        }else if(sectorID == 4){
            for(int j=5; j<9; j++){ pegs.add(board[3][j]); }
            for(int j=5; j<8; j++){ pegs.add(board[2][j]); }
            for(int j=6; j<8; j++){ pegs.add(board[1][j]); }
            pegs.add(board[0][6]);
        }else if(sectorID == 5){
            for(int j=9; j<13; j++) { pegs.add(board[4][j]); }
            for(int j=10; j<13; j++){ pegs.add(board[5][j]); }
            for(int j=10; j<12; j++){ pegs.add(board[6][j]); }
            pegs.add(board[7][11]);
        }else if(sectorID == 6){
            for(int j=9; j<13; j++) { pegs.add(board[12][j]); }
            for(int j=10; j<13; j++){ pegs.add(board[11][j]); }
            for(int j=10; j<12; j++){ pegs.add(board[10][j]); }
            pegs.add(board[9][11]);
        }
        return pegs;
    }

    @Override
    public void setPeg(int i, int j, int Owner){
        board[i][j]=generator.generatePeg(i,j,Owner);
    }

    @Override
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
