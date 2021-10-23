package cn.edu.bjfu.leetcode.oct;

import org.junit.Test;

import java.sql.Time;
import java.util.*;

/**
 * @author chaos
 * @date 2021-10-22 9:54
 */
public class Day22 {


    /**
     * <a href="https://leetcode-cn.com/problems/generate-parentheses/">括号生成</a>
     * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
     * 有效括号组合需满足：左括号必须以正确的顺序闭合。
     *
     * @param n 括号对数量
     * @return 所有结果
     */
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        // 特判
        if (n == 0) {
            return res;
        }

        StringBuilder curRes = new StringBuilder();
        // 执行深度优先遍历，搜索可能的结果
        dfs(curRes, 0, n, n, res);
        return res;
    }

    /**
     * @param curRes 当前递归得到的结果
     * @param left   左括号还有几个可以使用
     * @param right  右括号还有几个可以使用
     * @param res    结果集
     */
    private void dfs(StringBuilder curRes, int index, int left, int right, List<String> res) {
        // 因为每一次尝试，都使用新的字符串变量，所以无需回溯
        // 在递归终止的时候，直接把它添加到结果集，注意与「力扣」第 46 题、第 39 题区分
        if (left == 0 && right == 0) {
            res.add(curRes.toString());
            return;
        }

        // 剪枝（如图，左括号可以使用的个数严格大于右括号可以使用的个数，才剪枝，注意这个细节）
        if (left > right) {
            return;
        }

        if (left > 0) {
            curRes.append("(");
            dfs(curRes, index + 1, left - 1, right, res);
            curRes.deleteCharAt(index);
        }

        if (right > 0) {
            curRes.append(")");
            dfs(curRes, index + 1, left, right - 1, res);
            curRes.deleteCharAt(index);
        }
    }

    public List<String> generateParenthesis2(int n) {
        List<String> res = new ArrayList<>();
        // 特判
        if (n == 0) {
            return res;
        }

        // 执行深度优先遍历，搜索可能的结果
        dfs("", n, n, res);
        return res;
    }

    /**
     * @param curStr 当前递归得到的结果
     * @param left   左括号还有几个可以使用
     * @param right  右括号还有几个可以使用
     * @param res    结果集
     */
    private void dfs(String curStr, int left, int right, List<String> res) {
        // 因为每一次尝试，都使用新的字符串变量，所以无需回溯
        // 在递归终止的时候，直接把它添加到结果集即可，注意与「力扣」第 46 题、第 39 题区分
        if (left == 0 && right == 0) {
            res.add(curStr);
            return;
        }

        // 剪枝（如图，左括号可以使用的个数严格大于右括号可以使用的个数，才剪枝，注意这个细节）
        if (left > right) {
            return;
        }

        if (left > 0) {
            dfs(curStr + "(", left - 1, right, res);
        }

        if (right > 0) {
            dfs(curStr + ")", left, right - 1, res);
        }
    }

    @Test
    public void generateParenthesisTest() {
        long start = System.currentTimeMillis();
        List<String> strings = generateParenthesis2(15);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /**
     * <a href="https://leetcode-cn.com/problems/merge-k-sorted-lists/">合并K个升序链表</a>
     * 给你一个链表数组，每个链表都已经按升序排列。
     * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
     * @param lists k个升序链表
     * @return 合并链表
     */
    public ListNode mergeKLists(ListNode[] lists) {

        if (lists == null || lists.length == 0) {
            return null;
        }

        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));

        for (ListNode list : lists) {
            if (list != null) {
                queue.offer(list);
            }
        }

        ListNode head = new ListNode();
        ListNode tail = head;

        while (!queue.isEmpty()) {
            ListNode poll = queue.poll();
            tail.next = poll;
            tail = tail.next;
            if (poll.next != null) {
                queue.offer(poll.next);
            }
        }

        return head.next;
    }

}


