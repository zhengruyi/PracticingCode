package Chapter12_数组和字符串.Q167_两数之和II;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 30/11/2020 22:25
 **/

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        if(nums.length == 0){
            return res;
        }
        int left = 0;
        int right = nums.length -1;
        //双指针法
        while(left < right){
            if(nums[left] + nums[right] == target){
                res[0] = left+1;
                res[1] = right+1;
                return res;
            }else if(nums[left] + nums[right] < target){
                left++;
            }else if(nums[left] + nums[right] > target){
                right --;
            }
        }
        return res;
    }
}
