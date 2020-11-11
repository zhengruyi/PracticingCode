package Chapter10_动态规划.Q714_买卖股票的最佳时机含手续费;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 11/11/2020 21:24
 **/

public class Solution {
    public int maxProfit(int[] prices, int fee) {
        if(prices.length == 0){
            return 0;
        }
        // dp[i][k][0] = max(dp[i-1][k][0],dp[i-1][k][1]+prices[i])
        // dp[i][k][1] = max(dp[i-1][k][1],dp[i-1][k-1][0] - prices[i])
        //初始状态dp[-1][k][0] = dp[i][0][0] = 0;
        //dp[-1][k][1] = dp[i][0][1] = Integer.MIN_VALUE;
        //由于有手续费，可以在卖出时减去卖出利润或者在买入时计入买入成本，但这里尤其注意dp1的值可能为Integer.MIN_VALUE
        //为了避免溢出的情况，我们这里选择在买入时增加买入成本
        int dp0 = 0;
        int dp1 = Integer.MIN_VALUE;
        for(int i =0; i< prices.length; i++){
            int tmp = dp0;
            dp0 = Math.max(dp0,dp1 + prices[i]);
            dp1 = Math.max(dp1,tmp - prices[i] -fee);
        }
        return dp0;
    }
}
