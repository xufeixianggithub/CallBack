package com.interrupt.test12;

import java.util.concurrent.locks.LockSupport;

public class LockSupportTest {
    public static void main(String[] args) {
        int ws=1;
        if(ws>0){
            ws=-1;
        }else{
            System.out.println("00");
        }
    }
}