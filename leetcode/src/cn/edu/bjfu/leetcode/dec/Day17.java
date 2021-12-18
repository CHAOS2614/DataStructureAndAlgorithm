package cn.edu.bjfu.leetcode.dec;

import org.junit.Test;

/**
 * @author chaos
 * @date 2021-12-17 14:59
 */
public class Day17 {

    /**
     * <a href="https://leetcode-cn.com/problems/water-bottles/">换酒问题</a>
     * <p>
     * 小区便利店正在促销，用 numExchange 个空酒瓶可以兑换一瓶新酒。你购入了 numBottles 瓶酒。
     * 如果喝掉了酒瓶中的酒，那么酒瓶就会变成空的。
     * 请你计算 最多 能喝到多少瓶酒。
     * </p>
     */
    public int numWaterBottles(int numBottles, int numExchange) {
        int res = numBottles;
        while (numBottles >= numExchange) {
            res += numBottles / numExchange;
            numBottles = numBottles / numExchange + numBottles % numExchange;
        }
        return res;
    }

    @Test
    public void numWaterBottlesTest() {
        System.out.println(numWaterBottles(15, 4));
    }
}
