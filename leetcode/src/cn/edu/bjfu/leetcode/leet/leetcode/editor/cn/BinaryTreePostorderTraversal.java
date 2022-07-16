package cn.edu.bjfu.leetcode.leet.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Chaos
 * @date 2022-07-14 10:49:54
 */
public class BinaryTreePostorderTraversal {
    public static void main(String[] args) {
        Solution solution = new BinaryTreePostorderTraversal().new Solution();
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
        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> ans = new ArrayList<>();
            Deque<TreeNode> stack = new LinkedList<>();
            stack.push(root);
            TreeNode last = null;
            while (root != null || !stack.isEmpty()) {
                while (root != null) {
                    stack.push(root);
                    root = root.left;
                }
                // 到达这里说明root为null，出栈
                root = stack.pop();
                // 如果右子树为空则直接遍历
                // 如果右子节点是上一个被遍历的节点，说明右子树遍历完成，遍历根节点
                if (root.right == null || root.right == last) {
                    ans.add(root.val);
                    // 上一个被遍历的节点，告诉下一轮根节点的右子树是否遍历完成
                    last = root;
                    root = null;
                }
                // 右子树不为空且右子节点没被遍历过，则根节点再次入栈，先遍历右子树
                else {
                    stack.push(root);
                    root = root.right;
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}