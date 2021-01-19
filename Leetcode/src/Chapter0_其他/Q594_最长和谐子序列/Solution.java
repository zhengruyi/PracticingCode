package Chapter0_其他.Q594_最长和谐子序列;

import java.util.HashMap;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 19/01/2021 22:57
 **/

public class Solution {
    public int findLHS(int[] nums) {
        HashMap <Integer,Integer> map = new HashMap<>();
        //统计数字出现的次数
        for(int num : nums){
            map.put(num,map.getOrDefault(num,0) + 1);
        }
        int ans = 0;
        //查看比当前数字大1或者小1的数字是否存在
        //如果存在计算和谐子序列的长度,并更新可能的最长和谐子序列
        for(int key: map.keySet()){
            if(map.containsKey(key+1)){
                ans = Math.max(ans, map.get(key) + map.get(key+1));
            }
            if(map.containsKey(key - 1)){
                ans = Math.max(ans, map.get(key) + map.get(key - 1));
            }
        }
        return ans;
    }
}
