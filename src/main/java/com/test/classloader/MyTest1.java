package com.test.classloader;

/**
 * @author ：fei
 * @date ：Created in 2019/8/23 0023 11:22
 * 对于静态字段来说，只有直接定义了该字段的类才会被初始化；
 * 当一个类在初始化时，要求祈福类全部都已初始化完毕了
 * -XX:+TraceClassLoading,用于追踪类的加载信息并打印出来
 * jvm参数都是以-XX:开始，+和-表示boolean值因为jvm参数有默认开启或关闭所以需要+或-去开启或关闭对应参数
 * -XX:+<option>，表示开启option选项
 * -XX:-<option>，表示关闭option选项
 * -XX:<option>=<value>，表示将option选项的值设置为value，比如设置堆大小
 */
public class MyTest1 {
    public static void main(String[] args) {
        //此句未使用MyChild1类的任何信息，故MyChild1类并未初始化
        System.out.println(MyChild1.parent1);
        //此时MyChild1被主动使用初始化该类，初始化过程只有一次MyParent1不会再次打印
        System.out.println(MyChild1.child1);
    }
}
class MyParent1{
    public static String parent1 = "parent1";
    static {
        System.out.println("MyParent1");
    }
}
class MyChild1 extends MyParent1{
    public static String child1 = "child1";
    static {
        System.out.println("MyChild1");
    }
}
