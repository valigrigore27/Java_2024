package org.example.homework;

import org.example.homework.Intersection;

import java.io.Serializable;
import java.util.Random;

public class Board implements Serializable {
    private Intersection[][] intersections;
    private int numLines;
    private int numColumns;

    public Board(int numLines, int numColumns) {
        this.numLines = numLines;
        this.numColumns = numColumns;
        intersections = new Intersection[numLines][numColumns];
        initializeIntersections();
        //generateRandomSticks();
    }

    private void initializeIntersections() {
        for (int i = 0; i < numLines; i++) {
            for (int j = 0; j < numColumns; j++) {
                intersections[i][j] = new Intersection(i, j);
            }
        }
    }
    public void resetBoard(int numLines, int numColumns) {
        this.numLines = numLines;
        this.numColumns = numColumns;
        intersections = new Intersection[numLines][numColumns];
        initializeIntersections();
    }

    public Intersection getIntersection(int x, int y) {
        return intersections[x][y];
    }

    public int getNumLines() {
        return numLines;
    }

    public int getNumColumns() {
        return numColumns;
    }

    public Intersection[][] getIntersections() {
        return intersections;
    }

    public void setIntersections(Intersection[][] intersections) {
        this.intersections = intersections;
    }

    public void setNumLines(int numLines) {
        this.numLines = numLines;
    }

    public void setNumColumns(int numColumns) {
        this.numColumns = numColumns;
    }

    public boolean isStoneAt(int x, int y) {
        return intersections[x][y].isOccupied();
    }
}
