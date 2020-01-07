package com.interrupt.test11;

import sun.nio.ch.Interruptible;

abstract class InterruptSupport implements Interruptible {

    private volatile boolean interrupted = false;
    private Interruptible interruptor = new Interruptible() {

        @Override
        public void interrupt(Thread thread) {
            interrupted = true;
            InterruptSupport.this.interrupt(thread); // 位置3
        }
    };

    public final boolean execute() throws InterruptedException {
        try {
            blockedOn(interruptor); // 位置1  
            if (Thread.currentThread().isInterrupted()) { // 立马被interrupted
                interruptor.interrupt(Thread.currentThread());
            }
            // 执行业务代码  
            bussiness();
        } finally {
            blockedOn(null);   // 位置2  
        }

        return interrupted;
    }

    public abstract void bussiness() ;

    //public abstract void interrupt(Thread thread);

    // -- sun.misc.SharedSecrets --  
    static void blockedOn(Interruptible intr) { // package-private
        sun.misc.SharedSecrets.getJavaLangAccess().blockedOn(Thread.currentThread(), intr);
    }
}  