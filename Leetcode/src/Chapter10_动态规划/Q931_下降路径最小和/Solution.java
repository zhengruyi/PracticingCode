package Chapter10_动态规划.Q931_下降路径最小和;

import java.util.Arrays;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 15/11/2020 18:30
 **/

public class Solution {
    public int minFallingPathSum(int[][] A) {
        if(A.length == 0 || A[0].length == 0){
            return 0;
        }
        int len = A.length;
        int[][] dp = new int[len][len];
        //初始化为最大值
        for(int i = 0; i < len; i++){
            Arrays.fill(dp[i],Integer.MAX_VALUE);
        }
        //初始化第一行
        for(int j = 0; j < len; j++){
            dp[0][j] = A[0][j];
        }
        //按照逻辑进行动态运算
        for(int i =1; i < len ; i++){
            for(int j = 0; j < len; j++){
                if(j-1 >= 0){
                    dp[i][j] = Math.min(dp[i][j],dp[i-1][j-1]+A[i][j]);
                }
                if(j+1 < len){
                    dp[i][j] = Math.min(dp[i][j],dp[i-1][j+1]+A[i][j]);
                }
                dp[i][j] = Math.min(dp[i][j], dp[i-1][j] + A[i][j]);
            }
        }
        //返回最后一行的最小值作为结果返回
        return Arrays.stream(dp[len-1]).min().getAsInt();
    }
}
