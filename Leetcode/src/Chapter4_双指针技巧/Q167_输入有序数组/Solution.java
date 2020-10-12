package Chapter4_双指针技巧.Q167_输入有序数组;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 12/10/2020 16:49
 **/

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        if(nums.length == 0){
            return res;
        }
        int left = 0;
        int right = nums.length -1;
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
