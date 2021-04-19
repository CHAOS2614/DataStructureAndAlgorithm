package cn.edu.bjfu.leetcode.april;

/**
 * @author Chaos
 * @date 2021/4/19
 */
public class Day19 {

    /**
     * <a href="">
     * 有效括号字符串为空("")、"(" + A + ")"或A + B，其中A 和B都是有效的括号字符串，+代表字符串的连接。例如，""，"()"，"(())()"和"(()(()))"都是有效的括号字符串。
     * 如果有效字符串S非空，且不存在将其拆分为S = A+B的方法，我们称其为原语（primitive），其中A 和B都是非空有效括号字符串。
     * 给出一个非空有效字符串S，考虑将其进行原语化分解，使得：S = P_1 + P_2 + ... + P_k，其中P_i是有效括号字符串原语。
     * 对S进行原语化分解，删除分解中每个原语字符串的最外层括号，返回 S。</a>
     */

    public String removeOuterParentheses(String S) {
        int count = 0;
        StringBuilder ans = new StringBuilder();
        int len = S.length();
        for (int i = 0; i < len; i++) {
            char c = S.charAt(i);
            if(c == '('){
                count++;
                if(count > 1){
                    ans.append(c);
                }
            }
            if(c == ')'){
                count--;
                if(count > 0){
                    ans.append(c);
                }
            }
        }
        return ans.toString();

    }
}
