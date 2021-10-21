package cn.edu.bjfu.leetcode.oct;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author chaos
 * @date 2021-10-11 9:36
 */
public class Day11 {


    public List<String> letterCombinations(String digits) {
        List<String> results = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return results;
        }
        Map<Character, String> phoneMap = new HashMap<Character, String>(16) {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};

        StringBuffer result = new StringBuffer();
        backtrack(phoneMap, results, digits, 0, result);
        return results;
    }

    private void backtrack(Map<Character, String> phoneMap, List<String> results, String digits, int index, StringBuffer result) {
        if (index == digits.length()) {
            results.add(result.toString());
        } else {
            String s = phoneMap.get(digits.charAt(index));
            for (int i = 0; i < s.length(); i++) {
                result.append(s.charAt(i));
                backtrack(phoneMap, results, digits, index + 1, result);
                result.deleteCharAt(index);
            }
        }
    }

}
