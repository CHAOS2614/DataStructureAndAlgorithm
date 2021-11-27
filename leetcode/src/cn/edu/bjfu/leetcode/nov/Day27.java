package cn.edu.bjfu.leetcode.nov;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chaos
 * @date 2021-11-27 9:45
 */
public class Day27 {

    List<List<Integer>> ans;

    public List<List<Integer>> subsets(int[] nums) {


        if (nums == null || nums.length == 0) {
            return null;
        }
        ans = new ArrayList<>((int) Math.pow(2, nums.length));
        backtrack(0, nums, new ArrayList<>(), ans);
        return ans;
    }

    private void backtrack(int index, int[] nums, List<Integer> subset, List<List<Integer>> subsets) {
        if (index == nums.length) {
            subsets.add(new ArrayList<>(subset));
            return;
        }
        subset.add(nums[index]);
        backtrack(index + 1, nums, subset, subsets);
        subset.remove(subset.size() - 1);
        backtrack(index + 1, nums, subset, subsets);
    }

    @Test
    public void subsetsTest() {
        List<List<Integer>> subsets = subsets(new int[]{1, 2, 3});
        for (List<Integer> subset : subsets) {
            System.out.println(subset);
        }
    }

}
