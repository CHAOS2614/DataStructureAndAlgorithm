package cn.edu.bjfu.leetcode.leet.leetcode.editor.cn;

/**
 * @author Chaos
 * @date 2022-06-28 11:32:49
 */
public class MajorityElement {
    public static void main(String[] args) {
        Solution solution = new MajorityElement().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int majorityElement(int[] nums) {
            int ans = nums[0];
            int count = 0;
            for (int num : nums) {
                if (ans == num) {
                    count++;
                } else {
                    count--;
                }
                if (count == 0) {
                    ans = num;
                    count ++;
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}