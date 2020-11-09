package Chapter10_动态规划.Q1230_抛硬币;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 10/11/2020 00:42
 **/

public class Solution {
    public double probabilityOfHeads(double[] prob, int target) {
        int len = prob.length;
        double[][] dp = new double[len+1][target+1];
        dp[0][0] = 1;
        for(int i = 1; i <= len; i++){
            dp[i][0] = dp[i-1][0] * (1 - prob[i-1]);
        }
        for(int i = 1; i<= len; i++){
            for(int j = 1; j<= target; j++){
                dp[i][j] = dp[i-1][j] * (1-prob[i-1]) + dp[i-1][j-1] * prob[i-1];
            }
        }
        return dp[len][target];
    }
}
