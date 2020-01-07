package com.interrupt.Funtion;

public class ClassOuter {
    private int noStaticInt = 1;
    private static int STATIC_INT = 2;

    public void fun() {
        System.out.println("外部类方法");
    }
    
    public void testFunctionClass(int a){
        class FunctionClass{
            private void fun(){
                System.out.println("局部内部类的输出");
                System.out.println(STATIC_INT);
                System.out.println(noStaticInt);
                System.out.println(a);
                //System.out.println(params);
                //params ++ ; // params 不可变所以这句话编译错误
            }
        }
        FunctionClass functionClass = new FunctionClass();
        functionClass.fun();
    }

    public static void main(String[] args) {
        ClassOuter c=new ClassOuter();
        c.testFunctionClass(3);
    }
}
