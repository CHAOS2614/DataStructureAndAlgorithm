package cn.edu.bjfu.leetcode.april;

import org.junit.Test;

import javax.management.StandardEmitterMBean;
import java.util.*;

/**
 * @author Chaos
 * @date 2021/4/22
 */
public class Day22 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * <a href="https://leetcode-cn.com/problems/search-in-a-binary-search-tree/">
     * 给定二叉搜索树（BST）的根节点和一个值。 你需要在BST中找到节点值等于给定值的节点。 返回以该节点为根的子树。 如果节点不存在，则返回 NULL。</a>
     */
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }

        if (root.val == val) {
            return root;
        } else if (val < root.val) {
            return searchBST(root.left, val);
        } else {
            return searchBST(root.right, val);
        }
    }


    /**
     * <a href="">
     * 自除数是指可以被它包含的每一位数除尽的数。
     * 例如，128 是一个自除数，因为128 % 1 == 0，128 % 2 == 0，128 % 8 == 0。
     * 还有，自除数不允许包含0。
     * 给定上边界和下边界数字，输出一个列表，列表的元素是边界（含边界）内所有的自除数。</a>
     * <p>
     * 可以转成字符串在转字符数组算 不用取余了
     */
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> ans = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (isSelfDividingNumbers(i)) {
                ans.add(i);
            }
        }
        return ans;
    }

    private boolean isSelfDividingNumbers(int n) {
        int remainder;
        int temp = n;
        while (temp > 0) {
            remainder = temp % 10;
            temp /= 10;
            if (remainder == 0 || n % remainder > 0) {
                return false;
            }
        }
        return true;
    }


    /**
     * <a href="">
     * 给你一个字符串s，它由数字（'0' - '9'）和'#'组成。我们希望按下述规则将s映射为一些小写英文字符：
     * 字符（'a' - 'i'）分别用（'1' -'9'）表示。
     * 字符（'j' - 'z'）分别用（'10#'-'26#'）表示。
     * 返回映射之后形成的新字符串。
     * 题目数据保证映射始终唯一。</a>
     */
    public String freqAlphabets(String s) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < len; i++) {
            if (i + 2 < len && chars[i + 2] == '#') {
                char c = (char) ((chars[i] - '0') * 10 + (chars[i + 1] - '1') + 'a');
                System.out.println(c);
                ans.append(c);
                i += 2;
            } else {
                ans.append((char) (chars[i] - '1' + 'a'));
            }
        }
        return ans.toString();
    }


    /**
     * <a href="https://leetcode-cn.com/problems/cells-with-odd-values-in-a-matrix/">
     * 给你一个 m x n 的矩阵，最开始的时候，每个单元格中的值都是 0。
     * 另有一个二维索引数组indices，indices[i] = [ri, ci] 指向矩阵中的某个位置，其中 ri 和 ci 分别表示指定的行和列（从 0 开始编号）。
     * 对 indices[i] 所指向的每个位置，应同时执行下述增量操作：
     * ri 行上的所有单元格，加 1 。
     * ci 列上的所有单元格，加 1 。
     * 给你 m、n 和 indices 。请你在执行完所有indices指定的增量操作后，返回矩阵中 奇数值单元格 的数目。</a>
     */
    public int oddCells(int m, int n, int[][] indices) {
        int[][] ans = new int[m][n];
        for (int[] index : indices) {
            int r = index[0];
            int c = index[1];
            for (int i = 0; i < n; i++) {
                ans[r][i]++;
            }
            for (int i = 0; i < m; i++) {
                ans[i][c]++;
            }
        }
        int sum = 0;
        for (int[] an : ans) {
            for (int i : an) {
                if ((i & 1) == 1) {
                    sum++;
                }
            }
        }
        return sum;
    }


    /**
     * <a href="https://leetcode-cn.com/problems/sum-of-unique-elements/">
     * 给你一个整数数组 nums 。数组中唯一元素是那些只出现 恰好一次 的元素。
     * 请你返回 nums 中唯一元素的 和 。</a>
     */
    public int sumOfUnique(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>(16);
        int ans = 0;
        for (int num : nums) {
            if (map.containsKey(num) && map.get(num) == 1) {
                ans -= num;
                map.put(num, map.get(num) + 1);

            } else if (!map.containsKey(num)) {
                ans += num;
                map.put(num, 1);
            }
        }
        return ans;
    }


    /**
     * <a href="https://leetcode-cn.com/problems/maximum-69-number/">
     * 给你一个仅由数字 6 和 9 组成的正整数 num。
     * 你最多只能翻转一位数字，将 6 变成 9，或者把 9 变成 6 。
     * 请返回你可以得到的最大数字。</a>
     */
    @Test
    public void maxTest() {
        maximum69Number(998866);
    }

    public int maximum69Number(int num) {
        char[] chars = String.valueOf(num).toCharArray();
        int len = chars.length;
        for (int i = 0; i < len; i++) {
            if (chars[i] == '6') {
                chars[i] = '9';
                break;
            }
        }
        System.out.println(String.copyValueOf(chars));
        return Integer.parseInt(String.copyValueOf(chars));
    }


    /**
     * <a href="https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/">
     * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。</a>
     */

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
    public int[] reversePrint(ListNode head) {
        ListNode node = head;
        int count = 0;
        while (node != null){
            node = node.next;
            count++;
        }
        node = head;
        int[] ans = new int[count];
        for (int i = count -1; i >= 0; i--) {
            ans[i] = node.val;
            node = node.next;
        }
        return ans;
    }

}












