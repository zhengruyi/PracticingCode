package Chapter10_动态规划.Q787_K站中转内最便宜的航班;

import java.util.Arrays;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 24/01/2021 19:02
 **/

public class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        //dp[i][k]表示后从起点出发经过最多k次转航班到达i所需要花费的最小价格
        int[][] dp = new int[n][K+1];
        //填补默认值
        for(int i = 0; i < n; i++){
            Arrays.fill(dp[i],Integer.MAX_VALUE);
        }
        //如果起点等于我们的出发点，就跟新对应的到达点和花费的机票钱
        for(int[] flight : flights){
            if(flight[0] == src){
                dp[flight[1]][0] = flight[2];
            }
        }
        //将起点和终点相同的情况更新入数组中
        for(int i = 0; i <= K; i++){
            dp[src][i] = 0;
        }
        //先遍历转换航班次数
        for(int k = 1; k <= K; k++){
            //在检查航班数
            for(int[] flight : flights){
                //如果航班起点有办法到达，那么就可以尝试把新航班考虑在内
                //去更新到达目的地所需要花费的成本
                if(dp[flight[0]][k-1] != Integer.MAX_VALUE){
                    //到达目的地的成本可能由于这条航班加转机产生变化
                    dp[flight[1]][k] = Math.min(dp[flight[1]][k],dp[flight[0]][k-1] + flight[2]);
                }
            }
        }
        return dp[dst][K] == Integer.MAX_VALUE ? -1 : dp[dst][K];
    }
}
