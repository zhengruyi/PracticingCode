package Chapter10_动态规划.Q115_不同的子序列;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 14/11/2020 19:22
 **/

public class Solution {
    public int numDistinct(String s, String t) {
        int len1 = s.length();
        int len2 = t.length();
        int[][] dp = new int[len2+1][len1+1];
        //空字符串是任何字符串的子序列
        for(int i = 0; i<= len1; i++){
            dp[0][i] = 1;
        }
        for(int i = 1; i <= len2; i++){
            for(int j = 1; j <= len1; j++){
                if(s.charAt(j-1) == t.charAt(i-1)){
                    //以当前字符作为结果的子序列数目为dp[i-1][j-1]
                    //不以当前字符为结果的子序列数目是dp[i][j-1]
                    //则总数目是两者的和
                    dp[i][j] = dp[i-1][j-1] + dp[i][j-1];
                }else{
                    //不相等则直接等于dp[i][j-1]
                    dp[i][j] = dp[i][j-1];
                }
            }
        }
        return dp[len2][len1];
    }
}
