package Chapter10_动态规划.Q221_最大正方形;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 15/11/2020 18:22
 **/

public class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        //以i,j为右下角的最大正方形边长
        int[][] dp = new int[rows][cols];
        int max = 0;
        //处理第一列的边界条件
        for(int i =0 ; i < rows; i++){
            if(matrix[i][0] == '1'){
                dp[i][0] = 1;
                max = 1;
            }
        }
        //处理第一行的边界条件
        for(int j = 0; j < cols; j++){
            if(matrix[0][j] == '1'){
                dp[0][j] = 1;
                max = 1;
            }
        }

        for(int i =1; i< rows; i++){
            for(int j =1; j < cols; j++){
                if(matrix[i][j] == '1'){
                    //由于一个正方形的最小边长是1，如果想要构成更大的正方形，那么他相邻的三个点
                    //都必须是1，对应的边长关系为dp[i][j] = min(dp[i-1][j],dp[i][j-1],dp[i-1][j-1])+1
                    dp[i][j] = Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1]) + 1;
                    max = Math.max(max,dp[i][j]);
                }
            }
        }
        return max * max;
    }
}
