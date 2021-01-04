package Chapter0_其他.Q205_同构字符串;

import java.util.HashMap;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 04/01/2021 21:05
 **/

public class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap <Character,Character> st = new HashMap<>();
        HashMap<Character,Character> ts = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            //这里用两个哈希表来保证对应的正反映射关系会被保存在下来
            if((st.containsKey(s.charAt(i)) && st.get(s.charAt(i)) != t.charAt(i)) ||
                    (ts.containsKey(t.charAt(i)) && ts.get(t.charAt(i)) != s.charAt(i))){
                return false;
            }else{
                st.put(s.charAt(i),t.charAt(i));
                ts.put(t.charAt(i),s.charAt(i));
            }
        }
        return true;
    }
}
