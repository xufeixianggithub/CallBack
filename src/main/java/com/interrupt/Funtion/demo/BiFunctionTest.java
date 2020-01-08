package com.interrupt.Funtion.demo;

import java.util.function.BiFunction;
import java.util.function.Function;

public class BiFunctionTest {
    public static void main(String[] args) {
        test2();
    }

    static void test1(){
        BiFunction<Integer,Integer,String> biFunction=(a,b)->String.valueOf(a+b);
        System.out.println(biFunction.apply(1,2));
    }

    static void test2(){

        BiFunction<Integer,Integer,String> biFunction=(a,b)->String.valueOf(a+b);

        Function<String,Integer> biFunction2=(c)->Integer.valueOf(c)+5;

        Integer aa=biFunction.andThen(biFunction2).apply(1,2);

        System.out.println(aa);

    }
}
