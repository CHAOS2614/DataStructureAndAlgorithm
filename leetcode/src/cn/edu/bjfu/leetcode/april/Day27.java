package cn.edu.bjfu.leetcode.april;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Chaos
 * @date 2021/4/27
 */
public class Day27 {

    /**
     * <a href="https://leetcode-cn.com/problems/make-two-arrays-equal-by-reversing-sub-arrays/">
     * 给你两个长度相同的整数数组target和arr。
     * 每一步中，你可以选择arr的任意 非空子数组并将它翻转。你可以执行此过程任意次。
     * 如果你能让 arr变得与 target相同，返回 True；否则，返回 False 。</a>
     */
    public boolean canBeEqual(int[] target, int[] arr) {
        int length = target.length;
        int[] count = new int[1001];
        for (int i = 0; i < length; i++) {
            count[target[i]]++;
            count[arr[i]]--;
        }
        for (int i : count) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * <a href="https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/">
     * 给定一个 N 叉树，返回其节点值的 前序遍历 。
     * N 叉树 在输入中按层序遍历进行序列化表示，每组子节点由空值 null 分隔（请参见示例）。
     * 进阶：
     * 递归法很简单，你可以使用迭代法完成此题吗?</a>
     */
    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, List<Node> children) {
            this.val = val;
            this.children = children;
        }
    }

    public List<Integer> preorder(Node root) {
        Stack<Node> stack = new Stack<>();
        List<Integer> ans = new ArrayList<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            Node pop = stack.pop();
            if (pop != null) {
                ans.add(pop.val);
                List<Node> children = pop.children;
                Collections.reverse(children);
                stack.addAll(children);
            }
        }
        return ans;
    }


    /**
     * <a href="https://leetcode-cn.com/problems/find-common-characters/">
     * 给定仅有小写字母组成的字符串数组 A，返回列表中的每个字符串中都显示的全部字符（包括重复字符）组成的列表。
     * 例如，如果一个字符在每个字符串中出现 3 次，但不是 4 次，则需要在最终答案中包含该字符 3 次。
     * 你可以按任意顺序返回答案。</a>
     */
    public List<String> commonChars(String[] A) {
        int[] minfreq = new int[26];
        Arrays.fill(minfreq, Integer.MAX_VALUE);
        for (String word : A) {
            int[] freq = new int[26];
            int length = word.length();
            for (int i = 0; i < length; ++i) {
                char ch = word.charAt(i);
                ++freq[ch - 'a'];
            }
            for (int i = 0; i < 26; ++i) {
                minfreq[i] = Math.min(minfreq[i], freq[i]);
            }
        }

        List<String> ans = new ArrayList<String>();
        for (int i = 0; i < 26; ++i) {
            for (int j = 0; j < minfreq[i]; ++j) {
                ans.add(String.valueOf((char) (i + 'a')));
            }
        }
        return ans;
    }


    /**
     * <a href="https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof/">
     * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。</a>
     */
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
    public ListNode reverseList(ListNode head) {
        ListNode listNode = new ListNode(0);
        ListNode p = head;
        while (p != null){
            head = head.next;
            p.next = listNode.next;
            listNode.next = p;
            p = head;
        }
        return listNode.next;
    }
}














