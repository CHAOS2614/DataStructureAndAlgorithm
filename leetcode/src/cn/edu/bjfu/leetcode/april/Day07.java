package cn.edu.bjfu.leetcode.april;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Chaos
 * @date 2021/4/7
 */
public class Day07 {

    /**
     * <a href="https://leetcode-cn.com/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof/">字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。
     * 比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。</a>
     */
    @Test
    public void reverseLeftWordsTest() {
        String s = "chaos";
        System.out.println(reverseLeftWords(s, 1));
    }

    public static String reverseLeftWords(String s, int n) {
        if (s.length() <= 1 || n >= s.length()) {
            return s;
        }
        String s1 = reverse(s.substring(0, n));
        String s2 = reverse(s.substring(n));
        return reverse((s1 + s2));

    }

    private static String reverse(String s) {
        if (s.length() <= 1) {
            return s;
        }
        return new StringBuilder(s).reverse().toString();
    }

    /**
     * <a href="https://leetcode-cn.com/problems/jewels-and-stones/">给定字符串J代表石头中宝石的类型，和字符串S代表你拥有的石头。S中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。
     * J中的字母不重复，J和S中的所有字符都是字母。字母区分大小写，因此"a"和"A"是不同类型的石头。</a>
     *
     * 暴力求解和哈希方法
     */
    @Test
    public void numJewelsInStonesTest() {
        String J = "aA";
        String S = "aAAAbbbb";
        System.out.println(numJewelsInStones(J,S));
    }

    public int numJewelsInStones(String jewels, String stones) {
        int jewelsLength = jewels.length();
        int stonesLength = stones.length();
        int jewelsCount = 0;
        Set<Character> jewelsSet = new HashSet<>();
        for (int i = 0; i < jewelsLength; i++) {
            jewelsSet.add(jewels.charAt(i));
        }
        for (int i = 0; i < stonesLength; i++) {
            if (jewelsSet.contains(stones.charAt(i))) {
                jewelsCount++;
            }
        }
        return jewelsCount;
    }
}
