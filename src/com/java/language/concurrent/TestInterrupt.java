package com.java.language.concurrent;

/**
 * Created by titan-developer on 1/26/15.
 */
public class TestInterrupt {
    public static void main(String[] strings) {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (this) {
//                    try {
//                        this.wait(2000);
//                    } catch (InterruptedException e) {
//                        System.out.println("Interrupted status : " + Thread.interrupted());
//                        e.printStackTrace();
//                    }
                    int i = 0;
                    for (i = 0; i < 100000; i ++) {
                        String x = new String("String obj : " + i);
                        boolean isInterrupt = Thread.interrupted();
                        if (isInterrupt) System.out.println("Interrupted... : " + x);
                    }
                    System.out.println("Finish : " + i);
                }
            }
        });

        thread.start();

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread.interrupt();
        System.out.println("Is interrupted : " + thread.isInterrupted());
    }
}
