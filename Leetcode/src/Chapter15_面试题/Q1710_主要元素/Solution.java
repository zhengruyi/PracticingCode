package Chapter15_面试题.Q1710_主要元素;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 02/02/2021 23:47
 **/

public class Solution {
    /**
     * 摩尔投票法,开头假设一个数字是众数，后续检查数字是否和当前假设的数字相等
     * 如果相等那么就加1，不同就减去1,如果减到0就更换数字。由于要保证众数的有效性
     * 所以在再次遍历一遍数字确保得到的答案就是数组的众数
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        if(nums == null || nums.length == 0){
            return -1;
        }
        int length = nums.length;
        int most = nums[0];
        int times = 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] == most){
                times++;
            }else{
                times--;
            }
            if(times == 0){
                most = nums[i];
                times = 1;
            }
        }
        times = 0;
        for(int num : nums){
            if(num == most){
                times++;
            }
        }
        return times >= (length + 1)/2 ? most : -1;
    }
}
