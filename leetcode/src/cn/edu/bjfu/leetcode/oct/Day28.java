package cn.edu.bjfu.leetcode.oct;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author chaos
 * @date 2021-10-28 9:43
 */
public class Day28 {

    private final List<List<Integer>> res = new ArrayList<>();

    /**
     * <a href="https://leetcode-cn.com/problems/combination-sum/">组合总和</a>
     * 给定一个无重复元素的正整数数组candidates和一个正整数target，找出candidates中所有可以使数字和为目标数target的唯一组合。
     * candidates中的数字可以无限制重复被选取。如果至少一个所选数字数量不同，则两种组合是唯一的。
     * 对于给定的输入，保证和为target 的唯一组合数少于!
     *
     * <p>[探索回溯],先画个树![](../../../../../../resource/组合总数1.png)，![](../../../../../../resource/组合总数2.png)，在编码。优化点是排序减少回溯次数，还有防止2 2 3 和 2 3 2 这种重复添加begin字段，防止重复。</p>
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<Integer> path = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates, path, target, 0);

        return res;
    }

    private void backtrack(int[] candidates, List<Integer> path, int target, int begin) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = begin; i < candidates.length; i++) {
            int rs = target - candidates[i];
            if (rs >= 0) {
                path.add(candidates[i]);
                backtrack(candidates, path, rs, i);
                path.remove(path.size() - 1);
            } else {
                break;
            }
        }
    }

}
