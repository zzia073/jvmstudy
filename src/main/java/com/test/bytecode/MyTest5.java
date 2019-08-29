package com.test.bytecode;

/**
 * @author ：fei
 * @date ：Created in 2019/8/29 0029 16:14
 * 方法的静态分派。（重载）
 * Grandpa g1 = new Father();
 * 以上代码，g1的静态类型是Grandpa，而g1的实际类型（真正指向的类型）是Father。
 * 我们可以得出这样一个结论：变量的静态类型是不会发生变化的，而变量的实际类型则是可以发生变化的（多态的一种体现），
 * 实际类型是在运行期方可确定。
 * 方法的动态分派。（重写）
 * 方法的动态分派涉及到一个重要的概念：方法接收者。
 * invokevirtual字节码指令的多态查找流程
 * 从实际的类开始自底向上依次查找，找到则调用
 * 方法重载是静态的，是编译期行为；方法重写是动态的，是运行期行为。
 */
public class MyTest5 {
    /**
     * 方法重载，是一种静态的行为，编译期就可以完全确定。
     */
    public void test(Grandpa grandpa){
        System.out.println("grandpa");
    }
    public void test(Father father){
        System.out.println("father");
    }
    public void test(Son son){
        System.out.println("son");
    }

    public static void main(String[] args) {
        Grandpa g1 = new Father();
        Grandpa g2 = new Son();
        MyTest5 myTest5 = new MyTest5();
        myTest5.test(g1);
        myTest5.test(g2);
    }
}
class Grandpa {

}
class Father extends Grandpa {

}
class Son extends Father {

}