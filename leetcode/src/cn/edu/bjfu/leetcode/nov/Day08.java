package cn.edu.bjfu.leetcode.nov;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author chaos
 * @date 2021-11-08 10:44
 */
public class Day08 {

    /**
     * 暴力求解
     */
    public int trap1(int[] height) {

        if (height == null || height.length < 3) {
            return 0;
        }

        int ans = 0;
        int leftMax;
        int rightMax;
        for (int i = 1; i < height.length - 1; i++) {
            leftMax = height[i];
            rightMax = height[i];
            for (int i1 = i - 1; i1 >= 0; i1--) {
                leftMax = Math.max(height[i1], leftMax);
            }
            for (int i1 = i + 1; i1 < height.length; i1++) {
                rightMax = Math.max(height[i1], rightMax);
            }
            ans += Math.min(leftMax, rightMax) - height[i];
        }

        return ans;
    }

    /**
     * 动态规划
     */
    public int trap2(int[] height) {
        if (height == null) {
            return 0;
        }
        int len = height.length;
        if (len < 3) {
            return 0;
        }
        int[] leftMax = new int[len];
        int[] rightMax = new int[len];
        leftMax[0] = height[0];
        for (int i = 1; i < len; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }
        rightMax[len - 1] = height[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }
        int ans = 0;
        for (int i = 1; i < len - 1; i++) {
            ans += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return ans;
    }

    /**
     * 单调栈
     */
    public int trap3(int[] height) {
        int ans = 0;
        Deque<Integer> stack = new LinkedList<>();
        int n = height.length;
        for (int i = 0; i < n; ++i) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int top = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int left = stack.peek();
                int currWidth = i - left - 1;
                int currHeight = Math.min(height[left], height[i]) - height[top];
                ans += currWidth * currHeight;
            }
            stack.push(i);
        }
        return ans;
    }

    /**
     * 双指针
     */
    public int trap4(int[] height) {
        if (height == null) {
            return 0;
        }
        int len = height.length;
        if (len < 3) {
            return 0;
        }
        int leftMax = height[0];
        int rightMax = height[len - 1];
        int left = 0;
        int right = len - 1;
        int ans = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                ans += leftMax - height[left];
                left++;
                leftMax = Math.max(leftMax, height[left]);
            } else {
                ans += rightMax - height[right];
                right--;
                rightMax = Math.max(rightMax, height[right]);
            }
        }
        return ans;
    }

    /**
     * <a href="https://leetcode-cn.com/problems/trapping-rain-water/">接雨水</a>
     */
    @Test
    public void trapTest() {
        int[] height = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap1(height));
        System.out.println(trap2(height));
        System.out.println(trap4(height));

    }


}
