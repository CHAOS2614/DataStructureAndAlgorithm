package cn.edu.bjfu.leetcode.leet.leetcode.editor.cn;

/**
 * @author Chaos
 * @date 2022-06-28 10:12:35
 */
public class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        Solution solution = new BestTimeToBuyAndSellStock().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProfit(int[] prices) {
            if(prices == null || prices.length <= 1){
                return 0;
            }
            int min = prices[0];
            int maxProfit = 0;
            for (int price : prices) {
                if(min > price){
                    min = price;
                }
                if(price - min > maxProfit){
                    maxProfit = price - min;
                }
            }
            return maxProfit;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}