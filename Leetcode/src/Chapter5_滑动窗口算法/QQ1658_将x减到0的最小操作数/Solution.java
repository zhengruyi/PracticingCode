package Chapter5_滑动窗口算法.QQ1658_将x减到0的最小操作数;

import java.util.Arrays;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 21/02/2021 21:17
 **/

public class Solution {
    /**
     * 问题是最少把左右部分剔除多少个元素可以让这些剔除的元素之和等于x，那么等价于数组的最长连续子数组
     * 使得子数组的和等于sum - x
     * @param nums
     * @param x
     * @return
     */
    public int minOperations(int[] nums, int x) {
        int left = 0;
        int right = 0;
        int total = Arrays.stream(nums).sum();
        int target = total - x;
        int sum = 0;
        int res = Integer.MIN_VALUE;
        //滑动窗口方法求得最长的连续子数组,使得子数组的和等于sum - x
        while(right < nums.length){
            sum += nums[right];
            while(sum > target && left <= right){
                sum -= nums[left];
                left++;
            }
            if(sum == target){
                res = Math.max(res,right - left + 1);
            }
            right++;
        }
        return res == Integer.MIN_VALUE ? -1 : nums.length - res;
    }
}
