package Chapter0_其他.Q217_存在重复元素;

import java.util.Arrays;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 24/02/2021 23:13
 **/

public class Solution {
    /**
     * 排序后看相邻的两个元素是否相同
     * @param nums
     * @return
     */
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for(int i = 1; i < nums.length; i++){
            if(nums[i] == nums[i-1]){
                return true;
            }
        }
        return false;
    }
}
