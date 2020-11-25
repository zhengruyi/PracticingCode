package Chapter10_动态规划.Q1312_让字符串成为回文串的最少插入次数;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 25/11/2020 20:41
 **/

public class Solution {
    public int minInsertions(String s) {
        int len = s.length();
        int[][] dp = new int[len][len];
        for(int i = len-1; i >= 0; i--){
            for(int j = i + 1; j < len; j++){
                //两侧字符相同，则最少插入次数等于中间的次数
                if(s.charAt(i) == s.charAt(j)){
                    dp[i][j] = dp[i+1][j-1];
                }else{
                    //不相等，则等于两种情况中最小的一个，然后需要额外添加一个字符，所以要加1
                    dp[i][j] = Math.min(dp[i+1][j],dp[i][j-1]) + 1;
                }
            }
        }
        return dp[0][len-1];
    }
}
