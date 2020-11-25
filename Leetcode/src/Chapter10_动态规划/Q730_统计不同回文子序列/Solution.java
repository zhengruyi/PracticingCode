package Chapter10_动态规划.Q730_统计不同回文子序列;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 25/11/2020 20:31
 **/

public class Solution {
    public int countPalindromicSubsequences(String S) {
        int len = S.length();
        int mod = 1000_000_000 + 7;
        //由于S中只会出现abcd四种的一个，所以k表示abcd四种状态
        int[][][] dp = new int[4][len][len];
        for(int i = len-1; i >= 0; i--){
            for(int j = i; j < len; j++){
                for(int k = 0; k < 4; k++){
                    char c = (char)('a' + k);
                    if(j == i){
                        //和当前指定字符相同为1，不同为0
                        dp[k][i][j] = S.charAt(i) == c ? 1 : 0;
                    }else{
                        if(S.charAt(i) != c){
                            dp[k][i][j] = dp[k][i+1][j];
                        }else if(S.charAt(j) != c){
                            dp[k][i][j] = dp[k][i][j-1];
                        }else{
                            //如果j== i+1那么长度固定等于2
                            if(j == i +1){
                                dp[k][i][j] = 2;
                            }else{
                                //这里的2表示两侧单独的字符各自单独算作一个回文字符串
                                dp[k][i][j] = 2;
                                //把中间所有可能的情况求和
                                for(int m = 0; m < 4; m++){
                                    dp[k][i][j] = (dp[k][i][j] + dp[m][i+1][j-1])%mod;
                                }
                            }
                        }
                    }
                }
            }
        }
        //对四种情况求和
        int ans = 0;
        for(int m =0; m < 4; m++){
            ans = (ans + dp[m][0][len-1])%mod;
        }
        return ans;
    }
}
