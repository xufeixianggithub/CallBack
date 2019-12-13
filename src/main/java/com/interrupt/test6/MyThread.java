package com.interrupt.test6;

public class MyThread extends Thread{
    @Override
    public void run(){
        int i=0;
        while (true){
            i++;
            System.out.println(i);
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }

    }
}
