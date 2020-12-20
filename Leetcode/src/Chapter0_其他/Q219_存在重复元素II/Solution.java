package Chapter0_其他.Q219_存在重复元素II;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 20/12/2020 22:57
 **/

public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map <Integer,Integer> map = new HashMap <>();
        for(int i = 0; i < nums.length; i++){
            //只有在前面存在重复元素且两者索引差值小于等于k时返回true
            if(map.containsKey(nums[i])){
                if(i - map.get(nums[i]) <= k){
                    return true;
                }
            }
            //更新值对应的索引
            map.put(nums[i],i);
        }
        return false;
    }
}
