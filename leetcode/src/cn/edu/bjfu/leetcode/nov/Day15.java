package cn.edu.bjfu.leetcode.nov;

import java.util.*;

/**
 * @author chaos
 * @date 2021-11-15 10:38
 */
public class Day15 {

    /**
     * <a href="https://leetcode-cn.com/problems/merge-intervals/">56. 合并区间</a>
     */
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return null;
        }
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        int[][] ans = new int[intervals.length][2];
        int count = 0;
        int[] mer = new int[2];
        mer[0] = intervals[0][0];
        mer[1] = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= mer[1]) {
                mer[1] = Math.max(intervals[i][1], mer[1]);
            } else {
                ans[count++] = mer;
                mer = intervals[i];
            }
        }
        ans[count] = mer;
        return Arrays.copyOfRange(ans, 0, count + 1);
    }


}
