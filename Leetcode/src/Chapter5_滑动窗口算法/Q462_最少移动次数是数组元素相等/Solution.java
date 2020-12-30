package Chapter5_滑动窗口算法.Q462_最少移动次数是数组元素相等;

import java.util.Arrays;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 30/12/2020 20:56
 **/

public class Solution {
    public int minMoves2(int[] nums) {
        //数组排序
        Arrays.sort(nums);
        int sum = 0;
        //所有元素到中位数所需要做的改变是最小的，所以选取中位数来作为目标元素
        for(int i = 0; i < nums.length; i++){
            sum += Math.abs(nums[i] - nums[nums.length/2]);
        }
        return sum;
    }
}
