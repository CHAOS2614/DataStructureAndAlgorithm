package cn.edu.bjfu.leetcode.leet.leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Chaos
 * @date 2022-07-21 09:56:46
 */
public class LinkedListCycleIi {
    public static void main(String[] args) {
        Solution solution = new LinkedListCycleIi().new Solution();
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
        public ListNode detectCycleMap(ListNode head) {
            ListNode p = head;
            Set<ListNode> map = new HashSet<>();
            while (p != null) {
                if (map.contains(p)) {
                    return p;
                }
                map.add(p);
                p = p.next;
            }
            return null;
        }

        public ListNode detectCycle(ListNode head) {
            if (head == null) {
                return null;
            }
            ListNode slow = head, fast = head;
            while (fast != null) {
                slow = slow.next;
                if (fast.next != null) {
                    fast = fast.next.next;
                } else {
                    return null;
                }
                if (fast == slow) {
                    ListNode ptr = head;
                    while (ptr != slow) {
                        ptr = ptr.next;
                        slow = slow.next;
                    }
                    return ptr;
                }
            }
            return null;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}