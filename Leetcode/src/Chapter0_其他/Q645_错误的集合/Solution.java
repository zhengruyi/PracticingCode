package Chapter0_其他.Q645_错误的集合;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 24/10/2020 22:18
 **/

public class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] res = new int[2];
        if(nums == null || nums.length == 0){
            return res;
        }
        //对每个值，将对应的索引所代表的值转成 负数
        for(int i = 0; i < nums.length; i++){
            int index = Math.abs(nums[i]) - 1;
            if(nums[index] > 0){
                nums[index] = nums[index] * -1;
            }else{
                //如果它已经是负数，那么代表这个索引就是重复的值
                res[0] = index + 1;
            }
        }
        //还是正数的值就是缺失的那个索引
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0){
                res[1] = i+1;
            }
        }
        return res;
    }
}
