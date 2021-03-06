package Chapter10_动态规划.Q583_两个字符串的删除操作;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 05/11/2020 22:50
 **/

public class Solution {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        int[][] dp = new int[len1+1][len2+1];
        //最少需要修改的次数为m+n-2*lcs, lcs是最长公共子序列
        //求最长公共子序列的过程，dp[i][j]是0..i和0..j的最长公共子序列长度
        for(int i = 1; i <= len1; i++){
            for(int j = 1; j <= len2; j++){
                //如果word1[i] == word2[j]相等，那么就在0..i-1和0..j-1的最长公共子序列长度上加1
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    //如果不相等那么最长公共子序列长度等于0..i-1和0..j 以及0..i和0..j-1之间的子序列长度最大值
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return len1 + len2 - 2 * dp[len1][len2];
    }
}
