package cn.edu.bjfu.leetcode.leet.leetcode.editor.cn;

/**
 * @author Chaos
 * @date 2022-06-28 10:03:00
 */
public class SingleNumber {
    public static void main(String[] args) {
        Solution solution = new SingleNumber().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 位运算-异或（同为0，异为1）
     * 1. 归零律 a ^ a = 0
     * 2. 恒等律 a ^ 0 = a
     * 3. 交换律 a ^ b = b ^ a
     * 4. 结合律 a ^ b ^ c = a ^ (b ^ c)
     * 5. 自反 a ^ b ^ a = b
     */
    class Solution {
        public int singleNumber(int[] nums) {
            int ans = 0;
            for (int num : nums) {
                ans ^= num;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}