package cn.edu.bjfu.leetcode.leet.leetcode.editor.cn;

import java.util.Arrays;

/**
 * @author Chaos
 * @date 2022-08-30 18:30:41
 */
public class ShortestUnsortedContinuousSubarray {
    public static void main(String[] args) {
        Solution solution = new ShortestUnsortedContinuousSubarray().new Solution();
        System.out.println(solution.findUnsortedSubarray(new int[]{1, 2, 3, 4, 5, 6}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findUnsortedSubarrayLow(int[] nums) {
            int[] sorted = new int[nums.length];
            System.arraycopy(nums, 0, sorted, 0, nums.length);
            Arrays.sort(sorted);
            int left = 0;
            while (left < nums.length && nums[left] == sorted[left]) {
                left++;
            }
            int right = nums.length - 1;
            while (right >= 0 && nums[right] == sorted[right]) {
                right--;
            }
            return Math.max(right - left + 1, 0);
        }

        public int findUnsortedSubarray(int[] nums) {
            int n = nums.length;
            int maxn = Integer.MIN_VALUE, right = -1;
            int minn = Integer.MAX_VALUE, left = -1;
            for (int i = 0; i < n; i++) {
                /*
                 * right右边都比nums[right]大，否则right值就会变
                 * right右边是有序递增的，否则right就会变
                 */
                if (maxn > nums[i]) {
                    right = i;
                } else {
                    maxn = nums[i];
                }

                /*
                 * 和上面同理吧
                 */
                if (minn < nums[n - i - 1]) {
                    left = n - i - 1;
                } else {
                    minn = nums[n - i - 1];
                }
            }
            return right == -1 ? 0 : right - left + 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}