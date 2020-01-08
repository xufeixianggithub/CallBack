package com.interrupt.Funtion.demo;

import java.util.function.Supplier;

public class SupplierTest {
    public static void main(String[] args) {
        test1();
    }

    static void test1(){
        Supplier<Integer> s=()->5;
        System.out.println(s.get());
    }


}
