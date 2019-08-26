package com.test;

/**
 * @author ：fei
 * @date ：Created in 2019/8/26 0026 14:43
 */
public class MyTest8 {
    public static void main(String[] args) {
        System.out.println(FinalTest.x);
    }
}

class FinalTest {
    public static int x = 3;
    static {
        System.out.println("FinalTest static block");
    }
}