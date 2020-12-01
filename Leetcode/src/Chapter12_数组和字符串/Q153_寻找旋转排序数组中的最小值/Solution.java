package Chapter12_数组和字符串.Q153_寻找旋转排序数组中的最小值;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 01/12/2020 21:14
 **/

public class Solution {
    public int findMin(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        int left = 0;
        int right = nums.length - 1;
        /**
         * 左值 < 中值, 中值 < 右值 ：没有旋转，最小值在最左边，可以收缩右边界
         *
         *         右
         *      中
         *  左
         * 左值 > 中值, 中值 < 右值 ：有旋转，最小值在左半边，可以收缩右边界
         *
         *  左
         *          右
         *      中
         * 左值 < 中值, 中值 > 右值 ：有旋转，最小值在右半边，可以收缩左边界
         *
         *      中
         *  左
         *          右
         * 左值 > 中值, 中值 > 右值 ：单调递减，不可能出现
         *
         *  左
         *     中
         *         右
         *分析前面三种可能的情况，会发现情况1、2是一类，情况3是另一类。
         *
         * 如果中值 < 右值，则最小值在左半边，可以收缩右边界。
         * 如果中值 > 右值，则最小值在右半边，可以收缩左边界。
         * 通过比较中值与右值，可以确定最小值的位置范围，从而决定边界收缩的方向。
         *
         */
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }
}
