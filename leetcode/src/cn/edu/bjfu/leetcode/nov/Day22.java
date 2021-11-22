package cn.edu.bjfu.leetcode.nov;

/**
 * @author chaos
 * @date 2021-11-22 11:48
 */
public class Day22 {

    /**
     * <a href="https://leetcode-cn.com/problems/edit-distance/">编辑距离</a>
     */
    public int minDistance(String word1, String word2) {

        int length1 = word1.length();
        int length2 = word2.length();

        if (length1 * length2 == 0) {
            return length1 + length2;
        }

        /*
         * 我们有word1和word2，定义dp[i][j]，含义为：word1的前i个字符和word2的前j个字符的编辑距离。
         * 意思就是word1的前i个字符，变成word2的前j个字符，最少需要这么多步。
         */
        int[][] bp = new int[length1 + 1][length2 + 1];

        /*
         * 定理一：如果其中一个字符串是空串，那么编辑距离是另一个字符串的长度。
         * 比如空串“”和“ro”的编辑距离是2（做两次“插入”操作）。再比如"hor"和空串“”的编辑距离是3（做三次“删除”操作）。
         */
        for (int i = 0; i < length1 + 1; i++) {
            bp[i][0] = i;
        }
        for (int i = 0; i < length2 + 1; i++) {
            bp[0][i] = i;
        }

        /*
         * 定理二：当i>0,j>0时（即两个串都不空时）
         * dp[i][j]=min(dp[i-1][j]+1,dp[i][j-1]+1,dp[i-1][j-1]+int(word1[i]!=word2[j]))。
         * 啥意思呢？举个例子，word1 = "abcde", word2 = "fgh",
         * 我们现在算这俩字符串的编辑距离，就是找从word1，最少多少步，能变成word2？那就有三种方式：
         */
        for (int i = 1; i < length1 + 1; i++) {
            for (int j = 1; j < length2 + 1; j++) {
                /*
                 * 知道"abcd"变成"fgh"多少步（假设X步），
                 * 那么从"abcde"到"fgh"就是"abcde"->"abcd"->"fgh"。（一次删除，加X步，总共X+1步）
                 */
                int left = bp[i - 1][j] + 1;

                /*
                 * 知道"abcde"变成“fg”多少步（假设Y步），
                 * 那么从"abcde"到"fgh"就是"abcde"->"fg"->"fgh"。（先Y步，再一次添加，加X步，总共Y+1步）
                 */
                int right = bp[i][j - 1] + 1;

                /*
                 * 知道"abcd"变成“fg”多少步（假设Z步），
                 * 那么从"abcde"到"fgh"就是"abcde"->"fge"->"fgh"。
                 * （先不管最后一个字符，把前面的先变好，用了Z步，然后把最后一个字符给替换了。这里如果最后一个字符碰巧就一样，那就不用替换，省了一步）
                 */
                int change = bp[i - 1][j - 1];
                if (word1.charAt(i - 1) != word2.charAt(j - 1)) {
                    change += 1;
                }
                bp[i][j] = Math.min(left, Math.min(right, change));
            }
        }
        return bp[length1][length2];
    }
}
