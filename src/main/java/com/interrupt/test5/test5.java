package com.interrupt.test5;

public class test5 {
    public static void main(String[] args) {
        testRetry();
    }
    public static void testRetry() {
        int i = 0;
        retry:  //①
        while (true) {
            i++;
            System.out.println("i=" + i);
            int j = 0;
            //retry:   //②
            for (; ; ) {
                j++;
                System.out.println("j=" + j);
                if (j == 2) {
                    break retry;
                }
            }
        }
        System.out.println("for-end");
    }
}
