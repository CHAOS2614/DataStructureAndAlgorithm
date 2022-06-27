package cn.edu.bjfu.leetcode.leet.leetcode.editor.cn;

/**
 * @author Chaos
 * @date 2022-06-27 09:40:26
 */
public class UniqueBinarySearchTrees {
    public static void main(String[] args) {
        Solution solution = new UniqueBinarySearchTrees().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numTrees(int n) {
            return total(n);
            /*int[] dp = new int[n + 1];
            dp[0] = 1;
            dp[1] = 1;
            for (int i = 2; i <= n; i++) {
                for (int j = 1; j <= i; j++) {
                    dp[i] += dp[j - 1] * dp[i - j];
                }
            }
            return dp[n];*/
        }

        /**
         * 递归会导致已经算过的n的结果再算一次，时间效率会很低
         */
        public int total(int n){
            if(n <= 1){
                return 1;
            }
            int total = 0;
            for (int i = 1; i <= n; i++) {
                total += total(i-1) * total(n-i);
            }
            return total;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}