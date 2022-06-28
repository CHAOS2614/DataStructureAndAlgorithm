package cn.edu.bjfu.leetcode.leet.leetcode.editor.cn;

/**
 * @author Chaos
 * @date 2022-06-28 10:30:22
 */
public class LinkedListCycle {
    public static void main(String[] args) {
        Solution solution = new LinkedListCycle().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public class Solution {
        public boolean hasCycle(ListNode head) {
           /* ListNode p = head;
            while (p != null){
                if(p.val == Integer.MAX_VALUE){
                    return true;
                }
                p.val = Integer.MAX_VALUE;
                p = p.next;
            }
            return false;*/if (head == null || head.next == null) {
                return false;
            }
            ListNode slow = head;
            ListNode fast = head.next;
            while (slow != fast) {
                if (fast == null || fast.next == null) {
                    return false;
                }
                slow = slow.next;
                fast = fast.next.next;
            }
            return true;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}