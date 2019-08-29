package com.test.classloader;

import sun.misc.Launcher;

/**
 * @author ：fei
 * @date ：Created in 2019/8/27 0027 13:54
 */
public class MyTest23 {
    public static void main(String[] args) {
        System.out.println(System.getProperty("sun.boot.class.path"));
        System.out.println(System.getProperty("java.ext.dirs"));
        System.out.println(System.getProperty("java.class.path"));
        /*
            内建于JVM中的启动类加载器会加载java.lang.ClassLoader以及其他的Java平台类，
            当JVM启动时，一块特殊的机器码会运行，它会加载扩展类加载器与系统类加载器，
            这块特殊的机器码叫做启动类加载器（Bootstrap）。

            启动类加载器并不是Java类，而其他的加载器则都是java类，
            启动类加载器是特定于平台的就差指令，它负责开启整个加载过程。
            所有类加载器（除了启动类加载器）都被实现为Java类。不过，总归要有一个组件来加载第一个Java类加载器，从而整个加载过程能够顺利
            进行下去，加载第一个纯Java类加载器就是启动类加载器的职责。

            启动类加载器还会负责加载供JRE正常运行所需要的基本组件，这包括java.util与java.lang包中的类等等。
         */
        System.out.println(ClassLoader.class.getClassLoader());
        System.out.println(Launcher.class.getClassLoader());
    }
}
