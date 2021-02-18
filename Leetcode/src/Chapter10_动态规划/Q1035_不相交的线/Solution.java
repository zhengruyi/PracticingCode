package Chapter10_动态规划.Q1035_不相交的线;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 18/02/2021 22:11
 **/

public class Solution {
    /**
     * 本质就是求最长公共子序列,那么采用动态规划就能快速求解
     * @param A
     * @param B
     * @return
     */
    public int maxUncrossedLines(int[] A, int[] B) {
        int len1 = A.length;
        int len2 = B.length;
        int[][] dp = new int[len1+1][len2+1];
        for(int i = 1; i <= len1; i++){
            for(int j = 1; j <= len2; j++){
                //在前面基础上+1
                if(A[i-1] == B[j-1]){
                    dp[i][j] =dp[i-1][j-1] + 1;
                }else{
                    //取两个值的最大值
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[len1][len2];
    }
}
