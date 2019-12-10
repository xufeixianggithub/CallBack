package com.interrupt.test4;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class FutureTaskCancleTest {
    public static void main(String[] args) {
        List<String> list=new ArrayList<>();
        for (String q; (q = "1") != null;) {

        }
        ExecutorService executor = Executors.newSingleThreadExecutor();
        FutureTask futureTask = new FutureTask<String>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                for(int i=0;i<=10000;i++){
                    // 10ms完全可以打印10000个数字
                    Thread.sleep(1);
                    System.out.println(i);
                }
                return null;
            }
        });
        executor.execute(futureTask);
        System.out.println("futureTask start");
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        futureTask.cancel(true);
        System.out.println("futureTask cancel");
        executor.shutdown();
    }
}
