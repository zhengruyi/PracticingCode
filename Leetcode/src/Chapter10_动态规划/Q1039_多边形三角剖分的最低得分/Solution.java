package Chapter10_动态规划.Q1039_多边形三角剖分的最低得分;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 26/11/2020 23:10
 **/

public class Solution {
    public int minScoreTriangulation(int[] A) {
        int len = A.length;
        int[][] dp = new int[len][len];
        //dp[i][j]表示以i和j为底边，k为顶点的这样切分可以获得的最大分数
        //将序列i..j切分成三块,i..k,k..j和ijk构成的三角形
        for(int i = len-3; i >= 0; i--){
            for(int j = i+2; j < len; j++){
                for(int k = i+1; k < j; k++){
                    if(dp[i][j] == 0){
                        dp[i][j] = dp[i][k] + dp[k][j] + A[i] * A[k] * A[j];
                    }else{
                        dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j] + A[i] * A[k] * A[j]);
                    }
                }
            }
        }
        return dp[0][len-1];
    }
}
