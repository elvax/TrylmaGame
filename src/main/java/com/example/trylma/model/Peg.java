package com.example.trylma.model;

import java.awt.*;

/*
 * Every peg has his owner and imformations needed to draw itself
 */
public class Peg {
    int i;
    int j;
    int xDraw;
    int yDraw;
    Image image;
    int ownerID;

    public Peg(int i, int j, int ownerID) {
        this.i = i;
        this.j = j;
        this.ownerID = ownerID;
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
}
