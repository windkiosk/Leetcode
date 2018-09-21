package com.java.language.concurrent;

/**
 * Created by bod on 11/17/14.
 */
public class SynchronizeInterruptibility {

    public static void main(String[] strings) {

        Object mutex = new Object();

        ThreadA a = new ThreadA(mutex);

        ThreadB b = new ThreadB(mutex);

        a.setThread(b);
        a.start();
        b.start();
    }
}

class ThreadA extends Thread {

    Object mutex = null;
    Thread threadB = null;

    public ThreadA(Object mutex) {
        this.mutex = mutex;
    }

    public void setThread(Thread b) {
        this.threadB = b;
    }

    public void run() {

        synchronized (mutex) {
            try {
                System.out.println("sleep in A");
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("interrupt B");
            threadB.interrupt();

            try {
                System.out.println("sleep in A2");
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("release block in A");
        }

    }
}

class ThreadB extends Thread {

    Object mutex = null;

    public ThreadB(Object mutex) {
        this.mutex = mutex;
    }

    public void run() {

        try {


            //thread B cannot be interrupted when waiting for the block.
            synchronized (mutex)
            {

                System.out.println("sleep in B");
                Thread.sleep(4000);
                System.out.println("sleep in B finished");

            }

        } catch (InterruptedException e) {
            System.out.println("Got interrupted");
            e.printStackTrace();
        }

    }
}



