package com.java.language.concurrent;

/**
 * Created by bod on 1/26/2015.
 */
public class DaemonThread {
    public static void main(String[] strings) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    synchronized (this) {
                        try {
                            this.wait(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
        thread.setDaemon(true);
        thread.start();

        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (this) {
                    try {
                        this.wait(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println("Thread stopped");
                }
            }
        });

        threadB.start();
    }
}
