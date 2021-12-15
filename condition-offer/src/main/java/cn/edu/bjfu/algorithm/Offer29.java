package cn.edu.bjfu.algorithm;

/**
 * @author chaos
 * @date 2021-12-15 12:27
 */
public class Offer29 {

    /**
     * <a href="https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof/">顺时针打印矩阵</a>
     * <p>
     * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
     * </p>
     */
    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }
        int totalCount = matrix.length * matrix[0].length;
        int[] res = new int[totalCount];
        // 结果集索引
        int index = 0,
                // 最外层左边索引
                left = 0,
                // 最外层右边索引
                right = matrix[0].length - 1,
                // 最外层上边索引
                top = 0,
                // 最外层下边索引
                bottom = matrix.length - 1;
        // 分层遍历，每次依次遍历最外层的上右下左
        while (true) {
            // 先遍历上层，行坐标不变，列坐标从最左变到最右边
            for (int i = left; i <= right; i++) {
                res[index++] = matrix[top][i];
            }
            // 上层遍历完成，最外上层向下移动，如果此时大于最下层，则说明全部遍历完毕
            if (++top > bottom) {
                break;
            }
            // 同理，遍历右层
            for (int i = top; i <= bottom; i++) {
                res[index++] = matrix[i][right];
            }
            if (--right < left) {
                break;
            }
            // 同理，遍历下层
            for (int i = right; i >= left; i--) {
                res[index++] = matrix[bottom][i];
            }
            if (--bottom < top) {
                break;
            }
            // 同理，遍历左层
            for (int i = bottom; i >= top; i--) {
                res[index++] = matrix[i][left];
            }
            if (++left > right) {
                break;
            }
        }
        return res;
    }


}
