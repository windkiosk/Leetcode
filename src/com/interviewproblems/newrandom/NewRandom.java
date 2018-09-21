package com.interviewproblems.newrandom;

import java.util.Random;

/**
 * Created by titan-developer on 1/18/15.
 */
public class NewRandom {

    Random random = new Random();

    public int newRandom() {
        while (true) {
            int res = 0;
            for (int i = 0; i < 10; ++i) {
                int v = random();
                res |= v << i;
            }
            if (res <= 99) return 1;
            else if (res <= 999) return 0;
        }
    }

    public int random() {
        return random.nextBoolean() ? 0 : 1;
    }
}
