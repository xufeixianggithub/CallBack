package com.interrupt.test10;

public class father implements grandFatherInterface{
    @Override
    public void getGrandFather() {
        System.out.println("get father");
    }

    public void getGrandMother() {
        System.out.println("get mother");
    }
}
