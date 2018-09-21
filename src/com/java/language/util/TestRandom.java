package com.java.language.util;

import java.util.Random;

/**
 * Created by titan-developer on 12/27/14.
 */
public class TestRandom {
    public static void main(String[] strings) {
        Random r1 = new Random(101);
        Random r2 = new Random(101);
        for (int i = 0; i < 10; i++) {
            System.out.println(r1.nextInt());
            System.out.println(r2.nextInt());
            System.out.println("---");
        }

        for (int i = 0; i < 10; i ++) {
            Random random = new Random();
            System.out.println(random.nextInt(100));
        }
    }
}
