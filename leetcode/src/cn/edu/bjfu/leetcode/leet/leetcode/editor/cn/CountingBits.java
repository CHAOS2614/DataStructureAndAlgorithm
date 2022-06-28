package cn.edu.bjfu.leetcode.leet.leetcode.editor.cn;

/**
 * @author Chaos
 * @date 2022-06-28 17:19:39
 */
public class CountingBits {
    public static void main(String[] args) {
        Solution solution = new CountingBits().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 计算一个数字的二进制有几位为1
     * x & (x - 1) 可以将最低位的1变为0
     * 知道x为0的次数即为1的个数
     */
    class Solution {
        public int[] countBits(int n) {
            int[] bits = new int[n + 1];
            int highBit = 0;
            for (int i = 1; i < n + 1; i++) {
                if ((i & (i - 1)) == 0) {
                    highBit = i;
                }
                bits[i] = bits[i - highBit] + 1;
            }
            Integer.bitCount(110);
            return bits;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}