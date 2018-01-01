package com.example.trylma.model;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

import static com.example.trylma.model.SixBoard.DISTANCE_FROM_EDGES;
/**
 * The Peg class extends AbstractPeg class and contains the methods
 * needed to draw a square peg for the board, which is a six-pointed star.
 * Every peg has following fields:
 * <ul>
 * <li> i - the row number of the board in which it's placed.
 * <li> j - the column number of the board in which it's placed.
 * <li> xDraw - x-coordinate of the northwest corner
 * of the destination peg in pixels.
 * <li> yDraw - y-coordinate of the northwest corner
 * of the destination peg in pixels.
 * <li> image - the image of the peg - square of the right color.
 * <li> sectorID - ID of the player to which the peg belongs.
 * </ul>
 * @author      Sebastian Pabich
 * @author      Maria Wita
 * @version     1.0
 * @since       1.0
 */
public class SixSquarePeg extends AbstractPeg {
    int i;
    int j;
    int xDraw;
    int yDraw;
    private Image image;
    boolean isDraw;
    int sectorID;
    final int size = 30;
    final int radius = 15;
    /**
     * Factory method which generates a peg
     * with appropriate properties depending on
     * the selection of {@link PegGenerator}.
     *
     * @param i             the row number of the board in which
     *                      the peg is placed
     * @param j             the column number of the board in which
     *                      the peg is placed
     * @param sectorID       an integer indicating the ID of the player
     *                      to which the peg belongs.
     * @since               1.0
     */
    public void generatePeg(int i, int j, int sectorID){
        this.i = i;
        this.j = j;
        this.sectorID = sectorID;

        if (i % 2 == 0) {
            setXY((j * 35) + DISTANCE_FROM_EDGES, (i * 35) + DISTANCE_FROM_EDGES);
        } else {
            setXY((j * 35) - 40/2 + DISTANCE_FROM_EDGES, (i * 35) + DISTANCE_FROM_EDGES);
        }
    }

    /**
     * Method setXY sets the x-coordinate and y-coordinate of the northwest
     * corner of the destination peg in pixels.
     *
     * @param x         the x-coordinate in pixels
     * @param y         the y-coordinate in pixels.
     * @since       1.0
     */
    public void setXY(int x, int y) {
        xDraw = x;
        yDraw = y;
    }
    /**
     * Method getxDraw returns the x-coordinate of the northwest corner
     * of the destination peg in pixels.
     *
     * @return     the x-coordinate.
     * @since       1.0
     */
    public int getxDraw() {
        return xDraw;
    }
    /**
     * Method getyDraw returns the y-coordinate of the northwest corner
     * of the destination peg in pixels.
     *
     * @return     the y-coordinate.
     * @since       1.0
     */
    public int getyDraw() {
        return yDraw;
    }
    /**
     * Method geti returns the row number of the board in which
     * the peg is placed.
     *
     * @return     the row number of the board.
     * @since       1.0
     */
    public int geti(){
        return i;
    }
    /**
     * Method getj returns the column number of the board in which
     * the peg is placed.
     *
     * @return     the column number of the board.
     * @since       1.0
     */
    public int getj(){
        return j;
    }
    /**
     * Method getSectorID returns the sector number of the peg
     * which is the same as a number of the player to which it belongs.
     *
     * @return     OwnerID which is the same as the sectorID.
     * @since       1.0
     */
    public int getSectorID() {
        return sectorID;
    }
    /**
     * Method setImage sets an image of a peg that is closely
     * related to the OwnerID.
     *
     * @throws IOException      If an input or output
     *                          exception occurred
     * @since                   1.0
     */
    public void setImage() throws IOException {
        if (sectorID == -1) {
//            image = null;
        } else if (sectorID == 0) {
            image = ImageIO.read(new File("src/main/resources/stransparent.png"));
        } else if (sectorID == 1) {
            image = ImageIO.read(new File("src/main/resources/sred.png"));
        }else if (sectorID == 2) {
            image = ImageIO.read(new File("src/main/resources/sblue.png"));
        }else if (sectorID == 3) {
            image = ImageIO.read(new File("src/main/resources/spink.png"));
        }else if (sectorID == 4) {
            image = ImageIO.read(new File("src/main/resources/syellow.png"));
        }else if (sectorID == 5) {
            image = ImageIO.read(new File("src/main/resources/sorange.png"));
        }else if (sectorID == 6) {
            image = ImageIO.read(new File("src/main/resources/sgreen.png"));
        }else if (sectorID == 7) {
            image = ImageIO.read(new File("src/main/resources/slight.png"));
        }
    }
    /**
     * Method doDraw draws a peg with appropriate properties.
     *
     * @param g             graphics
     * @since               1.0
     */
    public void doDraw(Graphics g) {
        if (sectorID != -1) {
            Graphics g2 = g.create();
            g2.drawImage(image, xDraw, yDraw, size, size, null);

            g2.dispose();
        }

    }
    /**
     * Method isClicked returns true, when the square peg includes
     * clicked x-coordinate and y-coordinate and false otherwise.
     *
     * @param x         the clicked x-coordinate in pixels
     * @param y         the clicked y-coordinate in pixels.
     * @return          <code>true</code> if the peg is clicked
     *                  by the Owner and <code>false</code> otherwise.
     * @since           1.0
     */
    public boolean isClicked(int x, int y){
        if (sectorID < 0)
            return false;
        if( x <= this.xDraw + 30 && x > this.xDraw && y <= this.yDraw + 30 && y > this.yDraw ){
            return true;
        }
        else{
            return false;
        }
    }
    /**
     * Method changeOwnerID changes the owner of the peg.
     *
     * @param newOwnerID    the new player ID
     * @since               1.0
     */
    public void changeOwnerID(int newOwnerID) {
        sectorID = newOwnerID;
    }
    /**
     * Method toString prints, where the peg is placed: the row and column
     * number of the board and the OwnerID.
     *
     * @return  the information of the peg in String
     * @since   1.0
     */
    public String toString() {
        return "i=" + i + " j=" + j + " id=" + sectorID;
    }
}

