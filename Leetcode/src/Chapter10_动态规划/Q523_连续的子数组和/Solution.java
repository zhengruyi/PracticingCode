package Chapter10_动态规划.Q523_连续的子数组和;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 19/11/2020 23:35
 **/

public class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map <Integer,Integer> map = new HashMap <Integer,Integer>();
        int sum = 0;
        map.put(0,-1);
        for(int i = 0; i < nums.length; i++){
            sum+=nums[i];
            //这里额外考虑除数为0的情况
            if(k != 0){
                //题目说明数组中的所有元素都为非负数，所以不要考虑余数是负数的情况
                sum%= k;
            }
            //由于每次都保存前缀和数组对k的余数,多以如果map中余数重复，则区间里面的数组前缀和为k
            //的倍数，就是题目的要求
            if(map.containsKey(sum)){
                //题目要求子数组最少长度为2
                if(i - map.get(sum) > 1){
                    return true;
                }
            }else{
                map.put(sum,i);
            }
        }
        return false;
    }
}
