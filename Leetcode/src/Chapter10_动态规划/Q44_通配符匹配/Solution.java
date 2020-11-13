package Chapter10_动态规划.Q44_通配符匹配;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 13/11/2020 23:45
 **/

public class Solution {
    public boolean isMatch(String s, String p) {
        if(s == null || p == null){
            return false;
        }
        int len1 = s.length();
        int len2 = p.length();
        boolean[][] dp = new boolean[len1+1][len2+1];
        dp[0][0] = true;
        for(int j =1; j <= len2; j++){
            //*字符可以匹配空字符串，所以当前字符为* dp[0][j]可以为true
            if(p.charAt(j-1) == '*'){
                dp[0][j] = true;
            }else{
                break;
            }
        }
        for(int i =1; i <= len1; i++){
            for(int j = 1; j <= len2; j++){
                if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?'){
                    dp[i][j] = dp[i-1][j-1];
                }else if(p.charAt(j-1) == '*'){
                    // 匹配多个i位置字符，或者不匹配字符。只要有一个成功就可以
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];
                }
            }
        }
        return dp[len1][len2];
    }
}
