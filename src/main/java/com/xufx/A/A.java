package com.xufx.A;

import com.xufx.B.B;
import com.xufx.Interface.CallBackInterface;

public class A implements CallBackInterface{
    private int c;
    private int d;
    public A(int c,int d){
        this.c=c;
        this.d=d;
    }
    public void CallBackResult(int c,int d,int result) {
        //控制台输出
        System.out.println(c + " + " + d + " = " + result);
    }

    public void calculation(){

        new Thread(
                new Runnable(){
                    public void run() {
                        B b=new B();
                        b.operate(A.this,c,d);
                    }
                }
        ).start();

    }
}
