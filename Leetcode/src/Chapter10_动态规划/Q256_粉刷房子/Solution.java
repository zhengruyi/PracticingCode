package Chapter10_动态规划.Q256_粉刷房子;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 07/11/2020 18:58
 **/

public class Solution {
    public int minCost(int[][] costs) {
        if(costs.length == 0){
            return 0;
        }
        int len = costs.length;
        //dp[i][0]从0..i且最后一栋房子为红色时需要的最小花费
        //dp[i][1]从0..i且最后一栋房子为蓝色时需要的最小花费
        //dp[i][2]从0..i且最后一栋房子为绿色时需要的最小花费
        int[][] dp = new int[len+1][3];
        for(int i = 1; i <= len; i++){
            dp[i][0] = costs[i-1][0] + Math.min(dp[i-1][1],dp[i-1][2]);
            dp[i][1] = costs[i-1][1] + Math.min(dp[i-1][0],dp[i-1][2]);
            dp[i][2] = costs[i-1][2] + Math.min(dp[i-1][0],dp[i-1][1]);
        }
        //最后结果是最后一种房子的三种颜色的最小值
        return Math.min(dp[len][0],Math.min(dp[len][1],dp[len][2]));
    }
}
