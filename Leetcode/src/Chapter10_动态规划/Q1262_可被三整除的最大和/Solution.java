package Chapter10_动态规划.Q1262_可被三整除的最大和;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 01/01/2021 22:34
 **/

public class Solution {
    public int maxSumDivThree(int[] nums) {
        int len = nums.length;
        int[][] dp = new int[len+1][3];
        //dp[i][0-2]分别表示从和对三取余的结果
        dp[0][0] = 0;
        //下面两个表示不可能情况
        dp[0][1] = Integer.MIN_VALUE;
        dp[0][2] = Integer.MIN_VALUE;
        for(int i = 1; i <= len; i++){
            //后面列出了所有可能的状态转移情况,主要就是对当前数字选或者不选
            if(nums[i-1] % 3 == 0){
                dp[i][0] = Math.max(dp[i-1][0], dp[i-1][0] + nums[i-1]);
                dp[i][1] = Math.max(dp[i-1][1], dp[i-1][1] + nums[i-1]);
                dp[i][2] = Math.max(dp[i-1][2], dp[i-1][2] + nums[i-1]);
            }else if(nums[i-1] % 3 == 1){
                dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] + nums[i-1]);
                dp[i][2] = Math.max(dp[i-1][2], dp[i-1][1] + nums[i-1]);
                dp[i][0] = Math.max(dp[i-1][0], dp[i-1][2] + nums[i-1]);
            }else if(nums[i-1] % 3 == 2){
                dp[i][1] = Math.max(dp[i-1][1], dp[i-1][2] + nums[i-1]);
                dp[i][2] = Math.max(dp[i-1][2], dp[i-1][0] + nums[i-1]);
                dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + nums[i-1]);
            }
        }
        return dp[len][0];
    }
}
