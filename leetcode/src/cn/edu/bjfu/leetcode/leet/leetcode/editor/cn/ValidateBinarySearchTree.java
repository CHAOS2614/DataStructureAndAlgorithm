package cn.edu.bjfu.leetcode.leet.leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Chaos
 * @date 2022-06-27 10:15:04
 */
public class ValidateBinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new ValidateBinarySearchTree().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    // Definition for a binary tree node.
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

    class Solution {

        public boolean isValidBST(TreeNode root) {
            return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
        }

        public boolean isValidBST(TreeNode node, long min, long max) {
            if (node == null) {
                return true;
            }
            if (node.val <= min || node.val >= max) {
                return false;
            }
            return isValidBST(node.left, min, node.val) && isValidBST(node.right, node.val, max);
        }

        public boolean inorder(TreeNode root) {
            Deque<TreeNode> stack = new LinkedList<>();
            long preMax = Long.MIN_VALUE;
            while (root != null || !stack.isEmpty()) {
                while (root != null) {
                    stack.push(root);
                    root = root.left;
                }
                root = stack.pop();
                if (root.val <= preMax) {
                    return false;
                }
                preMax = root.val;
                root = root.right;
            }
            return true;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}