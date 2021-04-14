package cn.edu.bjfu.leetcode.april;

/**
 * @author Chaos
 * @date 2021/4/14
 */
public class Day14 {

    /**
     * <a href="https://leetcode-cn.com/problems/sum-of-all-odd-length-subarrays/">
     * 给你一个正整数数组arr，请你计算所有可能的奇数长度子数组的和。
     * 子数组 定义为原数组中的一个连续子序列。
     * 请你返回 arr中 所有奇数长度子数组的和 。</a>
     *
     * 0个算偶数次
     */
    public int sumOddLengthSubarrays(int[] arr) {
        int len = arr.length, res = 0;
        for(int i = 0; i < len; i ++){
            int leftOdd = (i+1)/2, leftEven = i/2+1;
            int rightOdd = (len-i)/2, rightEven = (len-1-i)/2+1;
            res += arr[i]*(leftOdd*rightOdd + leftEven*rightEven);
        }
        return res;
    }
}
