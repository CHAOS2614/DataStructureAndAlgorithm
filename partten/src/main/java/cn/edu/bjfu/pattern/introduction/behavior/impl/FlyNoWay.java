package cn.edu.bjfu.pattern.introduction.behavior.impl;

import cn.edu.bjfu.pattern.introduction.behavior.FlyBehavior;

/**
 * @author chaos
 * @date 2022-09-20 20:10
 */
public class FlyNoWay implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("我不会飞!");
    }
}
