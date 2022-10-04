package cn.edu.bjfu.test;

import java.util.HashSet;
import java.util.Set;

/**
 * @author chaos
 * @date 2022-09-23 19:56
 */
public class Solution {
    // 数字个数
    public static void main(String[] args) {
        String s = "a1b2c3d";
        Set<Character> set = new HashSet<Character>() {
            {
                add('0');add('1');add('2');add('3');
                add('4');add('5');add('6');add('7');
                add('8');add('9');
            }
        };
        char[] chars = s.toCharArray();
        int sum = 0;
        for (int i = 0; i < chars.length; i++) {
            if (set.contains(chars[i])) {
                sum++;
                while (++i < chars.length && set.contains(chars[i])) {
                }
            }
        }
        System.out.println(sum);
    }
}
