package Chapter0_其他.Q954_二倍数对数组;

import java.util.TreeMap;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 25/03/2021 23:19
 **/

public class Solution {
    public boolean canReorderDoubled(int[] arr) {
        TreeMap<Integer,Integer> map = new TreeMap();
        //统计一下出现次数
        for(int num : arr){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        for(int i = 0; i < arr.length; i+= 2){
            int key = map.firstKey();
            int target;
            //负数的 n1 > n2 => 2 * n1 < 2 * n2
            if(key > 0){
                target = 2 * key;
            }else{
                //因为要用除法,所以先检查能否被2整除
                if(key % 2 != 0){
                    return false;
                }
                target = key /2 ;
            }
            //如果不包含直接返回
            if(!map.containsKey(target)){
                return false;
            }
            //更新出现次数
            map.put(key,map.get(key) - 1);
            map.put(target, map.get(target) - 1);
            //如果数字的出现次数为0，那么就直接移除
            if(map.get(key) == 0){
                map.remove(key);
            }
            //对于0来说, 2 * 0 == 0所以可能存在为空的情况,这里要检查是否存在
            if(map.containsKey(target) && map.get(target) == 0){
                map.remove(target);
            }
        }
        //检查map，正常应该为空
        return map.size() == 0;
    }
}
