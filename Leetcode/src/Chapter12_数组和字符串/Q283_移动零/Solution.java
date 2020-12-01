package Chapter12_数组和字符串.Q283_移动零;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 01/12/2020 21:26
 **/

public class Solution {
    public void moveZeroes(int[] nums) {
        int begin = 0;
        int end = 0;
        //慢指针指向0位置，fast指针指向要交换的位置，然后交替更新
        while(end < nums.length){
            while(begin < nums.length && nums[begin] != 0){
                begin++;
            }
            end = begin;
            while(end < nums.length && nums[end] == 0){
                end++;
            }

            if(end < nums.length){
                int tmp = nums[end];
                nums[end] = nums[begin];
                nums[begin] = tmp;
            }
        }
    }
}
