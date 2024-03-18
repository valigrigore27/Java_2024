package org.example;

public class Destination {
    private int distance;

    public Destination(int distance) {
        this.distance = distance;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "Destination{" +
                "distance=" + distance +
                '}';
    }
}
