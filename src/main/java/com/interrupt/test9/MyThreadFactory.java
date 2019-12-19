package com.interrupt.test9;

import io.netty.util.concurrent.DefaultThreadFactory;

import java.util.concurrent.ThreadFactory;

public class MyThreadFactory extends DefaultThreadFactory{
    public MyThreadFactory(String MyPool){
        super(MyPool);
    }
    @Override
    public Thread newThread(Runnable r) {
        Thread thread=super.newThread(r);
        thread.setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
        return thread;
    }
}
