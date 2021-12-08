package cn.edu.bjfu.leetcode.dec;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author chaos
 * @date 2021-12-08 10:49
 */
public class Day08 {

    public static class TreeNode {
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
     * <a href="https://leetcode-cn.com/problems/largest-rectangle-in-histogram/">最大柱状面积</a>
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> currentRow = new ArrayList<>();
            int size = queue.size();
            while (size > 0) {
                TreeNode remove = queue.remove();
                currentRow.add(remove.val);
                if (remove.left != null) {
                    queue.add(remove.left);
                }
                if (remove.right != null) {
                    queue.add(remove.right);
                }
                size--;
            }
            res.add(currentRow);
        }
        return res;
    }


}
