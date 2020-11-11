package Chapter10_动态规划.Q309_最佳买卖股票时机含冷冻期;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 11/11/2020 21:22
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
        //由于含有冷冻期，所以dp1的购买状态只能从i-2处才有可能
        int dp0 = 0;
        int dp1 = Integer.MIN_VALUE;
        int dp20 = 0;
        for(int i =0; i< prices.length; i++){
            int tmp = dp0;
            dp0 = Math.max(dp0,dp1+prices[i]);
            dp1 = Math.max(dp1,dp20 - prices[i]);
            dp20 = tmp;
        }
        return dp0;
    }
}
