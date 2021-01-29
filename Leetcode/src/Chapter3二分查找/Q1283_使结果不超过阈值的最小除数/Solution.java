package Chapter3二分查找.Q1283_使结果不超过阈值的最小除数;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 29/01/2021 22:01
 **/

public class Solution {
    /**
     * 由于随着除数的增大，数组除以这个除数的结果的上界是单调递减的
     * 所以可以用二分搜索来计算最小的除数，除数的下界是1上界是数组和+1
     * 标准的求数组左边界的求法
     * @param nums
     * @param threshold
     * @return
     */
    public int smallestDivisor(int[] nums, int threshold) {
        long right = getDivison(nums,1) + 1;
        long left = 1;
        while(left < right){
            long mid = left + (right - left)/2;
            long res = getDivison(nums,mid);
            //二分搜索求左边界的方法
            if(res > threshold){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        return (int) left;
    }
    public long getDivison(int[] nums, long divide){
        long sum = 0;
        for(int num : nums){
            sum += Math.ceil(num / (divide*1.0d));
        }
        return sum;
    }
}
