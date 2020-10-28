package Chapter10_动态规划.Q53_最大子数组和;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 28/10/2020 13:05
 **/

public class Solution {
    public int maxSubArray(int[] nums) {
        if(nums.length ==0){
            return 0;
        }
        //解决数组中只有一个元素的情况
        int res = nums[0];
        int prev = nums[0];
        int sum = 0;
        for(int i =1; i < nums.length; i++){
            sum = Math.max(0,prev)+nums[i];
            res = Math.max(res, sum);
            prev = sum;
        }
        return res;
    }
}
