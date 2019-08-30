package com.test.dynamicproxy;

/**
 * @author ：fei
 * @date ：Created in 2019/8/30 0030 10:20
 */
public class Student implements Study, Play {
    @Override
    public void writeHomeWork() {
        System.out.println("自己写作业");
    }

    @Override
    public void playGame() {
        System.out.println("自己玩游戏");
    }
}
