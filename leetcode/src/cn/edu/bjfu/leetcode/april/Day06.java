package cn.edu.bjfu.leetcode.april;

/**
 * @author Chaos
 * @date 2021/4/6
 *
 * <a href="https://leetcode-cn.com/problems/running-sum-of-1d-array/">给你一个数组 nums 。数组「动态和」的计算公式为：runningSum[i] = sum(nums[0]…nums[i])。
 * 请返回 nums 的动态和。</a>
 */
public class Day06 {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        int[] runningSum = runningSum(nums);
        for (int i : runningSum) {
            System.out.println(i);
        }
    }

    public static int[] runningSum(int[] nums){
        int n = nums.length;

        int[] runningSum = new int[n];
        runningSum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            runningSum[i] = runningSum[i-1] + nums[i];
        }

        return runningSum;
    }

}