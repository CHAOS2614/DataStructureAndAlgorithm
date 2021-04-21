package cn.edu.bjfu.leetcode.april;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Chaos
 * @date 2021/4/21
 */
public class Day21 {

    /**
     * <a href="https://leetcode-cn.com/problems/kth-node-from-end-of-list-lcci/">
     * 实现一种算法，找出单向链表中倒数第 k 个节点。返回该节点的值。</a>
     */
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public int kthToLast(ListNode head, int k) {
        ListNode fast = head;
        ListNode low = head;
        while (k > 0) {
            fast = fast.next;
            k--;
        }
        while (fast != null) {
            fast = fast.next;
            low = low.next;
        }
        return low.val;
    }


    /**
     * <a href="https://leetcode-cn.com/problems/merge-strings-alternately/">
     * 给你两个字符串 word1 和 word2 。请你从 word1 开始，通过交替添加字母来合并字符串。
     * 如果一个字符串比另一个字符串长，就将多出来的字母追加到合并后字符串的末尾。</a>
     */
    public String mergeAlternately(String word1, String word2) {
        int length1 = word1.length();
        int length2 = word2.length();
        int i = 0;
        int j = 0;
        StringBuilder ans = new StringBuilder();
        for (; i < length1 && j < length2; i++, j++) {
            ans.append(word1.charAt(i));
            ans.append(word2.charAt(j));
        }
        if (i < length1) {
            ans.append(word1.substring(i));
        }
        if (j < length2) {
            ans.append(word2.substring(j));
        }
        return ans.toString();
    }


    /**
     * <a href="https://leetcode-cn.com/problems/array-partition-i/">
     * 给定长度为2n的整数数组 nums ，你的任务是将这些数分成n 对,
     * 例如 (a1, b1), (a2, b2), ..., (an, bn) ，使得从 1 到n 的 min(ai, bi) 总和最大。</a>
     */
    public int arrayPairSum(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < len; i += 2) {
            sum += nums[i];
        }
        return sum;
    }


    /**
     * <a href="https://leetcode-cn.com/problems/maximum-product-of-two-elements-in-an-array/">
     * 给你一个整数数组 nums，请你选择数组的两个不同下标 i 和 j，使 (nums[i]-1)*(nums[j]-1) 取得最大值。
     * 请你计算并返回该式的最大值。</a>
     */
    public int maxProduct(int[] nums) {
        int len = nums.length;
        int max = 0;
        int max2 = 0;
        int index = 0;
//        for (int i = 0; i < len; i++) {
//            if (nums[i] > max) {
//                max = nums[i];
//                index = i;
//            }
//        }
//        for (int i = 0; i < len; i++) {
//            if (nums[i] > max2 && i != index) {
//                max2 = nums[i];
//            }
//        }
        for (int num : nums) {
            if (num > max) {
                max2 = max;
                max = num;
            } else if (num > max2) {
                max2 = num;
            }
        }
        return (max - 1) * (max2 - 1);
    }


    /**
     * <a href="">
     * 句子是一个单词列表，列表中的单词之间用单个空格隔开，且不存在前导或尾随空格。每个单词仅由大小写英文字母组成（不含标点符号）。
     * 例如，"HelloWorld"、"HELLO"和"hello world hello world"都是句子。
     * 给你一个句子s和一个整数k，请你将s截断，使截断后的句子仅含前k个单词。返回截断s后得到的句子。
     * <p>
     * 输入：s = "Hello how are you Contestant", k = 4
     * 输出："Hello how are you"
     * 解释：
     * s 中的单词为 ["Hello", "how" "are", "you", "Contestant"]
     * 前 4 个单词为 ["Hello", "how", "are", "you"]
     * 因此，应当返回 "Hello how are you"</a>
     */
    public String truncateSentence(String s, int k) {
        String[] strings = s.split(" ");
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < k - 1; i++) {
            ans.append(strings[i]);
            ans.append(" ");
        }
        ans.append(strings[k - 1]);
        return ans.toString();
    }


    /**
     * <a href="https://leetcode-cn.com/problems/unique-morse-code-words/">
     * 国际摩尔斯密码定义一种标准编码方式，将每个字母对应于一个由一系列点和短线组成的字符串，
     * 比如: "a" 对应 ".-", "b" 对应 "-...", "c" 对应 "-.-.", 等等。</a>
     */
    public int uniqueMorseRepresentations(String[] words) {
        String[] mo = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
        Set<String> set = new HashSet<>();
        for (String word : words) {
            StringBuilder s = new StringBuilder();
            int len = word.length();
            for (int i = 0; i < len; i++) {
                s.append(mo[word.charAt(i) - 'a']);
            }
            set.add(s.toString());
        }
        return set.size();
    }


    /**
     * <a href="https://leetcode-cn.com/problems/to-lower-case/">
     *    实现函数 ToLowerCase()，该函数接收一个字符串参数 str，并将该字符串中的大写字母转换成小写字母，之后返回新的字符串</a>
     */
    public String toLowerCase(String str) {
        //int len = str.length();
        //String s = str.toLowerCase();
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if(chars[i] >= 'A' && chars[i] <= 'Z'){
                chars[i] += 32;
            }
        }
        return new String(chars);
    }


    /**
     * <a href="https://leetcode-cn.com/problems/count-negative-numbers-in-a-sorted-matrix/">
     * 给你一个m * n的矩阵 grid，矩阵中的元素无论是按行还是按列，都以非递增顺序排列。
     * 请你统计并返回 grid 中 负数 的数目。</a>
     */
    public int countNegatives(int[][] grid) {
        int len = grid.length;
        int sum = 0;
        for (int i = 0; i < len; i++) {
            int len2 = grid[i].length;
            if(grid[i][0] < 0) {
                sum += (len - i) * len2;
                break;
            }
            for (int j = 0; j < len2; j++) {
                if(grid[i][j] < 0){
                    sum += len2 - j;
                    break;
                }
            }
        }
        return sum;
    }
}
