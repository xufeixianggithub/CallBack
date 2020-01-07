package com.interrupt.test11;
  
import java.io.File;  
import java.io.FileInputStream;  
import java.lang.reflect.Field;  
import java.util.concurrent.TimeUnit;  
import java.util.concurrent.locks.LockSupport;  
  
public class LockSupportTest {  
  
    private static LockSupportTest blocker = new LockSupportTest();  
  
    public static void main(String args[]) throws Exception {  
        //lockSupportTest();
        parkTest();
        //interruptParkTest();
        //interruptSleepTest();
        //interruptWaitTest();
    }  
  
    /** 
     * LockSupport.park对象后，尝试获取Thread.blocker对象，调用其single唤醒 
     *  
     * @throws Exception 
     */  
    private static void lockSupportTest() throws Exception {  
        Thread t = doTest(new TestCallBack() {  
  
            @Override  
            public void callback() throws Exception {  
                // 尝试sleep 5s  
                System.out.println("blocker");  
                LockSupport.park(blocker);  
                System.out.println("wakeup now!");//执行结果这一句未执行，表明object.notifyAll()不能唤醒LockSupport的阻塞Thread.
            }  
  
            @Override  
            public String getName() {  
                return "lockSupportTest";  
            }  
  
        });  
        t.start(); // 启动读取线程  
  
        Thread.sleep(150);  
        synchronized (blocker) {  
            Field field = Thread.class.getDeclaredField("parkBlocker");  
            field.setAccessible(true);  
            Object fBlocker = field.get(t);  
            System.out.println(blocker == fBlocker);  
            Thread.sleep(100);  
            System.out.println("notifyAll");  
            blocker.notifyAll();  
        }  
    }  
  
    /** 
     * 尝试去中断一个object.wait()，会抛出对应的InterruptedException异常 
     *  
     * @throws InterruptedException 
     */  
    private static void interruptWaitTest() throws InterruptedException {  
        final Object obj = new Object();  
        Thread t = doTest(new TestCallBack() {  
  
            @Override  
            public void callback() throws Exception {  
                // 尝试sleep 5s  
                obj.wait();
                System.out.println("wakeup now!");  
            }  
  
            @Override  
            public String getName() {  
                return "interruptWaitTest";  
            }  
  
        });  
        t.start(); // 启动读取线程  
        Thread.sleep(2000);  
        t.interrupt(); // 检查下在park时，是否响应中断  
    }  
  
    /** 
     * 尝试去中断一个Thread.sleep()，会抛出对应的InterruptedException异常 
     *  
     * @throws InterruptedException 
     */  
    private static void interruptSleepTest() throws InterruptedException {  
        Thread t = doTest(new TestCallBack() {  
  
            @Override  
            public void callback() throws Exception {  
                // 尝试sleep 5s  
                Thread.sleep(5000);  
                System.out.println("wakeup now!");  
            }  
  
            @Override  
            public String getName() {  
                return "interruptSleepTest";  
            }  
  
        });  
        t.start(); // 启动读取线程  
        Thread.sleep(2000);  
        t.interrupt(); // 检查下在park时，是否响应中断  
    }  
  
    /** 
     * 尝试去中断一个LockSupport.park()，会有响应但不会抛出InterruptedException异常 
     *  
     * @throws InterruptedException 
     */  
    private static void interruptParkTest() throws InterruptedException {  
        Thread t = doTest(new TestCallBack() {  
  
            @Override  
            public void callback() {  
                // 尝试去park 自己线程  
                LockSupport.parkNanos(blocker, TimeUnit.SECONDS.toNanos(5));  
                System.out.println("wakeup now!");  
            }  
  
            @Override  
            public String getName() {  
                return "interruptParkTest";  
            }  
  
        });  
        t.start(); // 启动读取线程  
        Thread.sleep(2000);  
        t.interrupt(); // 检查下在park时，是否响应中断  响应中断，会被唤醒,但是不抛出中断异常,不清除中断标置
        //且下次循环重写进入这个点时，无法阻塞了,blocker好像是一次性消耗品
    }  
  
    /** 
     * 尝试去中断一个LockSupport.unPark()，会有响应 
     *  
     * @throws InterruptedException 
     */  
    private static void parkTest() throws InterruptedException {  
        Thread t = doTest(new TestCallBack() {  
  
            @Override  
            public void callback() {  
                // 尝试去park 自己线程  
                LockSupport.park(blocker);
                System.out.println("wakeup now!");  
            }  
  
            @Override  
            public String getName() {  
                return "parkTest";  
            }  
  
        });  
  
        t.start(); // 启动读取线程  
        Thread.sleep(2000);  
        //LockSupport.unpark(t); 使用这一句唤醒,call方法下次一循环执行时会阻塞
        t.interrupt();//使用中断方法，会无限循环，导致下次无法阻塞LockSupport.park(blocker);
        //结论是，t.interrupt()可以中断唤醒LockSupport.park(blocker)阻塞，但是不会抛出中断异常
        //不像Object.wait()方法会抛出中断异常并清除中断标置
        Thread.sleep(2000);
        t.interrupted();
    }  
  
    public static Thread doTest(final TestCallBack call) {  
        return new Thread() {  
  
            @Override  
            public void run() {  
                //File file = new File("/dev/urandom"); // 读取linux黑洞
                try {  
                   /* FileInputStream in = new FileInputStream(file);
                    byte[] bytes = new byte[1024];  */
                    while (true) {
                      /*  if (Thread.interrupted()) {
                            throw new InterruptedException("被中断了");
                        }*/
                        //System.out.println("000");
                        //Thread.sleep(100);
                        long start = System.currentTimeMillis();  
                        call.callback();  
                        System.out.println(call.getName() + " callback finish cost : "  
                                           + (System.currentTimeMillis() - start));  
                    }  
                } catch (Exception e) {  
                    e.printStackTrace();  
                }  
            }  
  
        };  
    }  
}  
  
interface TestCallBack {  
  
    public void callback() throws Exception;  
  
    public String getName();  
}  