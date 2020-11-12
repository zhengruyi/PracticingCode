package Chapter10_动态规划.Q718_最长重复子数组;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 12/11/2020 22:15
 **/

public class Solution {
    public int findLength(int[] A, int[] B) {
        int len1 = A.length;
        int len2 = B.length;
        int max = 0;
        int[][] dp = new int[len1+1][len2+1];
        // if A[i] == B[j] dp[i][j] = dp[i-1][j-1]+1
        // else dp[i][j] = 0;
        for(int i =1; i <= len1; i++){
            for(int j = 1; j <= len2; j++){
                if(A[i-1] == B[j-1]){
                    dp[i][j] = dp[i-1][j-1] +1;
                    max = Math.max(dp[i][j],max);
                }else{
                    dp[i][j] = 0;
                }
            }
        }
        return max;
    }
}
