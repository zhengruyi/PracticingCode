package Chapter0_其他.Q290_单词规律;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 29/01/2021 22:28
 **/

public class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] strs = s.split("\\s+");
        if(strs.length != pattern.length()){
            return false;
        }
        Map <Character,String> map = new HashMap <>();
        Set <String> set = new HashSet <>();
        for(int i = 0 ; i < strs.length; i++){
            if(map.containsKey(pattern.charAt(i))){
                //如果pattern的通过一个字符对应着不同的字符串，那么就返回false
                if(!map.get(pattern.charAt(i)).equals(strs[i])){
                    return false;
                }
            }else{
                //说明s的不同字符串对应着patter中的不同字符，返回false;
                if(set.contains(strs[i])){
                    return false;
                }
                map.put(pattern.charAt(i),strs[i]);
                set.add(strs[i]);
            }
        }
        return true;
    }
}
