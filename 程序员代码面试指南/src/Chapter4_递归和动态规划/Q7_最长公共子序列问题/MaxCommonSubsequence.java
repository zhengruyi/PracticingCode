package Chapter4_递归和动态规划.Q7_最长公共子序列问题;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 06/06/2020 18:35
 **/

public class MaxCommonSubsequence {
    public String findMaxSubsequence(String s1, String s2){
        if(s1 == null || s2 == null || s1.length() == 0 || s2.length() ==0){
            return null;
        }
        int[][] dp = getDP(s1,s2);
        return generateSubsequence(s1,s2,dp);
    }
    public int[][] getDP(String s1, String s2){
        int rows = s1.length();
        int columns = s2.length();
        int[][] dp = new int[rows][columns];
        int init = 0;
        for (int i = 0; i < rows; i++) {
            if(s1.charAt(i) == s2.charAt(0)){
                init = 1;
            }
            dp[i][0] = init;
        }
        init =0;
        for (int i = 0; i < columns; i++) {
            if(s2.charAt(i) == s1.charAt(0)){
                init = 1;
            }
            dp[0][i] = init;
        }
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < columns; j++) {
                int max = Math.max(dp[i-1][j],dp[i][j-1]);
                if(s1.charAt(i) == s2.charAt(j)){
                    max = Math.max(max,dp[i-1][j-1]+1);
                }
                dp[i][j] = max;
            }
        }
        return dp;
    }
    public String generateSubsequence(String s1, String s2, int[][] dp){
        StringBuilder builder = new StringBuilder();
        int row = dp.length -1;
        int column = dp[0].length -1;
        while (row > 0 || column > 0){
            if(row > 0 &&dp[row][column] == dp[row - 1][column]){
                row --;
            }else if(column >0 && dp[row][column] == dp[row][column -1]){
                column -- ;
            }else{
                builder.append(s1.charAt(row));
                row --;
                column --;
            }
        }
        return builder.reverse().toString();
    }
    @Test
    void test(){
        Assertions.assertEquals("12C4B6",findMaxSubsequence("1A2C3D4B56","B1D23CA45B6A"));
    }
}
