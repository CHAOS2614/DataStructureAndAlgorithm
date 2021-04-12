package cn.edu.bjfu.leetcode.april;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author Chaos
 * @date 2021/4/12
 */
public class Day12 {

    /**
     * <a href="https://leetcode-cn.com/problems/minimum-time-visiting-all-points/">
     * 平面上有n个点，点的位置用整数坐标表示 points[i] = [xi, yi] 。请你计算访问所有这些点需要的 最小时间（以秒为单位）。
     * 你需要按照下面的规则在平面上移动：
     * 每一秒内，你可以：
     * 沿水平方向移动一个单位长度，或者
     * 沿竖直方向移动一个单位长度，或者
     * 跨过对角线移动 sqrt(2) 个单位长度（可以看作在一秒内向水平和竖直方向各移动一个单位长度）。
     * 必须按照数组中出现的顺序来访问这些点。
     * 在访问某个点时，可以经过该点后面出现的点，但经过的那些点不算作有效访问。</a>
     */
    @Test
    public void minTimeToVisitAllPointsTest() {
        int[][] points = {{1, 1}, {3, 4}, {-1, 0}};
        System.out.println(minTimeToVisitAllPoints(points));
    }

    public int minTimeToVisitAllPoints(int[][] points) {
        int ans = 0;
        for (int i = 1; i < points.length; i++) {
            ans += Math.max(Math.abs(points[i][0] - points[i - 1][0]), Math.abs(points[i][1] - points[i - 1][1]));
        }
        return ans;
    }


    /**
     * <a href="https://leetcode-cn.com/problems/check-if-two-string-arrays-are-equivalent/">
     * 给你两个字符串数组 word1 和 word2 。如果两个数组表示的字符串相同，返回 true ；否则，返回 false 。
     * 数组表示的字符串是由数组中的所有元素 按顺序 连接形成的字符串。</a>
     *
     * <a href="https://blog.csdn.net/weixin_45009941/article/details/96443500">
     * 1.线程安全上
     * StringBuffer：用于解决大量拼接时产生很多中间对象问题而提供的一个类，是线程安全的.但StringBuilder不是线程安全的.
     * 2.使用的情况
     * 1.在字符串不经常发生的变化的业务场景优先使用String
     * 2.在单线程下,比如有大量的字符创操作的情况下,应该使用StringBuilder
     * 2.在多线程下,有大量的字符串大的操作的情况下,应该使用StringBuffer
     * 3.运算速度
     * StringBuilder>StringBuffer>String
     * 4.声明后的状态
     * String是final类不能被继承且为字符串常量，
     * 而StringBuffer和StringBuilder均为字符串变量,
     * String对象一旦被创建便不更改,而StringBuilder和StringBuffer是可变的。</a>
     *
     * <a href="https://www.cnblogs.com/wisdo/p/4310938.html">
     * Join(String, IEnumerable<String>)
     * 串联类型为 String 的 IEnumerable<T> 构造集合的成员，其中在每个成员之间使用指定的分隔符。
     * Join<T>(String, IEnumerable<T>)
     * 串联集合的成员，其中在每个成员之间使用指定的分隔符。
     * Join(String, Object[])
     * 串联对象数组的各个元素，其中在每个元素之间使用指定的分隔符。
     * Join(String, String[])
     * 串联字符串数组的所有元素，其中在每个元素之间使用指定的分隔符。
     * Join(String, String[], Int32, Int32)
     * 串联字符串数组的指定元素，其中在每个元素之间使用指定的分隔符。</a>
     */
    @Test
    public void arrayStringsAreEqualTest() {
        String[] word1 = {"ab", "c"}, word2 = {"a", "bc"};
        System.out.println(arrayStringsAreEqual(word1, word2));
        System.out.println(arrayStringsAreEqual2(word1, word2));
    }

    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();
        for (String s : word1) {
            s1.append(s);
        }
        for (String s : word2) {
            s2.append(s);
        }
        return s1.toString().equals(s2.toString());
    }

    public boolean arrayStringsAreEqual2(String[] word1, String[] word2) {
        return String.join("", word1).equals(String.join("", word2));
    }


    /**
     * <a href="https://leetcode-cn.com/problems/largest-number/">
     * 给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
     * 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。</a>
     */
    @Test
    public void largestNumberTest(){

    }

    public String largestNumber(int[] nums) {
        int n = nums.length;
        // 转换成包装类型，以便传入 Comparator 对象（此处为 lambda 表达式）
        Integer[] numsArr = new Integer[n];
        for (int i = 0; i < n; i++) {
            numsArr[i] = nums[i];
        }

        Arrays.sort(numsArr, (x, y) -> {
            long sx = 10, sy = 10;
            while (sx <= x) {
                sx *= 10;
            }
            while (sy <= y) {
                sy *= 10;
            }
            return (int) (-sy * x - y + sx * y + x);
        });

        if (numsArr[0] == 0) {
            return "0";
        }
        StringBuilder ret = new StringBuilder();
        for (int num : numsArr) {
            ret.append(num);
        }
        return ret.toString();
    }


}
