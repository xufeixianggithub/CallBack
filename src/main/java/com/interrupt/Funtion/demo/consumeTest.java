package com.interrupt.Funtion.demo;

import java.util.function.Consumer;

public class consumeTest {
    public static void main(String[] args) {
        /*StringBuilder s=new StringBuilder("11");
        Consumer<StringBuilder> consumer=(str)->{str.append("22");};
        consumer.accept(s);
        System.out.println(s.toString());

        Consumer<StringBuilder> consumer1=(str)->{str.append("33");};

        consumer.andThen(consumer1).accept(s);
        System.out.println(s);*/

        StringBuilder sb = new StringBuilder("Hello ");
        Consumer<StringBuilder> consumer = (str) -> str.append("Jack!");
        consumer.accept(sb);
        System.out.println(sb.toString());	// Hello Jack

        Consumer<StringBuilder> consumer1 = (str) -> str.append(" Bob!");
        consumer.andThen(consumer1).accept(sb);
        System.out.println(sb.toString());	// Hello Jack! Bob!

    }
}
