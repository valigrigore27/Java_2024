package org.example;

public class GameTimer extends Thread {
    private final long timeLimitMillis;
    private volatile boolean timeExpired = false;

    public GameTimer(long timeLimitMillis) {
        this.timeLimitMillis = timeLimitMillis;
        setDaemon(true);
    }

    public long getTimeLimitMillis() {
        return timeLimitMillis;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(timeLimitMillis);
            timeExpired = true;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean isTimeExpired() {
        return timeExpired;
    }
}
