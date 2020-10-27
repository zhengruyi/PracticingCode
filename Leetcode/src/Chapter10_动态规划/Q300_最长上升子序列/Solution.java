package Chapter10_动态规划.Q300_最长上升子序列;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 27/10/2020 21:43
 **/

/**
 * 容易记忆的时间复杂度O(N^2),空间复杂度O(N)的解法
 */
public class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int[] dp = new int[nums.length];
        //初始子序列为1
        dp[0] = 1;
        //全局寻找最长子序列，因为最长子序列的最后一位节点不一定在字符串末尾，所以不可以返回dp[nums.length-1]
        int res = 1;
        for(int i = 1; i< nums.length; i++){
            int tmp = 0;
            for(int j = 0; j< i; j++){
                if(nums[i] > nums[j]){
                    tmp = Math.max(tmp,dp[j]);
                }
            }
            dp[i] = tmp+1;
            res = Math.max(dp[i],res);
        }
        return res;
    }
}
