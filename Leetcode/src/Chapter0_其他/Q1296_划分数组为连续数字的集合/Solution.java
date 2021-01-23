package Chapter0_其他.Q1296_划分数组为连续数字的集合;

import java.util.Arrays;
import java.util.TreeMap;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 23/01/2021 20:52
 **/

public class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        int length = nums.length;
        if(length % k != 0){
            return false;
        }
        Arrays.sort(nums);
        //里面所有的键值都按照从小到大的顺序排列
        TreeMap<Integer,Integer> map = new TreeMap <>();
        //统计所有数字的出现频率
        for(int num : nums){
            map.put(num,map.getOrDefault(num,0)+ 1);
        }
        //如果能够吧map清空，说明可以把数组分成k个连续的数字
        while(map.size() > 0){
            //key的最小值
            int begin = map.keySet().iterator().next();
            //最小值的出现频率
            int times = map.get(begin);
            //要求所有begin.. begin+k的出现次数至少为times
            for(int i = begin; i < begin + k; i++){
                //检查i是否存在
                if(!map.containsKey(i)){
                    return false;
                }
                //如果后续数字出现频率刚好等于times,俺么就删除key,不然就更新对应的key的出现频率
                if(map.get(i) == times){
                    map.remove(i);
                }else if(map.get(i) > times){
                    map.put(i,map.get(i) - times);
                }else{
                    return false;
                }
            }
        }
        return true;
    }
}
