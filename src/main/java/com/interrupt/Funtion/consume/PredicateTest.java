package com.interrupt.Funtion.consume;

import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class PredicateTest {
    public static void main(String[] args) {
        test4();
    }
    static void test1(){
        Predicate<Integer> predicate1=(a)->a==3;
        System.out.println(predicate1.test(2));
    }
    static void test2(){
        Predicate<Integer> predicate1=(a)->a==3;
        Predicate<Integer> predicate2=(a)->a==4;
        boolean falg=predicate1.and(predicate2).test(5);
        System.out.println(falg);
    }

    static void test3(){
        Predicate<Integer> predicate=(a)->a.equals(2);
        predicate=predicate.negate();
        System.out.println(predicate.test(2));
    }

    static void test4(){
        BiPredicate<Integer,Integer> biPredicate=(a,b)->a>b;
        System.out.println(biPredicate.test(2,3));
    }
}
