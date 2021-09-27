package cn.edu.bjfu.leetcode.sep;

/**
 * @author chaos
 * @date 2021-09-24 11:49
 */
public class Day25 {

    /**
     * <a href="https://leetcode-cn.com/problems/longest-palindromic-substring/">最长回文子串</a>
     * 动态规划解法
     */
    public String longestPalindrome(String s) {

        if (s == null || s.length() < 2) {
            return s;
        }
        int length = s.length();
        int max = 1;
        int begin = 0;
        boolean[][] b = new boolean[length][length];

        // 每个单独的字符肯定是回文子串
        for (int i = 0; i < length; i++) {
            b[i][i] = true;
        }

        char[] chars = s.toCharArray();

        for (int j = 1; j < length; j++) {
            for (int i = 0; i < j; i++) {
                // 最左和最右不一样肯定不是回文子串
                if (chars[i] != chars[j]) {
                    b[i][j] = false;
                    continue;
                } else {
                    // 单独一个和两个一样的是
                    if (j - i < 3) {
                        b[i][j] = true;
                    } else {
                        // 状态转移
                        b[i][j] = b[i + 1][j - 1];
                    }
                }
                // 更新最长回文子串
                if (b[i][j] && j - i + 1 > max) {
                    max = j - i + 1;
                    begin = i;
                }
            }
        }

        return s.substring(begin, begin + max);

    }

    /**
     * <a href="https://leetcode-cn.com/problems/longest-palindromic-substring/">最长回文子串</a>
     * 中心扩展解法
     */
    public String longestPalindrome2(String s) {

        if (s == null || s.length() < 2) {
            return s;
        }
        int length = s.length();
        int max = 1;
        int start = 0;

        char[] chars = s.toCharArray();

        int begin, end;
        for (int i = 0; i < length; i++) {
            begin = end = i;
            while (begin >= 0 && chars[begin] == chars[i]) {
                begin--;
            }
            while (end < length && chars[end] == chars[i]) {
                end++;
            }
            while (begin >= 0 && end < length && chars[begin] == chars[end]) {
                begin--;
                end++;
            }

            // begin 和 end 在最后一次判定为真之后又分别-- ++ 了，所以边界值要搞清楚
            if (end - begin - 1 > max) {
                max = end - begin - 1;
                start = begin + 1;
            }
        }

        return s.substring(start, start + max);

    }


}
