package cn.edu.bjfu.leetcode.may;

import java.util.*;

/**
 * @author Chaos
 * @date 2021/5/8
 */
public class Day08 {

    /**
     * <a href="https://leetcode-cn.com/problems/generate-a-string-with-characters-that-have-odd-counts/">
     * 给你一个整数 n，请你返回一个含 n 个字符的字符串，其中每种字符在该字符串中都恰好出现 奇数次 。
     * 返回的字符串必须只含小写英文字母。如果存在多个满足题目要求的字符串，则返回其中任意一个即可。</a>
     */
    public String generateTheString(int n) {
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < n; i++) {
            ans.append('a');
        }
        if ((n & 1) == 0) {
            ans.setCharAt(n - 1, 'b');
        }
        return ans.toString();
    }

    /**
     * <a href="https://leetcode-cn.com/problems/intersection-of-two-arrays/">
     * 给定两个数组，编写一个函数来计算它们的交集。</a>
     *
     * 既然没有用到map里的value，为啥不用set呢
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        List<Integer> ans = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>(Math.max(len1, len2));
        for (int i : nums1) {
            map.put(i, 1);
        }
        for (int i : nums2) {
            if (map.containsKey(i)) {
                ans.add(i);
                map.remove(i);
            }
        }
        int[] ansArray = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            ansArray[i] = ans.get(i);
        }
        return ansArray;
    }

}
