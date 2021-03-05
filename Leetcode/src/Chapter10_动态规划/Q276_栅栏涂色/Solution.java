package Chapter10_动态规划.Q276_栅栏涂色;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 05/03/2021 23:29
 **/

public class Solution {
    /**
     * 如果当前选择的颜色和前一个不一样,那么总共有dp[i-1] * (k-1)
     * 如果当前的颜色和前面一样,那么就有dp[i-2] * 1 * (k-1)
     * 所以dp[i] = dp[i-1] * (k-1) + dp[i-2] * 1 * (k-1)
     * 特别的dp[1] = k, dp[2] = k * k
     * @param n
     * @param k
     * @return
     */
    public int numWays(int n, int k) {
        if(n == 1){
            return k;
        }else if(n == 2){
            return k * k;
        }
        int[] dp = new int[n+1];
        dp[1] = k;
        dp[2] = k * k;
        for(int i = 3; i <= n; i++){
            dp[i] = dp[i-1] * (k-1) + dp[i-2] * 1 * (k-1);
        }
        return dp[n];
    }
}
