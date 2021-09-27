package cn.edu.bjfu.leetcode.sep;

import java.lang.reflect.Method;

/**
 * @author chaos
 * @date 2021-09-23 9:03
 */
public class Day23 {


}


class Animal {
    public void move() {
        System.out.println("动物可以移动");
    }
}

class Dog extends Animal {
    @Override
    public void move() {
        System.out.println("狗可以跑和走");
    }

    public void bark() {
        System.out.println("狗可以吠叫");
    }
}

class TestDog {
    public static void main(String[] args) {
        Animal a = new Animal();
        Animal b = new Dog();
        a.move();
        b.move();
        // b.bark();
        Object o = new Object();
        String s = new String();
        Integer l1 = 1;
        Long l2 = new Long( 1L);
        System.out.println(1 == 1L);
    }
}

