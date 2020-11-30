package Chapter12_数组和字符串.Q485_最大连续1的个数;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 30/11/2020 22:29
 **/

public class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int start = -1;
        //双指针法，start指向元素为0的位置
        for(int i = 0; i < nums.length;i++){
            if(nums[i] == 0){
                max = Math.max(max,i - start -1);
                start = i;
            }
        }
        max = Math.max(max,nums.length - start -1);
        return max;
    }
}
