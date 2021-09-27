package cn.edu.bjfu.leetcode.sep;

import org.junit.Test;

import java.util.Stack;
import java.util.Vector;

/**
 * @author chaos
 * @date 2021-09-22 15:27
 */
public class Day22 {

    public boolean isValid(String s) {
        if (s == null || (s.length() & 1) == 1) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if (aChar == ')') {
                if (stack.isEmpty() || stack.pop() != '(') {
                    return false;
                }
                continue;
            }
            if (aChar == ']') {
                if (stack.isEmpty() || stack.pop() != '[') {
                    return false;
                }
                continue;
            }
            if (aChar == '}') {
                if (stack.isEmpty() || stack.pop() != '{') {
                    return false;
                }
                continue;
            }
            stack.push(aChar);
        }
        return stack.isEmpty();
    }

    @Test
    public void isValidTest() {
        System.out.println(isValid("{[]}"));
        Vector v;
        byte b1 = 3, b2 = 4;
        int i = b1 + b2;
        short s1 = 1,s2 = 2;
        int i1 = s1 + s2;
        int i2 = 'a' + 'b';
    }

}
