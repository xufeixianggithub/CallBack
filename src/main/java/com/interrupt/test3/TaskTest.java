package com.interrupt.test3;

public class TaskTest implements Runnable{

        @Override
        public void run() {
            try{
                System.out.println(11);
                wait();
                System.out.println(22);
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }