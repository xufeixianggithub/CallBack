package com.interrupt.test7;

public class test7 {
    public static void main(String[] args) {
        //片段1
      /*new Thread(new Runnable() {
          @Override
          public void run() {
                             System.out.println("Run of Runnable");
                         }})


        {
          public void run() {
                             System.out.println("Run of Thread");
                         }
         }.start();*/

        //片段2
      /*  new Thread(new Runnable() {
      @Override
      public void run() {
                         System.out.println("Run of Runnable");
                     }
       }) {
          public void run() {
                             System.out.println("Run of Thread");
                             super.run();
                         }
       }.start();*/



    }
}
