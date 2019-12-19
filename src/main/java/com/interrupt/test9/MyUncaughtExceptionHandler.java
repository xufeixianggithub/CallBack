package com.interrupt.test9;

public class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        //LOGGER.error(t + " throws exception: " + e);
        System.out.println(t + " throws exception: " + e);
    }
}
