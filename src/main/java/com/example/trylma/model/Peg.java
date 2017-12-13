package com.example.trylma.model;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/*
 * Every peg has his owner and imformations needed to draw itself
 */
public class Peg {
    int i;
    int j;
    int xDraw;
    int yDraw;
    private BufferedImage image;
    int ownerID;
    final int size = 30;
    final int radius = 15;

    public Peg(int i, int j, int ownerID) {
        try {
            this.i = i;
            this.j = j;
            this.ownerID = ownerID;
            setImage();
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

    public int geti() {
        return i;
    }

    public int getj() { return j; }

    public int getOwnerID() {
        return ownerID;
    }

    private void setImage() throws IOException{
        if (ownerID == -1) {
            image = null;
        } else if (ownerID == 0) {
            image = ImageIO.read(new File("src/main/resources/transparent.png"));
        } else if (ownerID == 1) {
            image = ImageIO.read(new File("src/main/resources/red.png"));
        } else if (ownerID == 2) {
            image = ImageIO.read(new File("src/main/resources/blue.png"));
        } else if (ownerID == 3) {
            image = ImageIO.read(new File("src/main/resources/pink.png"));
        } else if (ownerID == 4) {
            image = ImageIO.read(new File("src/main/resources/yellow.png"));
        } else if (ownerID == 5) {
            image = ImageIO.read(new File("src/main/resources/orange.png"));
        } else if (ownerID == 6) {
            image = ImageIO.read(new File("src/main/resources/green.png"));
        }
    }

    public void doDraw(Graphics g) {
            Graphics g2 = g.create();
            g2.drawImage(image, xDraw, yDraw, size, size, null);
            g2.dispose();
    }

    public boolean isClicked(int x, int y){
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


}
