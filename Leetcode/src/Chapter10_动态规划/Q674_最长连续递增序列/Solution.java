package Chapter10_动态规划.Q674_最长连续递增序列;

import java.util.Arrays;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 14/03/2021 22:09
 **/

public class Solution {
    /**
     * 最大连续递增子数组，简单的动态规划
     * @param nums
     * @return
     */
    public int findLengthOfLCIS(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int length = nums.length;
        int[] dp = new int[length];
        Arrays.fill(dp,1);
        int max = 1;
        for(int i = 1; i < length; i++){
            if(nums[i] > nums[i-1]){
                dp[i] = dp[i-1] + 1;
            }
            max = Math.max(max,dp[i]);
        }
        return max;
    }
}
