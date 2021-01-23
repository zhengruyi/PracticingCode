package Q47_礼物的最大价值;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 23/01/2021 21:20
 **/

public class Solution {
    /**
     * 简单的动态规划 dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]) + grid[i][j]
     * @param grid
     * @return
     */
    public int maxValue(int[][] grid) {
        int ans = 0;
        if(grid.length == 0 || grid[0].length == 0){
            return ans;
        }
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m+1][n+1];
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]) + grid[i-1][j-1];
            }
        }
        return dp[m][n];
    }
}
