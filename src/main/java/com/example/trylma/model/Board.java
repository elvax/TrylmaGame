package com.example.trylma.model;

import java.awt.*;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class Board implements Serializable{
    public abstract void generateBoard(PegGenerator P);

    public abstract void setImage() throws IOException;

    public abstract List setBoardForPlayers(int numberOfPlayers);

    public abstract void doDrawBoard(Graphics g);

    public abstract void updateBoard(AbstractPeg[] list);

    public abstract void fillSector(int i);

    public abstract AbstractPeg getClicked(int x, int y);

    public abstract AbstractPeg getPeg(int i, int j);

    public abstract List<AbstractPeg> move(AbstractPeg p, int i, int j);

    public abstract List<AbstractPeg> move(AbstractPeg p, AbstractPeg d);

    public abstract List<AbstractPeg> correctMoves(AbstractPeg p);

    public abstract List<AbstractPeg> setPossibleMoves(AbstractPeg p);

    public abstract void changeIdPossibleMoves(List<AbstractPeg> list);

    public abstract List<AbstractPeg> getPegsOfSector(int sectorID);

    public abstract List<AbstractPeg> getPegsOfID(int id);

    public abstract void setPeg(int i, int j, int Owner);

    public abstract void printBoard();
}
