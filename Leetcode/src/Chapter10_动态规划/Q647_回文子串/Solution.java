package Chapter10_动态规划.Q647_回文子串;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 24/11/2020 21:31
 **/

public class Solution {
    public int countSubstrings(String s) {
        int ans = 0;
        boolean[][] dp = new boolean[s.length()][s.length()];
        for(int j = 0; j < s.length(); j++){
            for(int i =0; i <= j; i++){
                //与Q5的题目相似，也是通过中心扩展法来判断是不是回文字符串，如果是就在原来统计的基础上加1
                //注意这里 i==j表示统计单个字符
                if(s.charAt(i) == s.charAt(j) &&(j - i < 2 || dp[i+1][j-1])){
                    dp[i][j] = true;
                    ans++;
                }
            }
        }
        return ans;
    }
}
