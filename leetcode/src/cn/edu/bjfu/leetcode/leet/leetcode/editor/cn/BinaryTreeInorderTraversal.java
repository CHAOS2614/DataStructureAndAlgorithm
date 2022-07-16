package cn.edu.bjfu.leetcode.leet.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Chaos
 * @date 2022-07-11 11:05:21
 */
public class BinaryTreeInorderTraversal {
    public static void main(String[] args) {
        Solution solution = new BinaryTreeInorderTraversal().new Solution();
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

        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> ans = new ArrayList<>();
            List<Integer> ans2 = new ArrayList<>();
            Deque<TreeNode> stack = new LinkedList<>();
            TreeNode cur = root;
            while (cur != null || !stack.isEmpty()) {
                while (cur != null) {
                    stack.push(cur);
                    cur = cur.left;
                }
                // 走到这一步说明root肯定为null
                // 不论是走到最左边了还是上一轮的right为null
                // 所以都直接取栈顶进行遍历
                cur = stack.pop();
                ans.add(cur.val);
                cur = cur.right;
            }
            cur = root;
            // 和上边一个意思
            while (cur != null || !stack.isEmpty()) {
                if (cur != null) {
                    stack.push(cur);
                    cur = cur.left;
                } else {
                    cur = stack.pop();
                    ans2.add(cur.val);
                    cur = cur.right;
                }
            }
            return ans;
        }


        public List<Integer> inorderTraversalMirror(TreeNode root) {
            List<Integer> ans = new ArrayList<>();
            TreeNode current = root;
            while (current != null) {
                if (current.left == null) {
                    ans.add(current.val);
                    current = current.right;
                } else {
                    TreeNode before = getBefore(current);
                    if (before.right == current) {
                        before.right = null;
                        ans.add(current.val);
                        current = current.right;
                    } else {
                        before.right = current;
                        current = current.left;
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