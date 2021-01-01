package Chapter10_动态规划.Q1139_最大的以1为边界的正方形;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 01/01/2021 22:40
 **/

public class Solution {
    public int largest1BorderedSquare(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        //dp[i][j][0]表示从左到当前点最大的连续1个数
        //dp[i][j][1]表示从上到当前节点的最大连续1个数
        int[][][] dp = new int[m+1][n+1][2];
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(grid[i-1][j-1] == 1){
                    dp[i][j][0] = dp[i][j-1][0] + 1;
                    dp[i][j][1] = dp[i-1][j][1] + 1;
                }
            }
        }
        int res = 0;
        for(int i =1; i <= m; i++){
            //计算对应的节点是否也有足够的连续1来构成正方形边界,不满足就缩小边界长度
            for(int j =1; j <=n; j++){
                for(int side = Math.min(dp[i][j][0],dp[i][j][1]); side >= 1; side--){
                    if(dp[i-side+1][j][0] >= side && dp[i][j-side+1][1] >= side){
                        res = Math.max(res, side);
                    }
                }
            }
        }
        return res * res;
    }
}
