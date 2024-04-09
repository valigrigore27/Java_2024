package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Player implements Runnable {
    private String playerName;
    private final Bag bag;
    private final int n;
    private final List<Token> tokensDrawn;
    private final Lock lock;

    public Player(String playerName, Bag bag, int n) {
        this.playerName = playerName;
        this.bag = bag;
        this.n = n;
        this.tokensDrawn = new ArrayList<>();
        this.lock = new ReentrantLock();
    }

    public List<Token> getTokensDrawn() {
        return tokensDrawn;
    }

    public String getPlayerName() {
        return playerName;
    }

    @Override
    public void run() {
        while (true) {
            lock.lock();
            try {
                Token token = bag.drawRandomToken();
                if (token == null) {
                    break;
                }
                System.out.println(playerName + " drew token: (" + token.getFirst() + ", " + token.getSecond() + ")");
                tokensDrawn.add(token);
            } finally {
                lock.unlock();
            }
        }
    }

    public int countSequences() {
        int points = 0;
        for (int i = 0; i < tokensDrawn.size(); i++) {
            for (int j = i + 1; j < tokensDrawn.size(); j++) {
                if (tokensDrawn.get(i).getSecond() == tokensDrawn.get(j).getFirst()) {
                    points++;
                }
            }
        }
        return points;
    }
}
