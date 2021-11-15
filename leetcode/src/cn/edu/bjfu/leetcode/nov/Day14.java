package cn.edu.bjfu.leetcode.nov;

import org.junit.Test;

import java.util.Map;

/**
 * @author chaos
 * @date 2021-11-14 13:16
 */
public class Day14 {

    public int maxSubArray(int[] nums) {

        int ans = nums[0];
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (ans < 0) {
                ans = sum = Math.max(ans, nums[i]);
            } else {
                if (nums[i] > 0) {
                    if (sum + nums[i] > ans) {
                        ans = sum + nums[i];
                    } else {
                        ans = Math.max(ans, nums[i]);
                    }
                    sum += nums[i];
                } else {
                    sum = Math.max(sum + nums[i], 0);
                }
            }
        }
        return ans;
    }

    public int maxSubArray2(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int res = dp[0];

        /*
         * dp[i]表示到以i结尾的最大子序列和，不要纠结如果i为负，以nums[i]结尾可定包括i，就是比较dp[i-1] + nums[i] 和 nums[i]的到校
         */
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            res = Math.max(dp[i], res);
        }
        for (int i : dp) {
            System.out.println(i);
        }
        return res;
    }


    @Test
    public void maxSubArrayTest() {
        System.out.println(maxSubArray2(new int[]{1, 2, -1, -2, 2, 1, -2, 1, 4, -5, 4}));
    }


    public boolean canJump(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return true;
        }
        boolean ans = true;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 0) {
                ans = false;
                for (int j = i - 1; j >= 0; j--) {
                    if (nums[j] > i - j) {
                        ans = true;
                        break;
                    }
                }
                if (!ans) {
                    break;
                }
            }
        }
        return ans;
    }

}