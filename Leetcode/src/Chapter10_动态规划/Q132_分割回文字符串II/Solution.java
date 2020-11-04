package Chapter10_动态规划.Q132_分割回文字符串II;

import java.util.Arrays;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 04/11/2020 19:09
 **/

public class Solution {
    public int minCut(String s) {
        if(s.length() == 0 || s.length() == 1){
            return 0;
        }
        char[] chas = s.toCharArray();
        int len = chas.length;
        //判断i,j之间字符串是不是回文字符串
        boolean[][] checkPalindrome = new boolean[len][len];
        for(int right =0; right < len; right++){
            for(int left = 0; left <=right; left++){
                //如果当前左右字符相等且左右差距小于等于2或者内部已经是一个回文字符串，则当前字符串也是一个回文字符串
                if(chas[right] == chas[left] && (right - left <=2 || checkPalindrome[left+1][right-1])){
                    checkPalindrome[left][right] = true;
                }
            }
        }
        int[] dp = new int[len];
        //最多要切分的次数等于字符串长度
        Arrays.fill(dp,len);
        for(int i = 0; i < len; i++){
            //如果当前字符串是回文字符串则不需要切割
            if(checkPalindrome[0][i]){
                dp[i] = 0;
                continue;
            }
            //遍历一次dp数组
            for(int j =0; j < i; j++){
                //如果j+1到i为回文字符串，那么只需要在dp[j]的基础上在切割一次，就可以获得回文子字符串
                if(checkPalindrome[j+1][i]){
                    dp[i] = Math.min(dp[i],dp[j]+1);
                }
            }
        }
        return dp[len-1];
    }
}
