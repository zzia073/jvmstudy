package com.test.classloader;

import java.util.Random;

/**
 * @author ：fei
 * @date ：Created in 2019/8/26 0026 09:50
 * 当一个接口在初始化时，并不要求其父接口都完成了初始化
 * 只有在真正使用到父接口的时候（如引用接口中所定义的常量时），才会初始化
 */
public class MyTest5 {
    public static void main(String[] args) throws Exception {
        System.out.println(MyChild5.b);
    }
}
interface MyParent5 {
    //间接引用时是常量不会导致初始化
    public static final int a = 5;
    //间接引用导致初始化
    public static final int m = new Random().nextInt();
    public static final Thread t = new Thread(){
        {
            System.out.println("Myparent5 init");
        }
    };
}
interface MyChild5 extends MyParent5 {
    public static final int b = new Random().nextInt();
}
class Myparent5C implements MyChild5 {
    public static int c = 1;
}