package com.example.trylma.model;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

import static com.example.trylma.model.SixBoard.DISTANCE_FROM_EDGES;

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

    //public Peg(){}

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


    public void setXY(int x, int y) {
        xDraw = x;
        yDraw = y;
    }

    public int getxDraw() {
        return xDraw;
    }

    public int getyDraw() {
        return yDraw;
    }

    public int geti(){
        return i;
    }

    public int getj(){
        return j;
    }

    public int getSectorID() {
        return sectorID;
    }

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

    public void doDraw(Graphics g) {
        if (sectorID != -1) {
            Graphics g2 = g.create();
            g2.drawImage(image, xDraw, yDraw, size, size, null);

            g2.dispose();
        }

    }

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



    public void changeOwnerID(int newOwnerID) {
        sectorID = newOwnerID;
    }

    public String toString() {
        return "i=" + i + " j=" + j + " id=" + sectorID;
    }


}

