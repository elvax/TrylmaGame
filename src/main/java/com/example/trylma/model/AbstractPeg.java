package com.example.trylma.model;

import java.awt.*;
import java.io.IOException;
import java.io.Serializable;

public abstract class AbstractPeg implements Serializable {
    abstract public void generatePeg(int i, int j, int OwnerID);
    abstract public void doDraw(Graphics g);
    abstract public void setImage() throws IOException;
    abstract public int getSectorID();
    abstract public int geti();
    abstract public int getj();
    abstract public int getxDraw();
    abstract public int getyDraw();
    abstract public void setXY(int x, int y);
    abstract public void changeOwnerID(int newOwnerID);
    abstract public boolean isClicked(int x, int y);
//    abstract public AbstractPeg getPeg(int i, int j) throws IllegalArgumentException;

}
