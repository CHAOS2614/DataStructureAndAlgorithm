package cn.edu.bjfu.leetcode.april;

import javafx.scene.effect.SepiaTone;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Chaos
 * @date 2021/4/13
 */
public class Day13 {

    /**
     * <a href="https://leetcode-cn.com/problems/find-numbers-with-even-number-of-digits/">
     * 给你一个整数数组 nums，请你返回其中位数为 偶数 的数字的个数。</a>
     */
    @Test
    public void findNumbersTest() {
        int[] nums = {12, 345, 2, 6, 7896};
        System.out.println(findNumbers(nums));
    }

    public int findNumbers(int[] nums) {
        int ans = nums.length;
        for (int num : nums) {
//            int temp = 0;
//            while (num > 0) {
//                num /= 10;
//                temp++;
//            }
//            if ((temp & 1) == 0) {
//                ans++;
//            }
            ans -= (String.valueOf(num).length() & 1);
        }
        return ans;
    }


    /**
     * 给你一个单链表的引用结点head。链表中每个结点的值不是 0 就是 1。已知此链表是一个整数数字的二进制表示形式。
     * 请你返回该链表所表示数字的 十进制值 。
     */
    @Test
    public void getDecimalValueTest() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(0);
        ListNode node3 = new ListNode(1);
        node1.next = node2;
        node2.next = node3;

        System.out.println(getDecimalValue(node1));
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public int getDecimalValue(ListNode head) {
//        if (head == null) {
//            return 0;
//        }
//        int length = 0;
//        int ans = 0;
//        ListNode p = head;
//        while (p != null) {
//            length++;
//            p = p.next;
//        }
//        p = head;
//        while (p != null) {
//            ans += Math.pow(2, --length) * p.val;
//            p = p.next;
//        }
//        return ans;
        int ans = 0;
        ListNode p = head;
        while (p != null) {
            ans = (ans << 1) + p.val;
            p = p.next;
        }
        return ans;
    }


    /**
     * <a href="https://leetcode-cn.com/problems/matrix-diagonal-sum/">
     * 给你一个正方形矩阵 mat，请你返回矩阵对角线元素的和。
     * 请你返回在矩阵主对角线上的元素和副对角线上且不在主对角线上元素的和。
     * </a>
     */
    @Test
    public void diagonalSumTest() {
        int[][] mat = {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};
        System.out.println(diagonalSum(mat));

        int a = 20;

        int b = a >> 1;
        System.out.println(b);

    }

    public int diagonalSum(int[][] mat) {
        int ans = 0;
        int len = mat.length;
        int mid = len >> 1;
        for (int i = 0; i < len; i++) {
            ans += (mat[i][i] + mat[i][len - 1 - i]);
        }
//        if ((len & 1) == 1) {
//            int mid = (len - 1) >> 1;
//            ans -= mat[mid][mid];
//        }
        return ans - mat[mid][mid] * (len & 1);
    }


    /**
     * <a href="https://leetcode-cn.com/problems/determine-color-of-a-chessboard-square/">判断国际象棋棋盘中一个格子的颜色</a>
     */
    public boolean squareIsWhite(String coordinates) {
        return (((coordinates.charAt(0) - 'a' + 1) + coordinates.charAt(1)) & 1) == 1;
    }

    /**
     * <a href="https://leetcode-cn.com/problems/find-the-highest-altitude/">
     * 有一个自行车手打算进行一场公路骑行，这条路线总共由n + 1个不同海拔的点组成。自行车手从海拔为 0的点0开始骑行。
     * 给你一个长度为 n的整数数组gain，其中 gain[i]是点 i和点 i + 1的 净海拔高度差（0 <= i < n）。请你返回 最高点的海拔 。
     * </a>
     */
    @Test
    public void largestAltitudeTest() {
        int[] gain = {-4, -3, -2, -1, 4, 3, 2};
        System.out.println(largestAltitude(gain));
    }

    public int largestAltitude(int[] gain) {
        int max = 0;
        max = Math.max(max, gain[0]);
        int len = gain.length;
        for (int i = 1; i < len; i++) {
            gain[i] += gain[i - 1];
            max = Math.max(max, gain[i]);
        }
        return max;
    }


    /**
     * <a href="https://leetcode-cn.com/problems/number-of-students-doing-homework-at-a-given-time/">
     * 给你两个整数数组 startTime（开始时间）和 endTime（结束时间），并指定一个整数 queryTime 作为查询时间。
     * 已知，第 i 名学生在 startTime[i] 时开始写作业并于 endTime[i] 时完成作业。
     * 请返回在查询时间 queryTime 时正在做作业的学生人数。形式上，返回能够使 queryTime 处于区间 [startTime[i], endTime[i]]（含）的学生人数。</a>
     */
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int ans = 0;
        int len = startTime.length;
        for (int i = 0; i < len; i++) {
            if (queryTime >= startTime[i] && queryTime <= endTime[i]) {
                ans++;
            }
        }
        return ans;
    }

    @Test
    public void setTest(){
        Set<String> strings = new HashSet<>();
        boolean aaa = strings.add("aaa");
        System.out.println(aaa);
        boolean aaa1 = strings.add("aaa");
        System.out.println(aaa1);
    }
}
