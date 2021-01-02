package Q63_股票的最大利润;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 02/01/2021 23:20
 **/

public class Solution {
    /**
     * 股票问题的通用解法
     * https://labuladong.gitbook.io/algo/di-ling-zhang-bi-du-xi-lie/tuan-mie-gu-piao-wen-ti
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int profit0 = 0;
        int profit1 = Integer.MIN_VALUE;
        for(int price : prices){
            profit0 = Math.max(profit0, profit1 + price);
            profit1 = Math.max(profit1, -price);
        }
        return profit0;
    }
}
