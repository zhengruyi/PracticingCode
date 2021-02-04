package Chapter10_动态规划.Q1277_统计全为1的正方形子矩阵;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 04/02/2021 23:12
 **/

public class Solution {
    public int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        int res = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                //处于行和列的边界那么只可能构成边长为1的矩阵，是否能构成和对应位置左边是否为1有关
                if(i == 0 || j == 0){
                    dp[i][j] = matrix[i][j];
                    //如果当前点为1，那么判断左边，上边和左上三个坐标,如果这三个左边都可以大于0，那么就可已构成
                    //一个更大的正方形,边长是三个左边中的最小值+1,那么以i,j为右下角坐标的正方形边长就是1..dp[i][j];
                }else if(matrix[i][j] == 1){
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i][j-1],dp[i-1][j])) + 1;
                }
                //求得总的正方形子矩阵数目
                res += dp[i][j];
            }
        }
        return res;
    }
}
