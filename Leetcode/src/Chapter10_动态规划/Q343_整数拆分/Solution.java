package Chapter10_动态规划.Q343_整数拆分;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 18/11/2020 20:31
 **/

public class Solution {
    public int integerBreak(int n) {
        //dp[i]表示把i拆分后能获得的最大乘积
        int[] dp = new int[n+1];
        //当i=1时，表示数字无法拆分，这是该数字能获得最大乘积为1
        dp[1] = 1;
        for(int i = 1; i <= n; i++){
            for(int j = 1; j < i; j++){
                //dp[i-j]*j表示把数字拆成两部分,再把dp[i-j]拆分后能获得的最大乘积
                // j* (i-j)直接把数字拆成两部分，直接求乘积
                //dp[i] = max(dp[i-j]*j, j*(i-j))
                dp[i] = Math.max(dp[i],Math.max(j * (i-j), j * dp[i-j]));
            }
        }
        return dp[n];
    }
}
