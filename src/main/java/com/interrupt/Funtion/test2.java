package com.interrupt.Funtion;

import java.util.ArrayList;
import java.util.List;

public class test2 {

    public static <T> T genericMethod(Class<T> tClass)throws InstantiationException ,
            IllegalAccessException{
        T instance = tClass.newInstance();
        return instance;
    }

    public static void main(String[] args) throws Exception{
        List<String> list1 =new ArrayList();
        List<String>[] list =new ArrayList[10];
        test2 t2=test2.genericMethod(test2.class);
        t2.say();
    }

    private void say(){
        System.out.println(11);
    }
}
