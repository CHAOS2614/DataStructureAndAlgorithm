package cn.edu.bjfu.leetcode.april;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Chaos
 * @date 2021/4/19
 */
public class Day19 {

    /**
     * <a href="https://leetcode-cn.com/problems/remove-outermost-parentheses/">
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
            if (c == '(') {
                count++;
                if (count > 1) {
                    ans.append(c);
                }
            }
            if (c == ')') {
                count--;
                if (count > 0) {
                    ans.append(c);
                }
            }
        }
        return ans.toString();
    }


    /**
     * <a href="https://leetcode-cn.com/problems/destination-city/">
     * 给你一份旅游线路图，该线路图中的旅行线路用数组 paths 表示，其中 paths[i] = [cityAi, cityBi] 表示该线路将会从 cityAi 直接前往 cityBi 。请你找出这次旅行的终点站，即没有任何可以通往其他城市的线路的城市。
     * 题目数据保证线路图会形成一条不存在循环的线路，因此只会有一个旅行终点站。</a>
     */
    public String destCity(List<List<String>> paths) {
        Map<String, String> map = new HashMap<>(16);
        for (List<String> path : paths) {
            map.put(path.get(0), path.get(1));
        }
        String key = paths.get(0).get(0);
        while (map.containsKey(key)) {
            key = map.get(key);
        }
        return key;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }
        TreeNode node = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(node);
        return root;
    }

}
