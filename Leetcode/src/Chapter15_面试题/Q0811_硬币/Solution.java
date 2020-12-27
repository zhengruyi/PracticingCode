package Chapter15_面试题.Q0811_硬币;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 27/12/2020 22:55
 **/

public class Solution {
    public int waysToChange(int n) {
        int type = 4;
        int num = 1000000007;
        int[] dp = new int[n+1];
        int[] coins = {25,10,5,1};
        dp[0] = 1;
        //简单动态规划，dp[i][j] = dp[i][j-1] + dp[i-coins[j]][j] if i >= coins[j]
        //这里采用状态压缩来家加快速度节省空间
        for(int j = 0; j < coins.length; j++){
            for(int i = 1; i <= n; i++){
                if(i >= coins[j]){
                    dp[i] = (dp[i] + dp[i - coins[j]])%num;
                }
            }
        }
        return dp[n];
    }
}
