package Q42_连续子数组的最大和;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 14/02/2021 23:49
 **/

public class Solution {
    /**
     * 简单的动态规划
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int num : nums){
            sum = Math.max(sum + num, num);
            max = Math.max(max,sum);
        }
        return max;
    }
}
