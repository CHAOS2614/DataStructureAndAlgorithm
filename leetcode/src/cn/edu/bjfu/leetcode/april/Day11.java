package cn.edu.bjfu.leetcode.april;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Chaos
 * @date 2021/4/11
 */
public class Day11 {

    /**
     * <a href="https://leetcode-cn.com/problems/subtract-the-product-and-sum-of-digits-of-an-integer/">
     * 给你一个整数 n，请你帮忙计算并返回该整数「各位数字之积」与「各位数字之和」的差。
     * </a>
     */
    @Test
    public void subtractProductAndSumTest() {
        System.out.println(subtractProductAndSum(4421));
    }

    public int subtractProductAndSum(int n) {

        int product = 1;
        int sum = 0;
        int remainder;
        while (n > 0) {
            remainder = n % 10;
            product *= remainder;
            sum += remainder;
            n /= 10;
        }
        return product - sum;

    }


    /**
     * <a href="https://leetcode-cn.com/problems/create-target-array-in-the-given-order/">
     * 给你两个整数数组 nums 和 index。你需要按照以下规则创建目标数组：
     * 目标数组 target 最初为空。
     * 按从左到右的顺序依次读取 nums[i] 和 index[i]，在 target 数组中的下标 index[i] 处插入值 nums[i] 。
     * 重复上一步，直到在 nums 和 index 中都没有要读取的元素。
     * 请你返回目标数组。
     * 题目保证数字插入位置总是存在。
     * </a>
     * <a href="https://www.cnblogs.com/better-farther-world2099/articles/11995176.html">
     * 关于数组向后移动
     * </a>
     */
    @Test
    public void createTargetArrayTest() {
        int[] nums = {0, 1, 2, 3, 4}, index = {0, 1, 2, 2, 1};
        for (int i : createTargetArray(nums, index)) {
            System.out.println(i);
        }
    }

    public int[] createTargetArray(int[] nums, int[] index) {
        int len = index.length;
        int[] ans = new int[len];
        for (int i = 0; i < len; i++) {
            if (len - 1 - index[i] >= 0) {
                System.arraycopy(ans, index[i], ans, index[i] + 1, len - 1 - index[i]);
            }
            ans[index[i]] = nums[i];
        }
        return ans;
    }


    /**
     * <a href="">
     * 给你一个以行程长度编码压缩的整数列表nums。
     * 考虑每对相邻的两个元素 [freq, val] = [nums[2*i], nums[2*i+1]]（其中i >= 0），每一对都表示解压后子列表中有 freq个值为val的元素，你需要从左到右连接所有子列表以生成解压后的列表。
     * 请你返回解压后的列表。
     * 示例 1：
     * 输入：nums = [1,2,3,4]
     * 输出：[2,4,4,4]
     * 解释：第一对 [1,2] 代表着 2 的出现频次为 1，所以生成数组 [2]。
     * 第二对 [3,4] 代表着 4 的出现频次为 3，所以生成数组 [4,4,4]。
     * 最后将它们串联到一起 [2] + [4,4,4] = [2,4,4,4]。
     * </a>
     */
    @Test
    public void decompressRLElistTest() {
        int[] nums = {1, 1, 2, 3};
        for (int i : decompressRLElist(nums)) {
            System.out.println(i);
        }
    }

    public int[] decompressRLElist(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i += 2) {
            for (int j = 0; j < nums[i]; j++) {
                list.add(nums[i + 1]);
            }
        }
        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }


    /**
     * <a href="https://leetcode-cn.com/problems/how-many-numbers-are-smaller-than-the-current-number/">
     * 给你一个数组nums，对于其中每个元素nums[i]，请你统计数组中比它小的所有数字的数目。
     * 换而言之，对于每个nums[i]你必须计算出有效的j的数量，其中 j 满足j != i 且 nums[j] < nums[i]。
     * 以数组形式返回答案。</a>
     */
    @Test
    public void smallerNumbersThanCurrentTest() {
        int[] nums = {37, 64, 63, 2, 41, 78, 51, 36, 2, 20, 25, 41, 72, 100, 17, 43, 54, 27, 34, 86, 12, 48, 70, 44, 87, 68, 62, 98, 68, 30, 8, 92, 5, 10};
        for (int i : smallerNumbersThanCurrent(nums)) {
            System.out.println(i);
        }
    }

    public int[] smallerNumbersThanCurrent(int[] nums) {
        int len = nums.length;
        int[] hash = new int[101];
        for (int num : nums) {
            hash[num]++;
        }
        int[] ans = new int[len];
        /*for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i]; j++) {
                ans[i] += hash[j];
            }
        }*/

        for (int i = 0; i < 100; i++) {
            hash[i + 1] += hash[i];
        }
        for (int i = 0; i < len; i++) {
            //注意数组下标越界
            ans[i] = nums[i] == 0 ? 0 : hash[nums[i] - 1];
        }
        return ans;
    }


    /**
     * <a href="https://leetcode-cn.com/problems/count-the-number-of-consistent-strings/">
     * 给你一个由不同字符组成的字符串allowed和一个字符串数组words。如果一个字符串的每一个字符都在 allowed中，就称这个字符串是 一致字符串 。
     * 请你返回words数组中一致字符串的数目.
     * 示例 1：
     * 输入：allowed = "ab", words = ["ad","bd","aaab","baa","badab"]
     * 输出：2
     * 解释：字符串 "aaab" 和 "baa" 都是一致字符串，因为它们只包含字符 'a' 和 'b' 。
     * </a>
     */
    @Test
    public void countConsistentStringsTest() {
        String allowed = "abc";
        String[] words = {"a", "b", "c", "ab", "ac", "bc", "abc"};
        System.out.println(countConsistentStrings(allowed, words));
    }

    public int countConsistentStrings(String allowed, String[] words) {
        int[] a2z = new int[26];
        int allowedLen = allowed.length();
        for (int i = 0; i < allowedLen; i++) {
            a2z[allowed.charAt(i) - 'a']++;
        }
        int ans = 0;
        for (String word : words) {
            int wordLen = word.length();
            int index = 0;
            for (; index < wordLen; index++) {
                if (a2z[word.charAt(index) - 'a'] == 0) {
                    break;
                }
            }
            if (index == wordLen) {
                ans++;
            }
        }
        return ans;
    }


    /**
     * 如果字符串满足以下条件之一，则可以称之为 有效括号字符串（valid parentheses string，可以简写为 VPS）：
     * 字符串是一个空字符串 ""，或者是一个不为 "(" 或 ")" 的单字符。
     * 字符串可以写为 AB（A 与 B字符串连接），其中 A 和 B 都是 有效括号字符串 。
     * 字符串可以写为 (A)，其中 A 是一个 有效括号字符串 。
     * 类似地，可以定义任何有效括号字符串S 的 嵌套深度 depth(S)：
     * depth("") = 0
     * depth(C) = 0，其中 C 是单个字符的字符串，且该字符不是 "(" 或者 ")"
     * depth(A + B) = max(depth(A), depth(B))，其中 A 和 B 都是 有效括号字符串
     * depth("(" + A + ")") = 1 + depth(A)，其中 A 是一个 有效括号字符串
     * 例如：""、"()()"、"()(()())" 都是 有效括号字符串（嵌套深度分别为 0、1、2），而 ")(" 、"(()" 都不是 有效括号字符串 。
     * 给你一个 有效括号字符串 s，返回该字符串的 s 嵌套深度 。
     */
    @Test
    public void maxDepthTest() {
        System.out.println(maxDepth("(1)+((2))+(((3)))"));
    }

    public int maxDepth(String s) {
        int ans = 0;
        int count = 0;
        char[] chars = s.toCharArray();
        int len = chars.length;
        for (char aChar : chars) {
            if (aChar == '(') {
                count++;
            }
            if (aChar == ')') {
                count--;
            }
            ans = Math.max(ans, count);
        }
        return ans;
    }
}
