package com.test.bytecode;

/**
 * @author ：fei
 * @date ：Created in 2019/8/29 0029 16:14
 * 字节码是静态的
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
 * 针对于方法调用动态分派的过程，虚拟机会在类的方法区建立一个虚方法表的数据结构（virtual method table，vtable），
 * 针对于invokeinterface指令来说，虚拟机会建立一个叫做接口方法表的数据结构（interface method table，itable）
 *
 * 现代JVM在执行Java代码的时候，通常都会将解释执行与编译执行二者结合起来进行。
 * 所谓解释执行，就是通过解释器来读取字节码，遇到相应的指令就去执行该指令。
 * 所谓编译执行，就是通过即时编译器（Just In Time，JIT）将字节码转换为本地机器码来执行；现代JVM会根据代码热点来生成相应的本地机器码。
 *
 * 基于栈的指令集于基于寄存器的指令集之间的关系：
 * 1.JVM执行指令时所采取的的方式是基于栈的指令集。
 * 2.基于栈的指令集主要的操作有入栈与出栈两种。
 * 3.基于栈的指令集的优势在于它可以在不同平台之间移植，而基于寄存器的指令集是与硬件架构紧密关联的，无法做到可移植。
 * 4.基于栈的指令集的缺点在于完成相同的操作，指令数量通常要比基于寄存器的指令集数量要多；基于栈的指令集是在内存中完成操作的，
 *   而基于寄存器的指令集是直接由CPU来执行的，它是在高速缓冲区中进行执行的，速度要快很多。虽然虚拟机可以采用一些优化手段，但总体来说，
 *   基于栈的指令集的执行速度要慢一些。
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