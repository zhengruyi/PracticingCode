package Chapter10_动态规划.Q188_买卖股票的最佳时机IV;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 11/11/2020 21:15
 **/

public class Solution {
    public int maxProfit(int K, int[] prices) {
        if(prices.length == 0){
            return 0;
        }
        // dp[i][k][0] = max(dp[i-1][k][0],dp[i-1][k][1]+prices[i])
        // dp[i][k][1] = max(dp[i-1][k][1],dp[i-1][k-1][0] - prices[i])
        //初始状态dp[-1][k][0] = dp[i][0][0] = 0;
        //dp[-1][k][1] = dp[i][0][1] = Integer.MIN_VALUE;
        //最多完成K笔，可以在一天之内完成K笔交易，所以要把所有情况都暴力搜索一遍
        int len  = prices.length;
        int[][][] dp = new int[len+1][K+1][2];
        for(int j = 0; j<= K; j++){
            dp[0][j][0] = 0;
            dp[0][j][1] = Integer.MIN_VALUE;
        }
        for(int i =1; i<= len; i++){
            dp[i][0][0] = 0;
            dp[i][0][1] = Integer.MIN_VALUE;
        }
        //遍历天数和交易笔数
        for(int i =1; i<= len; i++){
            for(int j =1; j <= K; j++){
                dp[i][j][0] = Math.max(dp[i-1][j][0],dp[i-1][j][1] + prices[i-1]);
                dp[i][j][1] = Math.max(dp[i-1][j][1],dp[i-1][j-1][0] - prices[i-1]);
            }
        }
        return dp[len][K][0];
    }
}
