package cn.edu.bjfu.algorithm;

/**
 * @author chaos
 * @date 2021-12-29 14:54
 * <a href="https://leetcode-cn.com/problems/jian-sheng-zi-ii-lcof/">剪绳子ii</a>
 * <p>
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m段（m、n都是整数，n>1并且m>1），
 * 每段绳子的长度记为 k[0],k[1]...k[m - 1] 。请问 k[0]*k[1]*...*k[m - 1] 可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 * </p>
 */
public class Offer14ii {

    public int cuttingRope(int n) {
        // 结果取模
        int p = 1000000007;
        if (n <= 3) {
            return n - 1;
        }
        // 将绳子剪成数个3位单位的段数，surplus表示不足3的剩余部分
        int surplus = n % 3;
        // 共多少个长度为3的段数，减1为了处理和最后剩余的部分
        int seg = n / 3 - 1;
        long ans = 1;
        long temp = 3;
        // 利用快速幂求3的seg次幂
        for (int i = seg; i > 0; i >>= 1) {
            if ((i & 1) == 1) {
                ans = (ans * temp) % p;
            }
            temp = (temp * temp) % p;
        }
        // 如果没有剩余，则返回结果 * 3，因为保留了一段
        if (surplus == 0) {
            return (int) (ans * 3 % p);
        }
        // 余1的话3 * 1 < 2 * 2, 所以 * 4
        if (surplus == 1) {
            return (int) (ans * 4 % p);
        }
        // 余2就是 3 * 2最大
        return (int) (ans * 6 % p);
    }
}
