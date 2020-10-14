package Chapter1差分数组和前缀和数组.Q560_和为K的子数组;

import java.util.HashMap;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 14/10/2020 17:25
 **/

public class Solution {
    public int subarraySum(int[] nums, int k) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        HashMap <Integer,Integer> map = new HashMap<>();
        int sum_i = 0;
        int res = 0;
        //初始情况，要记得设置 0 -> 1 的键值对
        map.put(0,1);
        for(int i =0; i < nums.length; i++){
            sum_i += nums[i];
            //计算和为k的另外一个数字
            int sum_j = sum_i - k;
            //如果包含的话，每一个都可以对应一个子数组的和
            if(map.containsKey(sum_j)){
                res += map.get(sum_j);
            }
            map.put(sum_i,map.getOrDefault(sum_i,0)+1);
        }
        return res;

    }
}
