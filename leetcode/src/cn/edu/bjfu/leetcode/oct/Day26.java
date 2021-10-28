package cn.edu.bjfu.leetcode.oct;

import org.junit.Test;

/**
 * @author chaos
 * @date 2021-10-26 14:27
 */
public class Day26 {

    public int[] searchRange(int[] nums, int target) {
        int leftIdx = searchLeft(nums, target);
        int rightIdx = searchRight(nums, target) - 1;
        if (leftIdx <= rightIdx && rightIdx < nums.length && nums[leftIdx] == target && nums[rightIdx] == target) {
            return new int[]{leftIdx, rightIdx};
        }
        return new int[]{-1, -1};
    }

    private int searchLeft(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int res = 0;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (target <= nums[mid]) {
                right = mid - 1;
                res = mid;
            } else {
                left = mid + 1;
            }
        }
        return res;
    }

    private int searchRight(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int res = nums.length;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (target < nums[mid]) {
                right = mid - 1;
                res = mid;
            } else {
                left = mid + 1;
            }
        }
        return res;
    }

    @Test
    public void searchRangeTest() {
        searchRange(new int[]{1}, 1);
    }


}
