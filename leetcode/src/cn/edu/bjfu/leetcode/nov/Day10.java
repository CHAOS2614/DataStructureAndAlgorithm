package cn.edu.bjfu.leetcode.nov;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chaos
 * @date 2021-11-10 10:27
 */

public class Day10 {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int[] visit = new int[nums.length];
        backtrack(ans, new ArrayList<>(), nums, visit);
        return ans;
    }

    private void backtrack(List<List<Integer>> ans, List<Integer> oneRes, int[] nums, int[] visit) {
        if (oneRes.size() == nums.length) {
            ans.add(new ArrayList<>(oneRes));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visit[i] == 1) {
                continue;
            }
            visit[i] = 1;
            oneRes.add(nums[i]);
            backtrack(ans, oneRes, nums, visit);
            visit[i] = 0;
            oneRes.remove(oneRes.size() - 1);
        }
    }

    /**
     * 全排列
     * <a href="https://leetcode-cn.com/problems/permutations/">全排列</a>
     * <p>给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。</p>
     */
    @Test
    public void permuteTest() {
        List<List<Integer>> permute = permute(new int[]{1, 2, 3});
        permute.forEach(System.out::println);
    }

}
