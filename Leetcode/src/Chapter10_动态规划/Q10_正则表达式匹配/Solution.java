package Chapter10_动态规划.Q10_正则表达式匹配;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 13/11/2020 23:48
 **/

public class Solution {
    public boolean isMatch(String s, String p) {
        int len1 = s.length();
        int len2 = p.length();
        if(len1 == 0 && len2 == 0){
            return true;
        }
        boolean[][] dp = new boolean[len1+1][len2+1];
        dp[0][0] = true;
        // a*a*a*这种情况可以匹配空字符串，所以作为初始化处理
        for (int j = 2; j <= len2; j+= 2) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }
        for(int i =1; i<= len1; i++){
            for(int j =1; j<= len2; j++){
                //如果当前对应字符相等或者当前字符为.
                if(p.charAt(j-1) == '.' || p.charAt(j-1) == s.charAt(i-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else if(p.charAt(j-1) == '*'){
                    //上一个字符等于当前i字符或者为.
                    if(j >= 2 &&(p.charAt(j-2) == '.'||p.charAt(j-2) == s.charAt(i-1))){
                        //匹配多个字符，不匹配字符，匹配一个字符，只要有一个成功就可以
                        dp[i][j] = dp[i-1][j] || dp[i][j-2] || dp[i][j-1];
                    }else{
                        //去掉前一个字符
                        dp[i][j] = dp[i][j-2];
                    }

                }
            }
        }
        return dp[len1][len2];
    }
}
