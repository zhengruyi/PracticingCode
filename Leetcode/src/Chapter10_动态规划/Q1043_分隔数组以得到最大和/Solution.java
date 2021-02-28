package Chapter10_动态规划.Q1043_分隔数组以得到最大和;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 28/02/2021 23:32
 **/

public class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        //dp[i]表示从0..i-1的划分能得到的最大值
        int[] dp = new int[n+1];
        for(int i = 0; i <= n; i++){
            //此时dp[i]等于0
            int max = dp[i];
            //创建变量用来搜索
            int j = i - 1;
            //当前往左搜索k位,取分割方法的最大值
            while((i - j) <= k && j >= 0){
                max = Math.max(max,arr[j]);
                dp[i] = Math.max(dp[i],dp[j] + (i - j) * max);
                j--;
            }
        }
        return dp[n];
    }
}
