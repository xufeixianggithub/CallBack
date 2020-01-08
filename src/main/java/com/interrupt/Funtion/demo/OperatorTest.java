package com.interrupt.Funtion.demo;

import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public class OperatorTest {
    public static void main(String[] args) {
        test2();
    }

    public static void test1(){
        UnaryOperator<Integer> unaryOperator=(a)->a*a;
        Integer b=unaryOperator.apply(2);
        System.out.println(b);
    }

    public static void test2(){
        BinaryOperator<Integer> binaryOperator=(a, b)->a*b;
        Integer b=binaryOperator.apply(2,3);
        System.out.println(b);
    }
}
