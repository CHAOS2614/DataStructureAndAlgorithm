package cn.edu.bjfu.leetcode.sep;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chaos
 * @date 2021-09-18 15:55
 */
public class Day18 {

    /**
     * <a href="https://leetcode-cn.com/problems/two-sum/">两数之和</a>
     * 给定一个整数数组 nums和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那个整数，并返回它们的数组下标
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现
     * 你可以按任意顺序返回答案。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/two-sum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int key = target - nums[i];
            if (map.containsKey(nums[i])) {
                res[0] = map.get(key);
                res[1] = i;
                break;
            } else {
                map.put(key, i);
            }
        }
        return res;
    }


    /**
     * <a href="https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/">无重复字符的最长子串</a>
     */
    public int lengthOfLongestSubstring(String s) {
        /*
        次左指针右移一位，移除set的一个字符，这一步会导致很多无用的循环。while循环发现的重复字符不一定就是Set最早添加那个，
        还要好多次循环才能到达，这些都是无效循环，不如直接用map记下每个字符的索引，直接进行跳转
         */
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0, start = 0;
        for (int end = 0; end < s.length(); end++) {
            char ch = s.charAt(end);
            if (map.containsKey(ch)) {
                /*
                因为并没有删除map中旧start-新start之间的值，所以可能这个ch是不是在窗口内的，这一步是必要的，map.get(ch) + 1不一定大于start
                 */
                start = Math.max(map.get(ch) + 1, start);
            }
            max = Math.max(max, end - start + 1);
            map.put(ch, end);
        }
        return max;
    }

    @Test
    public void lengthOfLongestSubstringTest() {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }


}
