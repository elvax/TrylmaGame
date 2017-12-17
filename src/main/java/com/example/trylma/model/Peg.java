package com.example.trylma.model;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;

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
    int ownerID;
    final int size = 30;
    final int radius = 15;

    public Peg(int i, int j, int ownerID) {
        try {
            this.i = i;
            this.j = j;
            this.ownerID = ownerID;

            setImage(ownerID);

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

    public int getOwnerID() {
        return ownerID;
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

            if (ownerID == 1) {
                g2.setColor(Color.RED);
                g2.fillOval(xDraw, yDraw, size, size);
            }
            g2.dispose();
        }

    }

    public boolean isClicked(int x, int y){
        if (ownerID < 1)
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
        ownerID = newOwnerID;
    }

    public String toString() {
        return "i=" + i + "j+" + j;
    }


}
