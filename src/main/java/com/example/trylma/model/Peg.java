package com.example.trylma.model;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;

import static com.example.trylma.model.SixBoard.DISTANCE_FROM_EDGES;

/*
 * Every peg has his owner and imformations needed to draw itself
 */
public class Peg extends AbstractPeg implements Serializable{
    int i;
    int j;
    int xDraw;
    int yDraw;
    private Image image;
    boolean isDraw;
    int sectorID;
    final int size = 30;
    final int radius = 15;

    public Peg(int i, int j, int sectorID) {
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

    public void setImage() throws IOException{
        if (sectorID == -1) {
//            image = null;
        } else if (sectorID == 0) {
            image = ImageIO.read(new File("src/main/resources/transparent.png"));
        } else if (sectorID == 1) {
            image = ImageIO.read(new File("src/main/resources/red.png"));
        }else if (sectorID == 2) {
            image = ImageIO.read(new File("src/main/resources/blue.png"));
        }else if (sectorID == 3) {
            image = ImageIO.read(new File("src/main/resources/pink.png"));
        }else if (sectorID == 4) {
            image = ImageIO.read(new File("src/main/resources/yellow.png"));
        }else if (sectorID == 5) {
            image = ImageIO.read(new File("src/main/resources/orange.png"));
        }else if (sectorID == 6) {
            image = ImageIO.read(new File("src/main/resources/green.png"));
        }else if (sectorID == 7) {
            image = ImageIO.read(new File("src/main/resources/light.png"));
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
        int x_c = this.xDraw + 15;
        int y_c = this.yDraw + 15;
        int sqrt_radius = this.radius*this.radius;
        int result = (x - x_c)*(x - x_c) + (y - y_c)*(y - y_c);
        if( result <= sqrt_radius ){
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
