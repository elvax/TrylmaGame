package com.example.trylma.model;

import java.awt.*;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/**
 * The SixBoard class extends abstract Board class and contains all the basic methods,
 * which the application needs to draw the board that has a shape of six-pointed star.
 *
 * @author      Sebastian Pabich
 * @author      Maria Wita
 * @version     1.0
 * @since       1.0
 */
public class SixBoard extends Board implements Serializable {
    public static int I_BOARD_SIZE = 17;
    public static int J_BOARD_SIZE = 13;
    public static final int DISTANCE_FROM_EDGES = 10;
    public PegGenerator generator;

    private AbstractPeg[][] board;
    /**
     * Constructor initialize the board of pegs.
     *
     * @since               1.0
     */
    public SixBoard() {
        board = new AbstractPeg[I_BOARD_SIZE][J_BOARD_SIZE];
    }

    /**
     * Factory method which generates a board which has a shape of six-pointed star
     * with appropriate peg depending on the selection of {@link PegGenerator}
     * and {@link BoardGenerator}.
     *
     * @param P             PegGenerator, which return the appropriate
     *                      Peg to board.
     * @since               1.0
     */
    @Override
    public void generateBoard(PegGenerator P){
        this.generator = P;
        initalizeBoard();
        setXYDraws();
    }

    /**
     * Method which fills the board with Pegs instances which will be used by players.
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
     * and + means "-1" was passed to sectorID
     * in constructor
     */
    private void initalizeBoard() {
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
        for(int j=0; j<13; j++) { board[i][j]=generator.generatePeg(i,j,0); }

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

        i=12;
        for(int j=0; j<13; j++) { board[i][j]=generator.generatePeg(i,j,0); }

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
    /**
     * Method which sets the board for players,
     * fill the board which pegs with correct sector ID
     * and returns the list of active sectors.
     *
     * @param numberOfPlayers      the number of players in game
     * @return                     the list of the active sectors
     *                             (sectors using in game)
     * @since                      1.0
     */
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

    /**
     * Abstract method which sets the x and y coordinates of
     * all pegs in the board.
     * @throws IOException      If an input or output
     *                          exception occurred
     * @since                   1.0
     */
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
    /**
     * Method which sets the appropriate image of all pegs in the board,
     * which use the peg's function setImage().
     * @throws IOException      If an input or output
     *                          exception occurred
     * @since                   1.0
     */
    @Override
    public void setImage() throws IOException {
        for(int i=0; i<I_BOARD_SIZE; i++) {
            for(int j=0; j<J_BOARD_SIZE; j++) {
                board[i][j].setImage();
            }
        }
    }
    /**
     * Abstract method doDrawBoard draws a board with appropriate properties
     * using the peg's doDraw function.
     *
     * @param g             graphics
     * @since               1.0
     */
    @Override
    public void doDrawBoard(Graphics g) {
        for(int i=0; i<I_BOARD_SIZE; i++) {
            for(int j=0; j<J_BOARD_SIZE; j++) {
                board[i][j].doDraw(g);
            }
        }
    }
    /**
     * Method updates the Board by changing pawns on the board
     * with pawns from the list.
     *
     * @param list          list of the pegs, which changed their properties,
     *                      for example the OwnerID
     * @since               1.0
     */
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

    /**
     * Method which returns all pegs that belongs to
     * the selected player.
     *
     * @param id            the number of owner ID
     * @return              list all of pegs of the selected player
     * @since               1.0
     */
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
    /**
     * Method which fill one of the sector of the board with correct pawns.
     *
     * @param i            the sector ID
     * @since                1.0
     */
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

    /**
     * Method which fill the sector one with pawns
     * and sets the OwnerID to 1.
     *
     * @since                1.0
     */
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

    /**
     * Method which fill the sector two with pawns
     * and sets the OwnerID to 2.
     *
     * @since                1.0
     */
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
    /**
     * Method which fill the sector three with pawns
     * and sets the OwnerID to 3.
     *
     * @since                1.0
     */
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

    /**
     * Method which fill the sector four with pawns
     * and sets the OwnerID to 4.
     *
     * @since                1.0
     */
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

    /**
     * Method which fill the sector five with pawns
     * and sets the OwnerID to 5.
     *
     * @since                1.0
     */
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

    /**
     * Method which fill the sector six with pawns
     * and sets the OwnerID to 6.
     *
     * @since                1.0
     */
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

    /**
     * Method getClicked returns the peg from the board which was clicked.
     *
     * @param x         the clicked x-coordinate in pixels
     * @param y         the clicked y-coordinate in pixels.
     * @return          peg from the board which was clicked.
     * @since           1.0
     */
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

    /**
     * Method which returns the peg which is in the i - row
     * and j - column in the board.
     *
     * @param i             the row number
     * @param j             the column number
     * @return              peg from the board
     * @since               1.0
     */
    @Override
    public AbstractPeg getPeg(int i, int j){
        return board[i][j];
    }

    /**
     * Method which return the list of all neighbours of the clicked peg.
     *
     * @param peg           the clicked peg which we want to move
     * @return              peg's list of not empty neighbours
     * @since               1.0
     */
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
                if (((t == j - 1 && i % 2 == 0) && (k == i - 1 || k == i + 1)) || k == i && t == j) {}
                else if ((t == j + 1 && i % 2 != 0) && (k == i + 1 || k == i - 1)) {}
                else { neighbours.add(board[k][t]);
                }
            }
        }
        return neighbours;
    }
    /**
     * Method which return the list of neighbours of the clicked peg
     * which are empty.
     *
     * @param peg           the clicked peg which we want to move
     * @return              peg's list of empty neighbours
     * @since               1.0
     */
    public java.util.List<AbstractPeg> findEmptyNeighbours(AbstractPeg peg){
        java.util.List<AbstractPeg> neighbours = findNeighbours(peg);
        java.util.List<AbstractPeg> emptyNeighbours = new ArrayList<AbstractPeg>();
        for(int i = 0; i < neighbours.size(); i++){
            AbstractPeg p = neighbours.get(i);
            if(p.getSectorID() == 0){
                emptyNeighbours.add(p);
            }
        }
        return emptyNeighbours;
    }

    /**
     * Method which return the list of neighbours of the clicked peg
     * which are not empty.
     *
     * @param peg           the clicked peg which we want to move
     * @return              peg's list of not empty neighbours
     * @since               1.0
     */
    public java.util.List<AbstractPeg> findNotEmptyNeighbours(AbstractPeg peg){
        java.util.List<AbstractPeg> neighbours = findNeighbours(peg);
        java.util.List<AbstractPeg> notEmptyNeighbours = new ArrayList<AbstractPeg>();
        for(int i = 0; i < neighbours.size(); i++){
            AbstractPeg p = neighbours.get(i);
            if(p.getSectorID() != 0 && p.getSectorID() != -1){
                notEmptyNeighbours.add(p);
            }
        }
        return notEmptyNeighbours;
    }

    /**
     * Method which checks if the move on the board is correct
     * and then returns two pegs that should be change or null,
     * when the move was't correct.
     *
     * @param p             the clicked peg which we want to move
     * @param i             the x - coordinate of the destiny peg
     * @param j             the y - coordinate of the destiny peg
     * @return              list of pegs that should be change
     * @since               1.0
     */
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

    /**
     * Method which checks if the move on the board is correct
     * and then returns two pegs that should be change or null,
     * when the move was't correct.
     *
     * @param p             the clicked peg which we want to move
     * @param d             the destiny place(peg which sectorID=0),
     *                      where we want to put the clicked peg
     * @return              list of pegs that should be change
     * @since               1.0
     */
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
    /**
     * Method which return the list of possible pegs that
     * can be replace by the clicked peg.
     *
     * @param p             the clicked peg which we want to move
     * @return              peg's list of possible moves
     * @since               1.0
     */
    public List<AbstractPeg> correctMoves(AbstractPeg p){
        List<AbstractPeg> moves = findEmptyNeighbours(p);
        List<AbstractPeg> notEmpty = findNotEmptyNeighbours(p);
        List<AbstractPeg> correctmoves = new ArrayList<AbstractPeg>();
        List<AbstractPeg> leaps = new ArrayList<AbstractPeg>();
        leaps.add(p);
        for(int z=0; z<leaps.size(); z++){
                AbstractPeg h = leaps.get(z);
                notEmpty = findNotEmptyNeighbours(h);
                for (int i = 0; i < notEmpty.size(); i++) {
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
                        leaps.add(board[i_move][j_move]);
                    }
                }
        }
        if(isInCorner(p)==true){
            for(int k=0; k<moves.size(); k++){
                if(isInCorner(moves.get(k))==true){
                    correctmoves.add(moves.get(k));
                }
            }
            return correctmoves;
        }
        return moves;
    }

    /**
     * Method which return the list of possible pegs that
     * can be replace by the clicked peg and change the sectorID of
     * this pegs in the board to number which means possible moves.
     *
     * @param p             the clicked peg which we want to move
     * @return              peg's list of possible moves
     * @since               1.0
     */
    @Override
    public java.util.List<AbstractPeg> setPossibleMoves(AbstractPeg p){
        java.util.List<AbstractPeg> moves = correctMoves(p);
        for(int i = 0; i < moves.size(); i++){
            AbstractPeg m = moves.get(i);
            m.changeOwnerID(7);
            board[m.geti()][m.getj()]=m;
        }
        return moves;
    }
    /**
     * Method which change the sectorID of pegs in the board
     * to number which means that they are empty.
     *
     * @param list          the list of pegs to change their sectorID
     * @since               1.0
     */
    @Override
    public void changeIdPossibleMoves(java.util.List<AbstractPeg> list){
        for(int i = 0; i < list.size(); i++){
            AbstractPeg m = list.get(i);
            m.changeOwnerID(0);
            this.board[m.geti()][m.getj()]=m;
        }
    }

    /**
     * Method which check if the peg is in the opposite corner.
     *
     * @param p             the clicked peg which we want to move
     * @return              true when is in the opposite corner  and false otherwise
     * @since               1.0
     */
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
        }
        if(id==2 || id==0){
            pegs = getPegsOfSector(5);
            for(int i=0; i<pegs.size(); i++){
                AbstractPeg peg = pegs.get(i);
                if(p.geti()==peg.geti() && p.getj()==peg.getj()){
                    return true;
                }
            }
        }
        if(id==3 || id==0){
            pegs = getPegsOfSector(6);
            for(int i=0; i<pegs.size(); i++){
                AbstractPeg peg = pegs.get(i);
                if(p.geti()==peg.geti() && p.getj()==peg.getj()){
                    return true;
                }
            }
        }
        if(id==6 || id==0) {
            pegs = getPegsOfSector(3);
            for(int i=0; i<pegs.size(); i++){
                AbstractPeg peg = pegs.get(i);
                if(p.geti()==peg.geti() && p.getj()==peg.getj()){
                    return true;
                }
            }
        }
        return false;
    }
    /**
     * Method which returns all pegs that belongs to the sector.
     *
     * @param sectorID      the number of sector ID
     * @return              list of pegs of the selected sector
     * @since               1.0
     */
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
    /**
     * Method which sets peg with new properties in the board.
     *
     * @param i             the row number of peg in the board
     * @param j             the column number of peg in the board
     * @param Owner         the Owner ID of the peg
     * @since               1.0
     */
    @Override
    public void setPeg(int i, int j, int Owner){
        board[i][j]=generator.generatePeg(i,j,Owner);
    }

    /**
     * Method prints the board.
     * @since               1.0
     */
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
    /**
     * Method which returns true if the player won the game.
     *
     * @param PlayerID            the number of player ID
     * @return                    list all of pegs of the selected player
     * @since                     1.0
     */
    @Override
    public boolean isWinner(int PlayerID){
        int sector=0;
        if(PlayerID==1){ sector = 4; }
        else if(PlayerID==4){ sector = 1; }
        else if(PlayerID==6){ sector = 3; }
        else if(PlayerID==3){ sector = 6; }
        else if(PlayerID==5){ sector = 2; }
        else if(PlayerID==2){ sector = 5; }
        List<AbstractPeg> pegs = getPegsOfSector(sector);
        for(int i=0; i<pegs.size(); i++){
            AbstractPeg p = pegs.get(i);
            if(p.getSectorID()!=PlayerID){
                return false;
            }
        }
        return true;
    }

}
