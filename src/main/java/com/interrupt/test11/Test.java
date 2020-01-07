package com.interrupt.test11;

import java.util.concurrent.locks.LockSupport;

public class Test {
    public static void main(String[] args) throws Exception{
        MyThread t=new MyThread();
        t.start();
        Thread.sleep(1000);
        t.interrupt();
        System.out.println("主线程中断完成");
    }
}
