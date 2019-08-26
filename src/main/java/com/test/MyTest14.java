package com.test;

import java.net.URL;

/**
 * @author ：fei
 * @date ：Created in 2019/8/26 0026 16:16
 */
public class MyTest14 {
    public static void main(String[] args) {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        URL resource = classLoader.getResource("com/test/MyTest14.class");
        System.out.println(resource);
        Class<?> clazz = int.class;
        System.out.println(clazz.getClassLoader());
    }
}
