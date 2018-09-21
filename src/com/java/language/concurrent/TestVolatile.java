package com.java.language.concurrent;

/**
 * Created by bod on 2/1/15.
 */
public class TestVolatile {

    /**
     *  With normal version, could see i > j sometime in method 'two' output.
     */
    public static void main(String[] strings) {
        Thread thread0 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true)
                    Test.one();
            }
        });

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true)
                    Test.two();
            }
        });

        thread0.start();
        thread1.start();
    }
}

//normal version.
/*version Test {
    static int i = 0, j = 0;
    static void one() { i++; j++; }
    static void two() {
        System.out.println("i=" + i + " j=" + j);
    }
}*/

//synchronized version
/*class Test {
    static int i = 0, j = 0;
    static synchronized void one() { i++; j++; }
    static synchronized void two() {
        System.out.println("i=" + i + " j=" + j);
    }
}*/

//volatile version
class Test {
    static volatile int i = 0, j = 0;
    static void one() { i++; j++; }
    static void two() {
        System.out.println("i=" + i + " j=" + j);
    }
}