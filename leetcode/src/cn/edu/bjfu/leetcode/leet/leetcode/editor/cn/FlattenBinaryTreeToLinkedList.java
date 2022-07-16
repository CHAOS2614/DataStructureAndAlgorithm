package cn.edu.bjfu.leetcode.leet.leetcode.editor.cn;

/**
 * @author Chaos
 * @date 2022-07-05 09:40:59
 */
public class FlattenBinaryTreeToLinkedList {
    public static void main(String[] args) {
        Solution solution = new FlattenBinaryTreeToLinkedList().new Solution();
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

    /**
     * 对于官方题解中的【前驱】一词解释稍有问题
     * 对于root节点
     * 把right接到left子树的最右边节点不一定是前驱节点，
     * 理解应该是left节点一直向右的最终节点的右边，
     * 这样right接过去之后前序遍历这棵树结果不变
     */
    class Solution {
        public void flatten(TreeNode root) {
            while (root != null) {
                TreeNode left = root.left;
                if (left != null) {
                    TreeNode right = left;
                    while (left != null) {
                        right = left;
                        left = left.right;
                    }
                    right.right = root.right;
                    root.right = root.left;
                    root.left = null;
                }
                root = root.right;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}