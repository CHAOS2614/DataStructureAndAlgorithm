package cn.edu.bjfu.leetcode.april;

/**
 * @author Chaos
 * @date 2021/4/16
 */
public class Day16 {

    /**
     * <a href="https://leetcode-cn.com/problems/minimum-height-tree-lcci/">
     * 给定一个有序整数数组，元素各不相同且按升序排列，编写一个算法，创建一棵高度最小的二叉搜索树。</a>
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int x) {
            val = x;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        public TreeNode sortedArrayToBST(int[] nums) {
            return create(nums, 0, nums.length);
        }

        public TreeNode create(int[] nums, int left, int right) {
            if (left >= right) {
                return null;
            }
            int mid = (left + right) / 2;
            TreeNode treeNode = new TreeNode(nums[mid]);
            treeNode.left = create(nums, left, mid);
            treeNode.right = create(nums, mid + 1, right);
            return treeNode;
        }

    }


    /**
     * <a href="https://leetcode-cn.com/problems/er-cha-shu-de-jing-xiang-lcof/">
     * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。</a>
     */
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode temp = root.left;
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(temp);
        return root;
    }


    /**
     * <a href="https://leetcode-cn.com/problems/er-cha-shu-de-shen-du-lcof/">
     * 输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。</a>
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }


    /**
     * <a href="">
     * 给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠,
     * 你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为 NULL 的节点将直接作为新二叉树的节点。</a>
     */
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return null;
        }
//        int val = 0;
//        if (root1 != null) {
//            val += root1.val;
//        }
//        if (root2 != null) {
//            val += root2.val;
//        }
//
//
//        return new TreeNode(val, mergeTrees(root1 != null ? root1.left : null, root2 != null ? root2.left : null), mergeTrees(root1 != null ? root1.right : null, root2 != null ? root2.right : null));
//
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        TreeNode node = new TreeNode();
        return new TreeNode(root1.val + root2.val,
                mergeTrees(root1.left, root2.left),
                mergeTrees(root1.right, root2.right));
    }

    /**
     * <a href="https://leetcode-cn.com/problems/count-good-triplets/">
     * 给你一个整数数组 arr ，以及 a、b 、c 三个整数。请你统计其中好三元组的数量。
     * 如果三元组 (arr[i], arr[j], arr[k]) 满足下列全部条件，则认为它是一个 好三元组。
     * 0 <= i < j < k < arr.length
     * |arr[i] - arr[j]| <= a
     * |arr[j] - arr[k]| <= b
     * |arr[i] - arr[k]| <= c</a>
     */
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int len = arr.length;
        int ans = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                for (int k = j + 1; k < len; k++) {
                    if (Math.abs(arr[i] - arr[j]) <= a &&
                            Math.abs(arr[j] - arr[k]) <= b &&
                            Math.abs(arr[i] - arr[k]) <= c) {
                        ans++;
                    }
                }
            }
        }
        return ans;
    }


    /**
     * <a href="">
     * 给你一个数组rectangles，其中 rectangles[i]=[li, wi]表示第i个矩形的长度为li、宽度为wi。
     * 如果存在 k 同时满足 k <= li和k <= wi ，就可以将第 i 个矩形切成边长为k的正方形。例如，矩形[4,6]可以切成边长最大为4的正方形。
     * 设 maxLen 为可以从矩形数组rectangles切分得到的最大正方形的边长。
     * 返回可以切出边长为 maxLen 的正方形的矩形 数目 。</a>
     */
    public int countGoodRectangles(int[][] rectangles) {
        int ans = 0;
        int max = Math.min(rectangles[0][0], rectangles[0][1]);
        for (int[] rectangle : rectangles) {
            int min = Math.min(rectangle[0], rectangle[1]);
            if (max == min) {
                ans++;
            } else if (max < min) {
                ans = 1;
                max = min;
            }
        }
        return ans;
    }
}
