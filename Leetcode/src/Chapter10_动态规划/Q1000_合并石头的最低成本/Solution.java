package Chapter10_动态规划.Q1000_合并石头的最低成本;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 27/11/2020 21:42
 **/

public class Solution {
    public int mergeStones(int[] stones, int k) {
        int max = 10000_0000;
        int n = stones.length;
        //有最后一堆石头必定会由k堆合并过来，这样持续递归下去，最终得出
        //要想最后合并成一堆石头。那么初始的石头的数目必须满足的关系是
        //n -1 = (k-1)*num
        if((n-1) % (k-1) != 0){
            return -1;
        }
        int[] sum = new int[n+1];
        int[][][] dp = new int[n+1][n+1][k+1];
        //前缀数组求和来方便求数组的区间和
        for(int i = 1; i <= n; i++){
            sum[i] = sum[i-1] + stones[i-1];
        }
        //初始化将合并成本设置成最大值，但不能设置成Integer.MAX_VALUE
        //因为后面仍然要在这个基础上添加数字
        for(int i = 0; i <=n; i++){
            for(int j =i; j <= n; j++){
                for(int m =2; m <= k; m++){
                    dp[i][j][m] = max;
                }
            }
            //本来只有一堆则不需要成本
            dp[i][i][1] = 0;
        }
        //区间动态规划的标准模板
        for(int len =2; len <= n; len++){
            for(int i =1; i+len-1 <=n; i++){
                int j = i + len -1;
                //dp[i][j][m]便是将i..j之间的序列分成m堆，而且必须是按i..p分一堆,p+1..j分成m-1堆
                for(int m = 2; m <=k; m++){
                    for(int p = i; p <j; p+=k-1){
                        dp[i][j][m] = Math.min(dp[i][j][m],dp[i][p][1]+dp[p+1][j][m-1]);
                    }
                }
                //最后合并成一堆必定是先分成k堆，最后在合并成1堆
                dp[i][j][1] = dp[i][j][k] + sum[j] - sum[i-1];
            }
        }
        return dp[1][n][1];
    }
}
