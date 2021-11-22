package cn.edu.bjfu.leetcode.nov;

/**
 * @author chaos
 * @date 2021-11-20 13:41
 */
public class Day20 {

    /**
     * <a href="https://leetcode-cn.com/problems/unique-paths/">不同路径</a>
     * 一个机器人位于一个 m x n网格的左上角 （起始点在下图中标记为 “Start” ）。
     * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
     * 问总共有多少条不同的路径？
     * <p>
     * 动态规划
     */
    public int uniquePaths(int m, int n) {
        int[][] bp = new int[m][n];
        for (int i = 0; i < m; i++) {
            bp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            bp[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                bp[i][j] = bp[i - 1][j] + bp[i][j - 1];
            }
        }
        return bp[m - 1][n - 1];
    }

    /**
     * 数学公式cmn
     */
    public int uniquePaths2(int m, int n) {
        long ans = 1;
        for (int x = n, y = 1; y < m; ++x, ++y) {
            ans = ans * x / y;
        }
        return (int) ans;
    }

    /**
     * <a href="https://leetcode-cn.com/problems/minimum-path-sum/">最小路径和</a>
     * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
     * 说明：每次只能向下或者向右移动一步。
     * <p>
     * 和上面的动态规划方法很类似，只是到某个点的路径个数换成最短路径的和了
     */
    public int minPathSum(int[][] grid) {
        if (grid == null) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int[][] bp = new int[m][n];
        bp[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            bp[i][0] = bp[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < n; i++) {
            bp[0][i] = bp[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                bp[i][j] = Math.min(bp[i - 1][j], bp[i][j - 1]) + grid[i][j];
            }
        }
        return bp[m - 1][n - 1];
    }

    /**
     * 斐波那契数列
     */
    public int climbStairs(int n) {
        int[] bp = new int[n];
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        bp[0] = 1;
        bp[1] = 2;
        for (int i = 2; i < n; i++) {
            bp[i] = bp[i - 2] + bp[i - 1];
        }
        return bp[n - 1];
    }
}
