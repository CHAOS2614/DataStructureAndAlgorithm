package cn.edu.bjfu.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chaos
 * @date 2021-12-19 11:12
 */
public class Offer07 {


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private Map<Integer, Integer> indexMap;

    public TreeNode myBuildTree(int[] preorder, int preorderLeft, int preorderRight, int inorderLeft) {
        if (preorderLeft > preorderRight) {
            return null;
        }

        // 前序遍历中的第一个节点就是根节点
        int preorderRoot = preorderLeft;
        // 在中序遍历中定位根节点
        int inorderRoot = indexMap.get(preorder[preorderRoot]);
        // 先把根节点建立出来
        TreeNode root = new TreeNode(preorder[preorderRoot]);
        // 得到左子树中的节点数目
        int sizeLeftSubtree = inorderRoot - inorderLeft;
        // 递归地构造左子树，并连接到根节点
        // 先序遍历中「从 左边界+1 开始的 sizeLeftSubtree」个元素就对应了中序遍历中「从 左边界 开始到 根节点定位-1」的元素
        root.left = myBuildTree(preorder, preorderLeft + 1, preorderLeft + sizeLeftSubtree, inorderLeft);
        // 递归地构造右子树，并连接到根节点
        // 先序遍历中「从 左边界+1+左子树节点数目 开始到 右边界」的元素就对应了中序遍历中「从 根节点定位+1 到 右边界」的元素
        root.right = myBuildTree(preorder, preorderLeft + sizeLeftSubtree + 1, preorderRight, inorderRoot + 1);
        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        // 构造哈希映射，帮助我们快速定位根节点
        indexMap = new HashMap<>((int) (inorder.length / 0.75));
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }
        return myBuildTree(preorder, 0, n - 1, 0);
    }

}
