package Chapter10_动态规划.Q1248_统计优美子数组;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 19/11/2020 23:26
 **/

public class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        Map <Integer,Integer> map = new HashMap <Integer,Integer>();
        //把（0,1)放入是因为当奇数和正好为k时，res+=1
        map.put(0,1);
        int count = 0;
        int res = 0;
        for(int i =0; i < nums.length; i++){
            //统计到目前索引为止的奇数数字有多少个
            if(nums[i] % 2 != 0){
                count++;
            }
            //如果存在前缀子数组,且它的奇数数目正好是count-k，那么两个下标的区间数组的奇数数目正好的k
            //所以可以累加到返回值里
            if(map.containsKey(count - k)){
                res += map.get(count - k);
            }
            map.put(count, map.getOrDefault(count,0)+1);
        }
        return res;
    }
}
