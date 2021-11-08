package cn.edu.bjfu.tree;

import org.omg.CosNaming.BindingIterator;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author chaos
 * @date 2021-11-06 19:40
 */
public class Reserve2Tree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public TreeNode getLeft() {
            return left;
        }

        public void setLeft(TreeNode left) {
            this.left = left;
        }

        public TreeNode getRight() {
            return right;
        }

        public void setRight(TreeNode right) {
            this.right = right;
        }
    }

    public static boolean judge(TreeNode root) {

        Deque<TreeNode> stack = new LinkedList<>();
        stack.addLast(root);
        while (!stack.isEmpty()) {
            TreeNode first = stack.removeFirst();
            if (first != null) {
                System.out.println(first.val);
                stack.addLast(first.right);
                stack.addLast(first.left);
            }else {
                while (!stack.isEmpty()){
                    TreeNode node = stack.removeFirst();
                    if(node != null){
                        return false;
                    }
                }

            }

        }


        return true;
    }

    public static TreeNode initTree(TreeNode node) {
        Scanner in = new Scanner(System.in);
        System.out.println("请输入节点的值：");
        int value = in.nextInt();
        if (value == 0) {
            return null;
        }

        node = new TreeNode(value);
        node.left = initTree(node.left);
        node.right = initTree(node.right);
        return node;

    }

    public static void pre(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.val);
        pre(root.left);
        pre(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = initTree(null);
        pre(root);
        System.out.println("****************************");
        System.out.println(judge(root));
    }


}
