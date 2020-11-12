package Chapter10_动态规划.Q712_两个字符串的最小ASCII删除和;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 12/11/2020 22:12
 **/

public class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        int[][] dp = new int[len1+1][len2+1];
        //与最小编辑距离一样,这里考虑将s2从0删除到i位置
        for(int i =1; i <= len1; i++){
            dp[i][0] = dp[i-1][0] + s1.charAt(i-1);
        }
        //与最小编辑距离一样,这里考虑将s1从0删除到j位置
        for(int j =1; j <= len2; j++){
            dp[0][j] = dp[0][j-1] + s2.charAt(j-1);
        }
        //如果s1[1] ==s2[j]那么dp[i][j] == dp[i-1][j-1]
        //否则 dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1]
        for(int i = 1; i<= len1; i++){
            for(int j = 1; j <= len2; j++){
                dp[i][j] = s1.charAt(i-1) == s2.charAt(j-1) ? dp[i-1][j-1] : Math.min(dp[i-1][j]+s1.charAt(i-1),dp[i][j-1]+s2.charAt(j-1));
            }
        }
        return dp[len1][len2];
    }
}
