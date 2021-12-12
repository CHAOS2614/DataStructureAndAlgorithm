package cn.edu.bjfu.algorithm;

/**
 * @author chaos
 * @date 2021-12-12 10:35
 * <a href="https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/">二维数组中的查找</a>
 * <p>
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * </p>
 */
public class Offer04 {

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        if (matrix[0] == null || matrix[0].length == 0) {
            return false;
        }
        int n = matrix.length;
        int m = matrix[0].length;
        for (int i = 0, j = m - 1; i < n && j >= 0; ) {
            if (matrix[i][j] == target) {
                return true;
                // 如果target小于右上角的值，则小于当前列所有值（列递增），此列舍弃
            } else if (matrix[i][j] > target) {
                j--;
                // 如果target大于有上角的值，则大于此行所有值（行递增）此行舍弃
            } else {
                i++;
            }
        }
        return false;
    }


}
