package Q53_和为s的两个数字;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 25/12/2020 00:48
 **/

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        int left = 0;
        int right = nums.length-1;
        //有序数组，求解和为某个固定值，小于则移动左指针大于则移动右指针
        while(left < right && nums[left] + nums[right] != target){
            if(nums[left] + nums[right] > target){
                right--;
            }else{
                left ++;
            }
        }
        res[0] = nums[left];
        res[1] = nums[right];
        return res;
    }
}
