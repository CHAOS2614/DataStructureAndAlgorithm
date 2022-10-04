package cn.edu.bjfu.pattern.introduction.behavior.impl;

import cn.edu.bjfu.pattern.introduction.behavior.FlyBehavior;

/**
 * @author chaos
 * @date 2022-09-20 20:09
 */
public class FlyWithWings implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("使用翅膀飞行!");
    }
}
