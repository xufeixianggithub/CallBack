package com.interrupt.test2;

public class Interrupt  {
	public static void main(String[] args) throws Exception {
		Thread t = new Thread(new Worker());
		t.start();
		
		Thread.sleep(200);
		t.interrupt();
		
		System.out.println("Main thread stopped.");
	}
	
	public static class Worker implements Runnable {
		public void run() {
			System.out.println("Worker started.");
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				Thread curr = Thread.currentThread();
				//再次调用interrupt方法中断自己，将中断状态设置为“中断”
				curr.interrupt();//status: true
				System.out.println("Worker IsInterrupted: " + curr.isInterrupted());//status: true
				System.out.println("Worker IsInterrupted: " + curr.isInterrupted());//status: true
				System.out.println("Static Call: " + Thread.interrupted());//1.clear status 2.return true
				System.out.println("---------After Interrupt Status Cleared----------");
				System.out.println("Static Call: " + Thread.interrupted());//return false
				System.out.println("Worker IsInterrupted: " + curr.isInterrupted());//return false
				System.out.println("Worker IsInterrupted: " + curr.isInterrupted());//return false
			}
			
			System.out.println("Worker stopped.");
		}
	}
}
