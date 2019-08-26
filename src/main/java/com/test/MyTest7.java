package com.test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author ：fei
 * @date ：Created in 2019/8/26 0026 14:36
 */
public class MyTest7 {
    public static void main(String[] args) throws Exception {
        Class<?> clazz = Class.forName("java.lang.String");
        System.out.println(clazz.getClassLoader());
        Class<?> clazz1 = Class.forName("com.test.C");
        System.out.println(clazz1.getClassLoader());
    }
}
class C {

}