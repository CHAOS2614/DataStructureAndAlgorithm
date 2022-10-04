package cn.edu.bjfu.leetcode.leet.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Chaos
 * @date 2022-07-20 10:29:36
 */
public class SubarraySumEqualsK {
    public static void main(String[] args) {
        Solution solution = new SubarraySumEqualsK().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int subarraySum2(int[] nums, int k) {
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                int sum = 0;
                for (int j = i; j < nums.length; j++) {
                    sum += nums[j];
                    if (sum == k) {
                        count++;
                    }
                }
            }
            return count;
        }

        /**
         * 为啥内层循环不按2那样以i开始而是以i结束？
         * 因为这样能够用map优化内层循环
         * 和两数之和那道题是的，把到i位置的总和和前面的差值存在map里，不用循环了
         */
        public int subarraySum3(int[] nums, int k) {
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                int sum = 0;
                for (int j = i; j >= 0; j--) {
                    sum += nums[j];
                    if (sum == k) {
                        count++;
                    }
                }
            }
            return count;
        }

        public int subarraySum(int[] nums, int k) {
            int count = 0;
            int sum = 0;
            Map<Integer, Integer> map = new HashMap<>(nums.length);
            map.put(0, 1);
            for (int num : nums) {
                sum += num;
                if (map.containsKey(sum - k)) {
                    count += map.get(sum - k);
                }
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}