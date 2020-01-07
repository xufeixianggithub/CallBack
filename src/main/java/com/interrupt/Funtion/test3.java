package com.interrupt.Funtion;

import java.util.ArrayList;
import java.util.List;

public class test3 {
    public static void main(String[] args) {
        List<?>[] lsa = new ArrayList[10]; // Not really allowed.
        Object o = lsa;
        Object[] oa = (Object[]) o;
        List<Integer> li = new ArrayList<Integer>();
        li.add(new Integer(3));
        oa[1] = li; // Unsound, but passes run time store check
        String s = (String) lsa[1].get(0); // Run-time error: ClassCastException.
    }
}
