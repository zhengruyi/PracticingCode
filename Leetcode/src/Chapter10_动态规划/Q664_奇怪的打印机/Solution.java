package Chapter10_动态规划.Q664_奇怪的打印机;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 26/11/2020 23:16
 **/

public class Solution {
    public int strangePrinter(String s) {
        if(s.length() == 0){
            return 0;
        }
        int len = s.length();
        int[][] dp = new int[len][len];
        // base case,虽有的字符最少需要打印一次
        for(int i =0; i < len; i++){
            dp[i][i] = 1;
        }
        for(int j = 1; j < len; j++){
            for(int i =0; i < j; i++){
                //如果序列i..j的char[i]==char[j]那么打印i..j需要的次数和i..j-1的次数相等
                //因为打印i时可以顺便把j打印了
                if(s.charAt(i) == s.charAt(j)){
                    dp[i][j] = dp[i][j-1];
                    continue;
                }
                //如果i..j的两端字符i和j不相等，那么i..j至少等于i..j-1的次数在加上打印j字符的次数
                dp[i][j] = dp[i][j-1] + 1;
                //开始检查i..j中是否存在k使得char[k]==char[j]
                //如果存在意味着可以在打印k时顺便打印出j,那么最少需要次数等于i..k-1加上k..j-1的和
                for(int k = i + 1; k < j; k++){
                    if(s.charAt(k) == s.charAt(j)){
                        dp[i][j] = Math.min(dp[i][j], dp[i][k-1] + dp[k][j-1]);
                    }
                }
            }
        }
        return dp[0][len-1];
    }
}
