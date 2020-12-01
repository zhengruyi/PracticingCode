package Chapter12_数组和字符串.Q26_删除排序数组中的重复项;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 01/12/2020 21:22
 **/

public class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length < 2){
            return nums.length;
        }
        int slow = 1;
        int fast = 1;
        int val = nums[0];
        //慢指针指向有效位置，快指针不停往下寻找下一个不同的元素
        while(fast < nums.length){
            if(nums[fast] != val){
                nums[slow++] = nums[fast];
                val = nums[fast];
            }
            fast++;
        }
        return slow ;
    }
}
