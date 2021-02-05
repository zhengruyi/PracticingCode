package Chapter0_其他.Q1207_独一无二的出现次数;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 05/02/2021 23:30
 **/

public class Solution {
    /**
     * 一个map统计字符的出现次数，一个set用来判断出现次数是否有重合的
     * @param arr
     * @return
     */
    public boolean uniqueOccurrences(int[] arr) {
        HashMap <Integer,Integer> map = new HashMap<>();
        for(int num : arr){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        HashSet <Integer> set = new HashSet();
        for(int key : map.keySet()){
            if(set.contains(map.get(key))){
                return false;
            }else{
                set.add(map.get(key));
            }
        }
        return true;
    }
}
