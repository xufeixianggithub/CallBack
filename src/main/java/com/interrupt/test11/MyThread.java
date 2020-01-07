package com.interrupt.test11;

import java.util.concurrent.locks.LockSupport;

public class MyThread extends Thread{
    @Override
    public void run(){
        Object obj=new Object();
        Object obj2=new Object();
        LockSupport.park(obj);
        //LockSupport.park(obj);
        System.out.println("wake up1");
        //LockSupport.park(obj);
        LockSupport.park(obj);
        System.out.println("wake up2");
    }
}
