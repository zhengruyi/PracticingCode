package Chapter10_动态规划.Q87_扰乱字符串;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 14/11/2020 19:31
 **/

public class Solution {
    public boolean isScramble(String s1, String s2) {
        char[] chs1 = s1.toCharArray();
        char[] chas2 = s2.toCharArray();
        if(s1.length() != s2.length()){
            return false;
        }
        int length = s1.length();
        // dp表示在s1的i位置和s2的j位置，k长的字符串是不是扰乱字符串
        boolean[][][] dp = new boolean[length][length][length+1];
        for(int i = 0; i < length; i++){
            for(int j = 0; j< length; j++){
                //如果字符相等那么对应位置且长度为1的字符串互为扰乱字符串
                if(chs1[i] == chas2[j]){
                    dp[i][j][1] = true;
                }
            }
        }
        //遍历长度，之所以从2开始，是因为i的位置时从0..length-2
        for(int len = 2; len <= length; len++){
            //字符串s1的i位置遍历
            for(int i =0; i <= length - len; i++){
                //字符串s2的j位置遍历
                for(int j =0; j <= length -len; j++){
                    //分割位置遍历从1..len-1
                    for(int k =1; k <= len - 1; k++){
                        //s1和s2按照分割位置分成s1,s2和t1,t2,这里查看s1是不是等于t1,s2是不是等于t2
                        if(dp[i][j][k] && dp[i+k][j+k][len - k]){
                            dp[i][j][len] = true;
                            break;
                        }
                        //这里考虑调换后的情况s1对应t2,和 s2对应t1的情况
                        if(dp[i+k][j][len-k] && dp[i][j+len-k][k]){
                            dp[i][j][len] = true;
                            break;
                        }
                    }
                }
            }
        }
        return dp[0][0][length];
    }
}
