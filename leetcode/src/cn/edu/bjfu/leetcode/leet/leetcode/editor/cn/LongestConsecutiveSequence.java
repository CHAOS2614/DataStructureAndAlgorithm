package cn.edu.bjfu.leetcode.leet.leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Chaos
 * @date 2022-07-16 09:30:57
 */
public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        Solution solution = new LongestConsecutiveSequence().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestConsecutive(int[] nums) {
            Set<Integer> numSet = new HashSet<Integer>();
            for (int num : nums) {
                numSet.add(num);
            }
            int longestStreak = 0;
            for (int num : numSet) {
                // 保证只从某段连续序列的最小值进行计数，防止重复
                // 比如 [2,3,1,8,9],只会有1,8进入循环，应为其他的结果肯定小于这俩开始
                if (!numSet.contains(num - 1)) {
                    int currentNum = num;
                    int currentStreak = 1;
                    while (numSet.contains(currentNum + 1)) {
                        currentNum += 1;
                        currentStreak += 1;
                    }
                    longestStreak = Math.max(longestStreak, currentStreak);
                }
            }
            return longestStreak;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}