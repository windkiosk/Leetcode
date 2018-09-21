package com.java.language.concurrent;

/**
 * Created by titan-developer on 1/26/15.
 */
public class TestInterruptWait {
    public static void main(String[] strings) {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (this) {
                    try {
                        this.wait(2000);
                    } catch (InterruptedException e) {
                        //expected to return false since wait() already consume interrupt flag.
                        System.out.println("Interrupted status : " + Thread.interrupted());
                        e.printStackTrace();
                    }
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
