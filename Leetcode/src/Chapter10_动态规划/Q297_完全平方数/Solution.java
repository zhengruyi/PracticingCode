package Chapter10_动态规划.Q297_完全平方数;

import java.util.Arrays;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 18/11/2020 20:21
 **/

public class Solution {
    public int numSquares(int n) {
        //计算上限，用来表示 len * len > n
        int len = (int)Math.sqrt(n) + 1;
        int[] nums = new int[len+1];
        //提前计算平方数数组
        for(int i =1; i <= len; i++){
            nums[i] = i * i;
        }
        //申请dp数组，dp[i]表示表示i最少需要多少个平方数
        int[] dp = new int[n+1];
        //提前填充最大值，这里不能用Integer.MAX_VALUE,因为后面仍然会加1
        Arrays.fill(dp,n+1);
        dp[0] = 0;
        for(int i = 1; i<=n; i++){
            for(int j =0; j <= len; j++){
                if(i < nums[j]){
                    break;
                }
                //dp[i] = min(dp[i],dp[i-nums[j]]+1)
                dp[i] = Math.min(dp[i],dp[i-nums[j]]+1);
            }
        }
        return dp[n];
    }
}
