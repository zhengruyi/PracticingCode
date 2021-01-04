package Chapter15_面试题.Q1716_按摩师;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 04/01/2021 20:55
 **/

public class Solution {
    int res = 0;
    public int massage(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int len = nums.length;
        //dp[i]表示从开始到现在总共可以工作的最长时长
        int[] dp = new int[len+1];
        dp[1] = nums[0];
        for(int i = 2; i <= nums.length; i++){
            //如果选择今天,那么只能选择i-2，如果不选择今天，那么可以选择dp[i-1]
            dp[i] = Math.max(dp[i-2] + nums[i-1],dp[i-1]);
        }
        return dp[len];
    }
}
