package com.interrupt.test4;

import java.util.concurrent.*;

public class FutureTaskCancleTest {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        FutureTask futureTask = new FutureTask<String>(new Callable<String>() {
            @Override
            public String call() throws Exception {

                System.out.println(1231231);
               /* for(int i=0;i<=10000;i++){
                    // 10ms完全可以打印10000个数字
                    Thread.sleep(1);
                    System.out.println(i);
                }*/
                return "123";
            }
        }){
              @Override
              protected void done() {
                System.out.println("done1111");
                int i=1/0;
                System.out.println("done2222");
            }
        };
        executor.execute(futureTask);
        System.out.println("futureTask start");
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //futureTask.cancel(true);
        try {
            System.out.println("futureTaskResult"+futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("futureTask cancel");
        executor.shutdown();
    }
}
