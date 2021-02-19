package Chapter4_双指针技巧.Q1679_K和数对的最大数目;

import java.util.Arrays;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 19/02/2021 23:25
 **/

public class Solution {
    /**
     * 简单的排序，然后双指针来找所有可能的组合
     * @param nums
     * @param k
     * @return
     */
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        int res = 0;
        while(left < right){
            if(nums[left] + nums[right] == k){
                res++;
                left++;
                right--;
            }else if(nums[left] + nums[right] > k){
                right--;
            }else{
                left ++;
            }
        }
        return res;
    }
}
