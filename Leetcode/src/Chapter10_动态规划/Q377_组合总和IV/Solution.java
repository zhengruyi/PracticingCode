package Chapter10_动态规划.Q377_组合总和IV;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 13/01/2021 16:32
 **/

public class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target+1];
        dp[0] = 1;
        for(int j = 1; j < dp.length; j++){
            for(int i = 0; i < nums.length; i++){
                //由于不同顺序算作不同的序列，所以这里状态转移为dp[j] += dp[j-nums[i]]
                if(j >= nums[i]){
                    dp[j] += dp[j- nums[i]];
                }
            }
        }
        return dp[target];
    }
}
