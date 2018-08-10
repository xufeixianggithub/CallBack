package com.xufx.B;

import com.xufx.Interface.CallBackInterface;

public class B {
    public  void operate(CallBackInterface callBackInterface,int c,int d){

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        callBackInterface.CallBackResult(c,d,c+d);
    }
}
