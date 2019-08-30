package com.test.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author ：fei
 * @date ：Created in 2019/8/30 0030 10:22
 */
public class StudentProxy implements InvocationHandler {
    private Object obj;
    private String name;
    public StudentProxy(Object obj) {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getDeclaringClass().equals(Study.class)){
            System.out.println(name + "替你写过了 ~ ~ ~");
        }
        if (method.getDeclaringClass().equals(Play.class)){
            System.out.println(name + "允许你去玩耍 ~ ~ ~");
        }
        method.invoke(obj,args);
        if (method.getDeclaringClass().equals(Study.class)){
            System.out.println(name + "替你交作业 ！！！");
        }
        if (method.getDeclaringClass().equals(Play.class)){
            System.out.println("玩过了向" + name + "报告");
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
