package cn.edu.bjfu.leetcode.leet.leetcode.editor.cn;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Chaos
 * @date 2022-10-04 10:10:03
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        Solution solution = new LongestSubstringWithoutRepeatingCharacters().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            Set<Character> set = new HashSet<>();
            int len = s.length();
            int ans = 0;
            int right = -1;
            for (int i = 0; i < len; i++) {
                if (i != 0) {
                    set.remove(s.charAt(i - 1));
                }
                while (right + 1 < len && !set.contains(s.charAt(right + 1))) {
                    set.add(s.charAt(right + 1));
                    right++;
                }
                ans = Math.max(ans, right - i + 1);
            }
            return ans;
        }
    }

    class Solution2 {
        public int lengthOfLongestSubstring(String s) {
            HashMap<Character, Integer> map = new HashMap<>();
            int max = 0, start = 0;
            for (int end = 0; end < s.length(); end++) {
                char ch = s.charAt(end);
                if (map.containsKey(ch)) {
                /*
                因为并没有删除map中旧start-新start之间的值，所以可能这个ch是不是在窗口内的，这一步是必要的，map.get(ch) + 1不一定大于start
                 */
                    start = Math.max(map.get(ch) + 1, start);
                }
                max = Math.max(max, end - start + 1);
                map.put(ch, end);
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}