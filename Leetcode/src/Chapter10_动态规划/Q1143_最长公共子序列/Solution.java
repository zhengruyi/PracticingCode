package Chapter10_动态规划.Q1143_最长公共子序列;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 12/11/2020 21:42
 **/

public class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        char[] chas1 = text1.toCharArray();
        char[] chas2 = text2.toCharArray();
        int[][] dp = new int[chas1.length+1][chas2.length+1];
        //求最长公共子序列的方法，一般很少单独使用
        for(int i =1; i <=chas1.length; i++){
            for(int j =1; j <= chas2.length; j++){
                // dp[i][j] 分两种情况讨论
                //字符相等则等于 dp[i][j] = dp[i-1][j-1] + 1;
                //不相等则等于 dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1])
                if(chas1[i-1] == chas2[j-1]){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[chas1.length][chas2.length];
    }
}
