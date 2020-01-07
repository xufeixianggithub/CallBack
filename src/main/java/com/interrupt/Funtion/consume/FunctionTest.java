package com.interrupt.Funtion.consume;

import java.util.function.Function;

public class FunctionTest {
    public static void main(String[] args) {
        test3();
    }
    static void test1(){
        Function<Integer,String> f=(a)-> a.toString();
        System.out.println(f.apply(2));
    }
    static void test2(){
        Function<Integer,String> f=(a)-> a.toString();
        Function<String,Integer>f2=(b)->Integer.parseInt(b);
        Integer c=f.andThen(f2).apply(2);
        System.out.println(c);
    }

    static void test3(){
        Function<Integer,Integer> f=(a)-> a*a;
        Function<Integer,Integer> f2=(b)-> b+b;
        System.out.println( f.andThen(f2).apply(3));
        System.out.println( f.compose(f2).apply(3));
    }

}
