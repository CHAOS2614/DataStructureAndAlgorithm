package cn.edu.bjfu.leetcode.sep;

/**
 * @author chaos
 * @date 2021-09-29 15:36
 */
public class Day29 {


}

class ClassLoadingTest {
    public static void main(String[] args) {
        System.out.println(A.m);
    }
}

class A {
    static int m = 100;

    static {
        m = 300;
    }
}

