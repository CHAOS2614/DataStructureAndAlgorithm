package cn.edu.bjfu.tree;

import java.util.Scanner;

/**
 * @author chaos
 * @date 2021-12-10 11:28
 */
public class BiTree {

    public static class Node {
        private int val;
        private Node left;
        private Node right;

        public Node() {
        }

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }

    public static Node preCreateBiTree(Node node) {
        Scanner in = new Scanner(System.in);
        System.out.println("请输入节点的值：");
        int value = in.nextInt();
        if (value == 0) {
            return null;
        }
        node = new BiTree.Node(value);
        node.left = preCreateBiTree(node.left);
        node.right = preCreateBiTree(node.right);
        return node;
    }

}
