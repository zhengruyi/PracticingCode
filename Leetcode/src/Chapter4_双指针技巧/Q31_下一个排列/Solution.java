package Chapter4_双指针技巧.Q31_下一个排列;

import java.util.Arrays;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 16/12/2020 21:09
 **/

public class Solution {
    /**
     * 对于纯数字来说，字典排序的下一个组合就是数组中所有数字构成的下一个较大的数字
     * @param nums
     */
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        for(int i = len -1; i> 0; i--){
            //从后往前找，找出第一个递增序列，则i-1就是那个需要交换的较小的数字
            if(nums[i] > nums[i-1]){
                //由于交换后还要将i..len中排序成升序才能构成下一个较大的数字，所以这里先进行排序
                Arrays.sort(nums,i,len);
                //从i开始往后寻找到第一个比i-1位置大的数字，然后交换
                for(int j = i; j < len; j++){
                    if(nums[j] > nums[i-1]){
                        int tmp = nums[j];
                        nums[j] = nums[i-1];
                        nums[i-1] = tmp;
                        return;
                    }
                }
            }
        }
        //如果数组已经是最大值，即降序排列那么就回到最小值
        Arrays.sort(nums);
    }
}
