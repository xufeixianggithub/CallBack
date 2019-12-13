package com.interrupt.test6;

public class MyRunable implements Runnable{
    int i=0;
    @Override
    public void run() {
        while (true){
            i++;
            System.out.println("MyRunable:"+i);
        }
    }
}
