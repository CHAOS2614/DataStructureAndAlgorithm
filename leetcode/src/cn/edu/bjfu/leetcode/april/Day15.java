package cn.edu.bjfu.leetcode.april;

import org.junit.Test;

/**
 * @author Chaos
 * @date 2021/4/15
 */
public class Day15 {

    /**
     * <a href="https://leetcode-cn.com/problems/nGK0Fy/">
     * 小扣在秋日市集发现了一款速算机器人。店家对机器人说出两个数字（记作 x 和 y），请小扣说出计算指令：
     * "A" 运算：使 x = 2 * x + y；
     * "B" 运算：使 y = 2 * y + x。
     * 在本次游戏中，店家说出的数字为 x = 1 和 y = 0，小扣说出的计算指令记作仅由大写字母 A、B 组成的字符串 s，字符串中字符的顺序表示计算顺序，请返回最终 x 与 y 的和为多少。</a>
     */
    public int calculate(String s) {
        int x = 1;
        int y = 0;
        int len = s.length();

        for (int i = 0; i < len; i++) {
            switch (s.charAt(i)) {
                case 'A':
                    x = 2 * x + y;
                    break;
                case 'B':
                    y = 2 * y + x;
                    break;
                default:
                    return 0;
            }
        }
        return x + y;
    }

    /**
     * <a href="https://leetcode-cn.com/problems/split-a-string-in-balanced-strings/">
     * 在一个 平衡字符串 中，'L' 和 'R' 字符的数量是相同的。
     * 给你一个平衡字符串s，请你将它分割成尽可能多的平衡字符串。
     * 注意：分割得到的每个字符串都必须是平衡字符串。
     * 返回可以通过分割得到的平衡字符串的最大数量 。</a>
     */
    public int balancedStringSplit(String s) {
        int len = s.length();
        int ans = 0;
        int sum = 0;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == 'L') {
                sum++;
            }
            if (s.charAt(i) == 'R') {
                sum--;
            }
            if (sum == 0) {
                ans++;
            }
        }
        return ans;
    }


    /**
     * <a href="">
     * 给定一个二进制矩阵A，我们想先水平翻转图像，然后反转图像并返回结果。
     * 水平翻转图片就是将图片的每一行都进行翻转，即逆序。例如，水平翻转[1, 1, 0]的结果是[0, 1, 1]。
     * 反转图片的意思是图片中的0全部被1替换，1全部被0替换。例如，反转[0, 1, 1]的结果是[1, 0, 0]。</a>
     */
    public int[][] flipAndInvertImage(int[][] image) {
        int imageLen = image.length;
        for (int i = 0; i < imageLen; i++) {
            int len = image[i].length;
            for (int j = 0; j < (len / 2); j++) {
                int temp = image[i][j];
                image[i][j] = image[i][len - 1 - j] == 0 ? 1 : 0;
                image[i][len - 1 - j] = temp == 0 ? 1 : 0;
            }
            if ((len % 2) == 1) {
                image[i][len / 2] = image[i][len / 2] == 0 ? 1 : 0;
            }
        }
        return image;
    }


    /**
     * <a href="https://leetcode-cn.com/problems/increasing-decreasing-string/">
     * 从 s中选出 最小的字符，将它 接在结果字符串的后面。
     * 从 s剩余字符中选出最小的字符，且该字符比上一个添加的字符大，将它 接在结果字符串后面。
     * 重复步骤 2 ，直到你没法从 s中选择字符。
     * 从 s中选出 最大的字符，将它 接在结果字符串的后面。
     * 从 s剩余字符中选出最大的字符，且该字符比上一个添加的字符小，将它 接在结果字符串后面。
     * 重复步骤 5，直到你没法从 s中选择字符。
     * 重复步骤 1 到 6 ，直到 s中所有字符都已经被选过。</a>
     */

    public String sortString(String s) {
        int[] words = new int[26];
        int len = s.length();
        for (int i = 0; i < len; i++) {
            words[s.charAt(i) - 'a']++;
        }
        StringBuilder ans = new StringBuilder();
        while (ans.length() < len) {
            for (int i = 0; i < 26; i++) {
                if (words[i] > 0) {
                    ans.append((char) (i + 'a'));
                    words[i]--;
                }
            }
            for (int i = 25; i >= 0; i--) {
                if (words[i] > 0) {
                    ans.append((char) (i + 'a'));
                    words[i]--;
                }
            }
        }
        return ans.toString();
    }


    /**
     * <a href="https://leetcode-cn.com/problems/hamming-distance/">
     * 两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
     * 给出两个整数 x 和 y，计算它们之间的汉明距离。</a>
     *
     * <a href="https://blog.csdn.net/u012604810/article/details/80623241">
     * Integer.bitCount源码那些奇怪的数字</a>
     */
    public int hammingDistance(int x, int y) {
        int xor = x ^ y;
        int ans = 0;
        while (xor != 0) {
            ans += (xor & 1);
            xor = xor >> 1;
        }
        return ans;
        //return Integer.bitCount(x ^ y);
    }


    /**
     * <a href="">
     * 给你一个偶数长度的字符串 s 。将其拆分成长度相同的两半，前一半为 a ，后一半为 b 。
     * 两个字符串 相似 的前提是它们都含有相同数目的元音（'a'，'e'，'i'，'o'，'u'，'A'，'E'，'I'，'O'，'U'）。注意，s 可能同时含有大写和小写字母。
     * 如果 a 和 b 相似，返回 true ；否则，返回 false 。</a>
     */
    @Test
    public void halvesAreAlikeTest() {
        System.out.println(halvesAreAlike("aaaeee"));
    }

    public boolean halvesAreAlike(String s) {
        int len = s.length();
        int num = 0;
        for (int i = 0; i < len / 2; i++) {
            char c = s.charAt(i);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
                num++;
            }
        }
        for (int i = len / 2; i < len; i++) {
            char c = s.charAt(i);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
                num--;
            }
        }
        return num == 0;
    }
}
