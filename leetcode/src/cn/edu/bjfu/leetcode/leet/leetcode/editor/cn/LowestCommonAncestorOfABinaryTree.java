package cn.edu.bjfu.leetcode.leet.leetcode.editor.cn;

/**
 * @author Chaos
 * @date 2022-07-18 09:37:42
 */
public class LowestCommonAncestorOfABinaryTree {
    public static void main(String[] args) {
        Solution solution = new LowestCommonAncestorOfABinaryTree().new Solution();
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private TreeNode ans;

        public Solution() {
            this.ans = null;
        }

        // 很想后序遍历
        private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null) {
                return false;
            }
            boolean l = dfs(root.left, p, q);
            boolean r = dfs(root.right, p, q);
            // p，q唯一，所以如果左右子树都包（各）含一个节点，则当前节点是最近公共祖先
            if ((l && r)) {
                ans = root;
            }
            // 如果当前节点只有一个子树中包含p/q则看看另一个是不是当前节点，是则自己是最近公共祖先
            if (l || r) {
                if (root.val == p.val || root.val == q.val) {
                    ans = root;
                }
            }
            return l || r || (root.val == p.val || root.val == q.val);
        }

        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            this.dfs(root, p, q);
            return this.ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}