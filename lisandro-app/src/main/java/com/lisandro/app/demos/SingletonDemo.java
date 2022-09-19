package com.lisandro.app.demos;

import com.lisandro.app.classes.SampleSingleton;

public class SingletonDemo {
    
    public static void run() {

        class TestRunnable implements Runnable {
            public SampleSingleton singleton;

            @Override
            public void run() {
                System.out.println("Thread Started");
                try {
                    Thread.sleep(200);
                } catch (Exception e) {
                    System.err.println(e);
                }

                singleton = createSingleton();
                System.out.println("Singleton Instance: " + singleton.hashCode());
            }

            private SampleSingleton createSingleton() {
                return SampleSingleton.getInstance();
            }
        }

        Thread t1 = new Thread(new TestRunnable());
        Thread t2 = new Thread(new TestRunnable());
        Thread t3 = new Thread(new TestRunnable());
        Thread t4 = new Thread(new TestRunnable());

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        try{
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        } catch (InterruptedException e) {
            System.err.println(e);
        }
        

    }
}
