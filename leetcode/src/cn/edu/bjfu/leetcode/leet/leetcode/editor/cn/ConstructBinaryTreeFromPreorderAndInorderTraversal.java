package cn.edu.bjfu.leetcode.leet.leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Chaos
 * @date 2022-06-25 19:28:08
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public static void main(String[] args) {
        Solution solution = new ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
        TreeNode treeNode = solution.buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
        System.out.println(treeNode);
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
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            // return build(preorder, inorder, 0, inorder.length - 1, 0);
            return build2(preorder, inorder);
        }

        public TreeNode build(int[] preorder, int[] inorder, int left, int right, int i) {
            if (right < left) {
                return null;
            }
            int val = preorder[i];
            TreeNode node = new TreeNode(val);
            int index = splitArray(inorder, val);
            node.left = build(preorder, inorder, left, index - 1, i + 1);
            node.right = build(preorder, inorder, index + 1, right, i + index - left + 1);
            return node;
        }

        public TreeNode build2(int[] preorder, int[] inorder) {
            if (preorder == null || preorder.length == 0) {
                return null;
            }
            Deque<TreeNode> stack = new LinkedList<>();
            TreeNode root = new TreeNode(preorder[0]);
            stack.push(root);
            int index = 0;
            for (int i = 1; i < preorder.length; i++) {
                TreeNode currentNode = new TreeNode(preorder[i]);
                TreeNode peek = stack.peek();
                if (peek.val != inorder[index]) {
                    peek.left = currentNode;
                    stack.push(currentNode);
                } else {
                    TreeNode pop = stack.pop();
                    index++;
                    while (!stack.isEmpty() &&
                            stack.peek().val == inorder[index]) {
                        pop = stack.pop();
                        index++;
                    }
                    pop.right = currentNode;
                    stack.push(currentNode);
                }
            }
            return root;
        }

        public int splitArray(int[] inorder, int val) {
            for (int i = 0; i < inorder.length; i++) {
                if (inorder[i] == val) {
                    return i;
                }
            }
            return 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}