package cn.edu.bjfu.leetcode.leet.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Chaos
 * @date 2022-06-28 21:33:02
 */
public class FindAllNumbersDisappearedInAnArray {
    public static void main(String[] args) {
        Solution solution = new FindAllNumbersDisappearedInAnArray().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> findDisappearedNumbers(int[] nums) {
            for (int num : nums) {
                nums[Math.abs(num) - 1] = -Math.abs(nums[Math.abs(num) - 1]);
            }
            List<Integer> ans = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > 0) {
                    ans.add(i + 1);
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}