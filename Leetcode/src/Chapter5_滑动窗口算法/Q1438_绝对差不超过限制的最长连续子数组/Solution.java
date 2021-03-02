package Chapter5_滑动窗口算法.Q1438_绝对差不超过限制的最长连续子数组;

import java.util.TreeMap;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 02/03/2021 23:24
 **/

public class Solution {
    public int longestSubarray(int[] nums, int limit) {
        TreeMap <Integer,Integer> map = new TreeMap();
        int left = 0;
        int max = 0;
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i],map.getOrDefault(nums[i],0) + 1);
            // TreeMap是内部有序的，所以lastKey() - firstKey()就是区间的绝对值差
            while(map.lastKey() - map.firstKey() > limit){
                //移动左指针,移除出去的元素
                map.put(nums[left], map.get(nums[left]) - 1);
                if(map.get(nums[left]) == 0){
                    map.remove(nums[left]);
                }
                left++;
            }
            max = Math.max(max, i - left + 1);
        }
        return max;
    }
}
