package Chapter10_动态规划.Q471_编码最短长度的字符串;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 27/11/2020 22:07
 **/

public class Solution {
    String[][] dp;
    public String encode(String s) {
        int n = s.length();
        dp = new String[n][n];
        for(int len = 1; len<= n; len++){
            for(int i = 0; i + len -1 < n; i++){
                int j = i + len -1;
                 //将区间的字符串传入，返回经过压缩编码后的字符串
                dp[i][j] = compress(s,i,j);
                //如果区间长度小于4，则编码后长度比原来长度更长，随意直接忽略
                if(len > 4){
                    //选择区间的某一个点，使得编码后的字符串长度最短
                    for(int k = i; k < j; k++){
                        String split = dp[i][k] + dp[k+1][j];
                        if(dp[i][j].length() > split.length()){
                            dp[i][j] = split;
                        }
                    }
                }
            }
        }
        return dp[0][n-1];
    }
    public String compress(String s, int i, int j){
        s = s.substring(i,j+1);
        //如果原字符串长度小于5，则直接忽略，因为编码后长度比原字符串还要长
        if(s.length() < 5){
            return s;
        }
        //判断s中是否有重复字符串
        int p = (s+s).indexOf(s,1);
        if(p !=s.length()){
            //重复字符串的数目
            int cnt = s.length()/p;
            //返回固定格式的字符串
            return String.format("%d[%s]",cnt,dp[i][i+p-1]);
        }
        return s;
    }
}
