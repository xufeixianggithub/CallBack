package com.interrupt.test6;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

import static java.lang.Thread.sleep;

public class test6 {
    public static void main(String[] args) throws InterruptedException {
        /*FutureTask futureTask = new FutureTask<String>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                for(int i=0;i<=10000;i++){
                    // 10ms完全可以打印10000个数字
                    Thread.sleep(1);
                    System.out.println(i);
                }
                return null;
            }
        });*/

       /* MyThread t=new MyThread();
        t.start();
        sleep(1000);
        t.interrupt();*/

        MyRunable task=new MyRunable();
        //new Thread(task).start();

        //futureTask.cancel(true);

    }
}
