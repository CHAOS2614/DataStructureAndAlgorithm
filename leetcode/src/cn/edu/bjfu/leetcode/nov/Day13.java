package cn.edu.bjfu.leetcode.nov;

import java.util.*;

/**
 * @author chaos
 * @date 2021-11-13 11:19
 */
public class Day13 {

    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            int[] chars = new int[26];
            for (int i = 0; i < str.length(); i++) {
                chars[str.charAt(i) - 'a']++;
            }
            String key = Arrays.toString(chars);
            System.out.println(key);
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<>(map.values());
    }
}
