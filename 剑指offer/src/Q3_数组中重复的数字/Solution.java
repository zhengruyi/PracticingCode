package Q3_数组中重复的数字;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 17/03/2021 23:46
 **/

public class Solution {
    public int findRepeatNumber(int[] nums) {
        int temp = 0;
        for(int i = 0; i < nums.length; i++){
            //将数字nums[i]安排到对应的位置，使用循环来保证下一步前进前，保证
            //这个位置的和这个位置相关联的数字都被移动到了对应位置,这样第一次不满足条件的位置
            //就是重复数字且索引相对较小
            while(nums[i] != i){
                if(nums[i] == nums[nums[i]]){
                    return nums[i];
                }
                temp = nums[nums[i]];
                nums[nums[i]] = nums[i];
                nums[i] = temp;
            }
        }
        return -1;
    }
}
