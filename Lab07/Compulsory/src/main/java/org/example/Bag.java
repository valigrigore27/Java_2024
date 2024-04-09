package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

class Bag {
    private final List<Token> tokens;

    public Bag(int n) {
        tokens = new ArrayList<>();
        for (int i = 1; i <= n; i++) {{
                tokens.add(new Token(i, i+1));
            }
        }
        tokens.add(new Token(n+1, 1));
    }

    public synchronized Token drawRandomToken() {
        if (tokens.isEmpty()) {
            return null;
        }
        Random random = new Random();
        int index = random.nextInt(tokens.size());
        return tokens.remove(index);
    }
}
