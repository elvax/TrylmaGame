package com.example.trylma.model;

import java.awt.*;
import java.io.IOException;

public abstract class AbstractPeg {
    abstract public void doDraw(Graphics g);
    abstract public void setImage(int ownerId) throws IOException;
    abstract public int getSectorID();
    abstract public void setXY(int x, int y);
    abstract public void changeOwnerID(int newOwnerID);
    abstract public boolean isClicked(int x, int y);
//    abstract public AbstractPeg getPeg(int i, int j) throws IllegalArgumentException;

}
