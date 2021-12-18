package cn.edu.bjfu.algorithm;

/**
 * <a href="https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/">机器人的运动范围</a>
 * <p>
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，
 * 它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，
 * 因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 * </p>
 *
 * @author chaos
 * @date 2021-12-13 13:21
 */
public class Offer13 {

    public int movingCount(int m, int n, int k) {
        if (k == 0) {
            return 1;
        }
        boolean[][] visited = new boolean[m][n];
        visited[0][0] = true;
        int sum = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (coordinateSum(i) + coordinateSum(j) > k) {
                    continue;
                }
                if (i - 1 >= 0) {
                    visited[i][j] |= visited[i - 1][j];
                }
                if (j - 1 >= 0) {
                    visited[i][j] |= visited[i][j - 1];
                }
                sum += visited[i][j] ? 1 : 0;
            }
        }
        return sum;

    }

    public int coordinateSum(int x) {
        int res = 0;
        while (x > 0) {
            res += x % 10;
            x /= 10;
        }
        return res;
    }
}
