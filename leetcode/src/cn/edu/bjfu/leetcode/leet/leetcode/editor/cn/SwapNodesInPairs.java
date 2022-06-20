package cn.edu.bjfu.leetcode.leet.leetcode.editor.cn;

/**
 * @author Chaos
 * @date 2021-11-23 20:00:51
 */
public class SwapNodesInPairs {
    public static void main(String[] args) {
        Solution solution = new SwapNodesInPairs().new Solution();
    }

    public class ListNode {

        int val;

        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode swapPairs(ListNode head) {
            ListNode preHead = new ListNode();
            preHead.next = head;
            ListNode temp = preHead;
            while (temp.next != null && temp.next.next != null) {
                ListNode left = temp.next;
                ListNode right = temp.next.next;
//                p1.val = p1.val ^ p2.val;
//                p2.val = p1.val ^ p2.val;
//                p1.val = p1.val ^ p2.val;
//                p1 = p2;
                temp.next = right;
                left.next = right.next;
                right.next = left;
                temp = left;

            }
            return preHead.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}