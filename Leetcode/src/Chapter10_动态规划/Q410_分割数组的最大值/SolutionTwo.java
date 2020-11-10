package Chapter10_动态规划.Q410_分割数组的最大值;

import java.util.Arrays;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 10/11/2020 22:16
 **/

public class SolutionTwo {
    public int splitArray(int[] nums, int m) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int n = nums.length;
        int[] sum = new int[n+1];
        //前缀和，用来求子数组的区间和
        for(int i =0; i < n; i++){
            sum[i+1] = sum[i] + nums[i];
        }
        int[][] dp = new int[n+1][m+1];
        //初始化为最大值
        for(int i =0; i <= n; i++){
            Arrays.fill(dp[i],Integer.MAX_VALUE);
        }
        //初始状态
        dp[0][0] = 0;
        for(int i = 1; i<= n; i++){
            for(int j = 1; j <= Math.min(i,m); j++){
                for(int k = 0; k < i; k++){
                    dp[i][j] = Math.min(dp[i][j],Math.max(dp[k][j-1],sum[i] - sum[k]));
                }
            }
        }
        return dp[n][m];
    }
}
