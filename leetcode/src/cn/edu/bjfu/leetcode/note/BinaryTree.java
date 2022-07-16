package cn.edu.bjfu.leetcode.note;

import cn.edu.bjfu.leetcode.leet.leetcode.editor.cn.BinaryTreeInorderTraversal;
import cn.edu.bjfu.leetcode.leet.leetcode.editor.cn.BinaryTreePostorderTraversal;
import cn.edu.bjfu.leetcode.leet.leetcode.editor.cn.BinaryTreePreorderTraversal;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author chaos
 * @date 2022-07-14 9:25
 */
public class BinaryTree {
    private static class TreeNode {
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

    /**
     * 二叉树的前序遍历迭代方式
     */
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

    /**
     * 前序遍历mirror算法
     * 核心思路就是利用叶子节点的空指针
     * 二叉树遍历的一个问题就是遍历子节点之后如何返回到根节点
     * 所以引入了栈解决这一问题
     * 那么，在不影响遍历顺序的前提下
     * 遍历完子树之后能够回到根节点就解决了这个问题
     * 方法就是遍历子树之前，找到子树遍历过程中的最后一个叶子节点
     * 将这个叶子节点的右指针指向根节点
     * 这个节点就是根节点<b>中序遍历的前驱节点,及左孩子一直往右的那个节点</b>
     * 前序遍历和中序遍历的不同之处只是一个先处理根节点一个后处理根节点
     * 最后别忘了把那个指向根节点的指针置空
     */
    public List<Integer> preorderTraversalMirrors(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        TreeNode current = root;
        while (current != null) {
            // 左子树为空，直接访问
            if (current.left == null) {
                ans.add(current.val);
                current = current.right;
            }
            // 左子树不为空，为了将来访问完左子树能够回到根节点继续遍历，找到前驱指向根节点
            else {
                TreeNode before = getBefore(current);
                // 说明根节点没遍历过
                if (before.right == null) {
                    before.right = current;
                    ans.add(current.val);
                    current = current.left;
                }
                // 说明该节点已经遍历过了，恢复指针遍历右子树
                else {
                    before.right = null;
                    current = current.right;
                }
            }
        }
        return ans;
    }

    /**
     * 中序遍历迭代法
     */
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

    /**
     * 中序遍历mirror方法
     */
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

    /**
     * 后序遍历迭代法
     * 注意的是要判断右子树是否遍历过
     * 没遍历过则根节点再次入栈，及根节点可能入栈两次
     */
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


    public TreeNode getBefore(TreeNode current) {
        TreeNode before = current.left;
        while (before.right != null && before.right != current) {
            before = before.right;
        }
        return before;
    }
}
