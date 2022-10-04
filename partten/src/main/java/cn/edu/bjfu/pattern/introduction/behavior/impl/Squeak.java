package cn.edu.bjfu.pattern.introduction.behavior.impl;

import cn.edu.bjfu.pattern.introduction.behavior.QuackBehavior;

/**
 * @author chaos
 * @date 2022-09-20 20:13
 */
public class Squeak implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("Squeak");
    }
}
