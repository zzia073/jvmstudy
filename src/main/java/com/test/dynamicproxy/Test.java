package com.test.dynamicproxy;

import java.lang.reflect.Proxy;

/**
 * @author ：fei
 * @date ：Created in 2019/8/30 0030 10:25
 */
public class Test {
    public static void main(String[] args) {
        System.setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles","true");
        StudentProxy studentProxy = new StudentProxy(new Student());
        studentProxy.setName("小明");
        Study o = (Study) Proxy.newProxyInstance(Student.class.getClassLoader(), Student.class.getInterfaces(), studentProxy);
        o.writeHomeWork();
        Play o1 = (Play) Proxy.newProxyInstance(Student.class.getClassLoader(), Student.class.getInterfaces(), studentProxy);
        o1.playGame();
    }
}
