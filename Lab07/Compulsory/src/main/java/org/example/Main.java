package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int n = 5;
        int numberOfPlayers = 3;
        Bag bag = new Bag(n);

        List<Player> players = new ArrayList<>();
        List<Thread> threads = new ArrayList<>();

        for (int i = 1; i <= numberOfPlayers; i++) {
            Player player = new Player("Player " + i, bag, n);
            players.add(player);
            Thread thread = new Thread(player);
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
