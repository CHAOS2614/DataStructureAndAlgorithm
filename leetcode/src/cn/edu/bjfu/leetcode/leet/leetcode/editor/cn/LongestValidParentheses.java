package cn.edu.bjfu.leetcode.leet.leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Chaos
 * @date 2022-09-04 11:37:12
 * <a href="https://leetcode-cn.com/problems/longest-valid-parentheses/submissions/">最长有效括号</a>
 * 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
 */
public class LongestValidParentheses {
    public static void main(String[] args) {
        Solution solution = new LongestValidParentheses().new Solution();
    }

    // leetcode submit region begin(Prohibit modification and deletion)

    class Solution {

        /**
         *
         */
        public int longestValidParentheses(String s) {

            if (s == null || s.length() < 2) {
                return 0;
            }
            int[] currentCount = new int[s.length()];
            char[] chars = s.toCharArray();

            for (int i = 1; i < chars.length; i++) {
                if (chars[i] == ')') {
                    if (chars[i - 1] == '(') {
                        if (i > 2) {
                            currentCount[i] = currentCount[i - 2] + 2;
                        } else {
                            currentCount[i] = 2;
                        }
                    } else if (i - currentCount[i - 1] - 1 >= 0 && chars[i - currentCount[i - 1] - 1] == '(') {
                        if (i - currentCount[i - 1] >= 2) {
                            currentCount[i] = currentCount[i - 1] + 2 + currentCount[i - currentCount[i - 1] - 2];
                        } else {
                            currentCount[i] = currentCount[i - 1] + 2;
                        }
                    }
                }
            }
            int max = currentCount[0];
            for (int j : currentCount) {
                max = Math.max(max, j);
            }
            return max;
        }

        public int longestValidParentheses2(String s) {

            int max = 0;
            Deque<Integer> stack = new LinkedList<>();
            stack.addLast(-1);
            char[] chars = s.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == '(') {
                    stack.addLast(i);
                } else {
                    stack.removeLast();
                    if (stack.isEmpty()) {
                        stack.addLast(i);
                    } else {
                        max = Math.max(max, i - stack.getLast());
                    }
                }
            }
            return max;
        }

        public int longestValidParentheses3(String s) {
            int max = 0;
            int left = 0, right = 0;
            char[] chars = s.toCharArray();
            for (char c : chars) {
                if (c == '(') {
                    left++;
                } else {
                    right++;
                }
                if (left == right) {
                    max = Math.max(2 * right, max);
                } else if (right > left) {
                    left = right = 0;
                }
            }
            right = left = 0;
            for (int i = chars.length - 1; i >= 0; i--) {
                if (chars[i] == ')') {
                    right++;
                } else {
                    left++;
                }
                if (left == right) {
                    max = Math.max(2 * right, max);
                } else if (right < left) {
                    left = right = 0;
                }
            }
            return max;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}