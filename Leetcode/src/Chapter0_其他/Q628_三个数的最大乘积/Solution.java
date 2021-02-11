package Chapter0_其他.Q628_三个数的最大乘积;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 11/02/2021 23:50
 **/

public class Solution {
    /**
     * 最大的三数乘积来自于最大的三个正整数或者两个最小的负数相乘或者乘上最大值
     * 所以找到这五个数在分别计算两种情况,两种中的最大值就是结果值
     * @param nums
     * @return
     */
    public int maximumProduct(int[] nums) {
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;
        for(int x : nums){
            if(min1 > x){
                min2 = min1;
                min1 = x;
            }else if( min2 > x){
                min2 = x;
            }

            if(max1 < x){
                max3 = max2;
                max2 = max1;
                max1 = x;
            }else if(max2 < x){
                max3 = max2;
                max2 = x;
            }else if(max3 < x){
                max3 = x;
            }
        }
        return Math.max(max1 * max2 * max3, min1 * min2 * max1);

    }
}
