package com.test;

/**
 * @author ：fei
 * @date ：Created in 2019/8/26 0026 10:11
 *
 */
public class MyTest6 {
    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        System.out.println("counter1:" + Singleton.counter1);
        System.out.println("counter2:" + Singleton.counter2);
    }
}
class Singleton {
    private static Singleton singleton = new Singleton();
    private Singleton(){
        counter1 ++;
        counter2 ++;//准备阶段的意义
    }
    public static int counter1;
    public static int counter2 = 0;
    public static Singleton getInstance(){
        return singleton;
    }
}
