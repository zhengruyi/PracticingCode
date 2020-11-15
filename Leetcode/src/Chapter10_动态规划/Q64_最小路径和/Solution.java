package Chapter10_动态规划.Q64_最小路径和;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 15/11/2020 18:07
 **/

public class Solution {
    public int minPathSum(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] dp = new int[rows][cols];
        dp[0][0] = grid[0][0];
        for(int i = 1; i < rows; i++){
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }
        for(int j =1; j < cols; j++){
            dp[0][j] = dp[0][j-1] + grid[0][j];
        }
        //只能往右或者往下移动
        for(int i = 1; i < rows ;i++){
            for(int j = 1; j< cols; j++){
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j];
            }
        }
        return dp[rows-1][cols-1];
    }
}
