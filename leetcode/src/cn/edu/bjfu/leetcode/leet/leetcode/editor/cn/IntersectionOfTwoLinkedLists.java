package cn.edu.bjfu.leetcode.leet.leetcode.editor.cn;

/**
 * @author Chaos
 * @date 2022-06-28 11:02:55
 */
public class IntersectionOfTwoLinkedLists {
    public static void main(String[] args) {
        Solution solution = new IntersectionOfTwoLinkedLists().new Solution();
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            if (headA == null || headB == null) {
                return null;
            }
            ListNode p = headA, q;
            int m = 0, n = 0, diff;
            while (p != null) {
                m++;
                p = p.next;
            }
            p = headB;
            while (p != null) {
                n++;
                p = p.next;
            }
            if (m > n) {
                p = headA;
                q = headB;
                diff = m - n;
            } else {
                p = headB;
                q = headA;
                diff = n - m;
            }

            while (diff > 0) {
                p = p.next;
                diff--;
            }
            while (p != null && q != null) {
                if (p == q) {
                    return p;
                }
                p = p.next;
                q = q.next;
            }
            return null;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}