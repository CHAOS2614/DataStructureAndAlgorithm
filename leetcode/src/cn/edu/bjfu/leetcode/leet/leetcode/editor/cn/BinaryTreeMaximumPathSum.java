package cn.edu.bjfu.leetcode.leet.leetcode.editor.cn;

/**
 * @author Chaos
 * @date 2022-10-04 10:25:11
 */
public class BinaryTreeMaximumPathSum {
    public static void main(String[] args) {
        Solution solution = new BinaryTreeMaximumPathSum().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        // 存放结果
        int ans = Integer.MIN_VALUE;

        public int maxPathSum(TreeNode root) {
            maxGain(root);
            return ans;
        }

        /**
         * 子树最大贡献值
         * 即以该子树根节点到某一叶子节点最大路径和
         */
        public int maxGain(TreeNode node) {
            if (node == null) {
                return 0;
            }
            // 如果子树最大贡献值为负数，则不计入路径
            int leftGain = Math.max(maxGain(node.left), 0);
            int rightGain = Math.max(maxGain(node.right), 0);
            // 计算经过改节点的最大路径和
            int priceNewPath = node.val + leftGain + rightGain;
            // 更新结果
            ans = Math.max(ans, priceNewPath);
            // 返回该节点的最大贡献值
            return node.val + Math.max(leftGain, rightGain);
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
    static class TreeNode {
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
}