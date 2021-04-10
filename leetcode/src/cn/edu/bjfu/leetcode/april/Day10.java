package cn.edu.bjfu.leetcode.april;

import org.junit.Test;

/**
 * @author Chaos
 * @date 2021/4/10
 */
public class Day10 {

    /**
     * <a href="https://leetcode-cn.com/problems/xor-operation-in-an-array/">
     * 请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点。传入函数的唯一参数为要被删除的节点。
     * </a>
     * 思路:删除当前节点可以转换为将下一个节点的属性赋予当前节点，然后删除下一节点
     */
    @Test
    public void deleteNodeTest() {

        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(5);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(9);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = null;
        deleteNode(node2);
        ListNode node = node1;
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }


    /**
     * <a href="">
     * 给你两个整数，n 和 start 。
     * 数组 nums 定义为：nums[i] = start + 2*i（下标从0开始）且n == nums.length 。
     * 请返回 nums 中所有元素按位异或（XOR）后得到的结果。
     * </a>
     */
    @Test
    public void xorOperationTest() {
        System.out.println(xorOperation(10, 5));
    }

    public int xorOperation(int n, int start) {
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans ^= (start + 2 * i);
        }
        return ans;
    }


    /**
     * <a href="https://leetcode-cn.com/problems/na-ying-bi/">
     * 桌上有 n 堆力扣币，每堆的数量保存在数组 coins 中。我们每次可以选择任意一堆，拿走其中的一枚或者两枚，求拿完所有力扣币的最少次数。
     * 运行时间相差不多,好像还是4快点
     * </a>
     */
    @Test
    public void minCountTest() {
        int[] coins = {4, 2, 1, 5, 6, 8, 7, 4, 1, 2, 3, 6, 5, 4, 8, 9, 8, 7, 9, 10, 23, 54, 58, 47, 56, 20};
        long start = System.currentTimeMillis();
        for (long i = 0L; i < Integer.MAX_VALUE; i++) {
            minCount(coins);
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);

        start = System.currentTimeMillis();
        for (long i = 0L; i < Integer.MAX_VALUE; i++) {
            minCount3(coins);
        }
        end = System.currentTimeMillis();
        System.out.println(end - start);

        start = System.currentTimeMillis();
        for (long i = 0L; i < Integer.MAX_VALUE; i++) {
            minCount4(coins);
        }
        end = System.currentTimeMillis();
        System.out.println(end - start);

    }

    public int minCount(int[] coins) {
        int ans = 0;
        for (int coin : coins) {
            ans += (coin + 1) / 2;
        }
        return ans;
    }

    /**
     * 效率太差
     *
     * @param coins c
     * @return int
     */
    public int minCount2(int[] coins) {
        int ans = 0;
        for (int coin : coins) {
            ans += Math.ceil(coin / 2.0);
        }
        return ans;
    }

    public int minCount3(int[] coins) {
        int ans = 0;
        for (int coin : coins) {
            ans += ((coin / 2) + (coin & 1));
        }
        return ans;
    }

    public int minCount4(int[] coins) {
        int ans = 0;
        for (int coin : coins) {
            ans += ((coin >> 1) + (coin & 1));
        }
        return ans;
    }


    /**
     * <a href="https://leetcode-cn.com/problems/decode-xored-array/">
     * 未知 整数数组 arr 由 n 个非负整数组成。
     * 经编码后变为长度为 n - 1 的另一个整数数组 encoded ，其中 encoded[i] = arr[i] XOR arr[i + 1] 。例如，arr = [1,0,2,1] 经编码后得到 encoded = [1,2,3] 。
     * 给你编码后的数组 encoded 和原数组 arr 的第一个元素 first（arr[0]）。
     * 请解码返回原数组 arr 。可以证明答案存在并且是唯一的。
     * </a>
     * <p>若a^b=c,则a=b^c</p>
     */
    @Test
    public void decodeTest(){
        int[] encoded = {1,2,3};
        for (int i : decode(encoded, 1)) {
            System.out.println(i);
        }
    }

    public int[] decode(int[] encoded, int first) {
        int[] ans = new int[encoded.length+1];
        ans[0] = first;
        for (int i = 0; i < encoded.length; i++) {
            ans[i+1] = encoded[i] ^ ans[i];
        }
        return ans;
    }

}
