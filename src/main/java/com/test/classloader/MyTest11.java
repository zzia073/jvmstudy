package com.test.classloader;

/**
 * @author ：fei
 * @date ：Created in 2019/8/26 0026 15:03
 */
public class MyTest11 {
    public static void main(String[] args) {
        System.out.println(Child3.a);
        System.out.println("----------");
        Child3.doSomething();
    }
}
class Parent3 {
    static int a = 3;
    static {
        System.out.println("Parent3 static block");
    }
    static void doSomething(){
        System.out.println("doSomething");
    }

}
class Child3 extends Parent3 {
    static {
        System.out.println("Child3 static block");
    }
}
