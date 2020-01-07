package com.interrupt.test13;

import java.lang.reflect.Field;

public class ModifyFinalField {
    
    private final static Integer KEY_EXIT = 1024;
    
    private static void invoke() throws Exception{
        ModifyFinalField mff = new ModifyFinalField();
        
        System.out.println("Before modifying : "+mff.KEY_EXIT);//1024
        
        //获取属性【private final java.lang.Integer com.blueStarWei.invoke.ModifyFinalField.KEY_EXIT】
        Field field = mff.getClass().getDeclaredField("KEY_EXIT");
        //忽略属性的访问权限
        field.setAccessible(true);
        //设置新的值
        field.set(mff, 512);
        
        System.out.println("After modifying : "+mff.KEY_EXIT);//512
    }
    
    public static void main(String[] args) {
        try {
            invoke();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}