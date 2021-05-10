package cn.edu.bjfu.leetcode.may;

/**
 * @author Chaos
 * @date 2021/5/10
 */
public class Day10 {

    /**
     * <a href="https://leetcode-cn.com/problems/maximum-lcci/">
     * 编写一个方法，找出两个数字a和b中最大的那一个。不得使用if-else或其他比较运算符。</a>
     */
    public int maximum(int a, int b) {
        return (a + b + Math.abs(a - b)) / 2;
    }
}
