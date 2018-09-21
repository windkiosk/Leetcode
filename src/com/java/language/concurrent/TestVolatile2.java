package com.java.language.concurrent;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by bod on 2/1/15.
 */
public class TestVolatile2 {

    /**
     * Volatile can solve the visibility issue among different threads.
     * But still facing racing condition.
     */
    public static void main(String[] strings) {
        Thread thread0 = new Thread(new Runnable() {
            @Override
            public void run() {
                int c = 0;
                while (c++ < 10000) {
                    AddWithVolatile.one();
                    AddWithAtomic.one();
                }

                System.out.println("Thread0: finish");
                AddWithAtomic.two();
                AddWithVolatile.two();
            }
        });

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                int c = 0;
                while (c++ < 10000) {
                    AddWithVolatile.one();
                    AddWithAtomic.one();
                }

                System.out.println("Thread1: finish");

                AddWithAtomic.two();
                AddWithVolatile.two();
            }
        });

        thread0.start();
        thread1.start();
    }
}

class AddWithVolatile {
    static volatile int i = 0;
    static void one() { i++;}
    static void two() {
        System.out.println("volatile i=" + i);
    }
}
class AddWithAtomic {
    static AtomicInteger i = new AtomicInteger(0);
    static void one() { i.incrementAndGet();}
    static void two() {
        System.out.println("Atomic i=" + i.intValue());
    }
}

