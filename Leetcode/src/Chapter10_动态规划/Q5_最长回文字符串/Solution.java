package Chapter10_动态规划.Q5_最长回文字符串;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 24/11/2020 21:12
 **/

public class Solution {
    public String longestPalindrome(String s) {
        int max = 0;
        int start = 0;
        boolean[][] dp = new boolean[s.length()][s.length()];
        for(int j = 0; j < s.length(); j++){
            for(int i =0; i <= j; i++){
                //判断当前i..j之间是否是回文字符串，要么是i和j是相邻或者相同位置，那么在s[i] == s[j]的前提下
                //可以认定是回文字符串，如果j - i > 2,那么直接看i+1..j-1之间是不是回文字符串
                if(s.charAt(i) == s.charAt(j) && (j - i < 2 || dp[i+1][j-1])){
                    dp[i][j] = true;
                    //更新起始位置和最大回文字符串的长度来更新
                    if(j-i + 1 > max){
                        start = i;
                        max = j - i + 1;
                    }
                }
            }
        }
        return s.substring(start,start + max);
    }
}
