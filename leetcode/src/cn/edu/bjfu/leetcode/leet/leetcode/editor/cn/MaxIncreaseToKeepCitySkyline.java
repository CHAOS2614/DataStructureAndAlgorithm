package cn.edu.bjfu.leetcode.leet.leetcode.editor.cn;

/**
 * @author Chaos
 * @date 2021-12-13 13:13:35
 */
public class MaxIncreaseToKeepCitySkyline {
    public static void main(String[] args) {
        Solution solution = new MaxIncreaseToKeepCitySkyline().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxIncreaseKeepingSkyline(int[][] grid) {
            int[] maxRow = new int[grid.length];
            int[] maxCol = new int[grid[0].length];
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    maxRow[i] = Math.max(maxRow[i], grid[i][j]);
                    maxCol[j] = Math.max(maxCol[j], grid[i][j]);
                }
            }
            int sum = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    sum += Math.min(maxRow[i], maxCol[j]) - grid[i][j];
                }
            }
            return sum;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}