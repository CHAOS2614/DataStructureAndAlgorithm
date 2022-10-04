package cn.edu.bjfu.pattern.introduction.duck;

import cn.edu.bjfu.pattern.introduction.behavior.FlyBehavior;
import cn.edu.bjfu.pattern.introduction.behavior.QuackBehavior;

/**
 * @author chaos
 * @date 2022-09-20 20:08
 */
public abstract class Duck {
    private FlyBehavior flyBehavior;

    public FlyBehavior getFlyBehavior() {
        return flyBehavior;
    }

    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    public QuackBehavior getQuackBehavior() {
        return quackBehavior;
    }

    public void setQuackBehavior(QuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }

    private QuackBehavior quackBehavior;

    public abstract void display();

    public void fly() {
        flyBehavior.fly();
    }

    public void quack() {
        quackBehavior.quack();
    }

    public void swim() {
        System.out.println("所有的鸭子都会游泳！");
    }

}
