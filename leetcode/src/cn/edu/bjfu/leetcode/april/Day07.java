package cn.edu.bjfu.leetcode.april;

/**
 * @author Chaos
 * @date 2021/4/7
 *
 * <a href="https://leetcode-cn.com/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof/">字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。
 * 比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。</a>
 */
public class Day07 {

    public static void main(String[] args) {

        String s = "av";
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

}
