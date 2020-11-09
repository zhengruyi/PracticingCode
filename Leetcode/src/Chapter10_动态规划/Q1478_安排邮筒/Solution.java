package Chapter10_动态规划.Q1478_安排邮筒;

import java.util.Arrays;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 10/11/2020 00:43
 **/

public class Solution {
    public int minDistance(int[] houses, int K) {
        Arrays.sort(houses);
        int len = houses.length;
        int[][] distance = new int[len][len];
        for(int i =0; i < len; i++){
            for(int j= i; j < len; j++){
                int mid = i + j >> 1;
                for(int k = i; k<= j; k++){
                    distance[i][j] += Math.abs(houses[k] - houses[mid]);
                }
            }
        }
        int[][] dp = new int[len][K+1];
        for(int i =0; i < len; i++){
            for(int j= 0; j <= K; j++){
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        for(int i =0; i <len; i++){
            dp[i][1] = distance[0][i];
        }
        for(int i = 0; i < len; i++){
            for(int j = 2; j <= Math.min(i+1,K); j++){
                for(int k = j-1; k <=i; k++){
                    dp[i][j] = Math.min(dp[i][j], dp[k-1][j-1] + distance[k][i]);
                }
            }
        }
        return dp[len-1][K];
    }
}
