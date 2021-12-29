package cn.edu.bjfu.algorithm;

import org.testng.annotations.Test;

/**
 * @author chaos
 * @date 2021-12-29 14:21
 * <a href="https://leetcode-cn.com/problems/jian-sheng-zi-lcof/">剪绳子i</a>
 * <p>
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m段（m、n都是整数，n>1并且m>1），
 * 每段绳子的长度记为 k[0],k[1]...k[m - 1] 。请问 k[0]*k[1]*...*k[m - 1] 可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 * </p>
 */
public class Offer14i {

    public int cuttingRope(int n) {

        // dp[i]代表长度为i的绳子剪了之后最大乘积
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 1;
        // 从长度3开始到长度n的绳子剪了之后最大乘积
        for (int i = 3; i <= n; i++) {
            // 先剪一段长度为j的一段，剩下的部分可以剪也可以不剪
            // 不剪的话乘积就是 j * (i - j),
            // 剪的话直接用乘积最大的结果也就是dp[i - j]就好了
            for (int j = 1; j <= (i >> 1); j++) {
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }
        return dp[n];
    }

    @Test
    public void cuttingRopeTest() {
        System.out.println(cuttingRope(10));
    }
}
