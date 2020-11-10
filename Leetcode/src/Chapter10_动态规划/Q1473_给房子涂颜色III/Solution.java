package Chapter10_动态规划.Q1473_给房子涂颜色III;

import java.util.Arrays;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 10/11/2020 21:52
 **/

public class Solution {
    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        if(houses.length == 0){
            return 0;
        }
        //涂色花费的最大值,不可以设置成Integer.MAX_VALUE,因为后续任然会对它进行加减
        int max = 100000000;
        int[][][] dp = new int[m][n+1][target+1];
        for(int i = 0; i < m; i++){
            for(int j = 1; j<= n; j++){
                Arrays.fill(dp[i][j],max);
            }
        }
        //当前没有颜色时，则将dp数组初始化成初始成本
        if(houses[0] == 0){
            for(int j = 1; j <= n; j++){
                dp[0][j][1] = cost[0][j-1];
            }
        }else{
            //房子已经有颜色，则没有成本
            dp[0][houses[0]][1] = 0;
        }

        for(int i =1; i < m; i++){
            //当前房子已经有颜色，则需要对上一个房子颜色和街区进行二维遍历
            if(houses[i] != 0){
                int j1 = houses[i];
                for(int k =1; k <= target; k++){
                    for(int j = 1; j <= n ;j++){
                        //颜色相同算一个街区，不同则算两个街区
                        dp[i][j1][k] = Math.min(dp[i][j1][k],dp[i-1][j][j1 == j ? k : k-1]);
                    }
                }
            }else{
                //当前房子需要涂颜色，则需要对当前房子的颜色，上一个房子的颜色，和街区数目进行三维遍历
                for(int j1 = 1; j1 <= n; j1++){
                    for(int k =1; k<= target; k++){
                        for(int j2 = 1; j2 <= n; j2++){
                            dp[i][j1][k] = Math.min(dp[i][j1][k],dp[i-1][j2][j1 == j2 ? k : k-1] + cost[i][j1-1]);
                        }
                    }
                }
            }
        }
        //对最后一栋房子的所有可能颜色进行遍历,选择最小值作为答案
        int min = Integer.MAX_VALUE;
        for(int j =1; j<= n; j++){
            min = Math.min(min,dp[m-1][j][target]);
        }
        return min == max ? -1 : min;
    }
}
