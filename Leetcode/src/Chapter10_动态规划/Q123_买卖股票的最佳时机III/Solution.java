package Chapter10_动态规划.Q123_买卖股票的最佳时机III;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 11/11/2020 21:12
 **/

public class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length == 0){
            return 0;
        }
        // dp[i][k][0] = max(dp[i-1][k][0],dp[i-1][k][1]+prices[i])
        // dp[i][k][1] = max(dp[i-1][k][1],dp[i-1][k-1][0] - prices[i])
        //初始状态dp[-1][k][0] = dp[i][0][0] = 0;
        //dp[-1][k][1] = dp[i][0][1] = Integer.MIN_VALUE;
        //由于最多完成两笔交易，所以有可能会在一天内完成两笔，所以需要把两个情况都列出来考虑
        int dp20 = 0;
        int dp21 = Integer.MIN_VALUE;
        int dp10 = 0;
        int dp11 = Integer.MIN_VALUE;
        for(int i =0; i < prices.length; i++){
            dp20 = Math.max(dp20,dp21+prices[i]);
            dp21 = Math.max(dp21,dp10 - prices[i]);
            dp10 = Math.max(dp10,dp11 + prices[i]);
            dp11 = Math.max(dp11,-prices[i]);
        }
        return dp20;
    }
}
