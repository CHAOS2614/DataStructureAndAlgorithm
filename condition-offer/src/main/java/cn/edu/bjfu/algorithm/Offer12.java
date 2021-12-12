package cn.edu.bjfu.algorithm;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author chaos
 * @date 2021-12-12 15:58
 * <a href="https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof/">矩阵中的路径</a>
 * <p>
 * 给定一个m x n 二维字符网格board 和一个字符串单词word 。如果word 存在于网格中，返回 true ；否则，返回 false 。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * </p>
 */
public class Offer12 {

    public boolean exist(char[][] board, String word) {
        if (word == null || word.length() == 0) {
            return false;
        }
        char[] words = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (backtrack(board, words, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean backtrack(char[][] board, char[] words, int i, int j, int index) {
        if (i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != words[index]) {
            return false;
        }
        if (index == (words.length - 1)) {
            return true;
        }
        board[i][j] = '\0';
        boolean res = backtrack(board, words, i + 1, j, index + 1)
                || backtrack(board, words, i - 1, j, index + 1)
                || backtrack(board, words, i, j + 1, index + 1)
                || backtrack(board, words, i, j - 1, index + 1);
        board[i][j] = words[index];
        return res;
    }

}
