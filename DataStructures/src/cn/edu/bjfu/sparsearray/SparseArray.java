package cn.edu.bjfu.sparsearray;

import org.junit.Test;

/**
 * @author Chaos
 * @date 2021/3/24
 */
public class SparseArray {


    /**
     * 将二维数组转为稀疏数组
     *
     * @param twoDimensionalArray 原始二维数组
     * @return 转化后的稀疏数组
     */
    public int[][] twoDimensionalToSparseArray(int[][] twoDimensionalArray) {

        //1.遍历数组，得到非零数据的个数
        int sum = 0;
        for (int[] ints : twoDimensionalArray) {
            for (int anInt : ints) {
                if (anInt != 0) {
                    sum++;
                }
            }
        }

        //2.创建稀疏数组
        int[][] sparseArray = new int[sum + 1][3];

        sparseArray[0][0] = twoDimensionalArray.length;
        sparseArray[0][1] = twoDimensionalArray[0].length;
        sparseArray[0][2] = sum;

        int count = 0;
        for (int i = 0; i < twoDimensionalArray.length; i++) {
            for (int j = 0; j < twoDimensionalArray[i].length; j++) {
                if (twoDimensionalArray[i][j] != 0) {
                    count++;
                    sparseArray[count][0] = i;
                    sparseArray[count][1] = j;
                    sparseArray[count][2] = twoDimensionalArray[i][j];
                }
            }
        }
        System.out.println("转换完成，稀疏数组为：");
        for (int[] ints : sparseArray) {
            System.out.printf("%d\t%d\t%d\t\n", ints[0], ints[1], ints[2]);
        }

        return sparseArray;
    }

    /**
     * 将稀疏数组还原回二维数组
     *
     * @param sparseArray 稀疏数组
     * @return 还原后的二维数组
     */
    public int[][] sparseToTwoDimensionalArray(int[][] sparseArray) {

        int[][] twoDimensionalArray = new int[sparseArray[0][0]][sparseArray[0][1]];

        for (int i = 1; i < sparseArray.length; i++) {
            twoDimensionalArray[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }

        System.out.println("还原完成，二维数组为：");
        for (int[] ints : twoDimensionalArray) {
            for (int anInt : ints) {
                System.out.print(anInt + "\t");
            }
            System.out.println();
        }

        return twoDimensionalArray;
    }
}
