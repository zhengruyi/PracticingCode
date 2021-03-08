package Chapter10_动态规划.Q1513_仅含1的子串数;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 08/03/2021 22:46
 **/

public class Solution {
    /**
     * 简单的动态规划,主要难点在于res += dp[i]，便是以i为结尾的新增的子串个数
     * @param s
     * @return
     */
    public int numSub(String s) {
        int len = s.length();
        int [] dp = new int[len+1];
        long res = 0;
        int mod = 10_0000_0007;
        for(int i = 1; i <= len; i++){
            if(s.charAt(i-1) == '0'){
                dp[i] = 0;
            }else{
                dp[i] = dp[i-1] + 1;
                res = (res + dp[i]) % mod;
            }
        }
        return (int)res;
    }
}
