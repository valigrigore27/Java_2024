Am creat clasele Bag, Player si Token.

Clasa Player implementeaza clasa Runnable fiecare jucător avand un nume si acestia extragand token-uri din clasa Bag, iar in clasa Main vom aloca fiecare player unui thread.

In clasa Bag am metoda public synchronized Token drawRandomToken() ce va asigura ca atunci cand playerii vor extrage token-uri din Bag, sa nu extraga in acelasi timp acelasi token.
