package Chapter15_面试题.Q0105_一次编辑;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 22/01/2021 23:38
 **/

public class Solution {
    public boolean oneEditAway(String first, String second) {
        int len1 = first.length();
        int len2 = second.length();
        int[][] dp = new int[len1+1][len2+1];
        //字符串插入需要执行的成本
        for(int j = 1; j <= len2; j++){
            dp[0][j] = j;
        }
        //字符串删除需要执行的成本
        for(int i = 1; i <= len1; i++){
            dp[i][0] = i;
        }
        for(int i = 1; i <= len1; i++){
            for(int j = 1; j <= len2; j++){
                //这里采用计算转化所需要的次数
                if(first.charAt(i-1) != second.charAt(j-1)){
                    //这里表示三种情况替换，插入和删除三种情况的最小值
                    dp[i][j] = Math.min(Math.min(dp[i-1][j-1]+1, dp[i][j-1] + 1),dp[i-1][j]+1);
                }else{
                    dp[i][j] = dp[i-1][j-1];
                }
            }
        }
        //最后判断两者需要进行转化的最少次数，如果小于等于1就满足要求
        return dp[len1][len2] <= 1;
    }
}
