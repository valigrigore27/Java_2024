package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        int n = 8;
        int numberOfPlayers = 5;
        long timeLimitMillis = 30;

        Bag bag = new Bag(n);
        List<Player> players = new ArrayList<>();
        List<Thread> threads = new ArrayList<>();
        Object turnLock = new Object();

        GameTimer gameTimer = new GameTimer(timeLimitMillis);
        gameTimer.start();

        for (int i = 1; i <= numberOfPlayers; i++) {
            Player player = new Player("Player " + i, bag, n, turnLock);
            players.add(player);
            Thread thread = new Thread(player);
            threads.add(thread);
            thread.start();
        }

        Player player1 = new Player("Ionut", bag, n, turnLock);
        player1.setPoints(1);
        players.add(player1);

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        if (gameTimer.isTimeExpired()) {
            System.out.println(gameTimer.getTimeLimitMillis() + " millis exceeded! Game over.");
        } else {

            Player winner = new Player("NOBODY", bag, n, turnLock);
            int maxPoints = 0;
            for (Player player : players) {
                int points = player.countSequences();
                if (points > maxPoints) {
                    maxPoints = points;
                    winner = player;
                }
            }
            int flag = 0;
            for (Player player : players){
                if(winner.getPoints() > 0 && player.getPoints() == winner.getPoints() && !Objects.equals(player.getPlayerName(), winner.getPlayerName())){
                    System.out.println("DRAW");
                    System.out.println(winner.getPlayerName() + " has the same SCORE as " + player.getPlayerName());
                    flag = 1;
                }
            }
            if(flag == 0){
                System.out.println("Winner is: " + winner.getPlayerName() + " with " + winner.getPoints() + " points.");
            }
        }
    }
}
