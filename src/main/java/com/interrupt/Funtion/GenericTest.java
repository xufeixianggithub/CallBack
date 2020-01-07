package com.interrupt.Funtion;

import java.util.ArrayList;
import java.util.List;

public class GenericTest {
     
    public static void main(String[] args) {
        List<String> name = new ArrayList<String>();
        List<Integer> age = new ArrayList<Integer>();
        List<Number> number = new ArrayList<Number>();
        
        name.add("icon");
        age.add(18);
        number.add(314);
        //List<? extends Number> data=name;
        //getUperNumber(name);//1
        //getUperNumber(age);//2
        //getUperNumber(number);//3

        List<? extends Number> data=number;
       
   }
 
   public static void getData(List<?> data) {
      System.out.println("data :" + data.get(0));
   }
   
   public static void getUperNumber(List<? extends Number> data) {
          System.out.println("data :" + data.get(0));
       }
}