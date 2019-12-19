package com.interrupt.test9;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;

public class Test implements Runnable{
    //private static ExecutorService es =Demo1.newCachedThreadPool();
    private static ExecutorService es =Demo1.newDefineThreadPool(1,10,20,new ArrayBlockingQueue<Runnable>(90));
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            int i=5/0;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) throws Exception {
        Demo1 demo=(Demo1)es;
        demo.setCorePoolSize(2);
        for (int i = 0; i < 100; i++) {
            es.execute(new Test());
        }
        es.shutdown();
    }
}