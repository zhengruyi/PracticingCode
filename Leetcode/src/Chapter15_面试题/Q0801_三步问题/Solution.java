package Chapter15_面试题.Q0801_三步问题;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 05/03/2021 22:57
 **/

public class Solution {
    public int waysToStep(int n) {
        int[] dp = new int[n+1];
        //特殊的情况处理一下
        dp[0] = 1;
        for(int i = 1; i <= n; i++){
            //因为三数相加,所以要转化成long来防止溢出
            long i1 = dp[i-1];
            long i2 = i >= 2 ? dp[i-2] : 0;
            long i3 = i >= 3 ? dp[i-3] : 0;
            dp[i] = (int)((i1 + i2 + i3) % 1_000_000_007);
        }
        return dp[n];
    }
}
