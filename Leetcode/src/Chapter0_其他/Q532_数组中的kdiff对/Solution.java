package Chapter0_其他.Q532_数组中的kdiff对;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 21/01/2021 21:12
 **/

public class Solution {
    public int findPairs(int[] nums, int k) {
        Map <Integer,Integer> map = new HashMap <>();
        int ans = 0;
        for(int num : nums){
            //统计每个数字的种类和出现次数
            map.put(num,map.getOrDefault(num,0)+1);
        }
        for(int key : map.keySet()){
            if(k == 0){
                //如果k==0那么要求一个数字的出现次数大于1
                if(map.get(key) > 1){
                    ans++;
                }
            }else{
                //如果K > 0, 那么就只需要另外一个数字出现过就可以算做一对
                if(map.containsKey(key - k)){
                    ans++;
                }
            }
        }
        return ans;
    }
}
