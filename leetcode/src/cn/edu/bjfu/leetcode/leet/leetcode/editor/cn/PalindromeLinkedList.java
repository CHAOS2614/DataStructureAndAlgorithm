package cn.edu.bjfu.leetcode.leet.leetcode.editor.cn;

/**
 * @author Chaos
 * @date 2022-06-28 16:11:14
 */
public class PalindromeLinkedList {
    public static void main(String[] args) {
        Solution solution = new PalindromeLinkedList().new Solution();
    }

    class ListNode {
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

    class Solution {
        public boolean isPalindrome(ListNode head) {
            int size = 0;
            ListNode p = head;
            while (p != null) {
                size++;
                p = p.next;
            }
            p = head;
            int[] values = new int[size];
            while (p != null) {
                values[--size] = p.val;
                p = p.next;
            }
            int front = 0, back = values.length - 1;
            while (front < back) {
                if (values[front] != values[back]) {
                    return false;
                }
                front++;
                back--;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}