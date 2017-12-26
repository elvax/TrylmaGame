package com.example.trylma.model;

import java.awt.*;
import java.io.IOException;
import java.io.Serializable;

import static com.example.trylma.model.Board.DISTANCE_FROM_EDGES;

/*
 * Every peg has his owner and imformations needed to draw itself
 */
public class Peg extends AbstractPeg implements Serializable{
    int i;
    int j;
    int xDraw;
    int yDraw;
//    private Image image;
    boolean isDraw;
    int sectorID;
    final int size = 30;
    final int radius = 15;

    public Peg(int i, int j, int sectorID) {
        try {
            this.i = i;
            this.j = j;
            this.sectorID = sectorID;

            if (i % 2 == 0) {
                setXY((j * 35) + DISTANCE_FROM_EDGES, (i * 35) + DISTANCE_FROM_EDGES);
            } else {
                setXY((j * 35) - 40/2 + DISTANCE_FROM_EDGES, (i * 35) + DISTANCE_FROM_EDGES);
            }

            setImage(sectorID);

        } catch (IOException e) {
            e.printStackTrace();
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

    public int getSectorID() {
        return sectorID;
    }

    public void setImage(int ownerID) throws IOException{
        if (ownerID == -1) {
//            image = null;
            isDraw = false;
        } else if (ownerID == 0) {
//            image = ImageIO.read(new File("src/main/resources/transparent.png"));
            isDraw = true;
        } else if (ownerID == 1) {
            isDraw = true;
        }
    }

    public void doDraw(Graphics g) {
        if (isDraw) {
            Graphics g2 = g.create();
            g2.drawOval(xDraw, yDraw, size, size);

            if (sectorID == 1) {
                g2.setColor(Color.RED);
                g2.fillOval(xDraw, yDraw, size, size);
            }
            g2.dispose();
        }

    }

    public boolean isClicked(int x, int y){
        if (sectorID < 1)
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
        return "i=" + i + "j+" + j;
    }


}
