package Chapter0_其他.Q697_数组的度;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 23/12/2020 21:10
 **/

public class Solution {
    public int findShortestSubArray(int[] nums) {
        Map <Integer,Integer> left = new HashMap <>();
        Map<Integer,Integer> right = new HashMap<>();
        Map<Integer,Integer> count = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            //左边界只记录第一次出现的位置
            if(left.get(nums[i]) == null){
                left.put(nums[i],i);
            }
            //右边界记录第一次出现的位置
            right.put(nums[i],i);
            //统计数字出现次数
            count.put(nums[i],count.getOrDefault(nums[i],0)+1);
        }
        //获得数组中数字出现的最大频率
        int maxTimes = Collections.max(count.values());
        int min = Integer.MAX_VALUE;
        for(int key : count.keySet()){
            //包含最大频率数字的最短连续子数组的长度就是right - left +1
            if(count.get(key) == maxTimes){
                min = Math.min(min,right.get(key) - left.get(key) + 1);
            }
        }
        return min;
    }
}
