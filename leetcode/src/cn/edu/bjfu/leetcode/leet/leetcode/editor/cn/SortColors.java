package cn.edu.bjfu.leetcode.leet.leetcode.editor.cn;

/**
 * @author Chaos
 * @date 2021-11-23 12:06:45
 */
public class SortColors {
    public static void main(String[] args) {
        Solution solution = new SortColors().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void sortColors(int[] nums) {
            int len = nums.length;
            int p0 = 0;
            int p2 = len - 1;

            for (int i = 0; i <= p2; i++) {
                if (nums[i] == 0) {
                    nums[i] = nums[i] ^ nums[p0];
                    nums[p0] = nums[i] ^ nums[p0];
                    nums[i] = nums[i] ^ nums[p0];
                    p0++;
                } else if (nums[i] == 2 && i < p2) {
                    nums[i] = nums[i] ^ nums[p2];
                    nums[p2] = nums[i] ^ nums[p2];
                    nums[i] = nums[i] ^ nums[p2];
                    p2--;
                    if (nums[i] != 1) {
                        i--;
                    }
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}