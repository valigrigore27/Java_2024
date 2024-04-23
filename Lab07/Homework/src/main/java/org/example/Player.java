package org.example;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Player implements Runnable {
    private final String playerName;
    private final Bag bag;
    private final List<Token> tokensDrawn;
    private final Lock lock;
    private final Object turnLock;
    private int points = 0;

    public Player(String playerName, Bag bag, int n, Object turnLock) {
        this.playerName = playerName;
        this.bag = bag;
        this.tokensDrawn = new ArrayList<>();
        this.lock = new ReentrantLock();
        this.turnLock = turnLock;
    }

    public List<Token> getTokensDrawn() {
        return tokensDrawn;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getPoints() {
        return points;
    }

    @Override
    public void run() {
        while (true) {
//            synchronized (turnLock) {
//                try {
//                    turnLock.wait();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
            lock.lock();
            try {
                Token lastToken = tokensDrawn.isEmpty() ? null : tokensDrawn.get(tokensDrawn.size() - 1);
                Token token = chooseNextToken(lastToken);
                if (token == null) {
                    break;
                }
                System.out.println(playerName + " drew token: (" + token.getFirst() + ", " + token.getSecond() + ")");
                tokensDrawn.add(token);
                //turnLock.notifyAll();
            } finally {
                lock.unlock();
            }
        }
    }
    private Token chooseNextToken(Token lastToken) {
        synchronized (bag) {
            Iterator<Token> iterator = bag.getTokens().iterator();
            while (iterator.hasNext()) {
                Token candidate = iterator.next();
                if (lastToken == null || candidate.getFirst() == lastToken.getSecond()) {
                    iterator.remove();
                    return candidate;
                }
            }
        }
        return null;
    }


    public int countSequences() {
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
