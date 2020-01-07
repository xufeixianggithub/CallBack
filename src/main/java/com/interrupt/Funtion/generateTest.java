package com.interrupt.Funtion;

import sun.rmi.runtime.Log;

public class generateTest {

   static class generate<T,D>{
        private T t;
        private D d;

        public T getT() {
            return t;
        }

        public generate<T, D> setT(T t) {
            this.t = t;
            return this;
        }

        public D getD() {
            return d;
        }

        public generate<T, D> setD(D d) {
            this.d = d;
            return this;
        }

        private <T,K> T say(Box<T> tBox){
            T t=tBox.get();
            System.out.println(t.toString());
            return t;
        }

        public void showKeyValue1(Box<? extends Number> obj){
            System.out.println("泛型测试"+"key value is " + obj.get());
        }
    }

    public static void main(String[] args) {
        generate<Integer,Integer> g=new generate<Integer,Integer>();
    }
}
