package cn.edu.bjfu.leetcode.leet.leetcode.editor.cn;

/**
 * @author Chaos
 * @date 2021-12-04 21:40:40
 */
public class RansomNote {
    public static void main(String[] args) {
        Solution solution = new RansomNote().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     *
     */
    class Solution {
        public boolean canConstruct(String ransomNote, String magazine) {
            if (ransomNote.length() > magazine.length()) {
                return false;
            }
            int[] chars = new int[127];
            for (int i = 0; i < magazine.length(); i++) {
                chars[magazine.charAt(i)]++;
            }
            for (int i = 0; i < ransomNote.length(); i++) {
                if (--chars[ransomNote.charAt(i)] < 0) {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}