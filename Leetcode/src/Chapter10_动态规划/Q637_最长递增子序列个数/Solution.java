package Chapter10_动态规划.Q637_最长递增子序列个数;

import java.util.Arrays;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 28/10/2020 14:15
 **/

public class Solution {
    public int findNumberOfLIS(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int[] dp = new int[nums.length];
        int[] count = new int[nums.length];
        Arrays.fill(dp,1);
        Arrays.fill(count,1);
        for(int i =1; i < nums.length;i++){
            for(int j =0; j< i; j++){
                if(nums[j] < nums[i]){
                    //表示第一次到达该序列长度
                    if(dp[j] +1 > dp[i]){
                        dp[i] = dp[j] + 1;
                        count[i] = count[j];
                        //表示有多种方式到达该序列长度
                    }else if(dp[j] + 1 == dp[i]){
                        count[i]+=count[j];
                    }
                }
            }
        }
        //获得nums中的最大值
        int maxLength = Arrays.stream(dp).max().getAsInt();
        int res = 0;
        //计算最大序列长度的组合数
        for(int i = 0; i < dp.length; i++){
            if(dp[i] == maxLength){
                res+=count[i];
            }
        }
        return res;
    }
}