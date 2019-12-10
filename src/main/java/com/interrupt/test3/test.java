package com.interrupt.test3;

public class test {
    public static void main(String[] args) throws Exception{
        TaskTest t=new TaskTest();
        new Thread(t).start();
    }
}
