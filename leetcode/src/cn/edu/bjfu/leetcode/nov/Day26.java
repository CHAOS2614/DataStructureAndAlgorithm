package cn.edu.bjfu.leetcode.nov;

/**
 * @author chaos
 * @date 2021-11-26 10:02
 */
public class Day26 {

    /**
     * <a href="https://leetcode-cn.com/problems/minimum-window-substring/">最小覆盖子串</a>
     */
    public String minWindow(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();

        // 存储t中各个字符出现的次数
        int[] need = new int[127];
        // 存储s中滑动窗口中所含t中相应字符出现次数
        int[] have = new int[127];

        // 初始化need
        char[] chars = t.toCharArray();
        for (char aChar : chars) {
            need[aChar]++;
        }

        // 最小覆盖子串起点
        int start = 0;
        // 是否中所有字符在当前窗口中都包含了
        int count = 0;
        // 目前为止最小的覆盖子串
        int min = sLen + 1;
        // 左指针
        int left = 0;
        // 右指针
        int right = 0;

        // 开始滑动
        while (right < sLen) {

            char r = s.charAt(right);

            // 右指针字符是t中不包含的，直接右指针右移，本次循环结束
            if (need[r] == 0) {
                right++;
                continue;
            }

            // t中包含r，且滑动窗口中r的数量小于t中的数量，count才++，
            // 因为窗口中r的数量大于或等于t中数量，对于count并没影响
            if (have[r] < need[r]) {
                count++;
            }


            have[r]++;
            right++;

            // 如果保持窗口是覆盖子串，左指针右移
            while (count == tLen) {

                // 当前窗口小于最小覆盖子串，更新
                if (right - left < min) {
                    min = right - left;
                    start = left;
                }

                char l = s.charAt(left);

                // 如果t中没有l字符，则跳出本次循环
                if (need[l] == 0) {
                    left++;
                    continue;
                }

                // 如果窗口中l数量等于t中数量，-1
                // 如果数量大于t中数量，则不用-1，因为还符合覆盖子串
                if (have[l] == need[l]) {
                    count--;
                }
                have[l]--;
                left++;
            }

        }
        if (min == sLen + 1) {
            return "";
        }
        return s.substring(start, start + min);
    }


}
