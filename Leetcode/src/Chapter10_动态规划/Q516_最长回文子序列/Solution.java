package Chapter10_动态规划.Q516_最长回文子序列;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 24/11/2020 21:35
 **/

public class Solution {
    public int longestPalindromeSubseq(String s) {
        int len = s.length();
        int[][] dp = new int[len][len];
        //所有的单个字符都是回文子序列
        for(int i = 0; i < len; i++){
            dp[i][i] = 1;
        }
        //因为要计算i+1..j-1的情况，所以需要i倒序递减，这样才能保证计算i..j时i+1已经计算过
        //只能在回文子序列这样计算，是因为对于acbda这种情况时,任然会得出3，所以这种状态转移方式
        //只能用作回文子序列的计算
        for(int i = len - 2; i >= 0; i--){
            for(int j = i+1; j < len; j++){
                if(s.charAt(i) == s.charAt(j)){
                    dp[i][j] = dp[i+1][j-1] + 2;
                }else{
                    dp[i][j] = Math.max(dp[i+1][j],dp[i][j-1]);
                }
            }
        }
        return dp[0][len-1];
    }
}
