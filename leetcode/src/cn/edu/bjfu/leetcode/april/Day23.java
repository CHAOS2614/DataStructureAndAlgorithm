package cn.edu.bjfu.leetcode.april;

/**
 * @author Chaos
 * @date 2021/4/23
 */
public class Day23 {


    /**
     * <a href="https://leetcode-cn.com/problems/reverse-string/">
     * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
     * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
     * 你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。</a>
     */
    public void reverseString(char[] s) {
        int len = s.length;
        int mid = len >> 1;
        for (int i = 0; i < mid; i++) {
            char c = s[i];
            s[i] = s[len - 1 - i];
            s[len - 1 - i] = c;
        }
    }


    /**
     * <a href=="https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof/">
     * 给定一棵二叉搜索树，请找出其中第k大的节点。</a>
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private int val;
    private int k;

    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return val;
    }

    void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.right);
        if (k == 0) {
            return;
        }
        if (--k == 0) {
            val = root.val;
        }
        dfs(root.left);
    }

}
