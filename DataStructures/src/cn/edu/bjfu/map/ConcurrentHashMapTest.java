package cn.edu.bjfu.map;

import sun.misc.Unsafe;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author chaos
 * @date 2022-09-04 14:30
 */
public class ConcurrentHashMapTest {
    public static void main(String[] args) {
        System.out.println(ConcurrentHashMapTest.class.getClassLoader());
        System.out.println(String.class.getClassLoader());
        Unsafe unsafe = Unsafe.getUnsafe();
        ConcurrentHashMap concurrentHashMap;
    }
}
