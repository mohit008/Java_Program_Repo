package com.mohit.program.topic;

/**
 * Created by Mohit Soni on 15-05-2018.
 */
public class DeadLockMaster {

    public DeadLockMaster() {

        // problem
        t1.start();
        s1.start();

        //solution
        t2.start();
        s2.start();
    }

    /**
     * generates dead lock
     */
    static Thread t1 = new Thread(new Runnable() {

        @Override
        public void run() {
            synchronized (String.class) {
                // acquire String waiting for Integer

                System.out.println("Lock1 by String");
                System.out.println("Thread 1: Waiting for lock 2...");
                synchronized (Integer.class) {
                    System.out.println("Lock1 by Integer");
                }
            }
        }
    });
    static Thread s1 = new Thread(new Runnable() {

        @Override
        public void run() {
            synchronized (Integer.class) {
                // acquire Integer waiting for String

                System.out.println("Lock2 by Integer");
                System.out.println("Thread 2: Waiting for lock 1...");
                synchronized (String.class) {
                    System.out.println("Lock2 by String");
                }
            }
        }
    });

    /**
     * solution to dead lock
     */
    static Thread t2 = new Thread(new Runnable() {

        @Override
        public void run() {
            synchronized (String.class) {
                // call by different pattern

                System.out.println("Lock1 by String");
                System.out.println("Thread 1: Waiting for lock 2...");
                synchronized (Integer.class) {
                    System.out.println("Lock1 by Integer");
                }
            }
        }
    });
    static Thread s2 = new Thread(new Runnable() {

        @Override
        public void run() {
            synchronized (String.class) {
                System.out.println("Lock2 by Integer");
                System.out.println("Thread 2: Waiting for lock 1...");
                synchronized (Integer.class) {
                    System.out.println("Lock2 by String");
                }
            }
        }
    });
}
