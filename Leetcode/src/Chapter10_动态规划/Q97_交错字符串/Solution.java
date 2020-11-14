package Chapter10_动态规划.Q97_交错字符串;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 14/11/2020 19:14
 **/

public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();
        if(len1 == 0 && len2 == 0 && len3  == 0){
            return true;
        }
        //如果s3的字符串的长度和不等于前面两者之和，那么直接返回false
        if(len1 + len2 != len3){
            return false;
        }
        boolean[][] dp = new boolean[len1+1][len2+1];
        dp[0][0] = true;
        //这里必须从0开始，因为从1开始的话会忽略掉dp[0][1]和dp[1][0]这两种情况
        for(int i = 0; i<= len1; i++){
            for(int j = 0; j <= len2; j++){
                int k = i + j - 1;
                //如果s1的i位置匹配到S3的对应位置，那么dp[i][j] = dp[i-1][j]
                if(i > 0){
                    dp[i][j] = dp[i-1][j] && s1.charAt(i-1) == s3.charAt(k);
                }
                //如果s2的j位置匹配到S3的对应位置，那么dp[i][j] = dp[i][j-1]
                //不影响前面计算结果，所以加上dp[i][j]||
                if(j > 0){
                    dp[i][j] = dp[i][j]||(dp[i][j-1] && s2.charAt(j-1) == s3.charAt(k));
                }
            }
        }
        return dp[len1][len2];
    }
}
