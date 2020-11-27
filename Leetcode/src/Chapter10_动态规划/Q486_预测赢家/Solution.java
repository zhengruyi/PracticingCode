package Chapter10_动态规划.Q486_预测赢家;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 27/11/2020 21:56
 **/

public class Solution {
    public boolean PredictTheWinner(int[] nums) {
        int len = nums.length;
        int[][] dp = new int[len][len];
        //dp[i][j]表示在i..j区间中，先手比后手能多拿到的分数的最大值
        for(int i = 0; i < len; i++){
            //表示只有一个数字的情况下，先手可以拿走，所以比后手多出来的分数就是当前值的大小
            dp[i][i] = nums[i];
        }
        for(int i = len- 2; i>= 0; i--){
            for(int j = i+1; j< len; j++){
                //如果选择i,那么一轮选择后的先手比后手多的分数就是nums[i] - dp[i+1][j],反之就是
                //nums[j] - dp[i][j-1]
                dp[i][j] = Math.max(nums[i] - dp[i+1][j],nums[j] - dp[i][j-1]);
            }
        }
        //最终在整个序列上，先手比后手多分数更多则赢
        return dp[0][len-1] >= 0;
    }
}
