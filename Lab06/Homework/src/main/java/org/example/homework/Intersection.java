package org.example.homework;

import java.io.Serializable;

public class Intersection implements Serializable {
    private int x;
    private int y;
    private boolean occupied;

    public Intersection(int x, int y) {
        this.x = x;
        this.y = y;
        this.occupied = false;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void placeStone() {
        occupied = true;
    }

    public void removeStone() {
        occupied = false;
    }
}

