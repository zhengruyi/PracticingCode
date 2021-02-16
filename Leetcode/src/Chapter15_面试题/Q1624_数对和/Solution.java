package Chapter15_面试题.Q1624_数对和;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 16/02/2021 23:08
 **/

public class Solution {
    /**
     * 排序后用双指针,分别从左右往中间遍历,如果值刚好等于就同时移动左右指针,
     * 两个指针的元素和小于目标,那么移动左指针,不然移动右指针
     * @param nums
     * @param target
     * @return
     */
    public List<List <Integer>> pairSums(int[] nums, int target) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        List<List<Integer>> res = new ArrayList();
        while(left < right){
            if(nums[left] + nums[right] == target){
                res.add(Arrays.asList(nums[left],nums[right]));
                left++;
                right--;
            }else if(nums[left] + nums[right] < target){
                left++;
            }else{
                right--;
            }
        }
        return res;
    }
}
