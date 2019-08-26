package com.test;

/**
 * @author ：fei
 * @date ：Created in 2019/8/26 0026 15:07
 */
public class MyTest12 {
    public static void main(String[] args) throws Exception {
        ClassLoader loader = ClassLoader.getSystemClassLoader();
        Class<?> aClass = loader.loadClass("com.test.CL");
        System.out.println(aClass);

        System.out.println("------------");
        Class<?> aClass1 = Class.forName("com.test.CL");
        System.out.println(aClass1);
    }
}

class CL{
    static {
        System.out.println("CL");
    }
}