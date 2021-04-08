package cn.edu.bjfu.leetcode.april;

import org.junit.Test;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.stream.IntStream;

/**
 * @author Chaos
 * @date 2021/4/8
 */
public class Day08 {

    /**
     * <a href="https://leetcode-cn.com/problems/richest-customer-wealth/">
     * 给你一个 m * n 的整数网格 accounts ，其中 accounts[i][j] 是第 i 位客户在第 j 家银行托管的资产数量。
     * 返回最富有客户所拥有的资产总量。
     * 客户的资产总量就是他们在各家银行托管的资产数量之和。最富有客户就是 资产总量 最大的客户。
     * </a>
     */
    @Test
    public void maximumWealthTest() {
        int[][] accounts = {{1, 2, 3}, {3, 2, 1}};
        System.out.println(maximumWealth(accounts));
    }

    public int maximumWealth(int[][] accounts) {

        // 在力扣上运行时间太长了是因为流的问题吗？
        // return Arrays.stream(accounts).mapToInt(account -> Arrays.stream(account).sum()).max().orElse(0);

        int max = 0;
        for (int[] account : accounts) {
            int sum = 0;
            for (int i : account) {
                sum += i;
            }
            max = Math.max(sum, max);
        }
        return max;
    }


}
