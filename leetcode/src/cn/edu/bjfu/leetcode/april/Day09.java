package cn.edu.bjfu.leetcode.april;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Chaos
 * @date 2021/4/8
 */
public class Day09 {

    public static void main(String[] args) {
        System.out.println("\\ ");
    }


    /**
     * <a href="https://leetcode-cn.com/problems/number-of-good-pairs/">
     * 给你一个整数数组 nums 。
     * 如果一组数字 (i,j) 满足 nums[i] == nums[j] 且 i < j ，就可以认为这是一组 好数对 。
     * 返回好数对的数目。
     * </a>
     */
    @Test
    public void numIdenticalPairsTest() {
        int[] a = {1, 1, 1, 1};
        System.out.println(numIdenticalPairs(a));
    }

    public int numIdenticalPairs(int[] nums) {
        Map<Integer, Integer> m = new HashMap<>(16);
        for (int num : nums) {
            m.put(num, m.getOrDefault(num, 0) + 1);
        }
        int ans = 0;
        for (Map.Entry<Integer, Integer> entry : m.entrySet()) {
            int v = entry.getValue();
            ans += v * (v - 1) / 2;
        }
        return ans;
    }


    /**
     * <a href="https://leetcode-cn.com/problems/kids-with-the-greatest-number-of-candies/">
     * 给你一个数组candies和一个整数extraCandies，其中candies[i]代表第 i 个孩子拥有的糖果数目。
     * 对每一个孩子，检查是否存在一种方案，将额外的extraCandies个糖果分配给孩子们之后，此孩子有 最多的糖果。
     * 注意，允许有多个孩子同时拥有最多的糖果数目。
     * </a>
     */
    @Test
    public void kidsWithCandiesTest() {
        int[] candies = {2, 3, 5, 1, 3};
        System.out.println(kidsWithCandies(candies, 3));
    }

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int maxCandy = 0;
        for (int candy : candies) {
            maxCandy = Math.max(candy, maxCandy);
        }
        List<Boolean> res = new ArrayList<>();
        for (int candy : candies) {
            if ((candy + extraCandies) >= maxCandy) {
                res.add(true);
            } else {
                res.add(false);
            }
        }
        return res;
    }


    /**
     * <a href ="https://leetcode-cn.com/problems/shuffle-the-array/">
     * 给你一个数组 nums ，数组中有 2n 个元素，按 [x1,x2,...,xn,y1,y2,...,yn] 的格式排列。
     * 请你将数组按 [x1,y1,x2,y2,...,xn,yn] 格式重新排列，返回重排后的数组。
     * <p>
     * 思路:
     * 因为题目限制了每一个元素 nums[i] 最大只有可能是 1000，这就意味着每一个元素只占据了 10 个 bit。（2^10 - 1 = 1023 > 1000）
     * 而一个 int 有 32 个 bit，所以我们还可以使用剩下的 22 个 bit 做存储。实际上，每个 int，我们再借 10 个 bit 用就好了。
     * 因此，在下面的代码中，每一个 nums[i] 的最低的十个 bit（0-9 位），我们用来存储原来 nums[i] 的数字；再往前的十个 bit（10-19 位），我们用来存储重新排列后正确的数字是什么。
     * 在循环中，我们每次首先计算 nums[i] 对应的重新排列后的索引 j，之后，取 nums[i] 的低 10 位（nums[i] & 1023），即 nums[i] 的原始信息，把他放到 nums[j] 的高十位上。
     * </p>
     * 最后，每个元素都取高 10 位的信息(e >> 10)，即是答案。
     * </a>
     */
    @Test
    public void shuffleTest() {
        int[] nums = {2, 5, 1, 3, 4, 7};
        int[] shuffle = shuffle(nums, 3);

        for (int j : shuffle) {
            System.out.println(j);
        }
    }

    public int[] shuffle(int[] nums, int n) {

        for (int i = 0; i < 2 * n; i++) {
            int j = i < n ? 2 * i : 2 * (i - n) + 1;
            nums[j] |= (nums[i] & 1023) << 10;
        }
        for (int i = 0; i < 2 * n; i++) {
            nums[i] >>= 10;
        }
        return nums;
    }

    /**
     * <a href="https://leetcode-cn.com/problems/count-items-matching-a-rule/">
     * 给你一个数组 items ，其中items[i] = [type, color, name] ，描述第i件物品的类型、颜色以及名称。
     * 另给你一条由两个字符串ruleKey 和 ruleValue 表示的检索规则。
     * 如果第 i 件物品能满足下述条件之一，则认为该物品与给定的检索规则 匹配 ：
     * ruleKey == "type" 且 ruleValue == type 。
     * ruleKey == "color" 且 ruleValue == color 。
     * ruleKey == "name" 且 ruleValue == name 。
     * 统计并返回 匹配检索规则的物品数量 。
     * </a>
     */
    @Test
    public void countMatchesTest() {

    }

    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int ans = 0;
        if ("type".equals(ruleKey)) {
            ans = (int) items.stream().filter(item -> item.get(0).equals(ruleValue)).count();
        }
        if ("type".equals(ruleKey)) {
            ans = (int) items.stream().filter(item -> item.get(1).equals(ruleValue)).count();
        }
        if ("type".equals(ruleKey)) {
            ans = (int) items.stream().filter(item -> item.get(1).equals(ruleValue)).count();
        }
        return ans;
    }
}
