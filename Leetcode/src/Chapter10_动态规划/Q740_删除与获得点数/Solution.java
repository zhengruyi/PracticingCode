package Chapter10_动态规划.Q740_删除与获得点数;

import java.util.Arrays;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 31/10/2020 22:20
 **/

public class Solution {
    //转换成打家劫舍问题
    public int deleteAndEarn(int[] nums) {
        if(nums.length == 0){
            return 0;
        }else if(nums.length == 1){
            return nums[0];
        }
        int max = Arrays.stream(nums).max().getAsInt();
        //将原数组转换成对应位置出现的频率次数,这样就转成打家劫舍问题
        int[] all = new int[max+1];
        for(int item : nums){
            all[item]++;
        }
        int dpMinusOne = all[1];
        int dpMinusTwo = 0;
        int dp = 0;
        for(int i = 2; i <= max; i++){
            dp = Math.max(dpMinusOne,dpMinusTwo+i*all[i]);
            dpMinusTwo = dpMinusOne;
            dpMinusOne = dp;
        }
        return dp;
    }
}
