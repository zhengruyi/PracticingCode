package Chapter12_数组和字符串.Q209_长度最小的子数组;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 30/11/2020 22:33
 **/

public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int lo = 0, hi = 0, sum = 0;
        //滑动窗口方法
        int min = Integer.MAX_VALUE;
        while(hi < nums.length){
            sum += nums[hi++];
            while(sum >= s){
                min = Math.min(min,hi - lo);
                sum -= nums[lo++];
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
