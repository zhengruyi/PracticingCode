package Chapter10_动态规划.Q1048_最长字符串链;

import java.util.Arrays;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 19/01/2021 21:17
 **/

public class Solution {
    /**
     * 根据数组长度排序后,那么问题就会转化成求最长递增子序列，这个子序列的长度就是最长的字符串链
     * @param words
     * @return
     */
    public int longestStrChain(String[] words) {
        Arrays.sort(words,(o1, o2) -> o1.length() - o2.length());
        int ans = 0;
        //dp法求最长递增子序列,dp[i]便是前i的字符串的最长递增子序列
        int[] dp = new int[words.length];
        for(int i = 1; i < words.length; i++){
            for(int j = 0; j < i; j++){
                //如果字符串i是在字符串j的基础上添加一个字符，那么字符串j就是字符串i的前身
                if(contains(words[i],words[j])){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                    ans = Math.max(ans,dp[i]);
                }
            }
        }
        return ans + 1;
    }

    /**
     * 函数功能就是检查字符串s1中包含s2的所有字符，且长度刚刚好多1
     * @param s1
     * @param s2
     * @return
     */
    public boolean contains(String s1, String s2){
        if(s1.length() != s2.length() + 1){
            return false;
        }
        int i = 0, j = 0;
        while(i < s1.length() && j < s2.length()){
            if(s1.charAt(i) == s2.charAt(j)){
                i++;
                j++;
            }else{
                i++;
            }
        }
        return j == s2.length();
    }
}
