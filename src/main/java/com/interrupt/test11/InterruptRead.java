package com.interrupt.test11;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class InterruptRead extends InterruptSupport{

    private FileInputStream in;

    @Override
    public void bussiness() {
        /*File file = new File("/dev/urandom"); // 读取linux黑洞，永远读不完
        try {
            in = new FileInputStream(file);
            byte[] bytes = new byte[1024];
            while (in.read(bytes, 0, 1024) > 0) {
                // Thread.sleep(100);
                // if (Thread.interrupted()) {// 以前的Interrupt检查方式
                // throw new InterruptedException("");
                // }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }*/

        while (!Thread.currentThread().isInterrupted()){
            System.out.println("。。。");
        }

    }

    public FileInputStream getIn() {
        return in;
    }

    @Override
    public void interrupt(Thread thread) {
            //in.getChannel().close();
            System.out.println("执行子类中断");
            System.out.println("InterruptedStatus:"+thread.isInterrupted());
            System.out.println("InterruptedStatus:"+thread.isInterrupted());
    }

    public static void main(String[] args) {
        final InterruptRead test = new InterruptRead();
        Thread t = new Thread() {

            @Override
            public void run() {
                long start = System.currentTimeMillis();
                try {
                    System.out.println("InterruptRead start!");
                    test.execute();
                } catch (InterruptedException e) {
                    System.out.println("InterruptRead end! cost time : " + (System.currentTimeMillis() - start));
                    e.printStackTrace();
                }
            }
        };
        t.start();
        // 先让Read执行3秒
        try {
            Thread.sleep(1000);
        }catch (Exception e){
            e.printStackTrace();
        }
        // 发出interrupt中断
        t.interrupt();
    }
}
