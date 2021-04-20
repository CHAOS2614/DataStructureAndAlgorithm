package cn.edu.bjfu.leetcode.april;

import org.junit.Test;

/**
 * @author Chaos
 * @date 2021/4/20
 */
public class Day20 {

    /**
     * <a href="https://leetcode-cn.com/problems/robot-return-to-origin/">
     * 在二维平面上，有一个机器人从原点 (0, 0) 开始。给出它的移动顺序，判断这个机器人在完成移动后是否在 (0, 0) 处结束。
     * 移动顺序由字符串表示。字符 move[i] 表示其第 i 次移动。机器人的有效动作有R（右），L（左），U（上）和 D（下）。
     * 如果机器人在完成所有动作后返回原点，则返回 true。否则，返回 false。
     * 注意：机器人“面朝”的方向无关紧要。 “R” 将始终使机器人向右移动一次，“L” 将始终向左移动等。此外，假设每次移动机器人的移动幅度相同。</a>
     */
    public boolean judgeCircle(String moves) {
        int ud = 0;
        int lr = 0;
        int len = moves.length();
        if ((len & 1) == 1) {
            return false;
        }
        for (int i = 0; i < len; i++) {
            char c = moves.charAt(i);
            if (c == 'U') {
                ud++;
            }
            if (c == 'D') {
                ud--;
            }
            if (c == 'L') {
                lr++;
            }
            if (c == 'R') {
                lr--;
            }
        }
        return ud == 0 && lr == 0;
    }


    /**
     * <a href="https://leetcode-cn.com/problems/range-sum-of-bst/">
     * 给定二叉搜索树的根结点 root，返回值位于范围 [low, high] 之间的所有结点的值的和。</a>
     */
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

    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }
        if (root.val < low || root.val > high) {
            return rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
        }
        return rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high) + root.val;
    }


    /**
     * <a href="https://leetcode-cn.com/problems/replace-elements-with-greatest-element-on-right-side/">
     * 给你一个数组 arr ，请你将每个元素用它右边最大的元素替换，如果是最后一个元素，用 -1 替换。
     * 完成所有替换操作后，请你返回这个数组。</a>
     */
    @Test
    public void replaceElementsTest() {
        int[] arr = {17, 18, 5, 4, 6, 1};
        replaceElements(arr);
    }

    public int[] replaceElements(int[] arr) {
        int len = arr.length;
//        int k = 0;
//        int maxId = 0;
//        int max = 0;
//        while (k != len - 1) {
//            for (int i = k + 1; i < len; i++) {
//                if (arr[i] > max) {
//                    max = arr[i];
//                    maxId = i;
//                }
//            }
//            for (; k < maxId; k++) {
//                arr[k] = max;
//            }
//            max = 0;
//        }
//        arr[k] = -1;
//        return arr;
//        int n = 10;
//        int count = (int) Math.pow(10,n);
//        int[] ans = new int[count];
//        for (int i = 0; i < count; ans[++i] = i) {}
//
//        int len = arr.length;
//        if(len == 0){
//            return arr;
//        }
        int [] ans = new int[arr.length];

        ans[len - 1] = -1;
        for (int i = len - 2; i >= 0; i--) {
            ans[i] = Math.max(ans[i+1],arr[i+1]);
        }
        return ans;
    }

}
