package cn.edu.bjfu.leetcode.oct;

import com.sun.org.apache.bcel.internal.generic.ArithmeticInstruction;
import org.junit.Test;

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


    /**
     * <a href="">加1</a>
     * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
     * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
     * 你可以假设除了整数 0 之外，这个整数不会以零开头。
     */
    public int[] plusOne(int[] digits) {
//        int c = 0;
//        for (int i = digits.length - 1; i >= 0; i--) {
//            c = digits[i] / 9;
//            digits[i] = (digits[i] + 1) % 10;
//            if (c == 0) {
//                break;
//            }
//        }
//        if (c == 0) {
//            return digits;
//        } else {
//            int[] ans = new int[digits.length + 1];
//            ans[0] = 1;
//            System.arraycopy(digits, 0, ans, 1, digits.length);
//            return ans;
//        }
        int n = digits.length;
        for (int i = n - 1; i >= 0; --i) {
            if (digits[i] != 9) {
                ++digits[i];
                for (int j = i + 1; j < n; ++j) {
                    digits[j] = 0;
                }
                return digits;
            }
        }

        // digits 中所有的元素均为 9
        int[] ans = new int[n + 1];
        ans[0] = 1;
        return ans;

    }

    @Test
    public void plusOneTest() {
        for (int i : plusOne(new int[]{9})) {
            System.out.println(i);
        }
    }


}
