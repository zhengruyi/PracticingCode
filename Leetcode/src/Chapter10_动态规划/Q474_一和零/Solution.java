package Chapter10_动态规划.Q474_一和零;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 29/11/2020 16:37
 **/

public class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        //典型的背包问题
        if(strs.length == 0){
            return 0;
        }
        int len = strs.length;
        //dp[i][j][k]便是在0..i的字符串中，在满足m个0和n个1条件下最多能包含的字符串数目
        int[][][] dp = new int[len+1][m+1][n+1];
        for(int i = 1; i <= len; i++){
            int[] count = count(strs[i-1]);
            for(int j = 0; j <= m; j++){
                for(int k = 0; k<= n; k++){
                    //如果当前字符串可以被装下，那么就会有两个选择，装或者不装
                    if(count[0] <= j && count[1] <= k){
                        //不装则结果等于前i-1的结果，装则减去对应的容量
                        dp[i][j][k] = Math.max(dp[i-1][j][k],dp[i-1][j-count[0]][k-count[1]] +1);
                    }else{
                        dp[i][j][k] = dp[i-1][j][k];
                    }
                }
            }
        }
        return dp[len][m][n];

    }
    //返回给定字符串中对应的0和1的数量
    public int[] count(String s){
        int[] res = new int[2];
        for(int i = 0; i < s.length();i++){
            if(s.charAt(i) == '0'){
                res[0]++;
            }else{
                res[1]++;
            }
        }
        return res;
    }
}
