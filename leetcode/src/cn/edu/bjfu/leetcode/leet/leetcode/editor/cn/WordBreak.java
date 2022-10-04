package cn.edu.bjfu.leetcode.leet.leetcode.editor.cn;

import java.util.*;

/**
 * @author Chaos
 * @date 2022-07-16 09:56:32
 */
public class WordBreak {
    public static void main(String[] args) {
        System.out.println("leetcode".indexOf("code", 4));
        Solution solution = new WordBreak().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 动态规划啊动态规划
        // 还是不熟练，都没想到动态规划
        public boolean wordBreakDp(String s, List<String> wordDict) {
            Set<String> dict = new HashSet<>(wordDict.size());
            int maxLen = 0;
            for (String s1 : wordDict) {
                dict.add(s1);
                maxLen = Math.max(maxLen, s1.length());
            }
            boolean[] dp = new boolean[s.length() + 1];
            dp[0] = true;
            for (int i = 1; i < dp.length; i++) {
                for (int j = i; j >= 0 && i - j <= maxLen; j--) {
                    if (dp[j] && dict.contains(s.substring(j, i))) {
                        dp[i] = true;
                        break;
                    }
                }
            }
            for (boolean b : dp) {
                System.out.println(b);
            }
            return dp[dp.length - 1];
        }

        // 深度优先
        public boolean wordBreakDfs(String s, List<String> wordDict) {
            // 这个数组表示：s中以当前字母起始，后面是否匹配
            // 就是说s的前面部分匹配方式可能多种多样
            // 第一次到达该位置之后，后续无论如何都不匹配
            // 在回溯到该位置时将该位置设置为true
            // 后续如果前部分以其他方式匹配了，又到了该位置，直接返回false
            // 节省时间
            boolean[] startVisit = new boolean[s.length() + 1];
            return dfs(s, wordDict, 0, startVisit);
        }

        private boolean dfs(String s, List<String> wordDict, int start, boolean[] startVisit) {
            // 递归截止条件，当起始位置大于等于字符串长度，说明已经完全匹配，返回true
            if (start >= s.length()) {
                return true;
            }
            // 说明已经走到过这个位置且往后不会匹配
            if (startVisit[start]) {
                return false;
            }
            // dfs+回溯，树的每一层节点是wordDict中全部数据
            for (String word : wordDict) {
                // 长度超了直接下一个word
                if (word.length() + start > s.length()) {
                    continue;
                }
                // 如果当前word匹配了
                if (s.indexOf(word, start) == start) {
                    // 看看之后匹配不，也就是深度优先
                    if (dfs(s, wordDict, start + word.length(), startVisit)) {
                        return true;
                    }
                    // 当前word匹配的情况下，之后不能完成匹配，则依据startVisit定义
                    // 给start + word.length()位置打标记
                    startVisit[start + word.length()] = true;
                }
            }
            return false;
        }

        public boolean wordBreakBfs(String s, List<String> wordDict) {
            Queue<Integer> queue = new LinkedList<>();
            queue.add(0);

            int length = s.length();
            // 和dfs的visit一样
            boolean[] visited = new boolean[length + 1];
            // 每一层循环可以看做是树的一层，0入队列就相当于根节点
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    int start = queue.poll();
                    for (String word : wordDict) {
                        int nextStart = start + word.length();
                        if (nextStart > length || visited[nextStart]) {
                            continue;
                        }
                        if (s.indexOf(word, start) == start) {
                            if (nextStart == length) {
                                return true;
                            }
                            queue.add(nextStart);
                            // 更简单的理解为队列中不要重复数字，因为不关心前几层如何匹配的，只关心到该位置为止都是匹配的
                            visited[nextStart] = true;
                        }
                    }
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}