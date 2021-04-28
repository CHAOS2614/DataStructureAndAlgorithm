package cn.edu.bjfu.leetcode.april;

import java.util.Arrays;

/**
 * @author Chaos
 * @date 2021/4/28
 */
public class Day28 {


    /**
     * <a href="https://leetcode-cn.com/problems/reverse-words-in-a-string-iii/">
     * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。</a>
     */
    public String reverseWords(String s) {
        StringBuilder ans = new StringBuilder();
        String[] strings = s.split(" ");
        for (int i = 0; i < strings.length - 1; i++) {
            StringBuilder stringBuilder = new StringBuilder(strings[i]);
            ans.append(stringBuilder.reverse().toString()).append(" ");
        }
        StringBuilder stringBuilder = new StringBuilder(strings[strings.length - 1]);
        ans.append(stringBuilder.reverse().toString());
        return ans.toString();
    }
}
