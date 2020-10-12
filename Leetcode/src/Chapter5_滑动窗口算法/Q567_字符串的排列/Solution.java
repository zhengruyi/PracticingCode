package Chapter5_滑动窗口算法.Q567_字符串的排列;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 12/10/2020 22:14
 **/

public class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()){
            return false;
        }
        HashMap<Character, Integer> target = new HashMap<Character,Integer>();
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        for(int i = 0; i < s1.length();i++){
            target.put(s1.charAt(i),target.getOrDefault(s1.charAt(i),0)+1);
        }
        int nums = target.size();
        int count = 0;
        int left = 0;
        int right = 0;
        char[] chars = s2.toCharArray();
        while(right < chars.length){
            char c = chars[right];
            right++;
            //只处理在目标字符串中出现过的字符
            if(target.containsKey(c)){
                map.put(c,map.getOrDefault(c,0)+1);
                if(map.get(c).equals(target.get(c))){
                    count++;
                }
                if(count == nums){
                    return true;
                }
            }
            //这里尤其注意，为了保证窗口的长度，这里使用==s1.length()而不是nums,nums只表示目标字符串中的字符种类
            if(right - left == s1.length()){
                char tmp = chars[left];
                left++;
                if(target.containsKey(tmp)){
                    if(map.get(tmp).equals(target.get(tmp))){
                        count--;
                    }
                    map.put(tmp,map.get(tmp) -1);
                }

            }
        }
        return false;
    }
}
