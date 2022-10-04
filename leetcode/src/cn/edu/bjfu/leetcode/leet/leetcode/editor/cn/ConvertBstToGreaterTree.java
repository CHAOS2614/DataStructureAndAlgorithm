package cn.edu.bjfu.leetcode.leet.leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Chaos
 * @date 2022-07-11 10:24:40
 */
public class ConvertBstToGreaterTree {
    public static void main(String[] args) {
        Solution solution = new ConvertBstToGreaterTree().new Solution();
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
        int sum = 0;

        /**
         * 二插搜索树中序遍历结果是从小到大排列的
         * 转换一下，右子树 -> 根节点 -> 左子树遍历的结果就是从大到小
         * 用一个变量累加根节点的值再替换根节点的值就好了
         */
        public TreeNode convertBST(TreeNode root) {
            preorder(root);
            return root;
        }

        public void preorderRe(TreeNode root) {
            if (root == null) {
                return;
            }
            preorder(root.right);
            sum += root.val;
            root.val = sum;
            preorder(root.left);
        }

        public void preorder(TreeNode root) {
            int total = 0;
            Deque<TreeNode> stack = new LinkedList<>();
            TreeNode p = root;
            while (p != null || !stack.isEmpty()) {
                while (p != null) {
                    stack.push(p);
                    p = p.right;
                }
                p = stack.pop();
                total += p.val;
                p.val = total;
                p = p.left;
            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}