package Chapter10_动态规划.Q72_编辑距离;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 13/11/2020 23:37
 **/

public class Solution {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        int[][] dp = new int[len1+1][len2+1];
        //字符串插入需要执行的成本
        for(int j = 1; j <= len2; j++){
            dp[0][j] = j;
        }
        //字符串删除需要执行的成本
        for(int i = 1; i <= len1; i++){
            dp[i][0] = i;
        }
        for(int i =1; i <= len1; i++){
            for(int j = 1; j<= len2; j++){
                //当前字符串对应相等，则当前结果等于上一次比对结果
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    //不相等则结果等于最后一个人字符替换成本，或者删除i字符再转换成j.或者把i转换成j-1，在插入j字符
                    dp[i][j] = Math.min(dp[i-1][j]+1,Math.min(dp[i][j-1]+1, dp[i-1][j-1] +1));
                }
            }
        }
        return dp[len1][len2];
    }
}
