package com.java.language.concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by bod on 11/17/14.
 */
public class LocksTest {

    public static void main(String[] strings) {
        Lock lock = new ReentrantLock();

        Condition condition = lock.newCondition();

        ThreadD d = new ThreadD(lock, condition);
        ThreadC c = new ThreadC(lock, condition);

        c.start();
        d.start();

        //test lock.lockInterruptibly()
        try {
            Thread.sleep(1000);
            d.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    static class ThreadC extends Thread {
        Lock lock = null;
        Condition condition = null;

        public ThreadC(Lock lock, Condition condition) {
            this.lock = lock;
            this.condition = condition;
        }

        public void run() {

            lock.lock();
            System.out.println("thread C got lock");
            try {
                System.out.println("thread C wait");
                condition.await();
                System.out.println("thread C notified");
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println("thread C released lock");
                lock.unlock();
            }
        }
    }

    static class ThreadD extends Thread {
        Lock lock = null;
        Condition condition = null;

        public ThreadD(Lock lock, Condition condition) {
            this.lock = lock;
            this.condition = condition;
        }

        public void run() {

            boolean isInterrupted = false;
            try {
                lock.lockInterruptibly();
            } catch (InterruptedException e) {
                System.out.println("thread D got interrupted");
                isInterrupted = true;
                e.printStackTrace();
            }
            if (!isInterrupted) {
                System.out.println("thread D got lock");
                try {
                    Thread.sleep(2000);
                    System.out.println("thread D signal");
                    //System.out.println("thread D signal - 2s");
                    condition.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    System.out.println("thread D released lock");
                    lock.unlock();
                }
            }
        }
    }
}
