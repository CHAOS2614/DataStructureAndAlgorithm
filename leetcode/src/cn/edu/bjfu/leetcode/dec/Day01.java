package cn.edu.bjfu.leetcode.dec;

import org.junit.Test;

/**
 * @author chaos
 * @date 2021-12-02 10:37
 */
public class Day01 {

    public boolean exist(char[][] board, String word) {
        int row = board.length;
        int cel = board[0].length;
        boolean[][] visited = new boolean[row][cel];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < cel; j++) {
                boolean backtrack = backtrack(board, i, j, 0, word, visited);
                if (backtrack) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean backtrack(char[][] board, int i, int j, int index, String word, boolean[][] visited) {
        if (board[i][j] != word.charAt(index)) {
            return false;
        }
        if (index == word.length() - 1) {
            return true;
        }
        visited[i][j] = true;
        int[][] direction = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        for (int[] dir : direction) {
            int newI = i + dir[0];
            int newJ = j + dir[1];
            boolean result = false;
            if (newI >= 0 && newI < board.length && newJ >= 0 && newJ < board[0].length && !visited[newI][newJ]) {
                result = backtrack(board, newI, newJ, index + 1, word, visited);
            }
            if (result) {
                return true;
            }
        }
        visited[i][j] = false;
        return false;
    }

    @Test
    public void existTest(){
        System.out.println(exist(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "ABCD"));
    }


}
