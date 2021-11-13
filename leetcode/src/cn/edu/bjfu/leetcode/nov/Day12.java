package cn.edu.bjfu.leetcode.nov;

import org.junit.Test;

/**
 * @author chaos
 * @date 2021-11-12 10:32
 */
public class Day12 {


    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int n2 = n >> 1;
        for (int i = 0; i < n2; i++) {
            int max = n - i - 1;
            int count = n - 2 * i - 1;
            for (int j = 0; j < count; j++) {
                int temp = matrix[i][i + j];
                matrix[i][i + j] = matrix[max - j][i];
                matrix[max - j][i] = matrix[max][max - j];
                matrix[max][max - j] = matrix[i + j][max];
                matrix[i + j][max] = temp;
            }
        }
    }

    @Test
    public void rotateTest() {
        int[][] matrix = new int[][]{{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.print(anInt);
                System.out.print(" ");
            }
            System.out.println();
        }
        System.out.println("***************");
        rotate(matrix);
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.print(anInt);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

}
