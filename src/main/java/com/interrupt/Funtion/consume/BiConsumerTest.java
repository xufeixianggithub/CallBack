package com.interrupt.Funtion.consume;

import java.util.function.BiConsumer;

public class BiConsumerTest {
    public static void main(String[] args) {
       /* StringBuilder s=new StringBuilder("");
        BiConsumer<String,String> biConsumer=(str1,str2)->{s.append(str1).append(str2);};
        biConsumer.accept("11","22");
        System.out.println(s.toString());*/
        test2();
    }
    public static void test2(){
        StringBuilder s=new StringBuilder("");

        BiConsumer<String,String> biConsumer=(str1,str2)->{s.append(str1).append(str2);};

        biConsumer.andThen(((s1, s2) -> System.out.println(s))).accept("11","22");
    }
}
