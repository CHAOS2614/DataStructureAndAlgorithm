package cn.edu.bjfu.leetcode.leet.leetcode.editor.cn;

import java.util.*;

/**
 * @author Chaos
 * @date 2022-07-26 10:18:54
 */
public class TaskScheduler {
    public static void main(String[] args) {
        Solution solution = new TaskScheduler().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int leastInterval(char[] tasks, int n) {
            Map<Character, Integer> freq = new HashMap<>(32);
            for (char ch : tasks) {
                freq.put(ch, freq.getOrDefault(ch, 0) + 1);
            }
            // 任务种类总数
            int m = freq.size();
            List<Integer> nextValid = new ArrayList<>();
            List<Integer> rest = new ArrayList<>();
            for (Map.Entry<Character, Integer> entry : freq.entrySet()) {
                int value = entry.getValue();
                nextValid.add(1);
                rest.add(value);
            }
            int time = 0;
            for (int i = 0; i < tasks.length; ++i) {
                int minNextValid = Integer.MAX_VALUE;
                for (int j = 0; j < m; ++j) {
                    if (rest.get(j) != 0) {
                        minNextValid = Math.min(minNextValid, nextValid.get(j));
                    }
                }
                time = Math.max(time + 1, minNextValid);
                int best = -1;
                for (int j = 0; j < m; ++j) {
                    if (rest.get(j) != 0 && nextValid.get(j) <= time) {
                        if (best == -1 || rest.get(j) > rest.get(best)) {
                            best = j;
                        }
                    }
                }
                nextValid.set(best, time + n + 1);
                rest.set(best, rest.get(best) - 1);
            }

            return time;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}