package Chapter5_滑动窗口算法.Q438_找到字符串中的所有字母异位词;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 12/10/2020 22:43
 **/

public class Solution {
    public List <Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList <Integer>();
        if(s.length() < p.length()){
            return list;
        }
        HashMap <Character, Integer> target = new HashMap<Character,Integer>();
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        for(int i = 0; i < p.length();i++){
            target.put(p.charAt(i),target.getOrDefault(p.charAt(i),0)+1);
        }
        int nums = target.size();
        int count = 0;
        int left = 0;
        int right = 0;
        char[] chars = s.toCharArray();
        while(right < chars.length){
            char c = chars[right];
            map.put(c,map.getOrDefault(c,0)+1);
            right++;
            if(map.get(c).equals(target.get(c))){
                count++;
            }
            if(count == nums){
                list.add(left);
            }
            while(right - left == p.length()){
                char tmp = chars[left];
                left++;
                if(map.get(tmp).equals(target.get(tmp))){
                    count--;
                }
                map.put(tmp,map.get(tmp) -1);
            }
        }
        return list;
    }
}
