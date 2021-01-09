package Chapter10_动态规划.Q1049_最后一块石头重量II;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 10/01/2021 00:12
 **/

public class Solution {
    /**
     * 背包问题，就是讲总质量等分成2份，最后变成背包问题,即在
     * 容量固定容量情况下 sum/2,尽可能将石头装入包中来让总容量接近sum/2
     * 这样两者相冲后的生信息啊的容量最小
     * @param stones
     * @return
     */
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for(int num : stones){
            sum += num;
        }
        int target = sum / 2;
        int[] dp = new int[target+1];
        for(int i = 0; i < stones.length; i++){
            for(int j = target; j>= stones[i]; j--){
                dp[j] = Math.max(dp[j],dp[j-stones[i]] + stones[i]);
            }
        }
        return sum - dp[target] * 2;
    }
}
