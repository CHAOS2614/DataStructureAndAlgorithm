package cn.edu.bjfu.leetcode.oct;

import com.sun.org.apache.bcel.internal.generic.ArithmeticInstruction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author chaos
 * @date 2021-10-21 9:35
 */
public class Day21 {

    /**
     * <a href="https://leetcode-cn.com/problems/3sum/">三数之和</a>
     * 给你一个包含 n 个整数的数组nums，判断nums中是否存在三个元素 a，b，c ，使得a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
     * 注意：答案中不可以包含重复的三元组。
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return ans;
        }
        int n = nums.length;
        Arrays.sort(nums);

        for (int i = 0; i < n - 2; i++) {
            // 数组排过序了，如果第一个大于0，那么之后可定都大于0，不可能和为0
            if (nums[i] > 0) {
                break;
            }

            // 去重复数字
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int sum = -nums[i];
            int left = i + 1;
            int right = n - 1;
            while (left < right) {
                if (nums[left] + nums[right] == sum) {
                    List<Integer> res = new ArrayList<>();
                    res.add(nums[i]);
                    res.add(nums[left]);
                    res.add(nums[right]);
                    ans.add(res);
                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                } else if (nums[left] + nums[right] < sum) {
                    left++;
                } else {
                    right--;
                }

            }
        }

        return ans;

    }


}
