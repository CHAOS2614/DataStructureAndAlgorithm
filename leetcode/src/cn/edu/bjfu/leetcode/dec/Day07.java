package cn.edu.bjfu.leetcode.dec;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author chaos
 * @date 2021-12-07 19:02
 */
public class Day07 {

    public int largestRectangleArea(int[] heights) {
        if (heights == null) {
            return 0;
        }
        int len = heights.length;
        if (len == 1) {
            return heights[0];
        }

        int[] newHeights = new int[len + 2];
        System.arraycopy(heights, 0, newHeights, 1, len);
        len += 2;
        heights = newHeights;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.addLast(0);
        int area = 0;
        for (int i = 1; i < len; i++) {
            while (heights[stack.peekLast()] > heights[i]) {
                int height = heights[stack.removeLast()];
                int width = i - stack.peekLast() - 1;
                area = Math.max(area, height * width);
            }
            stack.addLast(i);
        }
        return area;
    }


}
