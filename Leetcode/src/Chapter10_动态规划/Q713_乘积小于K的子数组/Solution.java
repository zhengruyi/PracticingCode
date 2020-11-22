package Chapter10_动态规划.Q713_乘积小于K的子数组;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 22/11/2020 21:46
 **/

public class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k <= 1){
            return 0;
        }
        int left = 0;
        int times = 1;
        int res = 0;
        //滑动窗口计算区间数组中乘积小于等于k的区间,然后就可以计算以nums[right]为结尾的子数组数目，数目是right - left + 1;
        for(int right = 0; right < nums.length; right++){
            times *= nums[right];
            while(times >= k){
                times /= nums[left++];
            }
            res += right - left + 1;
        }
        return res;
    }
}
