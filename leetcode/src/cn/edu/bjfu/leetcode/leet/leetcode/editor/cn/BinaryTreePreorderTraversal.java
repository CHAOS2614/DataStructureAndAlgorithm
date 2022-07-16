package cn.edu.bjfu.leetcode.leet.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Chaos
 * @date 2022-07-11 09:57:58
 */
public class BinaryTreePreorderTraversal {
    public static void main(String[] args) {
        Solution solution = new BinaryTreePreorderTraversal().new Solution();
    }

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

    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> ans = new ArrayList<>();
            Deque<TreeNode> stack = new LinkedList<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                TreeNode pop = stack.pop();
                // 也可以在入栈的时候判断子节点是否为空，为空则不入栈
                if (pop != null) {
                    ans.add(pop.val);
                    stack.push(pop.right);
                    stack.push(pop.left);
                }
            }
            return ans;
        }

        public List<Integer> preorderTraversalMirrors(TreeNode root) {
            List<Integer> ans = new ArrayList<>();
            TreeNode current = root;
            while (current != null) {
                if (current.left == null) {
                    ans.add(current.val);
                    current = current.right;
                } else {
                    TreeNode before = getBefore(current);
                    if (before.right == null) {
                        before.right = current;
                        ans.add(current.val);
                        current = current.left;
                    } else {
                        before.right = null;
                        current = current.right;
                    }
                }
            }
            return ans;
        }

        public TreeNode getBefore(TreeNode current) {
            TreeNode before = current.left;
            while (before.right != null && before.right != current) {
                before = before.right;
            }
            return before;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}