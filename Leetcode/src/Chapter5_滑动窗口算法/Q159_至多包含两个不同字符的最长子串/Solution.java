package Chapter5_滑动窗口算法.Q159_至多包含两个不同字符的最长子串;

import java.util.HashMap;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 23/02/2021 23:38
 **/

public class Solution {
    /**
     * 经典的滑动窗口算法,用map来统计窗口内的字符个数和种类
     * @param s
     * @return
     */
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        HashMap <Character,Integer> map = new HashMap<>();
        int left = 0;
        int res = 0;
        for(int i = 0; i < s.length(); i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
            while(map.size() > 2){
                char key = s.charAt(left);
                left++;
                map.put(key,map.get(key) - 1);
                if(map.get(key) == 0){
                    map.remove(key);
                }
            }
            res = Math.max(res, i - left + 1);
        }
        return res;
    }
}
