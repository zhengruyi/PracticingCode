package Chapter10_动态规划.Q560_和为K的子数组;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 19/11/2020 23:22
 **/

public class Solution {
    public int subarraySum(int[] nums, int k) {
        Map <Integer,Integer> map = new HashMap <Integer,Integer>();
        int sum = 0;
        int res = 0;
        map.put(0,1);
        for(int i =0; i < nums.length;i++){
            //前缀和
            sum+= nums[i];
            //如果map中已经包含sum-k，那么表示在两个索引间的子数组和正好是k,而有多少个sum-k的前缀和就代表区间和为k的子数组有多少个
            if(map.containsKey(sum - k)){
                res += map.get(sum-k);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return res;
    }
}
