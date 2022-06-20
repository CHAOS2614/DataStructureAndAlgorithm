package cn.edu.bjfu.leetcode.leet.leetcode.editor.cn;

/**
 * @author Chaos
 * @date 2021-12-14 12:11:29
 */
public class KthLargestElementInAnArray {
    public static void main(String[] args) {
        Solution solution = new KthLargestElementInAnArray().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findKthLargest(int[] nums, int k) {
            return quickSelect(nums, 0, nums.length - 1, k - 1);
        }

        private int quickSelect(int[] nums, int left, int right, int k) {
            if (left < right) {
                int pos = partition(nums, left, right);
                if (pos == k) {
                    return nums[k];
                } else if (pos > k) {
                    return quickSelect(nums, left, pos - 1, k);
                } else {
                    return quickSelect(nums, pos + 1, right, k);
                }
            }
            return nums[k];
        }

        private int partition(int[] nums, int left, int right) {
            int temp = nums[left];
            while (left < right) {
                while (left < right && nums[right] <= temp) {
                    right--;
                }
                nums[left] = nums[right];
                while (left < right && nums[left] >= temp) {
                    left++;
                }
                nums[right] = nums[left];
            }
            nums[left] = temp;
            return left;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}