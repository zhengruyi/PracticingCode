package Chapter10_动态规划.Q576_出界的路劲数;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 19/01/2021 22:40
 **/

public class Solution {
    public int findPaths(int m, int n, int N, int i1, int j1) {
        int mod = 1_000_000_000 + 7;
        long[][][] dp = new long[m+2][n+2][N+1];
        //创建dp数组，创立虚拟边界,并且把虚拟边界的数字赋值成1
        //dp[i][j][k]便是从坐标(i,j)经过k步把球踢出边界的方法数目
        for(int i = 0; i <= m + 1; i++){
            dp[i][0][0] = 1;
            dp[i][n+1][0] = 1;
        }
        for(int j = 0; j <= n + 1; j++){
            dp[0][j][0] = 1;
            dp[m+1][j][0] = 1;
        }
        //dp[i][j][k] = dp[i-1][j][k-1] + dp[i+1][j][k-1] + dp[i][j-1][k-1]+ dp[i][j+1][k-1]
        for(int k = 1; k <= N; k++){
            for(int i =1; i <= m; i++){
                for(int j = 1; j <= n; j++){
                    dp[i][j][k] = (dp[i-1][j][k-1] + dp[i+1][j][k-1] + dp[i][j+1][k-1] + dp[i][j-1][k-1]) % mod;
                }
            }
        }
        long sum = 0;
        //起点经过所有k步的出界的数目之和
        for(int k = 1; k <= N; k++){
            sum = (sum + dp[i1+1][j1+1][k]) % mod;
        }
        return (int)sum;
    }
}
