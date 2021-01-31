package Chapter10_动态规划.Q1155_掷骰子的N种方法;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 31/01/2021 23:26
 **/

public class Solution {
    public int numRollsToTarget(int d, int f, int target) {
        long[][] dp = new long[d + 1][target + 1];
        dp[0][0] = 1;
        //遍历骰子数目
        for(int i = 1; i <= d; i ++){
            //遍历范围
            for(int j = i; j <= Math.min(i * f,target); j++){
                //遍历第i个骰子可能的值
                for(int k = 1; k <= f; k++){
                    if(k > j){
                        break;
                    }
                    //当前骰子变成k,所以在i个骰子的情况下，等于i-1个骰子组成j-k的种类数
                    dp[i][j] = (dp[i][j] + dp[i -1][j - k])% 1_000_000_007;
                }
            }
        }
        return (int)dp[d][target];
    }
}
