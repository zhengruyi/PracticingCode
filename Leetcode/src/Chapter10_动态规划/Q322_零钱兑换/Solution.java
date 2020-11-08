package Chapter10_动态规划.Q322_零钱兑换;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 27/10/2020 22:48
 **/

public class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        int max = Integer.MAX_VALUE;
        Arrays.fill(dp, max);
        dp[0] = 0;
        // dp[j] = min(dp[j], dp[j-coins[i]])
        for(int i =0; i < coins.length; i++){
            for(int j= 1; j <= amount; j++){
                if(j >= coins[i] && dp[j-coins[i]] != max){
                    dp[j] =  Math.min(dp[j],dp[j-coins[i]] + 1);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}
