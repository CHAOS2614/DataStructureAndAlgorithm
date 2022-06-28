package cn.edu.bjfu.leetcode.leet.leetcode.editor.cn;

/**
 * @author Chaos
 * @date 2022-06-28 21:41:55
 */
public class DiameterOfBinaryTree {
    public static void main(String[] args) {
        Solution solution = new DiameterOfBinaryTree().new Solution();
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
        int ans = 1;

        public int diameterOfBinaryTree(TreeNode root) {
            if (root == null) {
                return 0;
            }
            deep(root);
            return ans - 1;
        }

        public int deep(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int left = deep(root.left);
            int right = deep(root.right);
            ans = Math.max(ans, left + right + 1);
            return Math.max(left, right) + 1;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}