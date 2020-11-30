package Chapter12_数组和字符串.Q561_数组拆分I;

import java.util.Arrays;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 30/11/2020 22:23
 **/

public class Solution {
    public int arrayPairSum(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        //默认从小到大排序
        Arrays.sort(nums);
        int res = 0;
        for(int i =0; i< nums.length; i+=2){
            res += Math.min(nums[i],nums[i+1]);
        }
        return res;
    }
}
