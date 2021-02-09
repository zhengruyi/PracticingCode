package Chapter10_动态规划.Q161_相隔为1的编辑距离;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 09/02/2021 19:49
 **/

public class Solution {
    /**
     * 用动态规划求出从字符串s转化成字符串t的最小编辑距离,最后判断编辑距离是否等于1
     * @param s
     * @param t
     * @return
     */
    public boolean isOneEditDistance(String s, String t) {
        int len1 = s.length();
        int len2 = t.length();
        int[][] dp = new int[len1+1][len2+1];
        //将字符串的s的字符逐个删除
        for(int i = 0; i <= len1; i++){
            dp[i][0] = i;
        }
        //将字符串逐个插入
        for(int j = 0; j <= len2; j++){
            dp[0][j] = j;
        }
        //求最小的编辑距离
        for(int i = 1; i <= len1; i++){
            for(int j = 1; j <= len2; j++){
                dp[i][j] = Math.min(dp[i][j-1] + 1,dp[i-1][j] + 1);
                if(s.charAt(i-1) == t.charAt(j-1)){
                    dp[i][j] = Math.min(dp[i][j],dp[i-1][j-1]);
                }else{
                    dp[i][j] = Math.min(dp[i][j],dp[i-1][j-1] + 1);
                }
            }
        }
        return dp[len1][len2] == 1;
    }
}
