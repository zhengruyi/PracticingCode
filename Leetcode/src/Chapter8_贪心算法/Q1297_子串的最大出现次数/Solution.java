package Chapter8_贪心算法.Q1297_子串的最大出现次数;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 13/03/2021 23:12
 **/

public class Solution {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        HashMap <String,Integer> map = new HashMap();
        for(int i = 0; i <= s.length() - minSize; i++){
            //因为大的字符串重复那么小的子字符串也必然重复，所以这里去每次长度的最小值
            //统计子字符串的出现次数
            String str = s.substring(i, i+ minSize);
            if(getType(str) <= maxLetters){
                map.put(str,map.getOrDefault(str,0) + 1);
            }
        }
        int res = 0;
        for(int v : map.values()){
            res = Math.max(res,v);
        }
        return res;
    }

    /**
     * 统计一个字符串里面的字符种类
     * @param s
     * @return
     */
    public int getType(String s){
        Set <Character> set = new HashSet();
        for(int i = 0; i < s.length(); i++){
            set.add(s.charAt(i));
        }
        return set.size();
    }
}
